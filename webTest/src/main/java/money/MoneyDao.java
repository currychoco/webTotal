package money;

public class MoneyDao { // Member ���� ������ ���� ó�� ����� ����
	// DAO�� ���α׷� ���� ��, ������ ��ü�� �� �� �ְ� ����
	// ������(����) ���� ��, �̱��� �������� ������ �� ����
	// �� Singleton Pattern
	
	// 1. �ܺο��� newŰ���带 ���� MemberDao ��ü�� ������ �� ������ �⺻�����ڸ� ���ƹ���
	private MoneyDao() {}
	// 2. ������ ��ü�� Ŭ���� ���ο��� (private)������ ȣ���� ���� instance �Ҵ�
	private static MoneyDao instance = new MoneyDao();
	// 3. private ����� ������ �� �ִ� ������ getter
	public static MoneyDao getInstance() {
		return instance;
	}
	
	//�������� ������ ���� ��� �޼ҵ� ����~
}
