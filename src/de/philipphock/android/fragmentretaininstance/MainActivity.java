package de.philipphock.android.fragmentretaininstance;

import de.philipphock.android.lib.TaskCallbacks;
import de.philipphock.android.lib.TaskFragment;
import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity implements TaskCallbacks<MyTask>{

	private TaskFragment<MyTask> taskFragment; 
	private static final String TASK_FRAGMENT_TAG = "taskFragment";
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager fm = getFragmentManager();
		taskFragment = (TaskFragment<MyTask>) fm.findFragmentByTag(TASK_FRAGMENT_TAG);
		
		if (taskFragment == null) {
			taskFragment = new DummyTaskFragment();
		    fm.beginTransaction().add(taskFragment, TASK_FRAGMENT_TAG).commit();
		 }				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onStart() {
		super.onStart();
	}
	
	@Override
	protected void onStop() {
		
		super.onStop();
	}
	
	@Override
	protected void onRestart() {
		
		super.onRestart();
	}

	@Override
	public void onPreExecute() {
		
	}

	@Override
	public void onPostExecute() {
		
	}

	@Override
	public void onCancelled() {
		
	}




	@Override
	public void onUpdate(MyTask task) {
		Log.d("Test",task.getCounter()+"");
//		runOnUiThread(new Runnable() {
//			
//			@Override
//			public void run() {
//				//TextView statusTextView = (TextView) findViewById(R.id.status);
//				//statusTextView.setText(t.getCounter());				
//			}
//		});
		
	}

}
