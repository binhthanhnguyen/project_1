package models;

public class Faculty {
	private int id;
	private String name;
	private String location;
	private String description;

	public Faculty() {
		// TODO Auto-generated constructor stub
	}

	public Faculty(String name, String location, String description) {
		super();
		this.name = name;
		this.location = location;
		this.description = description;
	}

	public Faculty(int id, String name, String location, String description) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.description = description;
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

	public String getlocation() {
		return location;
	}

	public void setlocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
