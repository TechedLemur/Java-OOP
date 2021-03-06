package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class CardHand {
	
	private List<Card> cards = new ArrayList<Card>();
	
	public int getCardCount() {
		return cards.size();
	}
	
	public Card getCard(int n) {
		if (n < 0 || n >= this.getCardCount())
			throw new IllegalArgumentException();
		return cards.get(n);
	}
	
	public void addCard(Card card){
		cards.add(card);
	}
	
	public Card play(int n) {
		if (n < 0 || n >= this.getCardCount())
			throw new IllegalArgumentException();
		return cards.remove(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
