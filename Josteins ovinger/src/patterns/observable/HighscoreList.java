package patterns.observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighscoreList {
	
	private int maxSize;
	private ArrayList<Integer> results;
	private ArrayList<HighscoreListListener> listeners = new ArrayList<>();
	
	public HighscoreList(int maxSize) {
		this.maxSize = maxSize;
		results = new ArrayList<Integer>();
	}
	
	public int getElement(int i) {
		return results.get(i);
	}
	
	
	public int size() {
		return results.size();
	}
	
	
	public void addResult(int i) {
		ArrayList<Integer> oldlist = (ArrayList) results.clone();
		if (size() < maxSize) {
			results.add(i);
			Collections.sort(results);
			int d = diferIndex(oldlist, results);
			for (HighscoreListListener listener: listeners) {
				listener.listChanged(this, d);
			}
			return;
		}
		if (results.get(maxSize-1) > i ) {
		results.remove(maxSize-1);
		results.add(i);
		Collections.sort(results);
		int d = diferIndex(oldlist, results);
		for (HighscoreListListener listener: listeners) {
			listener.listChanged(this, d);
		}
		return;
		}
			
	}
	
	
	private int diferIndex(List<Integer> oldList, List<Integer> newList) {
		int max = oldList.size()-1;
		for (int i = 0; i<=max; i++) {
			if (!oldList.get(i).equals(newList.get(i)) ) {
				return i;
			}
		}
		return newList.size() -1;
	}
	
	public void addHighscoreListListener(HighscoreListListener listener){
		listeners.add(listener);
	}
	
	public void removeHighscoreListListener(HighscoreListListener listener) {
		listeners.remove(listener);
	}
	
	@Override
	public String toString() {
		return results.toString();
	}

}
