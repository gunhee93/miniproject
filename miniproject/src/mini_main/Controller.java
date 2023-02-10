package mini_main;

import javafx.scene.Parent;

import mini_main.infoService.InformationService;
import mini_main.infoService.InformationServiceImpl;
import mini_main.infoService.SerchService;
import mini_main.infoService.SerchServiceImpl;
import mini_main.infoService.StudentInfoService;
import mini_main.infoService.StudentInfoServiceImpl;


public class Controller {
	private Parent mainRoot;	
	private Parent stu;
	private Parent stuNum;
	private InformationService is;
	private StudentInfoService sis;
	
	private SerchService ss;
	private Parent stu2;
	
	public Controller() {
		// TODO Auto-generated constructor stub
		is = new InformationServiceImpl();
		sis = new StudentInfoServiceImpl();
		ss = new SerchServiceImpl();
	}
	public void setStu(Parent stu2) {
		// TODO Auto-generated method stub
		this.stu2 = stu2;
	}
	
	public void setRoot(Parent mainRoot) {
		// TODO Auto-generated method stub
		this.mainRoot = mainRoot;
	}
	
	public void crkInformation() {
		is.showInformation(mainRoot);
	}
	
	public void crkStudent() {
		sis.serchStudent();
	}
	public void crkProfessor() {
		sis.serchProfessor();
	}
	
	public void serchStudent() {
		ss.serchSutdent(stuNum);
	}


	
}
