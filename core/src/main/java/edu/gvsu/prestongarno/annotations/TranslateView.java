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

package edu.gvsu.prestongarno.annotations;

import edu.gvsu.prestongarno.api.Presenter;


/** **************************************************
 * Dynamic-MVP - edu.gvsu.prestongarno.internal - by Preston Garno on 3/26/17
 * ***************************************************/
public interface TranslateView {
	// not using this -> only was used for interface impl p.o.c.
	Presenter create();
}
