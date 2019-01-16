package encapsulation;

public class Account {
	private double balance;
	private double interestRate;
	
	public Account(double balance, double interestRate) {
		if (balance < 0 || interestRate < 0) {
			throw new IllegalArgumentException("Kan ikke ha negative verdier");
		}
		else {
			this.balance = balance;
			this.interestRate = interestRate;
		}
	}
	
	public void deposit(double cash) {
		if (cash < 0 ) {
			throw new IllegalArgumentException("Kan ikke ha negativ verdi");
		}
		else {
			this.balance = this.balance + cash;
		}
		
	}
	
	public void withdraw(double cash) {
		if (cash < 0) {
			throw new IllegalArgumentException("Kan ikke ha negativ verdi");
		}
		else if ((this.balance - cash) < 0) {
			throw new IllegalArgumentException("Kan ikke trekke mer en det er på kontoen");
		}
		else {
			this.balance = this.balance - cash;
		}
	}
	
	public void addInterest() {
	balance = balance + balance * interestRate / 100;
	}
			
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		if (interestRate < 0) {
			throw new IllegalArgumentException("Kan ikke ha negativ verdi");
		}
		else {
			this.interestRate = interestRate;
		}
		
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String toString() {
		return "Account: balance = " + balance + ", interestRate = " + interestRate;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
