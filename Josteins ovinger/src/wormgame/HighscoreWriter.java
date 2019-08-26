package wormgame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class HighscoreWriter implements FileHandling{
	
	private Scanner inFile;
	
	private PrintWriter file;
	
	

	@Override
	public void saveToFile(String filename, TreeMap<Integer, String> scores) {
		try {
			this.file = new PrintWriter(filename);
			for(Entry<Integer, String> entry : scores.entrySet()) {
				  Integer score = entry.getKey();
				  String name = entry.getValue();
				 
				  file.println(score + ":" + name);
			}
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public TreeMap<Integer, String> readFromFile(String filename) {
		TreeMap<Integer, String> highscores = new TreeMap<Integer, String>(Collections.reverseOrder());
		try {
			this.inFile = new Scanner(new FileReader(filename));
			
			while(inFile.hasNext()) {
				String line = inFile.nextLine();
				String[] parted = line.split(":");
				highscores.put(Integer.parseInt(parted[0]), parted[1]);
			}
			return highscores;
		} catch (FileNotFoundException e) {
			
		}
		return highscores;
		
		
	}

}
