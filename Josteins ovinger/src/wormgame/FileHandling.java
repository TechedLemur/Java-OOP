package wormgame;

import java.util.TreeMap;

public interface FileHandling {
	void saveToFile(String filename, TreeMap<Integer, String> scores);
	TreeMap<Integer, String> readFromFile(String filename);
}
