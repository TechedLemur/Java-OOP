package interfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NamedComparator implements Comparator<Named>{

	@Override
	public int compare(Named o1, Named o2) {
		if(o1.getFamilyName().equals(o2.getFamilyName()))
			return o1.getGivenName().compareTo(o2.getGivenName());
		return o1.getFamilyName().compareTo(o2.getFamilyName());
	}
	
	public static void main(String[] args) {
		NamedComparator comp = new NamedComparator();
		List<Named> named = new ArrayList<>();
		Person1 p1 = new Person1("Jostein","Tysse");
		Person2 p2 = new Person2("Thomas Borge");
		Person2 p3 = new Person2("Eirik Tysse");
		named.add(p1);
		named.add(p2);
		named.add(p3);
		System.out.println(named);
		named.sort(comp);
		System.out.println(named);
	}
}
