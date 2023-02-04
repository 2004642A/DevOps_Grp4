import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserCollectionTest {

	private UserCollection uc;
	private User u1;
	private final int USER_COLLECTION_SIZE = 1;
	
	@BeforeEach
	void setUp() throws Exception {
		uc= new UserCollection();
		u1 = new User("James","James2004","james@gmail.com","56789");
		uc.addUser(u1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetUsers() {
		List<User> retrievedUsers = uc.getUsers();
		 assertEquals(1, retrievedUsers.size());
		 assertEquals("James", retrievedUsers.get(0).getName());
		
	}

	@Test
	void testAddUser() {
		//fail("Not yet implemented");
		List<User> testUc = uc.getUsers();
		assertEquals(testUc.size(), USER_COLLECTION_SIZE);
		uc.addUser(u1);
		assertEquals(uc.getUsers().size(), USER_COLLECTION_SIZE+1);
	}
	
	@Test
	void testUpdateUser() {
		List<User> testUc = uc.getUsers();
		boolean updated = uc.updateUserInformation(testUc, "James", "James2004", "james123@gmail.com","5678954");
		assertEquals(true, updated);
		User updatedUser = getUserByName(testUc, "James");
		assertEquals("James", updatedUser.getName());
		assertEquals("James2004", updatedUser.getPassword());
		assertEquals("james123@gmail.com", updatedUser.getEmail());
		assertEquals("5678954", updatedUser.getContact());
	
		
	}
	
	@Test
	 void testDeleteUserByName() {
	    List<User> users = uc.getUsers();
	    assertEquals("James", users.get(0).getName());
	    uc.deleteUserByName(users, "James");
	   
	  }
	
	
	public User getUserByName(List<User> testUc, String name) {
		// TODO Auto-generated method stub
		 for (User user : testUc) {
		      if (user.getName().equals(name)) {
		        return user;
		      }
		    }
		return null;
	}


}
