import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AllProductTest {
	private AllProduct allproduct;

	@BeforeEach
	void setUp() throws Exception {
		allproduct = new AllProduct(null, null, null, null	);
	}

	@AfterEach
	void tearDown() throws Exception {
		allproduct = null;
	}

	@Test
	void testGetName() {
		allproduct.setName("Blue Top");
		String expectedName = "Blue Top";
		String actualName = allproduct.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	void testSetName() {
		allproduct.setName("Blue Top");
		assertEquals("Blue Top", allproduct.getName());
	}

	@Test
	void testGetCategory() {
		allproduct.setCategory("Top");
		String expectedCategory = "Top";
		String actualCategory = allproduct.getCategory();
		assertEquals(expectedCategory, actualCategory);
		
	}

	@Test
	void testSetCategory() {
		allproduct.setCategory("Top");
		assertEquals("Top", allproduct.getCategory());
	}

	@Test
	void testGetPrice() {
		allproduct.setPrice(15.0);
		double expectedPrice = 15.0;
		double actualPrice = allproduct.getPrice();
		assertEquals(expectedPrice, actualPrice);
	}

	@Test
	void testSetPrice() {
		allproduct.setPrice(15.0);
		assertEquals(15.0, allproduct.getPrice());
	}

	@Test
	void testGetImage() {
		allproduct.setImage("https://m.media-amazon.com/images/I/71T5kLAboyL._AC_SR175,263_QL70_.jpg");
		String expectedImage = "https://m.media-amazon.com/images/I/71T5kLAboyL._AC_SR175,263_QL70_.jpg";
		String actualImage = allproduct.getImage();
		assertEquals(expectedImage, actualImage);
		
	}

	@Test
	void testSetImage() {
		allproduct.setCategory("https://m.media-amazon.com/images/I/71T5kLAboyL._AC_SR175,263_QL70_.jpg");
		assertEquals("https://m.media-amazon.com/images/I/71T5kLAboyL._AC_SR175,263_QL70_.jpg", allproduct.getCategory());
	}

}
