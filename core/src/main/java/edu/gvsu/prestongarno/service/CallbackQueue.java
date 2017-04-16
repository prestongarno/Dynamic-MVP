package edu.gvsu.prestongarno.service;

/**
 * Created by preston on 4/16/17.
 *
 * This interface provides a way to communicate with the view ->
 * for each view class, generate a file that has a long switch statement
 * that will know which generated view method to invoke to get the correct callback type
 *
 * Callback queue always wraps callbacks in runnables
 * because the View might be running on a different thread
 */
interface CallbackQueue {
	Runnable dequeue();

	void queue(Runnable r);
}
