package interfaces;

import java.util.Arrays;
import java.util.Iterator;

public class StringGridImpl implements StringGrid{
	
	private String[][] grid;
	private int rows;
	private int columnCount;
	
	public StringGridImpl(int rows, int columnCount) {
		this.grid = new String [rows][columnCount];
		this.rows = rows;
		this.columnCount = columnCount;
	}
	
	@Override
	public int getRowCount() {
		return rows;
	}

	@Override
	public int getColumnCount() {
		return columnCount;
	}

	@Override
	public String getElement(int row, int column) {
		return grid[row][column];
	}
	
	@Override
	public void setElement(int row, int column, String element) {
		grid[row][column] = element;		
	}
	
	@Override
	public String toString() {
		return Arrays.deepToString(grid);
	}
	
	public static void main(String[] args) {
		StringGridImpl g1 = new StringGridImpl(2, 3);
		g1.setElement(0, 1, "Hei");
		System.out.println(g1);
	}

	@Override
	public Iterator<String> iterator() {
		
		return new StringGridIterator(this, true);
	}
	

}
