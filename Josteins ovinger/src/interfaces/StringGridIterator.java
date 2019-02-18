package interfaces;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String>{

	private StringGrid grid;
	private boolean rowMajor;
	private int x; 
	private int y;
	private int x1; 
	private int y1;
	public StringGridIterator(StringGrid grid, boolean rowMajor) {
		this.grid = grid;
		this.rowMajor = rowMajor;
		if (rowMajor) {
			this.x = -1;
			this.y = 0;
	    }
		else {
			this.y = -1;
			this.x = 0;
		}
	}		
			
	
	@Override
	public boolean hasNext() {
		if (this.y1 == grid.getRowCount()-1 && this.x1 == grid.getColumnCount()-1)
			return false;
		return true;
	}

	@Override
	public String next() {
		if(!this.hasNext())
			return null;
		String ans;
		if (rowMajor) {
			x++;
			ans = grid.getElement(y, x);
			x1 = this.x;
			y1 = this.y;
			if (x == grid.getColumnCount()-1) {
				x = -1;
				y++;
			}
			
		}
		else {
			y++;
			ans = grid.getElement(y, x);
			x1 = this.x;
			y1 = this.y;
			if (y == grid.getRowCount() -1) {
				y = -1;
				x++;
			}
		}
		return ans;
	}	
	
	public void remove() {
		throw new UnsupportedOperationException("no u");
	}
	public static void main(String[] args) {
		StringGrid g = new StringGridImpl(2, 3);
		g.setElement(0, 1, "Hei");
		g.setElement(1, 0, "Hallo");
		StringGridIterator i = new StringGridIterator(g, true);
		//System.out.println(g);
		for (String s: g) {
			System.out.println(s);
		}
	}

}
