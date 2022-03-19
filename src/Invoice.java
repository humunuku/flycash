import java.util.List;

public class Invoice {
	List<Product> products;
	

	public Invoice(List<Product> input_products) {
		products = input_products;

	}
	

	public int getTotalAmount() {
		int totalAmount = 0;
		for (int i = 0; i < products.size(); i++) {
			totalAmount = products.get(i).amount + totalAmount;
		}
		return totalAmount;

	}
	
	public double getTotalPrize() {
		
		double totalPrice = 0;
		
		for (int i = 0; i < products.size(); i++) {
			totalPrice = (products.get(i).price * products.get(i).amount) + totalPrice;
		}
		return totalPrice;

	}

	public double getProductsPrize(int amount, double price) {

		return amount * price;

	}
}
