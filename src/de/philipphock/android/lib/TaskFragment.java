package de.philipphock.android.lib;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

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
		Log.d("Test","attach: "+activity.getTaskId());
		TaskCallbackUpdatable<E> task = getTask();
		if (task!=null){
			task.updateTaskCallbacks((TaskCallbacks<E>)activity);
		}else{
			Log.d("Test","task is null");
		}
			
	}
	@Override
	public void onDetach() {
		super.onDetach();
		callbackActivity = null;
		TaskCallbackUpdatable<E> task = getTask();
		if (task!=null)
			task.updateTaskCallbacks(null);
	}
	
	public abstract void execute();
	
	/**
	 * 
	 * @return create
	 */
	public abstract TaskCallbackUpdatable<E> getTask();
}
