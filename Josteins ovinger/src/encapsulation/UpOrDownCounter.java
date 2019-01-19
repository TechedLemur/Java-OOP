package encapsulation;

public class UpOrDownCounter {
	private int counter;
	private int end;
	
	public UpOrDownCounter(int start, int end) {
		if (start == end) {
			throw new IllegalArgumentException("Start må være ulik end");
		}
		else {
			this.counter = start;
			this.end = end;
		}
	}
	
	public int getCounter() {
		return counter;
	}
	
	public boolean count(){
		if (counter < end) {
			counter++;
		}
		else if (counter > end) {
			counter--;
		}
		if (counter==end) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		return Integer.toString(counter);
	}
	
	

	public static void main(String[] args) {
		UpOrDownCounter c1 = new UpOrDownCounter(20,1);
		System.out.println(c1);
		while (c1.count()) {
			System.out.println(c1);
		}
		System.out.println(c1);


	}

}
