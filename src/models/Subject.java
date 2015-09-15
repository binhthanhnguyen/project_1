package models;

public class Subject {
	private int id;
	private String name;
	private int credits;
	private int textbookId;
	private String description;
	private int departmentId;
	
	public Subject() {
	}
	
	public Subject(int id, String name, int credits, String description) {
		super();
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.description = description;
	}

	public Subject(int id, String name, int credits, int textbookId,
			String description, int departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.textbookId = textbookId;
		this.description = description;
		this.departmentId = departmentId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCredits() {
		return credits;
	}


	public void setCredits(int credits) {
		this.credits = credits;
	}


	public int getTextbookId() {
		return textbookId;
	}


	public void setTextbookId(int textbookId) {
		this.textbookId = textbookId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
}
