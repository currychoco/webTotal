package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.DBManager;

public class MemberDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private MemberDao() {
		conn=null;
		pstmt=null;
		rs=null;
	}
	
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	public int getLastNo() {
		int no = 100000;
		conn = DBManager.getConnection();
		String sql = "select max(custno) from member_tbl_02";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				no = rs.getInt(1);
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
		
		return no + 1;
	}
	
	public void addMember(MemberDto dto) throws ParseException {
		conn=DBManager.getConnection();
		String sql="insert into member_tbl_02 values(?,?,?,?,?,?,?)";
		java.sql.Date sqlDate = java.sql.Date.valueOf(dto.getJoindate());
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCustno());
			pstmt.setString(2, dto.getCustname());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddress());
			pstmt.setDate(5, sqlDate);
			pstmt.setString(6, dto.getGradeOriginal());
			pstmt.setString(7, dto.getCity());
			
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public List<MemberDto> memberList(){
		List<MemberDto> list = new ArrayList<>();
		
		conn=DBManager.getConnection();
		String sql = "select * from member_tbl_02";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int custno = rs.getInt(1);
				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				String joinDate = rs.getString(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);
				
				list.add(new MemberDto(custno, custname, phone, address, joinDate, grade, city));
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
	
	public MemberDto getMember(int custno) {
		MemberDto dto = null;
		conn = DBManager.getConnection();
		String sql = "select * from member_tbl_02 where custno=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address=rs.getString(4);
				String joinDate =rs.getString(5);
				String grade =rs.getString(6);
				String city = rs.getString(7);
				
				dto = new MemberDto(custno, custname, phone, address, joinDate, grade, city);
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
		
		return dto;
	}
	
	public void updateMember(MemberDto member) {
		conn = DBManager.getConnection();
		String sql = "update member_tbl_02 set custname=?,phone=?,address=?,joindate=?,grade=?,city=? where custno=?";
		java.sql.Date date = java.sql.Date.valueOf(member.getJoindate());
				
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getCustname());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddress());
			pstmt.setDate(4, date);
			pstmt.setString(5, member.getGradeOriginal());
			pstmt.setString(6, member.getCity());
			pstmt.setInt(7, member.getCustno());
			
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
}
