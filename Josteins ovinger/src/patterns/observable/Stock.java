package patterns.observable;

import java.util.ArrayList;

public class Stock {
	
	protected String ticker;
	protected double price;
	protected ArrayList<StockListener> listeners = new ArrayList<>();
	
	public Stock(String ticker, double price) {
		this.ticker = ticker;
		this.price = price;
	}
	
	public void setPrice(double price) {
		
		if (price < 0)
			throw new IllegalArgumentException();
		
		for (StockListener listener : listeners) {
			listener.stockPriceChanged(this, this.price, price);
		}
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	public String getTicker() {
		return ticker;
	}
	public void addStockListener(StockListener listener) {
		listeners.add(listener);
	}
	
	public void removeStockListener(StockListener listener) {
		listeners.remove(listener);
	}
	
}
