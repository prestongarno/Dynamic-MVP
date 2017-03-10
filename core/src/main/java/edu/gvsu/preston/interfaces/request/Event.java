package edu.gvsu.preston.interfaces.request;

import edu.gvsu.preston.interfaces.result.Callback;

/**
 * ========================================================================
 * $(PROJECT_NAME) - by Preston Garno on 2/25/17
 * =========================================================================
 *
 * This class will be implemented by each presenter to define what kind of
 * information that the view needs to send if it wants to have its request
 * handled correctly
 *
 * =========================================================================
 */
public abstract class Event {

    //DANGER --> this may or may not contain references
    //to the view and will leak if not dropped when view destroyed
    final Callback result;

    public Callback getCallback() {
        return result;
    }

    /**
     * Uses what is apparently described as "Dependency Injection" (lol) nowadays to define a result
     * result type for each and every request that is allowed to be sent to a presenter
     *
     * The reason for this is that the presentation model defines what TYPE of data/etc will be sent to
     * the view, but seperate objects allow for releasing of this object to be GC if the view
     * is changed before the request returns.  Allowing the view to implement the actual action of
     * displaying the data, but allowing the presenter to define the structure of it is about as
     * clean of a decoupling of the View and the Model as I can imagine with the least hassle and side effects
     * the
     * @param callback
     */
    public Event(Callback callback)
    {
        result = callback;
    }
}
