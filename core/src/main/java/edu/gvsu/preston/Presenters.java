package edu.gvsu.preston;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * ========================================================================
 * by Preston Garno on 2/25/17
 * =========================================================================
 * Presenters.java: Just a static method that returns a list of Presenters that
 * are concerned with the particular lifecycle ID
 */
public class Presenters {

    private static Map<String, Presenter> MASTER_PRESENTER_LIST;

    public static Presenter[] initializePresenters() {
        throw new RuntimeException("nono");
   }

    //Presenter[] getPresenter()

    //============================================================================//
    //      A list of all possible presenters in the app
    //============================================================================//
    //private static final Presenter mainPresenter = (Presenter) new MainPresenter();
    //============================================================================//
    //      An array to make finding the correct presenter easy
    //============================================================================//
    //private static final Presenter[] presenters = new Presenter[]{mainPresenter};
}
