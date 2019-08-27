package inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CardDeck extends CardContainerImpl {
	
	private char[] suits = {'S', 'H', 'D', 'C'};
	
	public CardDeck(int n) {
		super(52);
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= n; j++) {
				cards.add(new Card(suits[i], j));
			}
		}
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
	
	
	public boolean hasCard(Predicate<Card> predicate) {
		for (Card card: cards) {
			if (predicate.test(card))
				return true;
		}
		return false;
	}

	public int getCardCount(Predicate<Card> predicate) {
		int i = 0;
		for (Card card: cards) {
			if (predicate.test(card))
				i++;
		}
		return i;
	}
	
	public List<Card> getCards(Predicate<Card> predicate){
		List<Card> liste = new ArrayList<>();
		for (Card card: cards) {
			if (predicate.test(card))
				liste.add(card);
		}
		return liste;
	}
	
	
	public static void main(String[] args) {
		CardDeck c = new CardDeck(7);
		System.out.println(Arrays.deepToString(c.cards.toArray()));
		c.shufflePerfectly();
		System.out.println(Arrays.deepToString(c.cards.toArray()));
	}

	

}
