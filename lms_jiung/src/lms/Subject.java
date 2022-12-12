package lms;

public class Subject {
	
	private String title;
	private int score;		
	
	// Constructor 
	public Subject(String title) {  // private ArrayList<Subject> subjectList; 여기서 이걸 추가 
		this.title = title;
	}
	// 생성자 오버로딩 
	public Subject(String title, int score) {
		this.title = title;
		this.score = score;
	}
	
	// Getter & Setter 
	public String getTitle() {
		return this.title;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

}