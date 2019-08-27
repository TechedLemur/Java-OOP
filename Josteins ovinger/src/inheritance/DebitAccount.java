package inheritance;

public class DebitAccount extends AbstractAccount {


	@Override
	void internalWithdraw(double amount) {
		if (this.balance - amount < 0)
			throw new IllegalStateException();
		this.balance = this.balance - amount;
	}

}
