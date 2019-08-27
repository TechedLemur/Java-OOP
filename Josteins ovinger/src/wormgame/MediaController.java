package wormgame;

// This requires importing javafx which can be done with Maven in the pom.xml file

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MediaController {
	
	private Media media;
	private MediaPlayer player;
	
	public MediaPlayer getPlayer() {
		return this.player;
	}
	public MediaController(String filename) {
		setMedia(filename);
		setMediaPlayer(media);
	}
	public void setMedia(String filename) {
		
		Media media = new Media(getClass().getResource(filename).toString());
		this.media = media;
	}
	
	public void setMediaPlayer(Media media) {
		MediaPlayer player = new MediaPlayer(media);
		this.player = player;
	}
	
	public void play() {
		player.play();
		player.setCycleCount(10);
	}
	
	public void pause() {
		player.pause();
	}
	
	public void stop() {
		player.stop();
	}

}
