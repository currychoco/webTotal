package user;

public class UserDto {
	private String name;
	private String id;
	private String password;
	
	public UserDto(String name, String id, String password) {
		this.name=name;
		this.id = id;
		this.password = password;
	}

	
	
	public String getName() {
		return name;
	}



	public String getId() {
		return id;
	}



	public String getPassword() {
		return password;
	}



	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
