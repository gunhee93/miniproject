package mini_main.infoService;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mini_main.Controller;

public class StudentInfoServiceImpl implements StudentInfoService{

	@Override
	public void serchStudent() {
		// TODO Auto-generated method stub
		Stage student = new Stage();
		
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("../../serchstudent.fxml"));
		
		try {
			
			Parent stu = loader.load();
			Controller ctr1 = loader.getController();
			student.setScene(new Scene(stu));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		student.setTitle("serch student");
		student.show();
		
	}

	@Override
	public void serchProfessor() {
		// TODO Auto-generated method stubs
		Stage professor = new Stage();
		
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("../../serchprofessor.fxml"));
		try {
			Parent pro = loader.load();
			Controller ctr2 = loader.getController();
			professor.setScene(new Scene(pro));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		professor.setTitle("serch professor");
		professor.show();
	}
	
}
