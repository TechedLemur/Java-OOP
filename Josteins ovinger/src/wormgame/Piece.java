package wormgame;

public class Piece {
	
	private int x, y;
	
	

	public Piece(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean runsInto(Piece piece) {
		if (this.x == piece.getX() && this.y == piece.getY())
			return true;
		return false;
	}


	public int getX() {
		return x;
	}



	public int getY() {
		return y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
