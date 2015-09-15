package models;

public class Class {
	private int id;
	private String name;
	private int subjectId;
	private int year;
	private int semester;
	private int userId;
	
	public Class() {
		// TODO Auto-generated constructor stub
	}

	public Class(int id, String name, int subjectId, int year, int semester) {
		super();
		this.id = id;
		this.name = name;
		this.subjectId = subjectId;
		this.year = year;
		this.semester = semester;
	}

	public Class(int id, String name, int subjectId, int year, int semester,
			int userId) {
		super();
		this.id = id;
		this.name = name;
		this.subjectId = subjectId;
		this.year = year;
		this.semester = semester;
		this.userId = userId;
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

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
