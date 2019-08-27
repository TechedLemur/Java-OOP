package inheritance;

public class SavingsAccount2 extends AbstractAccount{

	private int withdrawals;
	private double fee;
	
	public SavingsAccount2(int withdrawals, double fee) {
		this.withdrawals = withdrawals;
		this.fee = fee;
	}
	
	

	@Override
	void internalWithdraw(double amount) {
		if (withdrawals == 0) {
			if (this.balance - amount - fee < 0)
				throw new IllegalStateException();
			this.balance = this.balance - amount - fee;
			return;
		}
		if (this.balance - amount < 0)
			throw new IllegalStateException();
		this.balance = this.balance - amount;
		this.withdrawals--;
	}
}
