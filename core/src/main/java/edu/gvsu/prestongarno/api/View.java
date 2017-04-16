package edu.gvsu.prestongarno.api;

/****************************************
 * Created by preston on 4/16/17.
 *
 * Interface for the view to provide an entry point to the thread
 * Use this with unsafe UI threads
 ****************************************/
public interface View {
	/*****************************************
	 * The default behaviour of this method is to run the runnable
	 * on whichever thread the presenter calls back to the view on
	 *
	 * Override this method if the UI is not thread-safe and
	 * the runnable needs to be submitted somewhere
	 * @param r the callback
	 ****************************************/
	default void onCallback(Runnable r) {
		r.run();
	}
}
