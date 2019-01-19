package encapsulation;

public class StopWatch {
	int time = -1;
	int ticks;
	int LapTime = -1;
	int LastLapTime = -1;
	boolean started = false;
	boolean stopped = false;
	boolean running = false;
	public int getTime() {
		return time;
	}
	public int getTicks() {
		return ticks;
	}
	public int getLapTime() {
		return LapTime;
	}
	public int getLastLapTime() {
		return LastLapTime;
	}
	public boolean isStarted() {
		return started;
	}
	public boolean isStopped() {
		return stopped;
	}
	
	public void tick(int ticks) {
		if(ticks < 0) {
			throw new IllegalArgumentException("Not negative");
		}
		if (running) {
			time = time + ticks;
			LapTime = LapTime + ticks;					
		}
		this.ticks = this.ticks + ticks;
	}
	public void start() {
		if (running == true) {
			throw new IllegalStateException("Kan ikke starte når det er i gang");
		}
		started = true;
		running = true;
		LapTime = 0;
		time = 0;
	}
	
	public void stop() {
		if (running == false) {
			throw new IllegalStateException("Kan ikke stoppe når det er stoppet");
		}
		running = false;
		stopped = true;
		LastLapTime = LapTime;
		LapTime = 0;
		
	}
	public void lap() {
		if (running == false) {
			throw new IllegalStateException("Kan ikke lappe når det er stoppet");
		}
		LastLapTime = LapTime;
		LapTime = 0;
	}
	
	public String toString() {
		return "StopWatch: \nTicks: " + ticks + " Time: " + time + " LapTime: " + LapTime + " LastLapTime " + LastLapTime + " Running: " + running;
	}
	
	public static void main(String[] args) {
		StopWatch s1 = new StopWatch();
		System.out.println(s1);
		s1.tick(1);
		System.out.println(s1);
		s1.start();
		s1.tick(5);
		s1.lap();
		s1.tick(4);
		System.out.println(s1);
		s1.stop();
		s1.tick(3);
		
		System.out.println(s1);
	}
}
