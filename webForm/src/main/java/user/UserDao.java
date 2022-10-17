package user;

import java.util.ArrayList;

public class UserDao {

	private ArrayList<UserDto> list;

	private UserDao() {
		this.list = new ArrayList<UserDto>();
	}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	// 1. Create
	// 2. Read
	// 2-1) 객체 한 개 조회(아이디로 조회)
	// 2-2) 전체 데이터 조회
	// 3. Update
	// 4. Delete

	// 유저 생성
	private boolean checkDupl(String id) {
		boolean dupl = false;

		for (UserDto user : this.list) {
			if (id.equals(user.getId())) {
				dupl = true;
			}
		}
		return dupl;
	}

	public boolean addUser(String name, String id, String password) {
		if (!checkDupl(id)) {
			UserDto userDto = new UserDto(name, id, password);
			this.list.add(userDto);
			return true;
		}
		return false;
	}

	public boolean addUser(UserDto userDto) {
		if(!checkDupl(userDto.getId())) {
			this.list.add(userDto);
			return true;
		}
		return false;
	}

	// 하나의 유저정보 가져오기
	public UserDto getUserById(String id) {
		UserDto userDto = null;

		for (UserDto user : this.list) {
			if (id.equals(user.getId())) {
				userDto = user;
			}
		}

		return userDto;
	}

	// 모든 유저정보 가져오기
	public ArrayList<UserDto> getUserAll() {
		// return list;
		// 복사본을 줌
		ArrayList<UserDto> copy = new ArrayList<UserDto>();
		for (UserDto user : this.list) {
			UserDto userDto = new UserDto(user.getName(), user.getId(), user.getPassword());
			copy.add(userDto);
		}
		return copy;
	}

	// 유저 이름과 비밀번호 바꾸기
	public void setUser(UserDto userDto) {
		// 1) id 확인, index 얻고
		// 2) 해당 객체를 새 객체로 교체해주기

		int idx = -1;
		for (int i = 0; i < this.list.size(); i++) {
			UserDto user = this.list.get(i);
			if (userDto.getId().equals(user.getId())) {
				idx = i;
			}
		}

		if (idx != -1) {
			this.list.set(idx, userDto);
		}
	}

	public void setUser(String name, String id, String password) {
		UserDto userDto = getUserById(id);
		if (userDto != null) {
			userDto.setName(name);
			userDto.setPassword(password);
			setUser(userDto);
		}
	}

	// 유저 삭제하기
	// 1) id 일치하는 객체 확인 후 -> pw도 일치하면 삭제
	public void removeUser(String id, String password) {
		UserDto userDto = getUserById(id);
		if (userDto != null && userDto.getPassword().equals(password)) {
			this.list.remove(userDto);
		}
	}
}
