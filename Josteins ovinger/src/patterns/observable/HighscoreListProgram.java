package patterns.observable;

import java.util.Scanner;

public class HighscoreListProgram implements HighscoreListListener{

	private HighscoreList highscoreList; 
	
	private Scanner in = new Scanner(System.in);
	
	public void init() {
		this.highscoreList = new HighscoreList(10);
		this.highscoreList.addHighscoreListListener(this);
	}
	
	public void run() {
		System.out.println("Type next entry:");
		String next = in.nextLine();
		
		while (!next.equals("stop")) {
			this.highscoreList.addResult(Integer.parseInt(next));
			System.out.println("Type next entry:");
			next = in.nextLine();
		}
		
	}
	@Override
	public void listChanged(HighscoreList list, int i) {
		System.out.println("Index " + i + " changed");
		System.out.println(list.toString());
		
	}
	public static void main(String[] args) {
		HighscoreListProgram p1 = new HighscoreListProgram();
		p1.init();
		p1.run();
	}

}
