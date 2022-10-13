package money;

public class MoneyDao {
	private MoneyDao() {};
	
	private static MoneyDao instance = new MoneyDao();
	
	public static MoneyDao getInstance() {
		return instance;
	}
}
