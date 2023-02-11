package login;


import java.sql.SQLException;
import java.util.Scanner;

public class main {

		public static void main(String[] args) throws SQLException {
			login lg = new login();
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				int num;
				System.out.print("메뉴를 선택하세요: ");
				num = sc.nextInt();
				switch(num) {
				case 1:
					lg.insert();
					break;
				case 2:
				    lg.delete();
					break;
				case 0:
					System.out.println("프로그램 종료");
					return;
				default:
					System.out.println("선택된 메뉴가 없습니다.");
				}
				System.out.println();
			}
		}
	}
