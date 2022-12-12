package lms;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lms {
	
	// 멤버 변수는 정의부만 둠 -> 생성자 안에서 초기화 
	private Scanner sc;
	
	private FileManager fm;
	private String brand;
	private ArrayList<Student> list;
	private ArrayList<Subject> subjectList; // 과목을 만들기 위함 // 배열이라 생성자 영양안받음그럼 생성자는 ?
	
	public Lms(String brand) {
		this.brand = brand;
		init(); // 여기서 이닛을 쓴 이유는 모든 변수와 메소드를 초기화 해야 모든 함수들과 변수들을 사용 할 수 있음
	}
	
	
	private void init() {
		this.sc = new Scanner(System.in);
		this.fm = new FileManager(); // 추후에 생각 
		this.list = new ArrayList<Student>(); //list에 학생 리스트 추가 
		this.subjectList = new ArrayList<Subject>();
		
		this.subjectList.add(new Subject("국어")); // 여기서 과목에 그냥 추가함 함수가 3이 됨
		this.subjectList.add(new Subject("영어")); // String 의 title을 변수 없이 그냥 String 을 넣어서 title생김 
		this.subjectList.add(new Subject("수학"));
	}
	
	private void printMainMenu() {
		System.out.printf("total : %d\n", this.list.size());
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 정렬");
		System.out.println("4. 조회");
		System.out.println("5. 저장");
		System.out.println("6. 로드");
		System.out.println("0. 종료");
	}
	
	private void printSubMenuAdd() {
		System.out.println("1) 학생 등록");
		System.out.println("2) 수강 신청");
		System.out.println("3) 성적 입력");
	}
	
	private void printSubMenuDelete() {
		System.out.println("1) 학생 탈퇴");
		System.out.println("2) 수강 취소");
	}
	
	private int input() {
		System.out.print("선택 : ");
		return this.sc.nextInt();
	}
	
	private void printStudentAll() { // 임시로 학생들을 보여주기위해 설정된 StudentAll;
		for(int i=0; i<this.list.size(); i++) { // 이때 for문의 크기는 size로 정의 만약 함수가 있다면 size 변화
			Student student = this.list.get(i); 	//그리고 함수마다 student 로 정의해서넘버와 내임을 가져옴 
			System.out.printf("%d) %d : %s\n", i+1, student.getNumber(), student.getName());
			student.printSubjectAll(); // 서브젝트 함수를 가져옴 
		}
	}
	
	private void addStudent() {
		System.out.print("등록할 학생명 : ");
		String name = this.sc.next();
		int num = randomGenerator(); // num값을 주기 위해 
		
		Student student = new Student(num, name); // 랜덤으로 얻어온 값과방금 입력한 이름으로 생성자스튜던트 에 값넣음 
		this.list.add(student);
		System.out.printf("%s 학생등록 완료, 학번 : %d\n", name, num);
	}

	private int randomGenerator() {
		Random rn = new Random();
		int rNum = 0;
		while(true) {
			rNum = rn.nextInt(8999) +1000;
			
			boolean dupl = false;
			for(Student student : this.list) {
				if(rNum == student.getNumber())
					dupl = true;
			}
			if(!dupl)
				break;
		}
		return rNum;
	}
	
	private Student getStudent() {
		System.out.print("학번 : ");
		int num = this.sc.nextInt();
		
		for(Student student : this.list) {
			if(student.getNumber() == num)
				return student;  // 리턴값이 나오면 즉시 함수가 종료됨;
		}
		return null;	// 위에서 리턴값이 안나오면 널을 너줌 
	}
	
	private void addSubject() {
		Student student = getStudent(); // 널값 되면 그냥 널임 
		
		// 수강신청할 수 있는 과목 목록 출력 
		for(int i=0; i<this.subjectList.size(); i++) { // Lms에서 만든 서브젝트 리스트 3개임
			Subject subject = this.subjectList.get(i);	// 새롭게  subject에 넣어줌 
			System.out.printf("%d) %s\n", i+1, subject.getTitle()); // 그래서 subject 타이틀 겟 메소드에서 값 가져옴 
		}
		// 수강신청 인덱스를 입력받음 
		int idx = input() -1; // 위에 번호 누르면 
		
		// 유효한 선택여부 예외처리 
		if(idx >= 0 && idx < this.subjectList.size()) {
			// 추가할 과목 객체를 따로 생성 
			// 문제점 : 과목 리스트로 둔 객체의 주소가 공유 -> 모든 학생이 한개 객체를 공유
//			Subject subject = this.subjectList.get(idx);   
			String title = this.subjectList.get(idx).getTitle(); // 과목의 타이틀을 확인하는 용도로만 idx를 사용 
			Subject subject = new Subject(title); // 새로운 과목 객체 생성 (주소의 할당 : 인스턴스) 
			student.addSubject(subject);
		}
	}
	// key 포인트 ^^^^^^^^^^^^^^^^^^^^^ 
	
	
	// String title  
	
	private void updateScore() {
		Student student = getStudent();
		student.printSubjectAll();
		int idx = input() -1;
		
		if(idx >= 0 && idx < student.getSubjectsSize()) { 
			System.out.print("성적 입력 : ");
			int score = this.sc.nextInt();
			
			student.setSubjectScore(idx, score); // 스튜던트에 만들어둔 idx score을 입력
		}
	}
	
	private void removeStudent() {
		Student student = getStudent(); // this.list 에서 대상 학생객체 주소 반환
		if(student != null) {
			this.list.remove(student); // list에 있는 학생을 삭제한다. 
			System.out.println("학생탈퇴 완료");
		}
	}
	
	private void removeSubject() {
		Student student = getStudent(); // 학번 입력하고 스튜던트배열 가져옴 
		student.printSubjectAll();		// 	그리고 현재 가지고 있는서브젝트 목록 보여줌 
		int delIdx = this.sc.nextInt() -1; //인덱스 받고
		
		if(delIdx >= 0 && delIdx < student.getSubjectsSize()) {
			student.removeSubject(delIdx);  // 스튜던트 리무브에서 인덱스 넣어서 삭제 
			System.out.println("수강취소 완료");
		}
	}
	
	private void sortByStudentName() { // 정렬 
		// this.list 
		for(int i=0; i<this.list.size(); i++) { // 리스트의 사이즈 만큼 배열 돌린다 .
			Student first = this.list.get(i);	 // 새로운 first배열에 일단 첫번째 넣고 
			for(int j=i; j<this.list.size(); j++) { // 다시 새로운 배열 
				Student last = this.list.get(j); // last로 j 넣고 
				if(first.getName().compareTo(last.getName()) > 0) {
					this.list.set(i, last);		// ArrayList 의 값 수정 set()  // 이건 암기..
					this.list.set(j, first);
				}
			}
		}
	}
	
	private String createData() {		 // creatData 
		// 학번/이름,수강과목1/성적1,수강과목2/성적2... 
		String data = "";					 // 담을 String 배열 
		for(int i=0; i<this.list.size(); i++) { 
			Student student = this.list.get(i); //일단 student 배열 만들고 
			data += student.getNumber() + "/"; 	// 번호 이름 저장하고 
			data += student.getName();
			
			// 과목 
			for(int j=0; j<student.getSubjectsSize(); j++) { // get담을 준비 
				Subject subject = student.getSubject(j); // 
				String title = subject.getTitle();
				int score = subject.getScore();
				
				data += ",";
				data += title + "/" + score;
			}
			
			if(i < this.list.size() -1)
				data += "\n";
		}
		return data;
	}
	
	private void saveData() {
		String data = createData();
		fm.save(data);
	}
	
	private void loadData() {
		this.list = fm.load();
	}
	
	public void run() {
		while(true) {
			printStudentAll();
			printMainMenu();
			int sel = input();
			if(sel == 1) {
				printSubMenuAdd();
				sel = input();
				if(sel == 1)
					addStudent();
				else if(sel == 2)
					addSubject();
				else if(sel == 3)
					updateScore();
			}
			else if(sel == 2) {
				printSubMenuDelete();
				sel = input();
				
				if(sel == 1)
					removeStudent();
				else if(sel == 2)
					removeSubject();
			}
			else if(sel == 3)
				sortByStudentName();
			else if(sel == 4) 
				printStudentAll();
			else if(sel == 5) 
				saveData();
			else if(sel == 6) 
				loadData();
			else if(sel == 0) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
			
		}
	}
	
}
