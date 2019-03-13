package inheritance;

public class CargoCar extends TrainCar {

	private int cargoWeight;
	

	public CargoCar(int deadWeight, int cargoWeight) {
		super(deadWeight);
		this.cargoWeight = cargoWeight;
	}
	
	public void setCargoWeight(int cargoWeight) {
		this.cargoWeight = cargoWeight;
	}
	
	public int getCargoWeight() {
		return cargoWeight;
	}
	
	@Override
	public int getTotalWeight() {
		return getDeadWeight() + cargoWeight;
	}
	
	@Override
	public String toString() {
		return "CargoCar, Total Weigt: " + getTotalWeight() + ", Cargo Weight: " + getCargoWeight();
	}

}
