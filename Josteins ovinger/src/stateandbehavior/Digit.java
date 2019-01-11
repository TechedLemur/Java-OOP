package stateandbehavior;

public class Digit {
	
	int value;
	int base;
	
	public Digit(int base) {
		this.base = base;
		this.value = 0;
	}
	
	public boolean increment() {
		value ++;
		if (value == base) {
			value = 0;
			return true;			
		}
		return false;
	}
	

	public int getValue() {
		return value;
	}



	public int getBase() {
		return base;
	}


	public String toString() {
		
		if (value < 10) {
			return ""+ value;
			//"Tallsystem er: " + base + ", verdi er: " + 
		}
		else {
			//"Tallsystem er: " + base + ", verdi er: " + 
			return "" + (char)(55 + value);
			
		}
		
	}
	public static void main(String[] args) {
		Digit d1 = new Digit(12);
		Digit d2 = new Digit(12);
		Digit d3 = new Digit(12);
		//System.out.println(d1.toString()+d2.toString()+d3.toString());
		for (int i = 0; i < d1.getBase(); i++) {
			for (int j = 0; j < d1.getBase(); j++) {
				for (int k = 0; k < d1.getBase(); k++) {
					
					System.out.println(d1.toString()+d2.toString()+d3.toString());
					d3.increment();
				}
				d2.increment();
			}
			d1.increment();
		}
		System.out.println(d1.toString()+d2.toString()+d3.toString());
		
		
		}

	}


