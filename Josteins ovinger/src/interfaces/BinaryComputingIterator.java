package interfaces;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double> {
	private Double default1;
	private Double default2;
	private BinaryOperator<Double> operator;
	private Iterator<Double> iterator1;
	private Iterator<Double> iterator2;
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, 
			BinaryOperator<Double> operator) {
			this.iterator1 = iterator1;
			this.iterator2 = iterator2;
			this.operator = operator;
	}
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, 
			Double default1, Double default2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.operator = operator;
		this.default1 = default1;
		this.default2 = default2;
	}
	
	@Override
	public boolean hasNext() {
		if(!(iterator1.hasNext() || iterator2.hasNext()))
			return false;
		if (!iterator1.hasNext() && default1 == null)
			return false;
		if (!iterator2.hasNext() && default2 == null)
			return false;
		return true;
	}

	@Override
	public Double next() {
		if (!this.hasNext())
			return null;

		if (!iterator2.hasNext() && default2 != null){
			return operator.apply(iterator1.next(), default2);
		}
		else if (!iterator1.hasNext() && default1 != null)
			return operator.apply(default1, iterator2.next());
		else 
			return operator.apply(iterator1.next(), iterator2.next());
	}
	
	

}
