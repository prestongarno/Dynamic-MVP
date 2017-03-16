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

package edu.gvsu.prestongarno.example.SampleResources;


import edu.gvsu.prestongarno.interfaces.Callback;

/**
 * *************************************************
 * Dynamic-MVP - edu.gvsu.prestongarno.example - by Preston Garno on 3/9/17
 *
 * This represents a sample callback interface that the view has to implement
 ***************************************************/
public interface SampleCallback extends Callback {
    void call(String message);
}