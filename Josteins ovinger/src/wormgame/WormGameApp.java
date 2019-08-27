package wormgame;
//This requires importing javafx which can be done with Maven in the pom.xml file

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class WormGameApp extends Application{
	

	
	

	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("SnakeX");
//		primaryStage.setScene(new Scene(FXMLLoader.load(WormController.class.getResource("WormGame.fxml"))));
//		primaryStage.show();
//		primaryStage.get
		FXMLLoader loader = new FXMLLoader(getClass().getResource("WormGame.fxml"));
		Parent root = loader.load();
		WormController controller = loader.getController();
		Scene scene_main = new Scene(root);
		primaryStage.setScene(scene_main);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("Dolan.jpeg")));
		primaryStage.show();
		primaryStage.setResizable(false);
		controller.setup();
		primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				//System.out.println("Pressed" + keyEvent.getCode().toString());
				if (keyEvent.getCode() == KeyCode.W && (controller.dir != Direction.DOWN)) {
					controller.setUp();
					//WormGame.setUp();
				}
				else if (keyEvent.getCode() == KeyCode.D && (controller.dir != Direction.LEFT)) 
					controller.setRight();
					
				else if (keyEvent.getCode() == KeyCode.S && (controller.dir != Direction.UP)) 
					controller.setDown();	
				
				else if (keyEvent.getCode() == KeyCode.A && (controller.dir != Direction.RIGHT)) 
					controller.setLeft();
				
				else if(keyEvent.getCode() == KeyCode.Q) {
					controller.grow();
					controller.setCheat(true);
				}
				
//				switch (keyEvent.getCode().toString()) {
//				
//				case "W":
//					controller.setUp();
//				case "D":
//					controller.setRight();
//				case "S":
//					controller.setDown();
//				case "A":
//					controller.setLeft();
//					
//				}
			}
			
		});
		
	}

	public static void main(final String[] args) {
		WormGameApp.launch(args);
		
	}
}