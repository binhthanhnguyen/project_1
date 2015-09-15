package models;

public class Paper {
	private int id;
	private String name;
	private String issue;
	private int iSSN;
	private double impactFactor;
	private String publicationDate;
	private int userId;
	
	public Paper() {
		// TODO Auto-generated constructor stub
	}

	public Paper(int id, String name, String issue, int iSSN,
			double impactFactor, String publicationDate, int userId) {
		super();
		this.id = id;
		this.name = name;
		this.issue = issue;
		this.iSSN = iSSN;
		this.impactFactor = impactFactor;
		this.publicationDate = publicationDate;
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

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public int getiSSN() {
		return iSSN;
	}

	public void setiSSN(int iSSN) {
		this.iSSN = iSSN;
	}

	public double getImpactFactor() {
		return impactFactor;
	}

	public void setImpactFactor(double impactFactor) {
		this.impactFactor = impactFactor;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
