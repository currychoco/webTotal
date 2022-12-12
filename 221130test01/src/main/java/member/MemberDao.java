package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class MemberDao {

	private String url;
	private String user;
	private String password;
	private int latestCustno;

	private MemberDao() {
		this.url = "jdbc:oracle:thin:@localhost:1521:xe";
		this.user = "c##system";
		this.password = "1234";
	}

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	// 마지막 회원번호 조회 
	public int getLatestCustno() {
		Connection conn = DBManager.getConnection(this.url, this.user, this.password);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT MAX(custno) FROM member_tbl_02";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1) +1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 100000;
	}
	
	// Create
	public void addMember(MemberDto memberDto) {
		Connection conn = DBManager.getConnection(url, user, password);
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO member_tbl_02 VALUES(?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberDto.getCustno());
			pstmt.setString(2, memberDto.getCustname());
			pstmt.setString(3, memberDto.getPhone());
			pstmt.setString(4, memberDto.getAddress());
			pstmt.setTimestamp(5, memberDto.getJoindate());
			pstmt.setString(6, memberDto.getGrade());
			pstmt.setString(7, memberDto.getCity());

			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// Read
	// 2-1) 한 개 조회
	public MemberDto getMemberByCustno(int custno) {
		MemberDto member = null;

		Connection conn = DBManager.getConnection(url, user, password);
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM member_tbl_02 WHERE custno = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt(1);
				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				Timestamp joindate = rs.getTimestamp(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);

				member = new MemberDto(custno, custname, phone, address, joindate, grade, city);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return member;
	}

	// 2-2) 전체 조회
	public List<MemberDto> getMemberAll() {
		List<MemberDto> list = new ArrayList<>();

		Connection conn = DBManager.getConnection(url, user, password);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member_tbl_02";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				Timestamp joindate = rs.getTimestamp(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);

				MemberDto member = new MemberDto(no, custname, phone, address, joindate, grade, city);
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	// Update
	public void setMember(int custno, MemberDto memberDto) {
		Connection conn = DBManager.getConnection(url, user, password);
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE member_tbl_02 SET custname=?,phone=?,address=?,joindate=?,grade=?,city=? WHERE custno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getCustname());
			pstmt.setString(2, memberDto.getPhone());
			pstmt.setString(3, memberDto.getAddress());
			pstmt.setTimestamp(4, memberDto.getJoindate());
			pstmt.setString(5, memberDto.getGrade());
			pstmt.setString(6, memberDto.getCity());
			pstmt.setInt(7, custno);
			
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// Delete
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
