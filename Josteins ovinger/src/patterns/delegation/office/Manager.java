package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
	
	private ArrayList<Employee> employees;
	private int taskCount; 
	Manager (Collection<Employee> employees) {
		if (employees.isEmpty())
			throw new IllegalArgumentException();
		this.employees = new ArrayList<Employee>();
		this.employees.addAll(employees);
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		double result = employees.get(taskCount % employees.size()).doCalculations(operation, value1, value2);
		taskCount++;
		return result;
	}

	@Override
	public void printDocument(String document) {
		employees.get(taskCount % employees.size()).printDocument(document);
		taskCount++;
	}

	@Override
	public int getTaskCount() {
		return taskCount;
	}

	@Override
	public int getResourceCount() {
			return employees.stream().map(Employee::getResourceCount).reduce((a,b)-> (a+b)).get() + 1;
	}
	
	public static void main(String[] args) {
		Printer p1 = new Printer();
		Clerk c1 = new Clerk(p1);
		Clerk c2 = new Clerk(p1);
		Clerk c3 = new Clerk(p1);
		Collection<Employee> col = new ArrayList<Employee>();
		col.add(c1);
		col.add(c2);
		col.add(c3);
		Manager m1 = new Manager(col);
		System.out.println(m1.getResourceCount());
	}
}
