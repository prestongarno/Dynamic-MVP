package edu.gvsu.preston;

import edu.gvsu.preston.interfaces.request.Event;

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
        this.presenters = new ArrayList<Presenter>(4);
    }

    public void on(Event event)
    {
        for(Presenter p : presenters){
            p.onEvent(event);
        }
    }

/*    *//**
     * To be called by a view when requesting a
     * @param lifecycleID
     * @return
     *//*
    public void onViewStart(iView view)
    {
        for(Presenter p : Presenters.getPresenters(lifecycleID)){
            if(p.presentsFor(view)){
                p.setViewHandle(view);
                presenters.add(p);
            }
        }
    }*/

    public void onViewDone(String lifecycleID)
    {
        for(Presenter p : presenters){
            if(p.presentsFor(lifecycleID)){
                p.destroy();
                presenters.remove(p);
            }}
    }
}
