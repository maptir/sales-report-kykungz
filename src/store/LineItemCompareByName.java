package store;

import java.util.Comparator;

public class LineItemCompareByName implements Comparator<LineItem> {

	@Override
	public int compare(LineItem o1, LineItem o2) {
		return o1.getDescription().compareTo(o2.getDescription());
	}

}
