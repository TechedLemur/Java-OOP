package stateandbehavior;

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
		if (running) {
			time = time + ticks;
			LapTime = LapTime + ticks;					
		}
		this.ticks = this.ticks + ticks;
	}
	public void start() {
		started = true;
		running = true;
		LapTime = 0;
		time = 0;
	}
	
	public void stop() {
		running = false;
		stopped = true;
		LastLapTime = LapTime;
		LapTime = 0;
		
	}
	public void lap() {
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
