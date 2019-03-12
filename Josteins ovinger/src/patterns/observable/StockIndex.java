package patterns.observable;

import java.util.ArrayList;

public class StockIndex implements StockListener{

	private String name;
	private double index;
	private ArrayList<Stock> stocks = new ArrayList<>();
	
	public StockIndex(String name, Stock... stocks) {
		this.name = name;
		if (stocks.length == 0)
			this.index = 0;
		else {
			for (Stock stock:stocks) {
				this.stocks.add(stock);
				this.index = this.index + stock.getPrice();
			}
		}
	}
	
	private void updateIndex() {
		this.index = 0;
		for (Stock stock:stocks) {
			this.index = this.index + stock.getPrice();
		}
	}
	public void addStock(Stock stock) {
		if (stocks.contains(stock))
			return;
		this.stocks.add(stock);
		updateIndex();
	}
	
	public void removeStock(Stock stock) {
		this.stocks.remove(stock);
		updateIndex();
	}
	
	public double getIndex() {
		updateIndex();
		return index;
	}
	
	
	@Override
	public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
//		int i = stocks.indexOf(stock);
//		if (stock.getPrice() == newValue)
//			return;
//		stocks.get(i).setPrice(newValue);
		updateIndex();
		
	}

	
	
}
