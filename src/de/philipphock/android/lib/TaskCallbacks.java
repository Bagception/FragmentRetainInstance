package de.philipphock.android.lib;

public interface TaskCallbacks<E> {

	
		void onPreExecute();
		void onPostExecute();
		void onCancelled();
		void onUpdate(E task);
		
	
}
