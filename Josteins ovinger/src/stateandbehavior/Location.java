package stateandbehavior;

public class Location {
	int x;
	int y;
	
	public void up() {
		y--;
	}

	public void down() {
		y++;
	}
	
	public void left() {
		x--;
	}
	
	public void right() {
		x++;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return "Location	x: " + x + ", y: " + y;
	}
	
	public static void main(String[] args) {
		Location l1 = new Location();
		System.out.println(l1);
		l1.up();l1.up();
		l1.right();
		l1.right();
		System.out.println(l1);
		l1.down();l1.left();
		System.out.println(l1);
	}

}
