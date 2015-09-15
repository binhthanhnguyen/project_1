package models;

public class User {
	private int id;
	private String name;
	private String password;
	private String role;
	private String gender;
	private String dateOfBirth;
	private String phone;
	private String email;
	private String address;
	private int deparmentId;
	private String office;
	private String position;
	private int salaryGrade;
	private double positionAllowance;
	private double teachingAllowance;
	private int taxId;
	private String accountNumber;
	private boolean partyMember;
	private boolean unionMember;
	private boolean tradeUnionist;
	private String achievement;
	private String otherInfo;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public User(String name, String gender, String phone, String email, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public User(int id, String name, String password, String role,
			String gender, String dateOfBirth, String phone, String email,
			String address, int deparmentId, String office, String position,
			int salaryGrade, double positionAllowance,
			double teachingAllowance, int taxId, String accountNumber,
			boolean partyMember, boolean unionMember, boolean tradeUnionist,
			String achievement, String otherInfo) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.deparmentId = deparmentId;
		this.office = office;
		this.position = position;
		this.salaryGrade = salaryGrade;
		this.positionAllowance = positionAllowance;
		this.teachingAllowance = teachingAllowance;
		this.taxId = taxId;
		this.accountNumber = accountNumber;
		this.partyMember = partyMember;
		this.unionMember = unionMember;
		this.tradeUnionist = tradeUnionist;
		this.achievement = achievement;
		this.otherInfo = otherInfo;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDeparmentId() {
		return deparmentId;
	}

	public void setDeparmentId(int deparmentId) {
		this.deparmentId = deparmentId;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalaryGrade() {
		return salaryGrade;
	}

	public void setSalaryGrade(int salaryGrade) {
		this.salaryGrade = salaryGrade;
	}

	public double getPositionAllowance() {
		return positionAllowance;
	}

	public void setPositionAllowance(double positionAllowance) {
		this.positionAllowance = positionAllowance;
	}

	public double getTeachingAllowance() {
		return teachingAllowance;
	}

	public void setTeachingAllowance(double teachingAllowance) {
		this.teachingAllowance = teachingAllowance;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isPartyMember() {
		return partyMember;
	}

	public void setPartyMember(boolean partyMember) {
		this.partyMember = partyMember;
	}

	public boolean isUnionMember() {
		return unionMember;
	}

	public void setUnionMember(boolean unionMember) {
		this.unionMember = unionMember;
	}

	public boolean isTradeUnionist() {
		return tradeUnionist;
	}

	public void setTradeUnionist(boolean tradeUnionist) {
		this.tradeUnionist = tradeUnionist;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

}
