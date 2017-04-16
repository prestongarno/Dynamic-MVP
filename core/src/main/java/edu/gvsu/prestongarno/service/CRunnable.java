package edu.gvsu.prestongarno.service;

import edu.gvsu.prestongarno.api.Event;

/****************************************
 * Created by preston on 4/16/17.
 *
 * Wrapper class for an event also implements Runnable
 * which enables a View to override the onJoin() method
 * and submit that runnable to a different thread/thread pool
 *
 * This class will be submitted to the
 * callback queue instance linked with a particular view
 ****************************************/
abstract class CRunnable<E extends Event> implements Runnable {

	/*****************************************
	 * this array of objects stores the arguments to the callback
	 * method when the view has instructed EzMVP to pause joins
	 ****************************************/
	private Object[] args;

	/*****************************************
	 * Construct a new CallbackRunnable to wrap the event.
	 * @param event the event
	 ****************************************/
	CRunnable(E event) {

	}

	void onStoreCallbackArguments(Object[] args) {

	}
}
