package mini_main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AcornMain extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../acorn.fxml"));
		
		Parent mainRoot = loader.load();
		
		Controller ctr = loader.getController();
	
		ctr.setRoot(mainRoot);
		
		Scene scene = new Scene(mainRoot);
		primaryStage.setScene(scene);
		primaryStage.setTitle("AcornUniversity");
		primaryStage.show();
	}
}
