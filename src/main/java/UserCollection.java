import java.util.ArrayList;
import java.util.List;

public class UserCollection {
	 private ArrayList<User> users = new ArrayList<>();
	    
	    public UserCollection() {
	    	/*users.add(new User("James","James2004","james@gmail.com","56789"));*/
	       
	    }


	    public List<User> getUsers() {
	        return users;
	    }

	    public void addUser(User user) {
	    	users.add(user);
	    	
	    }
	  
		public boolean updateUserInformation(List<User> testUc, String name, String password, String email, String contact) {
			 for (User user : users) {
			      if (user.getName().equals(name)) {
			    	user.setName(name);
			        user.setPassword(password);
			        user.setEmail(email);
			        user.setContact(contact);
			        return true;
			      }
			 }
			return false;
		}
		
		public void deleteUserByName(List<User> users, String name) {
		    for (int i = 0; i < users.size(); i++) {
		      if (users.get(i).getName().equals(name)) {
		        users.remove(i);
		        break;
		      }
		    }
		}
	  


}

