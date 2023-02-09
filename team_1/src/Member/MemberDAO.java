package Member;
import Database.dbConn;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDAO {
    private Connection connection = null; // DB Connection
    private PreparedStatement stmt = null; // 동적 SQL 처리
    private ResultSet rs = null; // SQL ResultSet 반환

    Scanner scanner = new Scanner(System.in);
    private final String STUINSERT = "INSERT INTO STUDENT values(?, ?, ?, ?, ?, ?, ?, ?)"; // SQL INSERT
    private final String PROFINSERT = "INSERT INTO PROFESSOR values(?, ?, ?, ?, ?, ?, ?, ?)"; // SQL INSERT
    private final String LOGIN = "SELECT Pw FROM MEMBER WHERE ID = ?"; // SQL LOGIN
    private final String DELETE = "DELETE MEMBER WHERE ID = ?"; // SQL DELETE
    private final String SELECTALL = "SELECT * FROM MEMBER"; // SQL SELECT
    private final String SEARCH = "SELECT * FROM MEMBER WHERE NAME = ?";


    // 학생 정보 삽입
    public boolean stu_insert(Student student) {
        try {
            connection = dbConn.getConnection();
            stmt = connection.prepareStatement(STUINSERT);
            stmt.setString(1, student.getID());
            stmt.setString(2, student.getPw());
            stmt.setString(3, student.getName());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, student.Reg_Date());
            stmt.setString(6, student.getMajor());
            stmt.setInt(7, student.getStu_num());
            stmt.setString(8, student.getGender());
            stmt.executeUpdate();

            System.out.println("학생 회원가입 완료.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.close(stmt);
        } return true;
    }

    
    // 교수 정보 삽입
    public boolean prof_insert(Professor professor) {
        try {
            connection = dbConn.getConnection();
            stmt = connection.prepareStatement(PROFINSERT);

            stmt.setString(1, professor.getID());
            stmt.setString(2, professor.getPw());
            stmt.setString(3, professor.getName());
            stmt.setString(4, professor.getEmail());
            stmt.setString(5, professor.Reg_Date());
            stmt.setString(6, professor.getMajor());
            stmt.setString(7, professor.getOffice());
            stmt.setString(8, professor.getGender());

            stmt.executeUpdate();

            System.out.println("교수 회원가입 완료.");

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbConn.close(stmt);
        } return true;
    }
    
    // 학생 정보 삭제
    public void stu_delete(String Id) {
        try {
            connection = dbConn.getConnection();
            stmt = connection.prepareStatement(DELETE);
            stmt.setString(1, Id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.close(stmt);
        }
    }
    // 교수 정보 삭제
    public void prof_delete(String Id) {
        try {
            connection = dbConn.getConnection();
            stmt = connection.prepareStatement(DELETE);
            stmt.setString(1, Id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.close(stmt);
        }
    }

    // 모든 멤버 목록 조회
    public List<Member> selectAll() {
        List<Member> memberList = new ArrayList<>(); // 멤버 배열 선언
        try {
            connection = dbConn.getConnection();
            stmt = connection.prepareStatement(SELECTALL);
            while (rs.next()) {
                Member m = new Member(rs.getString("Id"), rs.getString("Pw"),
                        rs.getString("Name"), rs.getString("Email"),
                        rs.getString("Reg_Date"), rs.getString("Gender")); // toString
                memberList.add(m); // 멤버 배열에 삽입
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.close(stmt);
            dbConn.close(rs);
        }
        return memberList;
    }

    // 멤버 검색 (이름)
    // public Member searchMem(String Name) {
    //  return 0;
    //    }

    // 로그인
    public int login(String Id, String Pw) {
        try {
            connection = dbConn.getConnection();
            stmt = connection.prepareStatement(LOGIN);
            stmt.setString(1, Id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                if (rs.getString(1).contentEquals(Pw)) {
                    // System.out.println("로그인 성공");
                    return 1;
                }
                else {
                    // System.out.println("로그인 실패, 비밀번호 오류");
                    return 0;
                }
            }
            // System.out.println("로그인 실패, 존재하지 않는 아이디입니다");
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return -2;
    }



}
