package edu.gvsu.prestongarno.api;

/****************************************
 * Created by preston on 4/16/17.
 *
 * Base class with static factory methods
 ****************************************/
public class EzMVP {

	/*****************************************
	 * Initialize the presenter without receiving an instance of it.
	 * Call this if you do not need a actual reference and can implicitly send events
	 * @param view the view instance
	 ****************************************/
	public static void initialize(View view) {
		// create presenter, get queue instance, etc
	}

	/*****************************************
	 * This method will return an instance of the presenter after it is initialized.
	 * If a different class is provided to this method than the class specified in the
	 * annotation Link{edu.gvsu.prestongarno.annotations.Presenter}, then compilation will fail
	 * @param v the view instance
	 * @param presenter the class of the presenter
	 * @param <P> the presenter type
	 * @return P, the presenter that was initialized
	 ****************************************/
	public static <P> P initialize(View v, Class<?> presenter) {
		// when the view wants an instance of presenter
		return null;
	}
	/*****************************************
	 * Implicitly send a method to the presenter instance
	 * @param event the event to send to the presenter
	 * @param <C> the callback type
	 ****************************************/
	public static <C> void onEvent(Event<C> event) {
		// this is where the magic happens
	}

	/*****************************************
	 * Called when the view is animating or being re-created
	 *
	 * Example: Android screen rotation
	 * @param v the view that was paused
	 ****************************************/
	public static void pauseAll(View v) {

	}


}
