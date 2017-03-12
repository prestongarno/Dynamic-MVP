package edu.gvsu.prestongarno.annotations.meta;/*
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


import edu.gvsu.prestongarno.annotations.meta.containers.RuleContainer;

import java.lang.annotation.*;

/**
 * *************************************************
 * Dynamic-MVP - edu.gvsu.prestongarno.meta.annotations - by Preston Garno on 3/11/17
 *
 * Used for defining existing annotations (e.g. @Nullable) that are required to be used
 * and/or compatible with any of edu.gvsu.prestongarno.annotations
 *
 * NOTE: this is where abstraction stops, so rules for annotation rules are:
 *          1) Annotate rule with @FunctionalInterface
 *          2) Annotate implementation of validator with @Validator
 ***************************************************/
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RuleContainer.class)
public @interface AnnotationRule {
    String value();
}
