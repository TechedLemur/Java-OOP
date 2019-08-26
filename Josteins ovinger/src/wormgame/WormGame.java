package wormgame;

import java.util.Random;

public class WormGame {
	
	private Random rand = new Random();
	
	private int maxX, maxY;
	
	private Worm worm; 
	
	private Apple apple;
	private Piece[] metaApples;
	
	public boolean isGameOver() {
		if(worm.runsIntoItself())
			return true;
		
		Piece currentFront = worm.getPieces().get(worm.getPieces().size()-1);
		int currentX = currentFront.getX();
		int currentY = currentFront.getY();
		if (currentX < 0 || currentX > this.maxX)
			return true;
		
		else if (currentY < 0 || currentY > this.maxY)
			return true;
		
		return false;
	}
		
	public Worm getWorm() {
		return this.worm;
		
	}
	public Apple getApple() {
		return this.apple;
	}
	
	public void newApple() {
		boolean check = true;
		int i, x = 0, y = 0;
		while (check) {
			i = 0;
			x = rand.nextInt(maxX);
			y = rand.nextInt(maxY);
			Piece test = new Piece(x,y);
			for (Piece piece: worm.getPieces()) {
				if (test.runsInto(piece))
					i++;
			}
			if (i == 0)
				check = false;
		}
		this.apple = new Apple(x,y);
		
		Piece[] metaArray = {new Piece(x, y-1), new Piece(x, y+1), new Piece(x-1, y), new Piece(x+1, y)};
		this.metaApples = metaArray;
	}

	public void moveWorm() {
		this.worm.move();
	}
	
	public void growWorm() {
		this.worm.grow();
	}
	
	public boolean hitsApple() {
		if (this.worm.runsInto(this.apple))
			return true;
		for (Piece piece:this.metaApples) {
			if (this.worm.runsInto(piece))
				return true;
		}
		return false;
	}
	
	public void changeDir(Direction dir) {
		this.worm.setDirection(dir);
	}
	public WormGame(int width, int height) {
		
		this.maxX = width;
		this.maxY = height;
		this.worm = new Worm(width / 2, height / 2, Direction.DOWN);
		this.newApple();
		
		// TODO Auto-generated constructor stub
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
