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

}
