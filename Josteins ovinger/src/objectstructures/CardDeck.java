package objectstructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDeck {
	
	private List<Card> cards = new ArrayList<Card>();
	private char[] suits = {'S', 'H', 'D', 'C'};
	
	public CardDeck(int n) {
		
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= n; j++) {
				cards.add(new Card(suits[i], j));
			}
		}
	}
	
	public int getCardCount() {
		return cards.size();
	}
	
	public Card getCard(int n) {
		if (n < 0 || n >= this.getCardCount())
			throw new IllegalArgumentException();
		return cards.get(n);
	}
	
	public void deal(CardHand hand, int n) {
		if (n < 0 || n >= this.getCardCount())
			throw new IllegalArgumentException();
		for (int i = 0; i < n; i++) {
			hand.addCard(this.cards.remove(this.getCardCount()-1));
		}
		
		
	}
	public void shufflePerfectly() {
		List<Card> del1 = cards.subList(0, this.getCardCount() / 2 );
		List<Card> del2 = cards.subList(this.getCardCount() / 2, this.getCardCount());
		List<Card> cards_temp = new ArrayList<Card>();
		
		for (int i = 0; i < this.getCardCount() / 2; i++) {
			cards_temp.add(del1.get(i));
			cards_temp.add(del2.get(i));
		}
		this.cards = cards_temp;
	}

	public static void main(String[] args) {
		CardDeck c = new CardDeck(7);
		System.out.println(Arrays.deepToString(c.cards.toArray()));
		c.shufflePerfectly();
		System.out.println(Arrays.deepToString(c.cards.toArray()));
	}

}
