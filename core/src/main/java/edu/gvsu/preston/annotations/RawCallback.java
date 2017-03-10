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

package edu.gvsu.preston.annotations;

import edu.gvsu.preston.annotations.AnnotationContainers.RawCallContainer;
import edu.gvsu.preston.interfaces.result.Callback;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * *************************************************
 * Dynamic-MVP - edu.gvsu.preston.annotations - by Preston Garno on 3/10/17
 *
 * Annotate a Presenter with this to denote a callback that can be
 * invoked at any time without warning
 ***************************************************/
@Repeatable(RawCallContainer.class)
@Retention(RetentionPolicy.SOURCE)
public @interface RawCallback {
    Class<? extends Callback> Callback();
}
