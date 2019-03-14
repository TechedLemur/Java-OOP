package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public class ObservableHighscoreList extends ObservableList{
	
	private int maxSize;
	
	public ObservableHighscoreList(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public void addResult(int i) {
		ArrayList<Integer> oldlist = (ArrayList) results.clone();
		if (size() < maxSize) 
			results.add(i);
		else if((int)results.get(maxSize-1) > i) {
			results.remove(maxSize-1);
			results.add(i);
		}
		else
			return;
		results.sort((a,b) -> ((Integer)a).compareTo((Integer)b));
		int d = diferIndex(oldlist, results);
		listeners.forEach(c -> c.listChanged(this, d));
	}
	
	private int diferIndex(List<Integer> oldList, ArrayList<Object> results) {
		int max = oldList.size()-1;
		for (int i = 0; i<=max; i++) {
			if (!oldList.get(i).equals(results.get(i)) ) {
				return i;
			}
		}
		return results.size() -1;
	}

	@Override
	public boolean acceptsElement(Object o) {
		if (o.getClass() == Integer.class)
			return true;
		return false;
	}
	
}
