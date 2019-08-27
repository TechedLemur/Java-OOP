package patterns.observable;

import java.util.Scanner;

public class ObservableHighscoreListProgram implements ObservableListListener {

	private ObservableHighscoreList highscoreList; 
	
	private Scanner in = new Scanner(System.in);
	
	
	public void init() {
		this.highscoreList = new ObservableHighscoreList(10);
		this.highscoreList.addObservableListListener(this);
	}
	
	public void run() {
		System.out.println("Type next entry:");
		String next = in.nextLine();
		
		while (!next.equals("stop")) {
			try {
			this.highscoreList.addResult(Integer.parseInt(next));
			System.out.println("Type next entry:");
			}
			catch (Exception e) {
				System.out.println("vennligst skriv et tall:");
			}
			
			next = in.nextLine();
		}
		
	}
	
	@Override
	public void listChanged(ObservableList list, int position) {
		System.out.println("Index " + position + " changed");
		System.out.println(list.toString());

	}
	
	public static void main(String[] args) {
		HighscoreListProgram p1 = new HighscoreListProgram();
		p1.init();
		p1.run();
	}

}
