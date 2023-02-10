package mini_main.infoService;



import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class SerchServiceImpl implements SerchService{
	
	
	@Override
	public void serchSutdent(Parent stuNum) {
		// TODO Auto-generated method stub
		System.out.println("여기까지연결됐습니다.");
		
		TextField txtNumber = (TextField) stuNum.lookup("#txtStudent");
		
		
	}


}
