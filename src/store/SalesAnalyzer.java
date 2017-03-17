package store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesAnalyzer {

	public static void analyze(Store store) {
		Map<Long, Integer> ids = createMap(store);
		List<LineItem> items = toList(ids);
		Collections.sort(items, new LineItemCompareByName());
		print(items);

	}

	private static Map<Long, Integer> createMap(Store store) {
		Map<Long, Integer> ids = new HashMap<>();
		for (Sale sale : store) {
			for (LineItem item : sale) {
				ids.put(item.getProductId(), ids.getOrDefault(item.getProductId(), 0) + item.getQuantity());
			}
		}
		return ids;
	}

	private static List<LineItem> toList(Map<Long, Integer> ids) {
		List<LineItem> items = new ArrayList<>();
		for (long id : ids.keySet()) {
			LineItem item = new LineItem(id, ids.get(id));
			items.add(item);
		}
		return items;
	}

	private static void print(List<LineItem> items) {
		System.out.printf("%5s  %-26.30s %10s\n", "ID", "Description", "Quantity Sold");
		for (LineItem item : items) {
			System.out.printf("%5d  %-26.30s %8s\n", item.getProductId(), item.getDescription(), item.getQuantity());
		}

	}

	public static void main(String[] args) {
		SalesAnalyzer.analyze(Store.getInstance());
	}

}
