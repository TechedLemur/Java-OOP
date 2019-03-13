package inheritance;

public class ForeldreSpar extends SavingsAccount {

	private int withdrawals, total;
	
	
	public ForeldreSpar(double interestrate, int withdrawals) {
		super(interestrate);
		this.withdrawals = withdrawals;
		this.total = withdrawals;
	}
	
	@Override
	public void withdraw(double amount) {
		if (withdrawals == 0)
			throw new IllegalStateException();
			super.withdraw(amount);
		withdrawals--;
	}

	public int getRemainingWithdrawals() {
		return withdrawals;
	}
	
	@Override
	public void endYearUpdate() {
		super.endYearUpdate();
		this.withdrawals = total;
	}
	
}
