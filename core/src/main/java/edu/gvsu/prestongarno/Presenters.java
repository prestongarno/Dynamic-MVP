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

import edu.gvsu.prestongarno.annotations.TranslateView;


/**
 * ========================================================================
 * by Preston Garno on 2/25/17
 * =========================================================================
 * Presenters.java: Just a static method that returns a list of Presenters that
 * are concerned with the particular lifecycle ID
 ****************************************/
public class Presenters<T extends Presenter> {

	/*****************************************
	 * What we did today:
	 * 	- refined Event implementation -> now view really can broadcast events either IMPLICITLY
	 * 	(without a reference to the actual presenter implementation)
	 * 	OR just explicitly pass the event to the presenter by directly invoking a method on the instance
	 *
	 * To do on Saturday:
	 * 	- Translate lambda to a static method
	 * 			-- Captures are the hardest part -> locate variable assignment and store name for later
	 * 		-- if it's a primitive or a constant we can just store it in a table and look it up later
	 * 		-- other than that it might be impossible but we can try
	 *		- REMEMBER the concept behind the project -> implicit event handling, full decoupling, modular interface, easy unit testing,
	 *		- After injecting method into class, link the unique static method signature with any event handlers
	 *		defined in the presenter class -> so the event class can invoke that method on demand
	 *
	 ****************************************/
	
	@SuppressWarnings("unchecked")
	@Deprecated // just used when learning how to inject methods into AST
	public T activatePresenter(Object view) {
		// AST makes the view implement the TranslateView
		// interface and create a new Presenter in the create method
		return (T) ((TranslateView) view).create();
	}
	//View[] getPresenter()

    //============================================================================//
    //      A list of all possible presenters in the app
    //============================================================================//
    //private static final View mainPresenter = (View) new MainPresenter();
    //============================================================================//
    //      An array to make finding the correct View easy
    //============================================================================//
    //private static final View[] presenters = new View[]{mainPresenter};
}
