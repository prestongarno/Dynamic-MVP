package edu.gvsu.preston.interfaces.view;

import edu.gvsu.preston.interfaces.result.Callback;

/**
 * ========================================================================
 * $(PROJECT_NAME) - by Preston Garno on 2/25/17
 * =========================================================================
 */
public interface iView {
    /** Get the implementation of "Callback" that this View defines. Returns null if no Callback is defined
     * @param eventClass*/
    Callback getImplementation(Class<? extends Callback> eventClass);
}