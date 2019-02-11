package objectstructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StopWatchManager {
	
	private Map<String, StopWatch> watches = new HashMap<>();
	
	public StopWatch newStopWatch(String name) {
		StopWatch w = new StopWatch();
		watches.put(name, w);
		return w;
	}
	
	public void removeStopWatch(String name) {
		watches.remove(name);
	}
	
	public void tick(int ticks) {
		watches.forEach((key, value) -> value.tick(ticks));
	}
	public StopWatch getStopWatch(String name) {
		return watches.get(name);
	}
	
	public Collection<StopWatch> getAllWatches() {
		Collection<StopWatch> c = new ArrayList<StopWatch>();
		watches.forEach((key, value) -> c.add(value));
		return c;
	}
	
	public Collection<StopWatch> getStartedWatches(){
		Collection<StopWatch> c = new ArrayList<StopWatch>();
		watches.values().stream().filter(w -> w.isStarted()).forEach(w -> c.add(w));
		return c;
	}
	
	public Collection<StopWatch> getStoppedWatches(){
		Collection<StopWatch> c = new ArrayList<StopWatch>();
		watches.values().stream().filter(w -> w.isStopped()).forEach(w -> c.add(w));
		return c;
		
		
//		Collection<StopWatch> c = watches.values().stream().filter(w -> w.isStopped()).collect(Collectors.toList());
//		return c;
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	}

}
