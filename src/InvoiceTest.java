import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InvoiceTest {

	Invoice invoice;

	@BeforeEach
	void setUp() {
		List<Product> testProducts = new ArrayList<Product>();
		testProducts.add(new Product("TestProduct1", 3, 2.99));
		testProducts.add(new Product("TestProduct2", 2, 1.99));
		testProducts.add(new Product("TestProduct3", 4, 0.99));
		testProducts.add(new Product("TestProduct4", 1, 5.99));

		invoice = new Invoice(testProducts);
	}

	@Test
	@DisplayName("Calculate total amount.")
	void shouldCalculateCorrectAmount() {
		double result = invoice.getTotalAmount();
		assertEquals(10, result);
	}

	@Test
	@DisplayName("Calculate total prize.")
	void shouldCalculateCorrectPrize() {
		double result = invoice.getTotalPrize();
		assertEquals(22.90, result);
	}

	@Test
	@DisplayName("Check products of invoice.")
	void shouldCalculateProperProducts() {
		assertEquals(4, invoice.products.size());
	}

}
