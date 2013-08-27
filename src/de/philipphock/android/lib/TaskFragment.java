package de.philipphock.android.lib;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public abstract class TaskFragment<E> extends Fragment{


	protected TaskCallbacks<E> callbackActivity=null;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setRetainInstance(true);
		execute();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		callbackActivity = (TaskCallbacks<E>) activity;
	}
	@Override
	public void onDetach() {
		super.onDetach();
		callbackActivity = null;
	}
	
	public abstract void execute();
}
