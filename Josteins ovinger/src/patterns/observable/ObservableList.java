package patterns.observable;

import java.util.ArrayList;


public abstract class ObservableList {

	protected ArrayList<Object> results = new ArrayList<>();
	protected ArrayList<ObservableListListener> listeners = new ArrayList<>();
	
	public int size() {
		return results.size();
	}
	
	public Object getElement(int i) {
		return results.get(i);
	}

	public abstract boolean acceptsElement(Object o);
	
	public void addElement(Object o) {
		if (!acceptsElement(o))
			throw new IllegalArgumentException();
		results.add(o);
		listeners.forEach(c->c.listChanged(this, size()-1));
	}
	
	public void addElement(int i, Object o) {
		if (!acceptsElement(o))
			throw new IllegalArgumentException();
		if (i < 0 || i > size())
			throw new IndexOutOfBoundsException();
		results.add(i, o);
		listeners.forEach(c->c.listChanged(this, i));
	}
	
	public void removeElement(int i) {
		if (i < 0 || i >= size())
			throw new IndexOutOfBoundsException();
		results.remove(i);
	}
	
	public void addObservableListListener(ObservableListListener listener){
		listeners.add(listener);
	}
	
	public void removeObservableListListener(ObservableListListener listener) {
		listeners.remove(listener);
	}
}
