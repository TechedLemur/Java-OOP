package debugging;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringMergingIterator implements Iterator<String> {

	private Iterator<String> first;
	private Iterator<String> second;
	private boolean turnSwitch;

	public StringMergingIterator(Iterator<String> first, Iterator<String> second){
		this.first = first;
		this.second = second;
		this.turnSwitch = true;
	}

	@Override
	public boolean hasNext() {
		return first.hasNext() || second.hasNext();
	}

	@Override
	public String next() {
		
		if(! hasNext()){ throw new NoSuchElementException(); }

		String result = null;
		
		if(first.hasNext() && turnSwitch){ 		// removed "!" and added switching
			result = first.next();
			turnSwitch = false;					
		} 
		else if( second.hasNext() && !turnSwitch){
			result = second.next();
			turnSwitch = true;
		} 
		else {
			if(turnSwitch && second.hasNext()){ 	// if one iterator has maxed-> add rest in order
				result = second.next();
			}
			if(!turnSwitch && first.hasNext()){
				result = first.next();
			}
			
		}
		
		return result;
	}
	
	
}
