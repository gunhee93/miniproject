package mini_main.dao;

import java.util.List;

import mini_main.Student;

public interface DatabaseService {
	public boolean crkStuNumber(String stuNumber);
	public List<Student> selectAll();
}
