package interfaces;

public class Person1 implements Named {
	private String givenName;
	private String familyName;
	
	public Person1(String givenName, String familyNamy) {
		this.givenName = givenName;
		this.familyName = familyNamy;
	}

	@Override
	public void setGivenName(String name) {
		this.givenName = name;
	}

	@Override
	public void setFamilyName(String name) {
		this.familyName = name;
	}

	@Override
	public void setFullName(String name) {
		String[] splited = name.split(" ");
		setGivenName(splited[0]);
		setFamilyName(splited[1]);
	}

	@Override
	public String getGivenName() {
		return this.givenName;
	}

	@Override
	public String getFamilyName() {
		return this.familyName;
	}

	@Override
	public String getFullName() {
		return this.givenName + " " + this.familyName;
	}

	@Override
	public String toString() {
		return  givenName +" "+familyName;
	}
	
	
}
