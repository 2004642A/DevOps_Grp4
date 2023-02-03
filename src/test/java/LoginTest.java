import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginTest {

	private Login login;
    
	@BeforeEach
	void setUp() throws Exception {
	login = new Login(null, null, null, null);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetName() {
		login.setName("Sally");
		String expectedName = "Sally";
		String actualName = login.getName();
		assertEquals(expectedName, actualName);
	//	fail("Not yet implemented");
	}

	@Test
	void testSetName() {
		login.setName("Sally");
		assertEquals("Sally", login.getName());
	//	fail("Not yet implemented");
	}

	@Test
	void testGetPassword() {
		login.setPassword("123456789");
		String expectedPassword = "123456789";
		String actualPassword = login.getPassword();
		assertEquals(expectedPassword, actualPassword);
	//	fail("Not yet implemented");
	}

	@Test
	void testSetPassword() {
		login.setPassword("123456789");
		assertEquals("123456789", login.getPassword());
	//	fail("Not yet implemented");
	}

	@Test
	void testGetEmail() {
		login.setEmail("sally@email.com");
		String expectedEmail = "sally@email.com";
		String actualEmail = login.getEmail();
		assertEquals(expectedEmail, actualEmail);
	//	fail("Not yet implemented");
	}

	@Test
	void testSetEmail() {
		login.setEmail("sally@email.com");
		assertEquals("sally@email.com", login.getEmail());
	//	fail("Not yet implemented");
	}

	@Test
	void testGetContact() {
		login.setContact("98765432");
		String expectedContact = "98765432";
		String actualContact = login.getContact();
		assertEquals(expectedContact, actualContact);
	//	fail("Not yet implemented");
	}

	@Test
	void testSetContact() {
		login.setContact("98765432");
		assertEquals("98765432", login.getContact());
	//	fail("Not yet implemented");
	} 

}
