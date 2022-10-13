package member;

//Java Bean : ���α׷� �ȿ��� �����͸� �����ϴ� �ڷᱸ��
// 1) VO(Value Object) - VO�� read only�� -> getter �� ����
// 2) DTO(Data Transfer Object) - �����ͺ��̽��� �����͸� �ְ�޴� ��ü�� ���
// 3) DAO(Data Access Object) - DTO�� ���� �� �ֵ��� �����ͺ��̽��� ���������� �������ִ� ��ü(������ ó�� ������ �����ϴ� �������̽�)


//ȸ�������� ���� ��ü�� �����ϴ� Ŭ����
public class MemberDto { //DTO
	//���� : Oracle Database�� member_tbl02, money_tbl_02�� ��Ī�Ǿ����� MemberDto, MoneyDto�����
	// Singleton Patter���� MemberDao, MoneyDao�� ������ ��
	// �� 4���� �ڵ�� ����	
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private String joindate;
	private String grade;
	private String city;
	
	public MemberDto(int custno, String custname, String phone, String address, String joindate, String grade,
			String city) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
