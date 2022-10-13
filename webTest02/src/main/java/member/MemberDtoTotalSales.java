package member;

public class MemberDtoTotalSales {

	private int custno;
	private String custname;
	private String grade;
	private int totalSales;
	
	public int getCustno() {
		return custno;
	}

	public String getCustname() {
		return custname;
	}

	public String getGrade() {
		return grade;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public MemberDtoTotalSales(int custno, String custname, String grade, int totalSales) {
		this.custno = custno;
		this.custname = custname;
		this.grade = grade;
		this.totalSales = totalSales;
	}

	//매출 더하기
	public void add(int price) {
		this.totalSales += price;
	}

}
