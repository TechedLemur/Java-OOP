package encapsulation;

import java.util.Stack;

public class RPNCalc {
	
	private Stack<Double> stack = new Stack<Double>();
	
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
	
	public void performOperation(char c) {
		if (c == '+') {
			stack.push((stack.pop()+stack.pop()));
		}
		else if (c == '-') {
			stack.push(-(stack.pop())+stack.pop());
		}
		else if (c == '*') {
			stack.push((stack.pop()*stack.pop()));
		}
		else if (c == '/') {
			stack.push(1/(stack.pop()/stack.pop()));
		}
		else if (c == '~') {
			double a = stack.pop();
			double b = stack.pop();
			stack.push(a);
			stack.push(b);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
