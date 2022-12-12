package sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBManager;

public class SalesDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private SalesDao() {
		conn = null;
		pstmt = null;
		rs = null;
	}
	
	private static SalesDao instance = new SalesDao();
	public static SalesDao getInstance() {
		return instance;
	}
	
	//전체 매출 조회
	public List<Map<String, String>> getAllSales(){
		List<Map<String, String>> total = new ArrayList<>();
		
		conn = DBManager.getConnection();
		String sql="select\r\n"
				+ "mon.custno as 회원번호,\r\n"
				+ "mem.custname as 회원명,\r\n"
				+ "mem.grade as 등급,\r\n"
				+ "sum(mon.price) as 매출\r\n"
				+ "from money_tbl_02 mon\r\n"
				+ "join member_tbl_02 mem\r\n"
				+ "on mem.custno=mon.custno\r\n"
				+ "group by mon.custno, mem.custname, mem.grade\r\n"
				+ "order by 매출 desc";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String custno = rs.getString(1);
				String custname = rs.getString(2);
				String grade = rs.getString(3);
				String sales = rs.getString(4);
				
				switch (grade) {
				case "A":
					grade = "VIP";
					break;
				case "B":
					grade = "일반";
					break;
				case "C":
					grade="직원";
					break;
				default:
					break;
				}
				
				Map<String, String> map = new HashMap<>();
				map.put("custno", custno);
				map.put("custname", custname);
				map.put("grade", grade);
				map.put("sales", sales);
				
				total.add(map);
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
		
		return total;
	}
}
