import java.io.Serializable;

public class Login implements Serializable {

		private static final long serialVersionUID = 1L;
	    private String name;
	    private String password;
	    private String email;
	    private String contact;

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
		public Login(String name, String password, String email, String contact) {
			super();
			this.name = name;
			this.password = password;
			this.email = email;
			this.contact = contact;
		}
	}
