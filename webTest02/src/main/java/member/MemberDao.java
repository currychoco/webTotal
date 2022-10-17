package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import util.DBManager;

public class MemberDao {

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String url = "";
	private String user;
	private String password;

	private MemberDao() {
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "C##LHR";
		password = "1234";
	}

	// 마지막 회원번호 알기
	public int getLastCustno() {
		int lastNo = -1;
		try {
			conn = DBManager.getConnection(url, user, password);

			String sql = "SELECT MAX(custno) FROM member_tbl_02";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				lastNo = rs.getInt(1);
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
		return lastNo;
	}

	// 회원등록하기
	public boolean addMember(String custname, String phone, String address, String grade, String city) {
		boolean add = false;
		LocalDate now = LocalDate.now();
		int custno = getLastCustno() + 1;

		try {
			conn = DBManager.getConnection(this.url, this.user, this.password);

			String sql = "INSERT INTO member_tbl_02 values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			pstmt.setString(2, custname);
			pstmt.setString(3, phone);
			pstmt.setString(4, address);
			pstmt.setString(5, now.toString());
			pstmt.setString(6, grade);
			pstmt.setString(7, city);
			rs = pstmt.executeQuery();
			add = rs.rowInserted();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return add;
	}

	// 회원 정보 수정
	public boolean setMember(int custno, String custname, String phone, String address, String grade, String city) {
		boolean set = false;

		try {
			conn = DBManager.getConnection(url, user, password);

			String sql = "UPDATE member_tbl_02 SET custname = ?, phone = ?, address = ?, grade = ?, city = ? WHERE custno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, custname);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setString(4, grade);
			pstmt.setString(5, city);
			pstmt.setInt(6, custno);
			rs = pstmt.executeQuery();
			set = rs.rowUpdated();
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
		return set;
	}

	// 모든 멤버 가져오기
	public ArrayList<MemberDto> getMemberAll() {
		ArrayList<MemberDto> members = new ArrayList<>();

		// 데이터베이스 연동 (Connection 얻음)
		try {
			conn = DBManager.getConnection(url, user, password);

			// 연동된 데이터베이스를 통해 -> 쿼리를 날려 -> 결과(Result Set)을 얻어옴
			// query : SELECT * FROM member
			String sql = "SELECT * FROM member_tbl_02 ORDER BY custno";
			pstmt = conn.prepareStatement(sql); // 쿼리를 날릴 준비!
			rs = pstmt.executeQuery(); // 결과 테이블 담기

			while (rs.next()) { // 결과 셋에서 읽지 않은 새로운 row가 있니?
				int custno = rs.getInt(1); // 읽어온 행에서 -> 1열의 값을 반환 (자료형을 지정해서 가져옴)(sql의 인덱스 1부터 증가)
				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				String joindate = rs.getString(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);

				members.add(new MemberDto(custno, custname, phone, address, joindate, grade, city));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연동 실패");
		} finally {
			// 사용 완료한 객체 닫기
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return members;
	}

	public MemberDto getMember(int custno) {
		MemberDto result = null;
		String sql = "select * from member_tbl_02 where custno = ?";

		try {
			conn = DBManager.getConnection(this.url, this.user, this.password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				String joindate = rs.getString(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);

				result = new MemberDto(custno, custname, phone, address, joindate, grade, city);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
}
