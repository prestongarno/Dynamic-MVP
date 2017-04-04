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
 ****************************************/

package edu.gvsu.prestongarno;

import edu.gvsu.prestongarno.annotations.CallbackImpl;


/**
 * ========================================================================
 * $(PROJECT_NAME) - by Preston Garno on 2/25/17
 * =========================================================================
 * <p>
 * This class will be implemented by each View to define what kind of
 * information that the view needs to send if it wants to have its request
 * handled correctly
 * <p>
 * =========================================================================
 ****************************************/
public abstract class Event<T> {
	
	
	private T CALLBACK_TYPE;
	
	/*****************************************
	 * This value should be assigned at compileTime?
	 ****************************************/
	private T DYNAMIC_CALLBACK;
	
	/*****************************************
	 * Dependency injection to define result type for each and every request that is allowed to be sent to a View
	 * <p>
	 * The reason for this is that the presentation model defines what TYPE of data/etc will be sent to
	 * the view, but seperate objects allow for releasing of this object to be GC if the view
	 * is changed before the request returns.  Allowing the view to implement the actual action of
	 * displaying the data, but allowing the View to define the structure of it is about as
	 * clean of a decoupling of the View and the Model as I can imagine with the least hassle and side effects
	 ****************************************/
	public Event(@CallbackImpl T callback) {
		CALLBACK_TYPE = callback;
	}
	
	public T call() {
		return CALLBACK_TYPE == null ? DYNAMIC_CALLBACK : CALLBACK_TYPE;
	}
	
	public void setCallback(T callback) {
		this.DYNAMIC_CALLBACK = DYNAMIC_CALLBACK;
	}
	
	/*****************************************
	 * Drops reference to closure/lambda//anonymous class
	 ****************************************/
	void dropCallback() {
		CALLBACK_TYPE = null;
	}
}
