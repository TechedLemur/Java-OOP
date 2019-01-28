package encapsulation;

public class Nim {
	
	private int[] piles = {10,10,10};
	private boolean finished = false;
	
	public Nim() {
		}
	
	public Nim(int pileSize) {
		if (pileSize < 1)
			throw new IllegalArgumentException("Må ha minst 1 brikke i haugene");
		else {
			piles[0] = pileSize;
			piles[1] = pileSize;
			piles[2] = pileSize;
		}
			
	}
	public int getPile(int targetPile) {
		if (targetPile < 0 || targetPile > 2)
			throw new IllegalArgumentException("Må velge en av 3 hauger");
		else
			return piles[targetPile];
	}
	
	public void removePieces(int number, int targetPile) {
		if (finished)
			throw new IllegalStateException("Spillet er allerede ferdig");
		if (targetPile < 0 || targetPile > 2)
			throw new IllegalArgumentException("Må velge en av 3 hauger");
		if (number < 1 || piles[targetPile] - number < 0)
			throw new IllegalArgumentException("Feil");
//		if (piles[targetPile] - number < 0)
//			throw new IllegalStateException("Kan ikke fjerne mer enn det er i en haug");
		else {
			piles[targetPile] = piles[targetPile] - number;
			if (piles[targetPile] == 0)
				finished = true;
		}
	}
	
	public boolean isGameOver() {
		return finished;
	}
	
	public boolean isValidMove(int number, int targetPile) {
		if (finished)
			return false;
		if (targetPile < 0 || targetPile > 2)
			return false;
		if (number < 1 || piles[targetPile] - number < 0)
			return false;
		else 
			return true;
	}
	
	@Override
	public String toString() {
		return "Pile 0: " + piles[0] + "     Pile 1: " + piles[1] + "     Pile 2: " + piles[2] + "     Finished: " + finished; 
	}
	
	public static void main(String[] args) {
		Nim n1 = new Nim();
		n1.removePieces(5, 1);
		System.out.println(n1);
		n1.removePieces(5, 1);
		System.out.println(n1);
		// TODO Auto-generated method stub

	}

}
