package interfaces;

import java.util.Iterator;

public interface CardContainer extends Iterable<Card> {
	Iterator<Card> iterator();
	int getCardCount();
	Card getCard(int n);
}
