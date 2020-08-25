

public class User {
	private int id;
	private String name;
	private String surname;
	private int houseNo;
	private String postcode;
	private String city;
	private String role;
	
	public User(int id, String name, String surname, int houseNo, String postcode, String city, String role) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.houseNo = houseNo;
		this.postcode = postcode;
		this.city = city;
		this.role = role;
	}	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public int getHouseno() {
		return houseNo;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getRole() { 
		return role;
	}


}