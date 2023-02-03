import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	private User usertest;
	
	@BeforeEach
	void setUp() throws Exception {
		usertest = new User(null, null, null, null);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetName() {
		 usertest.setName("James");
		 String expectedName = "James";
		 String actualName = usertest.getName();
		 assertEquals(expectedName, actualName);
	}

	@Test
	void testSetName() {
        usertest.setName("James");
        assertEquals("James", usertest.getName());
	}

	@Test
	void testGetPassword() {
		usertest.setPassword("password123");
		String expectedPassword = "password123";
		String actualPassword = usertest.getPassword();
		assertEquals(expectedPassword, actualPassword);
	}

	@Test
	void testSetPassword() {
	    usertest.setPassword("password123");
        assertEquals("password123", usertest.getPassword());
	}

	@Test
	void testGetEmail() {
		usertest.setEmail("james@gmail.com");
		String expectedEmail = "james@gmail.com";
		String actualEmail = usertest.getEmail();
		assertEquals(expectedEmail, actualEmail);
	}

	@Test
	void testSetEmail() {
		 usertest.setEmail("james@gmail.com");
	     assertEquals("james@gmail.com", usertest.getEmail());
	}

	@Test
	void testGetContact() {
		usertest.setContact("84939746");
		String expectedContact = "84939746";
		String actualContact = usertest.getContact();
		assertEquals(expectedContact, actualContact);
	}

	@Test
	void testSetContact() {
		usertest.setContact("84939746");
	    assertEquals("84939746", usertest.getContact());
	}

}
