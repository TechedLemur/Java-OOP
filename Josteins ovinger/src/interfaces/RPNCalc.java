package interfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class RPNCalc {
	
	private Stack<Double> stack = new Stack<Double>();
	
	private Map<Character, BinaryOperator<Double>> operations = new HashMap<>();
	
	public void push(double n) {
		stack.push(n);
	}
	
	
	
	public double pop() {
		if (stack.isEmpty())
			return Double.NaN;
		return stack.pop();
	}
	
	public int getSize() {
		return stack.size();
	}
	
	public double peek(int n) {
		if (n >= stack.size() || stack.isEmpty())
			return Double.NaN;
		return stack.get(stack.size()-(n+1));
	}
	
	
	public boolean addOperator(char c, BinaryOperator<Double> operator) {
		if(operations.containsKey(c))
			return false;
		else
			operations.put(c, operator);
		return true;
		
	}
	public void removeOperator(char c) {
		operations.remove(c);
	}
	
	public void performOperation(char c) {
		if (!operations.containsKey(c))
			throw new UnsupportedOperationException();
		double a = this.pop();
		double b = this.pop();
		this.push(operations.get(c).apply(b, a));
	}
	

}
