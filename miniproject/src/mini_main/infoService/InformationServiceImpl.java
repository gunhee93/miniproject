package mini_main.infoService;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mini_main.Controller;

public class InformationServiceImpl implements InformationService{

	@Override
	public void showInformation(Parent mainRoot) {
		// TODO Auto-generated method stub
		Stage with = new Stage();
		
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("../../with.fxml"));
		Parent p = null;
		try {
			p = loader.load();
			
			Controller ctr = loader.getController();
			with.setScene(new Scene(p));
		} catch(Exception e) {
			e.printStackTrace();
		}
		

		with.setTitle("Information");
		with.show();
		
		
	}

}
