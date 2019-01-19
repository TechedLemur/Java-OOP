package encapsulation;


public class Vehicle {
	
	private char vehicleType;
	private char fuelType;
	private String registrationNumber;
	
	private char[] car_fuel = {'H', 'E', 'D', 'G' };
	private char[] bike_fuel = {'E', 'D', 'G'};


	private String[] electric = {"EL", "EK"};
	
	
	private boolean contains_char(char[] array, char letter) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == letter) {
				return true;
			}
		}
		return false;
	}
	
	private boolean contains_String(String[] array, String letters) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(letters)) {
				return true;
			}
		}
		return false;
	}
	private boolean alphaCheck(String string) {
		for (int i = 0; i < string.length(); i++) {
			if(!Character.isLetter(string.charAt(i))) {
				return false;
			}
			if(string.charAt(i) == 'Æ' || string.charAt(i) == 'Ø' || string.charAt(i) == 'Å') {
				return false;
			}
		}
		if (string.toUpperCase() != string) {
			return false;
		}
		return true;
	}
	private boolean numberCheck(String string) {
		for (int i = 0; i < string.length(); i++) {
			if(!Character.isDigit(string.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	

	public Vehicle(char vehicleType, char fuelType, String registrationNumber) {
		if (vehicleType == 'M') { //motorsykkel
			if (contains_char(bike_fuel, fuelType)) { //lovlig drivstoff
				if(!(registrationNumber.length() == 6)) {
					throw new IllegalArgumentException("Feil lengde på regnr");
				}
				else {
					String regletter = registrationNumber.substring(0, 2); //finner bokstaver
					String regNumbers = registrationNumber.substring(2);
					if (!(numberCheck(regNumbers))) {
						throw new IllegalArgumentException("Kan bare ha siffer i regnr");
					}
					if(contains_String(electric, regletter)) { //fornybar
						if (fuelType == 'E') {
							this.vehicleType = vehicleType;
							this.fuelType = fuelType;
							this.registrationNumber = registrationNumber;
						}
						else {
							throw new IllegalArgumentException("Feil kombinasjon");
						}
						
					}
					else { // ikke fornybar
						if (regletter.equals("HY") || fuelType == 'E') {
							throw new IllegalArgumentException("Kan ikke ha hydrogen på motorsykkel, eller elbil på feil regnr");
						}
						
						
						if (alphaCheck(regletter)) {
							this.vehicleType = vehicleType;
							this.fuelType = fuelType;
							this.registrationNumber = registrationNumber;
						}
						else {
							throw new IllegalArgumentException("Ugyldig bokstaver på regnr");
						}
					}
				}
			}
			else {
				throw new IllegalArgumentException("Ugyldig drivstoff");
			}
		}
		else if (vehicleType == 'C') { //bil
			if (contains_char(car_fuel, fuelType)) {
				if(!(registrationNumber.length() == 7)) {
					throw new IllegalArgumentException("Feil lengde på regnr");
				}
				else {
					String regletter = registrationNumber.substring(0, 2); //finner bokstaver
					String regNumbers = registrationNumber.substring(2);
					if (!(numberCheck(regNumbers))) {
						throw new IllegalArgumentException("Kan bare ha siffer i regnr");
					}
					
					if(contains_String(electric, regletter)) { //fornybar
						if (fuelType == 'E') {
							this.vehicleType = vehicleType;
							this.fuelType = fuelType;
							this.registrationNumber = registrationNumber;
						}
						else {
							throw new IllegalArgumentException("Feil kombinasjon");
						}
						
					}
					else { // ikke elbil
						if (regletter.equals("HY") && fuelType != 'H' ) {
							throw new IllegalArgumentException("Feil kombinasjon");
						}
						if (fuelType == 'H' && !(regletter.equals("HY"))) {
							throw new IllegalArgumentException("Feil kombinasjon");
						}
						if (fuelType == 'E') {
							throw new IllegalArgumentException("Feil kombinasjon");
						}
						if (alphaCheck(regletter)) {
							this.vehicleType = vehicleType;
							this.fuelType = fuelType;
							this.registrationNumber = registrationNumber;
						}
						else {
							throw new IllegalArgumentException("Ugyldig bokstaver på regnr");
						}
					}
				}
			}
				
			
			else {
				throw new IllegalArgumentException("Ugyldig drivstoff");
			}
		}
		else {
			throw new IllegalArgumentException("Ugyldig vehicletype");
		}
	}


	public void setRegistrationNumber(String registrationNumber) {
		if (this.vehicleType == 'C' && registrationNumber.length() == 7) {
			String regletter = registrationNumber.substring(0, 2); //finner bokstaver
			String regNumbers = registrationNumber.substring(2);
			if (!(numberCheck(regNumbers))) {
				throw new IllegalArgumentException("Kan bare ha siffer i regnr");
			}
			
			if(contains_String(electric, regletter)) { //fornybar
				if (fuelType == 'E') {
					this.registrationNumber = registrationNumber;
				}
				else {
					throw new IllegalArgumentException("Feil kombinasjon");
				}
				
			}
			else { // ikke elbil
				if (regletter.equals("HY") && fuelType != 'H' ) {
					throw new IllegalArgumentException("Feil kombinasjon");
				}
				if (fuelType == 'H' && !(regletter.equals("HY"))) {
					throw new IllegalArgumentException("Feil kombinasjon");
				}
				if (fuelType == 'E') {
					throw new IllegalArgumentException("Feil kombinasjon");
				}
				if (alphaCheck(regletter)) {
					this.registrationNumber = registrationNumber;
				}
				else {
					throw new IllegalArgumentException("Ugyldig bokstaver på regnr");
				}
			}
		}
		else if (vehicleType == 'M' && registrationNumber.length() == 6) {
			String regletter = registrationNumber.substring(0, 2); //finner bokstaver
			String regNumbers = registrationNumber.substring(2);
			if (!(numberCheck(regNumbers))) {
				throw new IllegalArgumentException("Kan bare ha siffer i regnr");
			}
			if(contains_String(electric, regletter)) { //fornybar
				if (fuelType == 'E') {
					this.registrationNumber = registrationNumber;
				}
				else {
					throw new IllegalArgumentException("Feil kombinasjon");
				}
			}
			else { // ikke fornybar
				if (regletter.equals("HY") || fuelType == 'E') {
					throw new IllegalArgumentException("Kan ikke ha hydrogen på motorsykkel, eller elbil på feil regnr");
				}
				
				
				if (alphaCheck(regletter)) {
					
					this.registrationNumber = registrationNumber;
				}
				else {
					throw new IllegalArgumentException("Ugyldig bokstaver på regnr");
				}
			}
		}
		else {
			throw new IllegalArgumentException("Noe er galt");
		}
	}
	
	public String toString(){
		return "Vehicle type: " + vehicleType + ", Fueltype: " + fuelType + ", Registrationnumber: " + registrationNumber;
	}


	public String getRegistrationNumber() {
		return registrationNumber;
	}





	public char getVehicleType() {
		return vehicleType;
	}



	public char getFuelType() {
		return fuelType;
	}



	public static void main(String[] args) {
		Vehicle v1 = new Vehicle('C', 'E', "EL21456");
		Vehicle v2 = new Vehicle('M', 'E', "EL2146");
		System.out.println(v1);
	}

}
