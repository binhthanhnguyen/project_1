package models;

public class Member {
	private int id;
	private String name;
	private int familyId;
	private String relationship;
	private String dateOfBirth;
	private String achievement;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Member(int id, String name, int familyId, String relationship,
			String dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.familyId = familyId;
		this.relationship = relationship;
		this.dateOfBirth = dateOfBirth;
	}

	public Member(int id, String name, int familyId, String relationship,
			String dateOfBirth, String achievement) {
		super();
		this.id = id;
		this.name = name;
		this.familyId = familyId;
		this.relationship = relationship;
		this.dateOfBirth = dateOfBirth;
		this.achievement = achievement;
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



	public int getFamilyId() {
		return familyId;
	}



	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}



	public String getRelationship() {
		return relationship;
	}



	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}



	public String getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getAchievement() {
		return achievement;
	}



	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
}
