package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDao {
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url;
	private String user;
	private String password;
	
	private MemberDao() {
		this.url = "jdbc:oracle:thin:@localhost:1521:xe";
		this.user = "C##LHR";
		this.password  ="1234";
	}
	
	public ArrayList<MemberDto> getMemberAll(){
		ArrayList<MemberDto> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(this.url, this.user,this.password);
			System.out.println("데이터베이스 연동 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터 연동 실패");
		}
		
		return list;
	}
}
