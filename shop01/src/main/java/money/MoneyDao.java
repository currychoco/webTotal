package money;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import member.MemberDao;
import member.MemberDto;
import util.DBManager;

public class MoneyDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url;
	private String user;
	private String password;
	
	private MoneyDao() {
		this.url = "jdbc:oracle:thin:@localhost:1521:xe";
		this.user = "c##lhr";
		this.password = "1234";
	}
	
	private static MoneyDao instance = new MoneyDao();
	public static MoneyDao getInstance() {
		return instance;
	}
	
	//매출
	public ArrayList<ArrayList<String>> getSales(){
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		
		MemberDao memberDao = MemberDao.getInstance();
		
		try {
			conn=DBManager.getConnection(url, user, password);
			String sql = "SELECT custno, SUM(price) as price FROM money_tbl_02 GROUP BY custno ORDER BY price DESC";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ArrayList<String> data = new ArrayList<>();
				
				int custno = rs.getInt(1);
				MemberDto member = memberDao.getMember(custno);
				
				data.add(rs.getString(1));
				data.add(member.getCustname());
				data.add(member.getGrade());
				data.add(rs.getString(2));
				
				result.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		return result;
	}
}
