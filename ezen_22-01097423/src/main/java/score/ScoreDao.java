package score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class ScoreDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private ScoreDao() {
		conn = null;
		pstmt = null;
		rs = null;
	}
	
	private static ScoreDao instance = new ScoreDao();
	public static ScoreDao getInstance() {
		return instance;
	}
	
	//Create 
	public boolean addScore(String stid, String dtcode, int midScore, int finalScore, int attend, int report, int etc) {
		boolean result = false;
		
		conn = DBManager.getConnection();
		String sql = "insert into table_result_03 values(?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stid);
			pstmt.setString(2, dtcode);
			pstmt.setInt(3, midScore);
			pstmt.setInt(4, finalScore);
			pstmt.setInt(5, attend);
			pstmt.setInt(6, report);
			pstmt.setInt(7, etc);
			
			result=pstmt.execute();
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
		return result;
	}
	
	//전체 읽어오기
	public List<List<String>> getAllList(){
		List<List<String>> list = new ArrayList<>();
		conn = DBManager.getConnection();
		String sql = "select\r\n"
				+ "res.stid as 학번,\r\n"
				+ "std.stname as 성명,\r\n"
				+ "std.resident as 성별,\r\n"
				+ "sub.subject as 과목명,\r\n"
				+ "sub.class as 전공구분,\r\n"
				+ "sub.professor as 담당교수,\r\n"
				+ "res.mid as 중간,\r\n"
				+ "res.final as 기말,\r\n"
				+ "res.attend as 출석,\r\n"
				+ "res.report as 레포트,\r\n"
				+ "res. etc as 기타,\r\n"
				+ "(select 평균 from scores sc where res.dtcode=sc.과목코드 AND res.stid=sc.학번) as 점수\r\n"
				+ "from table_result_03 res\r\n"
				+ "join table_std_01 std on res.stid=std.stid\r\n"
				+ "join table_subject_02 sub on res.dtcode=sub.subjectcode\r\n"
				+ "order by sub.subject desc, res.stid";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String stid = rs.getString(1);
				String stname = rs.getString(2);
				String gender = rs.getString(3);
				if(gender.charAt(7) == '1' || gender.charAt(7) == '3') {
					gender = "남";
				}else {
					gender = "여";
				}
				
				String subject = rs.getString(4);
				String clas = rs.getString(5);
				String professor = rs.getString(6);
				String midScore = rs.getString(7);
				String finalScore = rs.getString(8);
				String attend = rs.getString(9);
				String report = rs.getString(10);
				String etc = rs.getString(11);
				String scoreAvg = rs.getString(12);
				if(!scoreAvg.contains(".")) {
					scoreAvg += ".0";
				}
				
				double score = Double.parseDouble(scoreAvg);
				String grade;
				if(score >= 90) {
					grade = "A";
				} else if(score >=80) {
					grade = "B";
				} else if(score >= 70) {
					grade = "C";
				} else if(score >=60) {
					grade = "D";
				}else {
					grade = "F";
				}
				
				List<String> info = new ArrayList<>();
				info.add(stid);
				info.add(stname);
				info.add(gender);
				info.add(subject);
				info.add(clas);
				info.add(professor);
				info.add(midScore);
				info.add(finalScore);
				info.add(attend);
				info.add(report);
				info.add(etc);
				info.add(scoreAvg);
				info.add(grade);
				
				list.add(info);
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
