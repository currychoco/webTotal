package vote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBManager;

public class VoteDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private VoteDao() {
		conn=null;
		pstmt=null;
		rs=null;
	}
	
	private static VoteDao instance = new VoteDao();
	public static VoteDao getInstance() {
		return instance;
	}
	
	// 투표하기
	public void vote(String jumin, String name, String mNo, String time, String area, String vConfirm) {
		conn = DBManager.getConnection();
		String sql = "insert into tbl_vote_202005 values(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jumin);
			pstmt.setString(2, name);
			pstmt.setString(3, mNo);
			pstmt.setString(4, time);
			pstmt.setString(5, area);
			pstmt.setString(6, vConfirm);
			
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
	
	//투표검수조회
	public List<Map<String, String>> checkVote() {
		List<Map<String, String>> list = new ArrayList<>();
		
		conn = DBManager.getConnection();
		String sql = "select\r\n"
				+ "v_name as 성명,\r\n"
				+ "v_jumin as 주민등록번호,\r\n"
				+ "m_no as 후보번호,\r\n"
				+ "v_time as 투표시간,\r\n"
				+ "v_confirm as 유권자확인\r\n"
				+ "from tbl_vote_202005\r\n"
				+ "where v_area='제1투표장'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String vName = rs.getString(1);
				String vJumin = rs.getString(2);
				String mNo = rs.getString(3);
				String vTime = rs.getString(4);
				String vConfirm = rs.getString(5);

				String birthYear = "19" + vJumin.substring(0, 2);
				String birthMonth = vJumin.substring(2, 4);
				String birthDay = vJumin.substring(4, 6);
				
				// 생년월일
				String birth = birthYear + "년" + birthMonth + "월" + birthDay + "일생";
				
				// 나이
				int year = Integer.parseInt(birthYear);
				int ageInt = 2020 - year;
				String age = String.valueOf(ageInt);
				
				// 성별
				int genderInt = Integer.parseInt(vJumin.substring(6,7));
				String gender = "";
				if(genderInt % 2 == 0) {
					gender = "여";
				}else {
					gender = "남";
				}
				
				//투표시간
				String hour = vTime.substring(0, 2);
				String min = vTime.substring(2);
				String time = hour + ":" + min;
				
				// 유권자확인
				if(vConfirm.equals("Y")) {
					vConfirm = "확인";
				}else {
					vConfirm = "미확인";
				}
				
				Map<String, String> map = new HashMap<>();
				map.put("vName", vName);
				map.put("birth", birth);
				map.put("age", age);
				map.put("gender", gender);
				map.put("mNo", mNo);
				map.put("time", time);
				map.put("vConfirm", vConfirm);
				
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
