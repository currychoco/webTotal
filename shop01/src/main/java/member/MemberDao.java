package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class MemberDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String url;
	private String user;
	private String password;

	private MemberDao() {
		this.url = "jdbc:oracle:thin:@localhost:1521:xe";
		this.user = "c##test01";
		this.password = "1234";
	}

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	// 마지막 번호
	public int getLastNo() {
		int lastNo = -1;
		try {
			conn = DBManager.getConnection(url, user, password);

			String sql = "SELECT MAX(custno) FROM member_tbl_02";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				lastNo = rs.getInt(1) + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.clearWarnings();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(lastNo == -1) {
			return 10001;
		}
		return lastNo;
	}

	//오늘 날짜
	public String getDate() {
		LocalDate now = LocalDate.now();
		String[] data = now.toString().split(" ");
		return data[0].toString();
	}
	
	// 회원등록
	public boolean addMember(int custno, String custname, String phone, String address, String joindate, String grade, String city) {
		boolean add = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO member_tbl_02 VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			pstmt.setString(2, custname);
			pstmt.setString(3, phone);
			pstmt.setString(4, address);
			pstmt.setString(5, joindate);
			pstmt.setString(6, grade);
			pstmt.setString(7, city);
			rs = pstmt.executeQuery();
			add = rs.rowInserted();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		return add;
	}
	
	//회원 정보 가져오기
	public MemberDto getMember(int custno) {
		MemberDto m = null;
		try {
			conn=DBManager.getConnection(url, user, password);
			String sql = "SELECT * FROM member_tbl_02 WHERE custno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String custname=rs.getString(2);
				String phone = rs.getString(3);
				String address=rs.getString(4);
				String joindate = rs.getString(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);
				
				m = new MemberDto(custno, custname, phone, address, joindate, grade, city);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		return m;
	}
	
	//모든 회원 가져오기
	public List<MemberDto> getMemberAll(){
		List<MemberDto> member = new ArrayList<>();
		try {
			conn=DBManager.getConnection(url, user, password);
			
			String sql = "SELECT * FROM member_tbl_02";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int custno = rs.getInt(1);
				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address=rs.getString(4);
				String joindate= rs.getString(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);
				
				MemberDto mem = new MemberDto(custno, custname, phone, address, joindate, grade, city);
				member.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		return member;
	}
	
	//회원 정보 수정
	public void setMember(int custno, MemberDto memberDto) {
		try {
			conn =DBManager.getConnection(url, user, password);
			String sql = "UPDATE member_tbl_02 SET custname=?,phone=?,address=?,joindate=?,grade=?,city=? WHERE custno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getCustname());
			pstmt.setString(2, memberDto.getPhone());
			pstmt.setString(3, memberDto.getAddress());
			pstmt.setString(4, memberDto.getJoindate());
			pstmt.setString(5, memberDto.getGrade());
			pstmt.setString(6, memberDto.getCity());
			pstmt.setInt(7, memberDto.getCustno());
			
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
	}
	
	// 4. Delete
	public void removeMember(int custno) {
		Connection conn = DBManager.getConnection(this.url, this.user, this.password);
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM member_tbl_02 WHERE custno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
