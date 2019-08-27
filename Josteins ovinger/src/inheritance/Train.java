package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Train {
	
	private List<TrainCar> cars = new ArrayList<TrainCar>();
	
	public void addTrainCar(TrainCar car) {
		if(!contains(car))
			cars.add(car);
	}
	
	public boolean contains(TrainCar car) {
		return cars.contains(car);
	}
	
	public int getTotalWeight() {
		return cars.stream().mapToInt(TrainCar::getTotalWeight).sum();
	}
	
	public int getPassengerCount() {
		return cars.stream().filter(c -> c.getClass() == (PassengerCar.class)).map(c-> (PassengerCar) c)
				.mapToInt(PassengerCar::getPassengerCount).sum();
	}
	
	public int getCargoWeight() {
		return cars.stream().filter(c -> c.getClass() == (CargoCar.class)).map(c -> (CargoCar) c)
				.mapToInt(CargoCar::getCargoWeight).sum();
	}
	
	@Override
	public String toString() {
		return cars.toString();
	}
	
	public static void main(String[] args) {
		Train t = new Train();
		t.addTrainCar(new CargoCar(30,30));
		t.addTrainCar(new PassengerCar(30,30));
		System.out.println(t);
		
	}
}
