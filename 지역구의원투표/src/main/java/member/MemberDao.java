package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBManager;

public class MemberDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MemberDao() {
		conn=null;
		pstmt=null;
		rs=null;
	}
	
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	// 후보자 등수
	public List<Map<String, String>> getMemberRank() {
		List<Map<String, String>> list = new ArrayList<>();
		conn = DBManager.getConnection();
		String sql = "select\r\n"
				+ "vote.m_no as 후보번호,\r\n"
				+ "(select m_name from tbl_member_202005 where m_no=vote.m_no) as 후보명,\r\n"
				+ "count(m_no) as 총투표건수 \r\n"
				+ "from tbl_vote_202005 vote\r\n"
				+ "where vote.v_confirm = 'Y'\r\n"
				+ "group by vote.m_no\r\n"
				+ "order by 총투표건수 desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String mNo = rs.getString(1);
				String mName = rs.getString(2);
				String score = rs.getString(3);
				
				Map<String, String> map = new HashMap<>();
				map.put("mNo", mNo);
				map.put("mName", mName);
				map.put("score", score);
				
				list.add(map);
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
	
	//후보자 리스트
	public List<Map<String, String>> getMemberList(){
		List<Map<String, String>> list = new ArrayList<>();
		
		conn = DBManager.getConnection();
		String sql = "select\r\n"
				+ "mem.m_no as 후보성명,\r\n"
				+ "mem.m_name as 성명,\r\n"
				+ "(select p_name from tbl_party_202005 where p_code=mem.p_code) as 소속정당,\r\n"
				+ "mem.p_school as 학력,\r\n"
				+ "mem.m_jumin as 주민번호,\r\n"
				+ "mem.m_city as 지역구,\r\n"
				+ "(select p_tel1 from tbl_party_202005 where p_code=mem.p_code) || '-' ||\r\n"
				+ "(select p_tel2 from tbl_party_202005 where p_code=mem.p_code) || '-' ||\r\n"
				+ "(select p_tel3 from tbl_party_202005 where p_code=mem.p_code) as 대표전화\r\n"
				+ "from tbl_member_202005 mem";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String mNo = rs.getString(1);
				String mName = rs.getString(2);
				String pName = rs.getString(3);
				String school = rs.getString(4);
				String jumin = rs.getString(5);
				String area = rs.getString(6);
				String tel = rs.getString(7).replaceAll(" ", "");
				
				// 학력
				String schoolName = "";
				switch (school) {
				case "1":
					schoolName = "고졸";
					break;
				case "2":
					schoolName = "학사";
					break;
				case "3":
					schoolName = "석사";
					break;
				case "4":
					schoolName = "박사";
					break;
				default:
					break;
				}
				
				// 주민등록번호
				String firstJumin = jumin.substring(0, 6);
				String secondJumin = jumin.substring(6);
				String fullJumin = firstJumin + "-" + secondJumin;
				
				Map<String, String> map = new HashMap<>();
				map.put("mNo", mNo);
				map.put("mName", mName);
				map.put("pName", pName);
				map.put("school", schoolName);
				map.put("jumin", fullJumin);
				map.put("area", area);
				map.put("tel", tel);
				
				list.add(map);
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
}
