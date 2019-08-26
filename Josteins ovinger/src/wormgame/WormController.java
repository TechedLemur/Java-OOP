package wormgame;



import java.io.File;
import java.util.TreeMap;
import java.util.Map.Entry;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.media.MediaView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class WormController {
	
	@FXML
	AnchorPane root;
	
	@FXML
	Label label, textscore, gamemodeText, gamemodeview, testscore, scoreview, nameLabel;
	
	@FXML
	GridPane pane;
	
	@FXML
	Button run, shrekMode, elonMode;
	
	@FXML
	Rectangle outline;
	
	@FXML
	TextArea txtScores;
	
	@FXML
	TextField nameField;
	

	
	
	
	
	WormGame wormGame;
	
	Direction dir, last;
	
	ImagePattern applepic;
	ImagePattern wormpic;
	ImagePattern head;
	ImagePattern background;
	
	private MediaController music;
	private MediaController movie;
	private MediaView view;
	private boolean cheat;
	private boolean video;
	private Integer score;
	private String name = "Jostein";
	private HighscoreWriter writer;
	private TreeMap<Integer, String> highscore;
	public void setCheat(boolean arg) {
		this.cheat = arg;
	}
	
	
	private void setBackgroundImg(String filePath) {
		File file = new File(filePath);
		Image img = new Image(file.toURI().toString());
		this.background = new ImagePattern(img,0,0,1,1, true);
	}
	
	private void imageHeadSet(String filePath) {
		File file = new File(filePath);
		Image img = new Image(file.toURI().toString());
		this.head = new ImagePattern(img,0,0,1,1, true);
	}
	
	private void imageWormSet(String filePath) {
		File file = new File(filePath);
		Image img = new Image(file.toURI().toString());
		this.wormpic = new ImagePattern(img,0,0,1,1, true);
	}
	
	private void imageAppleSet(String filePath) {
		File file = new File(filePath);
		Image img = new Image(file.toURI().toString());
		this.applepic = new ImagePattern(img,0,0,1,1, true);
	}
	
	
	public void setUp() {
		if (this.dir == Direction.DOWN)
			return;
		
		this.dir = (Direction.UP);
	}
	public void setDown() {
		if (this.dir == Direction.UP)
			return;
		this.dir = (Direction.DOWN);
	}
	public void setLeft() {
		if (this.dir == Direction.RIGHT)
			return;
		this.dir =(Direction.LEFT);
	}
	public void setRight() {
		if (this.dir == Direction.LEFT)
			return;
		this.dir =(Direction.RIGHT);
	}
	
	
	
	
	
	public void grow() {
		this.wormGame.growWorm();
		
	}
	
	public void Draw(WormGame wormGame) {
		pane.getChildren().clear();
		this.DrawApple(wormGame);
		int i = 1;
		for (Piece piece:wormGame.getWorm().getPieces()) {
			if(!(piece.getX()<0 || piece.getY() < 0 || piece.getX()>wormGame.getMaxX() || piece.getY() > wormGame.getMaxY() )) {
				
			
				
			Rectangle r = new Rectangle();
			
			pane.getChildren().add(r);
			r.setWidth(40);
			r.setHeight(40);
			if (i == wormGame.getWorm().getLength()) {
				r.setFill(head);
				r.setWidth(50);
				r.setHeight(50);
			}
			else
				r.setFill(wormpic);
			GridPane.setConstraints(r, piece.getX(), piece.getY());
			GridPane.setHalignment(r, HPos.CENTER);
			}
			i++;
		}
	}
	
	
	public void DrawApple(WormGame game) {

		Rectangle apple = new Rectangle();
		pane.getChildren().add(apple);
		apple.setWidth(40);
		apple.setHeight(40);
		apple.setFill(applepic);
		GridPane.setConstraints(apple, game.getApple().getX(), game.getApple().getY());
		GridPane.setHalignment(apple, HPos.CENTER);
		
		//game.getApple().getX()
		//game.getApple().getY()
	}
	
	public void shrekMode() {
		this.movie = new MediaController("AllStar_Shrek.mp4");
		this.view = new MediaView(movie.getPlayer());
    	this.root.getChildren().add(view);
    	view.setFitHeight(662);
    	view.setY(8);
    	view.setVisible(false);
//    	outline.toFront();
//    	pane.toFront();
    	imageWormSet("src/wormgame/Shrek.png");
 	    imageAppleSet("src/wormgame/Shrek.png");
 	    imageHeadSet("src/wormgame/Shrek2.png");
 	    run.setDisable(false);
 	    this.video = true;
 	    gamemodeText.setText("Shrek Mode");
	}
	
	public void elonMode() {
		imageWormSet("src/wormgame/mari.png");
 	    imageAppleSet("src/wormgame/mariG.png");
 	    imageHeadSet("src/wormgame/w_musk_r.PNG");
    	this.music = new MediaController("Megalovania.mp3");
    	setBackgroundImg("src/wormgame/tesla1.jpg");
    	run.setDisable(false);
    	this.video = false;
 	    gamemodeText.setText("Elon Mode");


	}
	    
    @FXML
    public void run3() {
    	this.name = nameField.getText();
    	nameLabel.setDisable(true);
    	//this.movie = new MediaController("allStar.mp4");
    	
    	//this.music = new MediaController("Megalovania.mp3");
    	//music.play();
    	//setBackgroundImg("src/wormgame/Space.jpg");
    	//outline.setFill(background);
    	gamemodeText.setText(null);
    	if (video) {
    		view.setVisible(true);
    		movie.play();
    		outline.setFill(null);
    		
    	}
    		
    	else {
    		outline.setFill(background);
    		music.play();
    	}
    		
    	//this.view = new MediaView(movie.getPlayer());
    	//this.root.getChildren().add(view);
    	//view.setFitHeight(662);
    	//view.setFitWidth(900);
    	//view.setY(8);
    	outline.toFront();
    	pane.toFront();
    	pane.cursorProperty().set(Cursor.NONE);
    	textscore.toFront();
    	textscore.setVisible(true);
    	this.wormGame = new WormGame(111,62);
	    wormGame.newApple();
	    run.setDisable(true);
	    run.setVisible(false);
	    shrekMode.setDisable(true);
	    shrekMode.setVisible(false);
	    elonMode.setDisable(true);
	    elonMode.setVisible(false);
	    this.dir = null;
	    
//	    imageWormSet("src/wormgame/mari.png");
//	    imageAppleSet("src/wormgame/mari.png");
//	    imageHeadSet("src/wormgame/w_musk.PNG");
	    
    	new AnimationTimer() {
    		private long lastUpdate = 0;

			@Override
			public void handle(long now) {
				if (now - lastUpdate >= 00_000_000) {
                  
//				if (wormGame.isGameOver()) {
//					stop();
//					System.out.println("Game over");
//				}
				
				wormGame.changeDir(dir);
				wormGame.moveWorm();
				if (!video) {
					if(wormGame.getWorm().getDirection() == Direction.RIGHT && last != Direction.RIGHT)
						imageHeadSet("src/wormgame/w_musk_r.PNG");
					else if (wormGame.getWorm().getDirection() == Direction.LEFT && last != Direction.LEFT)
						imageHeadSet("src/wormgame/w_musk_L.PNG");

				}
				
				if (wormGame.hitsApple()) {
					wormGame.growWorm();
					wormGame.newApple();
				}
				if (wormGame.isGameOver()) {
					setBackgroundImg("src/wormgame/snakeX.jpg");
					outline.setFill(background);
					outline.toFront();
					shrekMode.setDisable(false);
				    shrekMode.setVisible(true);
				    elonMode.setDisable(false);
				    elonMode.setVisible(true);
					run.setVisible(true);
					run.toFront();
					shrekMode.toFront();
					elonMode.toFront();
					gamemodeview.toFront();
					stop();
					System.out.println("Game over");
					if (video)
						movie.stop();
					else {
						
						music.stop();
					}
					if (name.length() > 0) {	
					
					if (highscore.containsKey(score)) {
						String prev = highscore.get(score);
						highscore.put(score, name + ", " + prev);
					}
					else
						highscore.put(score, name);
					}	
					writer.saveToFile("src/wormgame/Highscores.txt", highscore);
					System.out.println(writer.readFromFile("src/wormgame/Highscores.txt"));
					printScores();
			    	nameLabel.setDisable(false);
			    	nameLabel.toFront();


				}
				Draw(wormGame);
//				try {
//					Thread.sleep(35);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				label.setText(String.valueOf(wormGame.getWorm().getLength()));
				score = wormGame.getWorm().getLength();
				last = wormGame.getWorm().getDirection();
				lastUpdate = now ;
			}
				 
            }
    		
    	}.start();
    	
    	}
    
    private void printScores() {
    	String tekst = "";
    	
    	
    	for(Entry<Integer, String> entry : highscore.entrySet()) {
			  Integer score = entry.getKey();
			  String name = entry.getValue();
			  tekst = tekst + name + " " + score + "\n";
    	}
    	testscore.setText(tekst);
    	scoreview.toFront();
    
    	
    }

    
    public void setup() {
    	setBackgroundImg("src/wormgame/snakeX.jpg");
		outline.setFill(background);
		this.writer = new HighscoreWriter();
		this.highscore = writer.readFromFile("src/wormgame/Highscores.txt");
		printScores();
    }
    
    
		
	}
	
	
	
	
	

