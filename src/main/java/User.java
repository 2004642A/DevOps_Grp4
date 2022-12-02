
public class User {

	protected String name;
	protected String password;
	protected String email;
	protected String contact;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public User(String name, String password, String email, String contact) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.contact = contact;
	}

}
