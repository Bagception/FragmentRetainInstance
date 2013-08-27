package de.philipphock.android.fragmentretaininstance;

import de.philipphock.android.lib.TaskFragment;

public class DummyTaskFragment extends TaskFragment<MyTask> {

	@Override
	public void execute() {
		if (callbackActivity !=null){
			MyTask t = new MyTask(callbackActivity);
			t.execute();
		}
		
	}

}
