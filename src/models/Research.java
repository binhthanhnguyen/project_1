package models;

public class Research {
	private int id;
	private String topic;
	private String grade;
	private double funds;
	private String startDate;
	private String dueDate;
	private int researcherId;
	private String state;
	private String result;
	
	public Research() {
		// TODO Auto-generated constructor stub
	}

	public Research(int id, String topic, String grade, double funds,
			String startDate, String dueDate, int researcherId, String state,
			String result) {
		super();
		this.id = id;
		this.topic = topic;
		this.grade = grade;
		this.funds = funds;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.researcherId = researcherId;
		this.state = state;
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getFunds() {
		return funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public int getResearcherId() {
		return researcherId;
	}

	public void setResearcherId(int researcherId) {
		this.researcherId = researcherId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	
}
