package patterns.observable;

import java.util.HashMap;
import java.util.Map;

public class SmartStock extends Stock{
	
	private Map<StockListener, Double[]> intervals= new HashMap<>();
	private Map<StockListener, Double[]> differences= new HashMap<>();
	public SmartStock(String ticker, double price) {
		super(ticker, price);
	}
	

	@Override
	public void setPrice(double price) {
		
		if (price < 0)
			throw new IllegalArgumentException();
		if (this.price == price)
			return;
		for (StockListener listener : listeners) {
			if (intervals.containsKey(listener)) {
				if(intervals.get(listener)[0] > price || intervals.get(listener)[1] < price)
					listener.stockPriceChanged(this, this.price, price);
			}
			else if (differences.containsKey(listener)){
				if (Math.abs(differences.get(listener)[1] - price) > differences.get(listener)[0]) {
					Double diff = differences.get(listener)[0];
					Double oldPrice = differences.get(listener)[1];
					Double[] newarg = {diff, price};
					listener.stockPriceChanged(this, oldPrice, price);
					differences.put(listener, newarg);
				}
			}
			else {
				listener.stockPriceChanged(this, this.price, price);
			}
			
		}
		this.price = price;
	}
	
	
	
	public void addStockListener(StockListener listener, double min, double max) {
		Double[] interval = {min, max};
		intervals.put(listener, interval);
		listeners.add(listener);
	}
	public void addStockListener(StockListener listener, double difference) {
		listeners.add(listener);
		Double[] diff = {difference, price};
		this.differences.put(listener, diff);
	}
	
	public static void main(String[] args) {
		SmartStock s1 = new SmartStock("Apple", 2.1);
		System.out.println(s1.getTicker());
	}
}


