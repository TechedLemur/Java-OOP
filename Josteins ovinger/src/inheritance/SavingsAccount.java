package inheritance;

public class SavingsAccount implements Account {
	
	protected double balance;
	protected double interestrate;

	public SavingsAccount(double interestrate) {
		this.interestrate = interestrate;
	}
	

	public void endYearUpdate() {
		this.balance = this.balance + this.balance * this.interestrate;
	}
	
	
	@Override
	public void deposit(double amount) {
		if (amount < 0)
			throw new IllegalArgumentException();
		this.balance = this.balance + amount;
	}

	@Override
	public void withdraw(double amount) {
		if (amount < 0)
			throw new IllegalArgumentException();
		if (this.balance - amount < 0)
			throw new IllegalStateException();
		this.balance = this.balance - amount;
	}

	@Override
	public double getBalance() {
		return this.balance;
	}

}
