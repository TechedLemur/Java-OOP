package inheritance;

public class CreditAccount extends AbstractAccount {

	private double creditLine;
	
	public CreditAccount(double creditLine) {
		this.creditLine = creditLine;
	}
	
	public void setCreditLine(double creditLine) {
		if (creditLine < 0)
			throw new IllegalArgumentException();
		if (this.balance + creditLine < 0)
			throw new IllegalStateException();
		this.creditLine = creditLine;
	}
	
	public double getCreditLine() {
		return creditLine;
	}

	
	
	@Override
	void internalWithdraw(double amount) {
		if (this.balance - amount + this.creditLine < 0)
			throw new IllegalStateException();
		this.balance = this.balance - amount;
	}

}
