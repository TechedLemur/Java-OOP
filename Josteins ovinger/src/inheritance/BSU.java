package inheritance;

public class BSU extends SavingsAccount {

	private double yearlyMax;
	private SavingsAccount yearly = new SavingsAccount(0);
	
	public BSU(double interestrate, double yearlyMax) {
		super(interestrate);
		this.yearlyMax = yearlyMax;
	}
	
	@Override
	public void deposit(double amount) {
		if(yearly.getBalance() + amount > yearlyMax)
			throw new IllegalStateException();
		yearly.deposit(amount);
		super.deposit(amount);
	}
	
	@Override
	public void withdraw(double amount) {
		yearly.withdraw(amount);
		super.withdraw(amount);
	}
	
	public double getTaxDeduction() {
		return yearly.getBalance() * 0.20;
	}
	
	@Override
	public void endYearUpdate() {
		super.endYearUpdate();
		yearly.balance = 0;
		
	}

}
