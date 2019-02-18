package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card implements Comparable{
	
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


	


	@Override
	public int compareTo(Object o) {
		int diff = (this.suit - ((Card) o).getSuit());
		if(diff == 0)
			diff = this.face - ((Card) o).getFace();
		return diff;
	}
	
	public static void main(String[] args) {
		Card c1 = new Card('H', 12);
		Card c2 = new Card('H', 5);
		Card c3 = new Card('S', 7);
		System.out.println(c2.compareTo(c3));
		List<Card> test = new ArrayList<>();
		test.add(c1);
		test.add(c2);
		test.add(c3);
		Collections.sort(test);
		System.out.println(test);

	}

}
