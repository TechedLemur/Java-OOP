package wormgame;

import java.util.ArrayList;
import java.util.List;

public class Worm {
	
	private List<Piece> pieces = new ArrayList<Piece>();
	private Direction direction;
	
	private boolean grows = false;
	
	public int getLength() {
		return pieces.size();
		
	}
	
	public List<Piece> getPieces(){
		return this.pieces;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	
	public Worm(int originalX, int originalY, Direction originalDirection) {
		this.pieces.add(new Piece(originalX, originalY));
		this.direction = originalDirection;
		
	}

	public void grow() {
		this.grows = true;
		
	}
	
	public boolean runsInto(Piece piece) {
		if (pieces.get(pieces.size()-1).runsInto(piece))
			return true;
		return false;
	}
	
	
	public boolean runsIntoItself() {
		for (int i = 0; i < (this.getLength() - 2); i++) {
			if (pieces.get(pieces.size()-1).runsInto(pieces.get(i)))
				return true;
		}
		return false;
		
	}
	
	public void move() {
		Piece currentFront = pieces.get(pieces.size()-1);
		int currentX = currentFront.getX();
		int currentY = currentFront.getY();
		if (this.getLength() > 2)
			if (!grows)
				pieces.remove(0);
		
		
		if (this.direction == Direction.UP) 
			pieces.add(new Piece(currentX, currentY-1));			
		
		else if (this.direction == Direction.RIGHT)
			pieces.add(new Piece(currentX + 1, currentY));
		
		else if (this.direction == Direction.DOWN)
			pieces.add(new Piece(currentX, currentY + 1));
		
		else if (this.direction == Direction.LEFT)
			pieces.add(new Piece(currentX - 1, currentY));
		
		this.grows = false;
					
	}
	
	
	public static void main(String[] args) {
		Worm worm = new Worm(5, 5, Direction.RIGHT);
        System.out.println(worm.getPieces());
        worm.move();
        System.out.println(worm.getPieces());
        worm.move();
        System.out.println(worm.getPieces());
        worm.move();
        System.out.println(worm.getPieces());

        worm.grow();
        System.out.println(worm.getPieces());
        worm.move();
        System.out.println(worm.getPieces());

        worm.setDirection(Direction.LEFT);
        System.out.println(worm.runsIntoItself());
        worm.move();
        System.out.println(worm.runsIntoItself());

	}

}
