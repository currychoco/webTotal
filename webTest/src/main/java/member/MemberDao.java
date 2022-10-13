package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDao { 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url = ""; // 접속할 데이터베이스의 주소
	private String user; // 오라클 계정
	private String password; // 비밀번호
	

	private MemberDao() {
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "C##LHR";
		password = "1234";
	}

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	
	//CRUD
	// 1. Create
	//2. Read
	//오라클 데이터베이스에 연동 후 -> 테이블 전체 데이터 조회
	public ArrayList<MemberDto> getMemberAll(){
		ArrayList<MemberDto> result = new ArrayList<>();
		// 데이터베이스 연동(Connection 얻음)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection(this.url,this.user,this.password);
			System.out.println("데이터베이스 연동 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연동 실패");
		}
		
		return result;
	}
}
