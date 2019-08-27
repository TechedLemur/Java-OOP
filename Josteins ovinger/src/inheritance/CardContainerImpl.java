package inheritance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainerImpl implements CardContainer {

	private int maxCardCount;
	
	public CardContainerImpl(int maxCardCount) {
		this.maxCardCount = maxCardCount;
	}
	
	public int getMaxCardCount() {
		return maxCardCount;
	}
	
	
	protected List<Card> cards = new ArrayList<Card>();
	

	@Override
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}

	@Override
	public int getCardCount() {
		return cards.size();
	}

	@Override
	public Card getCard(int n) {
		if (n < 0 || n >= this.getCardCount())
			throw new IllegalArgumentException();
		return cards.get(n);
	}

}
