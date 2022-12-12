package lms;

import java.util.ArrayList;

public class Student {

	// 모든 멤버변수는 private 처리  
	private int number;
	private String name;
	
	private ArrayList<Subject> subjects;
	
	public Student(int number, String name) {
		this.number = number;
		this.name = name;
		this.subjects = new ArrayList<Subject>(); // empty 
	}
	
	// 모든 Getter & Setter는 public 처리 
	public int getNumber() { // 조회만 가능 
		return this.number;
	}
	// get.number 하면 스튜던트의 변수 number값을 가져옴 
	
//	public void setNumber(int number) { // 기발급된 학번 수정을 허용X  
//		this.number = number;
//	}
	
	public String getName() {
		return this.name;
	}
	// get Name 하면 리턴 값으로 스튜던트의 number 값을 가져옴
	
	public void setName(String name) {
		this.name = name;
	}
	
	// setName 하면 name에 값을 넣고 이름이 설정 됨
	
	// 그 외 기능 메소드는 용도에 맞게 public 또는 private 처리 
	
	// 학생의 수강신청 내역 리스트에 접근할 수 있도록 퍼블릭 메소드 제공 
	public void addSubject(Subject subject) { //수강신청하려고 하는 과목의 값을 String으로 뽑아서 넣음 
		boolean dupl = false;
		for(Subject sub : this.subjects) { // 이때 서브에 서브젝트 함수를 담는데 
			if(sub.getTitle().equals(subject.getTitle())) // 서브.겟타이틀이같다면 트루줌 
				dupl = true;
		}
		if(!dupl) {
			this.subjects.add(subject); // 만약 같은게 없으면 
			System.out.println("수강신청 완료");
		}
		else	//있으면 
			System.out.println("이미 신청한 과목입니다.");
	}
	
//	public ArrayList<Subject> getSubjects() { // 외부에서 해당 객체(ArrayList)의 모든 메소드에 접근 가능 -> 쓰지 말자 
//		return this.subjects;
//	}
	
	// 대안 : 전체 과목에 대한 조회 용도로만 public 메소드를 제공 
	public void printSubjectAll() { // printStudentAll()을 위해 만들어진 함수 
		for(int i=0; i<this.subjects.size(); i++) { // 이것도 사이즈에 맞게 과목과 함수를 갖게 된다. 
			Subject subject = this.subjects.get(i); // 가독성을 높이기 위해 subject를 만들게 됐다. 
			System.out.printf("ㄴ %d) %s : %d점\n", i+1, subject.getTitle(), subject.getScore());
			// 새로 만든 subject에 타이틀 메세도르와 점수 메소드를 통하여 값을 가져옴
		}
	}
	
	public int getSubjectsSize() {
		return this.subjects.size();
	}
	
	public void setSubjectScore(int idx, int score) {
		Subject subject = this.subjects.get(idx); // 수정 대상 과목 
		subject.setScore(score);
		System.out.println("성적입력 완료 ");
	} // 여기에 서브젝트 
	
	public Subject getSubject(int idx) {
		return this.subjects.get(idx);
	}
	
	public void removeSubject(int idx) {
		this.subjects.remove(idx); // 받은 인덱스에서 서브젝트를 뺀다.
	}
	
	
	
}
