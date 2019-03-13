package inheritance;

public class TrainCar {
	private int deadWeight;
	
	
	public TrainCar(int deadWeight) {
		this.deadWeight = deadWeight;
	}
	
	
	public void setDeadWeight(int deadWeight) {
		this.deadWeight = deadWeight;
	}
	
	public int getDeadWeight() {
		return deadWeight;
	}
	
	public int getTotalWeight() {
		return getDeadWeight();
	}
	
	
}
