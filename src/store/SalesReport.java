package store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SalesReport {
	public double getTotal(Sale sale) {
		double totalPrice = 0;
		for (LineItem item : sale) {
			totalPrice += item.getTotal();
		}
		return totalPrice;
	}

	public void printItems(Sale sale) {
		this.printItems(sale.getItems());
	}

	public void printItems(Iterable<LineItem> sale) {
		for (LineItem item : sale) {
			System.out.printf("%4d %-30.30s %10.2f %10.2f\n", item.getQuantity(), item.getDescription(),
					item.getUnitPrice(), item.getTotal());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Store store = Store.getInstance();
		SalesReport report = new SalesReport();
		while (true) {
			System.out.print("Input sale id: ");
			long id = sc.nextLong();
			if (id == 0) {
				break;
			}
			Sale sale = store.getSale(id);
			if (sale != null) {
				List<LineItem> sorted = new ArrayList<>(sale.getItems());
				Collections.sort(sorted, new LineItemCompareByName());
				report.printItems(sorted);
				System.out.printf("%46s %10.2f\n", "TOTAL", report.getTotal(sale));
			} else {
				System.out.println("Could not find sales report for id: " + id);
			}
		}
		System.out.println("Quit");
		sc.close();
	}
}
