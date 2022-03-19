import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FlyCash {

	public static void main(String[] args) {

		// 1. Instantiate class to get access to methods.
		FlyCash flyCash = new FlyCash();

		// 2. Create products.
		List<Product> products = flyCash.createProducts();

		// 3. Create invoice from all entered products.
		Invoice invoice = new Invoice(products);

		// 5. Plot result in console.
		flyCash.plotResults(invoice);

	}

	public List<Product> createProducts() {

		List<Product> tempProducts = new ArrayList<Product>();

		Scanner scanName = new Scanner(System.in);
		String productName = "";
		Scanner scanPrize = new Scanner(System.in);
		double productPrize = 0;
		Scanner scanAmount = new Scanner(System.in);
		int productAmount = 0;

		for (int i = 0; i >= 0; i++) {

			// Enter product name.
			System.out.print("Enter product name: ");
			productName = scanName.nextLine();

			if (productName.isBlank()) {
				break;

			}

			// Enter a valid prize.
			boolean prizeAgain = true;
			while (prizeAgain) {
				try {
					System.out.print("Enter prize: ");
					productPrize = scanPrize.nextDouble();
					prizeAgain = false;
				} catch (InputMismatchException e) {
					System.out.println("Please enter a valid price and use , as decimal separator.");
					scanPrize.next();

				}
			}

			// Enter a valid amount.
			boolean amountAgain = true;
			while (amountAgain) {
				try {
					System.out.print("Enter amount: ");
					productAmount = scanAmount.nextInt();
					amountAgain = false;
				} catch (InputMismatchException ex) {
					System.out.println("Please enter a valid amount.");
					scanAmount.next();
				}

			}

			Product product = new Product(productName, productAmount, productPrize);
			tempProducts.add(product);
		}

		// CLose scanners.
		scanName.close();
		scanPrize.close();
		scanAmount.close();

		return tempProducts;
	}

	public void plotResults(Invoice invoice) {

		String headlineFormat = "%-15s%-10s%-15s%-15s%n";
		String lastLineFormat = "%-40s%-15f";
		String productsFormat = "%-15s%-10d%-15f%-15f%n";

		System.out.println("FlyCash");
		System.out.println("===============================================");
		System.out.printf(headlineFormat, "Produkt", "Anzahl", "Einzelpreis", "Summe");

		for (int i = 0; i < invoice.products.size(); i++) {
			String name = invoice.products.get(i).name;
			int amount = invoice.products.get(i).amount;
			double price = invoice.products.get(i).price;
			double productsPrize = invoice.getProductsPrize(amount, price);
			System.out.printf(productsFormat, name, amount, price, productsPrize);
		}

		System.out.printf(lastLineFormat, "SUMME", invoice.getTotalPrize());
	}

}
