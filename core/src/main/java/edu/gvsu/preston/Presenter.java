/*
 *       Copyright (c) 2017.  Preston Garno
 *
 *        Licensed under the Apache License, Version 2.0 (the "License");
 *        you may not use this file except in compliance with the License.
 *        You may obtain a copy of the License at
 *
 *            http://www.apache.org/licenses/LICENSE-2.0
 *
 *        Unless required by applicable law or agreed to in writing, software
 *        distributed under the License is distributed on an "AS IS" BASIS,
 *        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *        See the License for the specific language governing permissions and
 *        limitations under the License.
 */

package edu.gvsu.preston;

import edu.gvsu.preston.interfaces.result.Callback;
import edu.gvsu.preston.interfaces.request.Event;
import edu.gvsu.preston.interfaces.view.iView;

import java.lang.reflect.Method;
import java.util.*;

/**
 * ========================================================================
 * $(PROJECT_NAME) - by Preston Garno on 2/25/17
 * =========================================================================
 */
public abstract class Presenter {

//    private static List<Class<? extends Event>> POSSIBLE_EVENTS;

    private iView viewHandle;
    private final Random random;
    /**
     * This Map stores the results of a background job(s) that complete when the view is in an
     * unknown state.  Will complete when notified by the GM
     */
    private final Map<Class<? extends Callback>, Object[]> pendingResults;
    /**
     * This Array only exists as long as the View that this Presenter supports is alive
     * Once it is re-created this will be cleared and any calls to the values here will lead
     * to a Null Pointer and if not that then you most likely have a memory leak
     */
    private final Map<Integer, Event> jobs;
    /**
     * The glue that holds it together - when a view changes it's config, etc. references to result
     * impl. are cleared to allow GC and only implementation type is stored here to know which results
     * to map to what impl. on the jobs completing and the view being restored
     */
    private final Map<Integer, Class<? extends Callback>> jobsType;

    protected Presenter() {
//        POSSIBLE_EVENTS = new ArrayList<>();
        pendingResults = new HashMap<Class<? extends Callback>, Object[]>(2, 0.75f);
        random = new Random();
        jobs = new HashMap<Integer, Event>(4, 0.75f);
        jobsType = new HashMap<Integer, Class<? extends Callback>>(4, 0.75f);
    }

//    static void addPossibleEvent(Class<? extends Event> event){
//        POSSIBLE_EVENTS.add(event);
//    }

    /**
     * GM calls this method to broadcast
     * events a presenter is concerned with
     * All subclasses must call super.onEvent()
     * if they want their results returned to the
     * main thread.
     */
    protected void onEvent(Event event) {
        int key = generateJobNumber();
        jobs.put(key, event);
    }

    private int generateJobNumber() {
        return random.nextInt(999999999);
    }

    void destroy() {
        this.viewHandle = null;
    }

    @SuppressWarnings("unchecked")
    void setViewHandle(iView view) {
        this.viewHandle = view;
/*        Callback result;
        Object[] args;
        for(Map.Entry<Class<? extends Event>, Object[]> pending : this.pendingResults.entrySet()){
            try {
                result = view.getImplementation(pending.getKey().newInstance().getResult().getClass());
            } catch (Exception e) {
                e.printStackTrace();
            }
            args = pending.getValue();
            if(result != null){
                try {
                    result.getClass().getEnclosingMethod().invoke(null, args);
                } catch (Exception e){
                    //this will literally never happen barring an act of God
                    e.printStackTrace();
                    // well, if it does - make this thread die a miserable
                    // death by undefined mathematical behaviour
                    System.out.println(0/0);
                }
            }
        }*/
    }

    /**
     * Nullify the view, and all pending Events
     * that are being processed in the background
     */
    void onViewDestroyed() {
        this.viewHandle = null;
        Iterator<Map.Entry<Integer, Event>> it = jobs.entrySet().iterator();
        int key;
        Event event;
        while (it.hasNext()) {
            Map.Entry<Integer, Event> next = it.next();
            key = next.getKey();
            event = next.getValue();
            this.jobsType.put(key, event.getCallback().getClass());
        }
        this.jobs.clear();
    }

    /**
     * This method is how the result is passed back. The iView instance is hidden in the superclass,
     * so the only way for the child class to easily pass the results back to the view without manually
     * doing this same thing is to call super.onResult().
     * <p>
     * Why I think that this is a good solution that will completely
     * decouple the Presentation/Model layer from the view:
     * 1) Callback is an empty interface
     * 2)
     *
     * @param args
     */
    protected void onResult(int jobNumber, Object... args) {
        Callback result;
        if (viewHandle != null) {
            try {

                Event e = this.jobs.get(jobNumber);
                if (e == null)
                    result = this.viewHandle.getImplementation(jobsType.get(jobNumber));
                else result = e.getCallback();

                result.getClass().getMethods()[0].invoke(result, args);
                //check if it's a func interface
                Method m = result.getClass().getEnclosingMethod();
                if (m == null)
                    throw new IllegalArgumentException("Callback subclass must only contain a single method!");

                //Type checking args against the result method
                Class[] parameterTypes = m.getParameterTypes();
                if (parameterTypes.length != args.length)
                    throw new IllegalArgumentException("Callback implementation method arguments do not" +
                            "match provided arguments! ");
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (parameterTypes[i] != args[i].getClass()) {
                        throw new IllegalArgumentException("Type " + parameterTypes[i] + " does not match" +
                                " provided result argument: " + args[i]);
                    }
                }
            } catch (Exception e) {
                //Runtime exception will be thrown before this if
                //the wrong args are provided
                e.printStackTrace();
                System.out.println(0 / 0);
            }
        } else {
            pendingResults.put(jobsType.get(jobNumber), args);
        }
    }

    //Meta-Programming - Processor should generate methods taking each seperate event
    // implementation into account

}
