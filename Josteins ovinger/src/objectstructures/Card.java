package objectstructures;

public class Card {
	
	private char suit;
	private int face;
	
		
	public char getSuit() {
		return suit;
	}


	public int getFace() {
		return face;
	}



	public Card(char suit, int face) {
		if (!(suit == 'H' || suit == 'S' || suit == 'D' || suit == 'C'))
			throw new IllegalArgumentException("Ugyldig suit");
		if (face < 1 || face > 13)
			throw new IllegalArgumentException("Ugyldig face");
		
		this.suit = suit;
		this.face = face;	
	}
	
	
	
	@Override
	public String toString() {
		return ""+ suit + face;
	}


	public static void main(String[] args) {
		Card c1 = new Card('H', 12);
		System.out.println(c1);

	}

}
