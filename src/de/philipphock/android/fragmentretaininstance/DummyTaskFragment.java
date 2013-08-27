package de.philipphock.android.fragmentretaininstance;

import de.philipphock.android.lib.TaskCallbackUpdatable;
import de.philipphock.android.lib.TaskFragment;

public class DummyTaskFragment extends TaskFragment<MyTask> {

	private MyTask task;
	
	@Override
	public void execute() {
		if (callbackActivity !=null){
			task = new MyTask(callbackActivity);
			task.execute();
		}
		
	}

	@Override
	public TaskCallbackUpdatable<MyTask> getTask() {
		
		return task;
	}

}
