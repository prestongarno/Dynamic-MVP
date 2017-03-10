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

package edu.gvsu.prestongarno;

import edu.gvsu.prestongarno.interfaces.Event;

import java.util.ArrayList;
import java.util.List;

public class GM {
    //singleton instance
    private static GM instance;

    //returns the single instance
    public static GM getInstance() {
        if (instance == null)
            instance = new GM();
        return instance;
    }

    //===========================================================================//

    private final List<Presenter> presenters;


    private GM() {
        this.presenters = new ArrayList<>(4);
    }

    public void on(Event event) {
        for (Presenter p : presenters) {
            p.onEvent(event);
        }
    }

/*    */

    /**
     * To be called by a view when requesting a
     *
     * @param lifecycleID
     * @return
     *//*
    public void onViewStart(MVPView view)
    {
        for(View p : Presenters.getPresenters(lifecycleID)){
            if(p.presentsFor(view)){
                p.setViewHandle(view);
                presenters.add(p);
            }
        }
    }*/
    public void onViewDone(String lifecycleID) {
/*        for(View p : presenters){
                p.destroy();*/
    }
}
