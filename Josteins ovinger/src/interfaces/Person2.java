package interfaces;

public class Person2 implements Named{
	
	private String fullName;
	
	public Person2(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public void setGivenName(String name) {
		String[] splited = this.fullName.split(" ");
		this.fullName = name + " " + splited[1];
	}

	@Override
	public void setFamilyName(String name) {
		String[] splited = this.fullName.split(" ");
		this.fullName =splited[0] + " " + name;
		
	}

	@Override
	public void setFullName(String name) {
		this.fullName = name;		
	}

	@Override
	public String getGivenName() {
		String[] splited = this.fullName.split(" ");
		return splited[0];
	}

	@Override
	public String getFamilyName() {
		String[] splited = this.fullName.split(" ");
		return splited[1];
	}

	@Override
	public String getFullName() {
		return this.fullName;
	}

	@Override
	public String toString() {
		return fullName;
	}
	

}
