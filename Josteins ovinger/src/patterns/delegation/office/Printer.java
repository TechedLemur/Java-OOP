package patterns.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
	
	private Map<Employee, List<String>> history = new HashMap<>();
	
	public void printDocument(String document, Employee employee) {
		if (history.containsKey(employee)) 
			history.get(employee).add(document);
		else {
			List<String> docs = new ArrayList<String>();
			docs.add(document);
			history.put(employee, docs);
		}
	}
	
	public List<String> getPrintHistory(Employee employee){
		if (history.containsKey(employee))
			return history.get(employee);
		return new ArrayList<String>();
		
	}
}
