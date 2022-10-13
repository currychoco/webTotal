package money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MoneyDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String url;
	private String user;
	private String password;

	private MoneyDao() {
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "C##LHR";
		password = "1234";
	}

	private static MoneyDao instance = new MoneyDao();

	public static MoneyDao getInstance() {
		return instance;
	}

	public ArrayList<MoneyDto> getMoneyAll() {
		ArrayList<MoneyDto> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(this.url, this.user, this.password);

			String sql = "SELECT * FROM money_tbl_02";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int custno = rs.getInt(1);
				int saleno = rs.getInt(2);
				int pcost = rs.getInt(3);
				int amount = rs.getInt(4);
				int price = rs.getInt(5);
				String pcode = rs.getString(6);
				String sdate = rs.getString(7);

				list.add(new MoneyDto(custno, saleno, pcost, amount, price, pcode, sdate));
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
