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

import edu.gvsu.prestongarno.annotations.TranslateView;


/**
 * ========================================================================
 * by Preston Garno on 2/25/17
 * =========================================================================
 * Presenters.java: Just a static method that returns a list of Presenters that
 * are concerned with the particular lifecycle ID
 */
public class Presenters<T extends Presenter> {
	
	
	@SuppressWarnings("unchecked")
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
