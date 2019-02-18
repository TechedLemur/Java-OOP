package interfaces;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card>{
	
	CardContainer container;
	int index = -1;
	public CardContainerIterator(CardContainer container) {
		this.container = container;
	}
	@Override
	public boolean hasNext() {
		if (index < container.getCardCount()-1)
			return true;
		return false;
	}

	@Override
	public Card next() {
		if(!this.hasNext())
			return null;
		index++;
		return container.getCard(index);
	}
	

}
