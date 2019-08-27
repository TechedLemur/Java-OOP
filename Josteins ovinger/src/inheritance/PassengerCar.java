package inheritance;

public class PassengerCar extends TrainCar {

	private int passengerCount;
	
	public PassengerCar(int deadWeight, int passengerCount) {
		super(deadWeight);
		this.passengerCount = passengerCount;
	}
	
	public int getPassengerCount() {
		return passengerCount;
	}
	
	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	
	@Override
	public int getTotalWeight() {
		return super.getTotalWeight() + 80*getPassengerCount();
	}

	@Override
	public String toString() {
		return "PassengerCar, Total Weight: " + getTotalWeight() + ", Passengers: " + getPassengerCount();
	}
}
