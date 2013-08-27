package de.philipphock.android.fragmentretaininstance;

import de.philipphock.android.lib.TaskCallbacks;
import android.os.AsyncTask;
import android.util.Log;

public class MyTask extends AsyncTask<Void, Integer, Void> {
	private TaskCallbacks<MyTask> t;
	private volatile boolean running=true;
	private int counter = 0;
	
	public MyTask(TaskCallbacks<MyTask> t) {
		this.t=t;
	}
	
	public int getCounter() {
		return counter;
	}
	
	@Override
	protected void onCancelled() {
		super.onCancelled();
		if (t ==null){
			Log.d("Test","NULL ON CANCELLED");
		}else{
			t.onCancelled();			
		}
		
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		if (t ==null){
			Log.d("Test","NULL ON PREEXECUTE");
		}else{
			t.onPreExecute();			
		}
	}
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		if (t ==null){
			Log.d("Test","NULL ON POSTEXECUTE");
		}else{
			t.onPostExecute();			
		}
	}
	
	
	
	@Override
	protected Void doInBackground(Void... params) {
		t.onPreExecute();
		while(running){
			counter++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t.onUpdate(this);
		}
		t.onPostExecute();
		return null;
	}
	
	public void stopThread(){
		running=false;
	}

}
