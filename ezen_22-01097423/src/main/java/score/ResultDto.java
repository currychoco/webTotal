package score;

public class ResultDto {
	private String stid;
	private String dtcode;
	private int midScore;
	private int finalScore;
	private int attend;
	private int report;
	private int etc;
	
	public ResultDto(String stid, String dtcode, int midScore, int finalScore, int attend, int report, int etc) {
		super();
		this.stid = stid;
		this.dtcode = dtcode;
		this.midScore = midScore;
		this.finalScore = finalScore;
		this.attend = attend;
		this.report = report;
		this.etc = etc;
	}

	public String getStid() {
		return stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public String getDtcode() {
		return dtcode;
	}

	public void setDtcode(String dtcode) {
		this.dtcode = dtcode;
	}

	public int getMidScore() {
		return midScore;
	}

	public void setMidScore(int midScore) {
		this.midScore = midScore;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public int getAttend() {
		return attend;
	}

	public void setAttend(int attend) {
		this.attend = attend;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public int getEtc() {
		return etc;
	}

	public void setEtc(int etc) {
		this.etc = etc;
	}
	
	
}
