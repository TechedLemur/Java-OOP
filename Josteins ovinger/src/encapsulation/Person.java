package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Person {
	
	private String name; 
	private String email;
	private Date birthday;
	private char gender;
	private List<String> codes = Arrays.asList("ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw");
	
	
	private boolean alphaCheck(String string) {
		for (int i = 0; i < string.length(); i++) {
			if(!Character.isLetter(string.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	
	
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		String navn = name;
		
		int space = name.length() - name.replace(" ", "").length(); // teller antall mellomrom
		
		if(space != 1) {
			throw new IllegalArgumentException("Må ha kun ett mellomrom");
		}
		int space_index = navn.indexOf(" ");
		
		String fornavn = navn.substring(0, space_index);
		String etternavn = navn.substring(space_index + 1);
		
		if (fornavn.length() < 2 || etternavn.length() < 2) {
			throw new IllegalArgumentException("Fornavn og etternavn må være minst 2 bokstaver");
		}
		if (alphaCheck(fornavn) && alphaCheck(etternavn)){
			this.name = navn;		
		}
		else {
			throw new IllegalArgumentException("Navnene kan kun inneholde bokstaver");
		}
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		String[] navn = this.name.split(" ");
		if(((email.length() - email.replace("@", "").length() != 1))){
			throw new IllegalArgumentException("Må ha en @");
			}
		String[] alfa = email.split("@");
		String[] del1 = alfa[0].split("\\.");
		String[] del2 = alfa[1].split("\\.");
		
		for (int i = 0; i < 2; i++) {
			if(!(navn[i].toLowerCase().equals(del1[i].toLowerCase()))) {
			throw new IllegalArgumentException("Navn må stemme med email");			
			}
		}
		if(del2.length != 2) {
			throw new IllegalArgumentException("Må være domenenavn og landskode");
		}
		if (!(codes.stream().anyMatch(s -> s.equals(del2[1])))) {
			throw new IllegalArgumentException("Ikke gyldig landskode");
		}
		else {
			this.email = email;
		}
	}
	






	public Date getBirthday() {
		return birthday;
	}






	public void setBirthday(Date birthday) {
		Date current_date = new Date();
		if (birthday.after(current_date)) {
			throw new IllegalArgumentException("Kan ikke ha bursdag frem i tid :(");	
		}
		else {
			this.birthday = birthday;	
		}
	}






	public char getGender() {
		return gender;
	}






	public void setGender(char gender) {
		if (!(gender == 'M' || gender == 'F' || gender == '\0')) {
			throw new IllegalArgumentException("Det finnes bare to kjønn");
		}
		else {
			this.gender = gender;
		}
		
	}






	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("Jostein Tysse");
		System.out.println(p1.getName());
		p1.setEmail("jostein.tysse@gmail.no");
		System.out.println(p1.getEmail());
		Date d1 = new Date();
		System.out.println(d1);

	}
	

}
