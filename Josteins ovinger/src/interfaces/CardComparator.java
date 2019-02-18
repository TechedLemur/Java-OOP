package interfaces;

import java.util.Comparator;

public class CardComparator implements Comparator<Card>{
	
	private boolean ace;
	private char trumf;
	
	public CardComparator(boolean ace, char trumf) {
		this.ace = ace;
		this.trumf = trumf;
	}

	@Override
	public int compare(Card o1, Card o2) {
		if (o1.getSuit() == trumf) {
			if (o2.getSuit() != trumf)
				return 1;
			else if (ace) {
				if (o1.getFace() == o2.getFace())
					return 0;
				if (o1.getFace() == 1)
					return 1;
				else if (o2.getFace() == 1)
					return -1;
			} else
				return o1.compareTo(o2);
		}
		if (ace) {
			if(o1.getSuit() != o2.getSuit())
				return o1.compareTo(o2);
			if (o1.getFace() == o2.getFace())
				return 0;
			if (o1.getFace() == 1)
				return 1;
			else if (o2.getFace() == 1)
				return -1;
				
		}
		return o1.compareTo(o2);

	}
}
