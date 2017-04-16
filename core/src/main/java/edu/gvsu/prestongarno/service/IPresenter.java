package edu.gvsu.prestongarno.service;

import edu.gvsu.prestongarno.api.Event;

/**
 * Created by preston on 4/16/17.
 *
 * Probably inject this interface to the presenter class,
 * link with the view in the background
 *
 * Generate a class to bind callbacks to method invocations on the view
 */
public interface IPresenter {
	default void onEvent(Event event) {
		ServiceBinder.getInstance(this).provide(event);
	}
}
