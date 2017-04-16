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

package edu.gvsu.prestongarno.api;

import java.lang.ref.WeakReference;


/**
 * $(PROJECT_NAME) - by Preston Garno on 2/25/17
 * <p>
 *    Represents an event from the view
 * <p>
 ****************************************/
public class Event<C> {
	
	
	private final Class<C> CALLBACK_TYPE;

	private WeakReference<C> DYNAMIC_CALLBACK;
	
	/*****************************************
	 * Dependency injection to define result type for each and every request that is allowed to be sent to a View
	 * <p>
	 * The reason for this is that the presentation model defines what TYPE of data/etc will be sent to
	 * the view, but seperate objects allow for releasing of this object to be GC if the view
	 * is changed before the request returns.  Allowing the view to implement the actual action of
	 * displaying the data, but allowing the Presenter to define the type of it is about as
	 * clean of a decoupling of the View and the Model as I can imagine with the least hassle and side effects
	 ****************************************/
	public Event(Class<C> callback) {
		CALLBACK_TYPE = callback;
	}

	/*****************************************
	 //* @param willProvide the @FunctionalInterface type that the callback instance will be
	 * @param <T> Type argument
	 * @return a new Event\<C\> instance -> only used for Event definition at presenter instance creation
	 *
	 * 		todo probably move this to a new class, confuse this with others probably
	 ****************************************/
	public static <T> Event<T> bind() {
		return null;
	}

	public interface Messager<T> {
		void send();
	}

	public Messager<C> create(C call) {
		return new Messager<C>() {
			@Override
			public void send() {

			}
		};
	}

	/*****************************************
	 *
	 * Call from the view when the event actually occurs
	 *
	 * todo how to mock an interface with an object i.e.
	 * todo separate the definition from the view creating an implementation
	 * todo all while clearly expressing that the 2 are related.. on to retrolambda
	 * sure it's easy but hard to think of so many things at once
	 *
	 * @param callback the actual callback type (lambda expression)
	 * @return runtime instance of event for view to do whatever with
	 ****************************************/
	public Event<C> send(C callback) {
		return new Event<>(this.CALLBACK_TYPE);
	}

	/*****************************************
	 * @return the callback instance
	 ****************************************/
	public C get() {
		return this.DYNAMIC_CALLBACK != null ? DYNAMIC_CALLBACK.get() : null; // <-- here is where runtime callback "capture" of variables occurs
	}

	/*****************************************
	 * @param callback used in the background to
	 *                   resolve references to callback implementations
	 ****************************************/
	void setCallReference(C callback) {
		this.DYNAMIC_CALLBACK = new WeakReference<>(callback);
	}
	
	/*****************************************
	 * Drops reference to closure/lambda//anonymous class
	 ****************************************/
	@Deprecated // WeakReference and catch null pointer
	// because infer object is recreated at the point we provide the reference
	void dropCallback() {
		DYNAMIC_CALLBACK = null;
	}

	/*****************************************
	 * idea -> client cant dynamically bind extra event args, each one added will
	 * return another instance of event<n + 1> so client adds behaviour dynamically? maybe...
	 *
	 * 	Syntax when defining an event would be something like:
	 *
	 * 	public final Event\<CallbackImpl\> DEFINED_EVENT = Events.define(CallbackImpl.class)
	 * 			.with(RequiredArgument.class)
	 * 		   .with(Second_Argument.class)
	 *
	 *		Which will return an EVENT_2\<CallbackImpl\, RequiredArgument, SecondArgument>
	 *
	 * TODO probably can do this at compile time instead of writing it out
	 ****************************************/
	private static final class _VARARG_IMPL {

		private static class EVENT_1<A, B> extends Event<A> {
			private final Class<B> CALLBACK_TYPE;
			EVENT_1(Class<A> param, Class<B> param2) {
				super(param);
				CALLBACK_TYPE = param2;
			}

		}

		private static final class EVENT_2<A, B, C> extends EVENT_1<A, B> {
			private final Class<C> CALLBACK_TYPE;
			EVENT_2(Class<A> param, Class<B> param2, Class<C> param3) {
				super(param, param2);
				CALLBACK_TYPE = param3;
			}
		}
	}
}
