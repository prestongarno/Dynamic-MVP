package edu.gvsu.prestongarno.service;

import edu.gvsu.prestongarno.api.Event;

import java.lang.ref.WeakReference;
import java.util.LinkedList;

/**
 * Created by preston on 4/16/17.
 ****************************************/
final class ServiceBinder {
	//The main class that gets passed events and links with the View or just UI
	private ServiceBinder(){}

	static ServiceBinder getInstance(IPresenter presenter) {
		throw new UnsupportedOperationException();
	}

	void provide(Event e) {
		// link
	}

	private static final class VPpair<V, P> {
		final WeakReference<V> view;
		final P presenter;
		final LinkedList<Object/*Need to store pending results somehow*/> pending;
		/*****************************************
		 * This is the class which links presenter-> view
		 * @param view the view instance
		 * @param presenter the presenter
		 ****************************************/
		VPpair(V view, P presenter) {
			this.view = new WeakReference<>(view);
			this.presenter = presenter;
			pending = null;
		}
	}
}
