package inheritance;


public class CardHand extends CardContainerImpl {
	
	public CardHand(int maxCardCount) {
		super(maxCardCount);
	}

	public void addCard(Card card){
		if (getCardCount() >= getMaxCardCount())
			throw new IllegalStateException();
			cards.add(card);
		
	}
	
	public Card play(int n) {
		if (n < 0 || n >= this.getCardCount())
			throw new IllegalArgumentException();
		return cards.remove(n);
	}

	
	
	
}
