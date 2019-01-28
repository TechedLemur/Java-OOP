package encapsulation;


//virker ikke som testen ønsker
public class Rectangle {
	private int minX; 
	private int minY; 
	private int maxX; 
	private int maxY; 
	private int height; 
	private int width;
	public Rectangle() {
		this.minX = 0; 
		this.minY = 0; 
		this.maxX = 0; 
		this.maxY = 0; 
		this.height = maxY - minY; 
		this.width = maxX - minX;
		
	}
	public Rectangle(int minX, int minY,int maxX, int maxY ){
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.height = maxY - minY; 
		this.width = maxX - minX;
		
	}
	public int getMinX() {
		return minX;
	}

	public int getMinY() {
		return minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public boolean isEmpty() {
		if (width == 0 || height==0) {
			return true;
		}
		return false;
	}
	
	
	public boolean contains(int x, int y) {
		if (this.maxX < x || x < this.minX) {
			return false;
		}
		if (this.maxY < y || y < this.minY) {
			return false;
		}
		return true;
	}
	
	public boolean contains(Rectangle rect) {
		if (rect.getMaxX() > this.maxX || rect.getMinX() < this.minX) {
			return false;
		}
		if (rect.getMaxY() > this.maxY || rect.getMinY() < this.minY) {
			return false;
		}
		return true;
	}
	
	
	public boolean add(int x, int y) {
		if (this.isEmpty()) {
			this.maxX = x;
			this.minX = x;
			this.maxY = y;
			this.minY = y;
			this.height = maxY - minY; 
			this.width = maxX - minX;
			return true;
		}
		boolean change = !contains(x,y);
		if (x > this.maxX) {
			this.maxX = x;
		}
		if (x < this.minX) {
			this.minX = x;
		}
		if (y > this.maxY) {
			this.maxY = y;
		}
		if (y < this.minY) {
			this.minY = y;
		}
		this.height = maxY - minY; 
		this.width = maxX - minX;
		return change;
	}
	
	public boolean add(Rectangle rect) {
		
		if (rect.isEmpty()) {
			return false;
		}
		boolean change = !contains(rect);
		if (rect.getMaxX() > this.maxX) {
			this.maxX = rect.getMaxX();
		}
		if (rect.getMinX() < this.minX) {
			this.minX = rect.getMinX();
		}
		if (rect.getMaxY() > this.maxY) {
			this.maxY = rect.getMaxY();
		}
		if (rect.minY < this.minY) {
			this.minY = rect.getMinY();
		}
		this.height = maxY - minY; 
		this.width = maxX - minX;
		return change;
	}
	
	public Rectangle union(Rectangle rect) {
		if (rect.isEmpty()) {
			return this;
		}
		else {
			return new Rectangle(
					Math.min(this.minX, rect.getMinX()), 
					Math.min(this.minY, rect.getMinY()), 
					Math.max(this.maxX, rect.getMaxX()), 
					Math.max(this.maxY, rect.getMaxY()));
		}
	}
	
	public String toString() {
		return "Rectangle: Width = " + width + ", Height = " + height 
				+" Nederste venstre hjørne: (" + minX + ", " + minY 
				+ "), Øverste høyre hjørne: (" + maxX + ", " + maxY + ") ";
	}




	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle();
		Rectangle r3 = new Rectangle(-1,-2,4,5);
		Rectangle r4 = new Rectangle();
		System.out.println(r3);;
		r2.add(-3, 4);
		
		r1.add(2,3);
		System.out.println(r1);
		r1.add(-1, -4);
		System.out.println(r1);
		r1.add(r2);
		System.out.println(r1);
		r4.add(r2);
		Rectangle r5 = r3.union(r4);
		System.out.println(r5);
		System.out.println(r5.contains(1, 2));
	}

}
