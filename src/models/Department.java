package models;

public class Department {
	private int id;
	private String name;
	private String description;
	private int facultyId;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public Department(String name, String description, int facultyId) {
		super();
		this.name = name;
		this.description = description;
		this.facultyId = facultyId;
	}
	public Department(int id, String name, String description, int facultyId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.facultyId = facultyId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
}
