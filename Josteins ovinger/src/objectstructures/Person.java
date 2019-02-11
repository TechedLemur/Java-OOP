package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String name;
	private char gender;
	private Person mother, father;
	private List<Person> kids = new ArrayList<>();
	
	public Person(String name, char gender) {
		this.name = name;
		this.gender = gender;
	}
	
	public void addChild(Person p) {
		if (!(p.getFather() == this || p.getMother() == this))
			if (this.gender == 'M') {
				if (p.getFather() != null) {
					p.getFather().removeChild(p);
				}
			}
			else if (this.gender == 'F') {
				if (p.getMother() != null)
					p.getMother().removeChild(p);
			}
		if (kids.contains(p))
			return;
		kids.add(p);
		if (this.gender == 'M')
			p.setFather(this);
		else if (this.gender == 'F')
			p.setMother(this);
		
	}
	
	public void removeChild(Person p) {
		kids.remove(p);
		if (p.getFather() == this) {
			p.setFather(null);
		}
		else if (p.getMother() == this) {
			p.setMother(null);
		}
			
	}
	
	public void setMother(Person p) {
		if (p == null)
			this.mother = null;
		else if (p == this || p.getGender() == 'M')
			throw new IllegalArgumentException();
		
		else {
			if (this.mother != null && this.mother != p)
				this.getMother().removeChild(this);
			this.mother = p;
			p.addChild(this);
		}
	}
	
	public void setFather(Person p) {
		if (p == null)
			this.father = null;
		else if (p == this || p.getGender() == 'F')
			throw new IllegalArgumentException();
		
		else {
			if (this.father != null && this.father != p)
				this.getFather().removeChild(this);
			this.father = p;
			p.addChild(this);
		}
	}
	public String getName() {
		return name;
	}

	public char getGender() {
		return gender;
	}

	public Person getMother() {
		return mother;
	}

	public Person getFather() {
		return father;
	}
	
	public int getChildCount() {
		return kids.size();
	}
	
	public Person getChild(int n) {
		if (n < 0 || n >= getChildCount())
			throw new IllegalArgumentException();
		return kids.get(n);
	}


	public static void main(String[] args) {
		Person jens = new Person("Jens", 'M');
		Person anne = new Person("Anne", 'F');
		Person Halvard = new Person("Halvard", 'M');
		jens.addChild(anne);
		Halvard.addChild(anne);

	}

}
