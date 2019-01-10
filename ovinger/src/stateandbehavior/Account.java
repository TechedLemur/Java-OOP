package stateandbehavior;

public class Account {
	double balance;
	double interestRate = 3.5;
	
	public void deposit(double cash) {
		if (cash > 0 ) {
			balance = balance + cash;
		}
	}
	
	public void addInterest() {
	balance = balance + balance * interestRate / 100;
	}
			
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String toString() {
		return "Account: balance = " + balance + ", interestRate = " + interestRate;
	}
	
	public static void main(String[] args) {
		Account a1 = new Account();
		System.out.println(a1);
		a1.deposit(643000);
		a1.addInterest();
		System.out.println(a1);
		a1.setInterestRate(20);
		a1.addInterest();
		System.out.println(a1);
		

	}

}
