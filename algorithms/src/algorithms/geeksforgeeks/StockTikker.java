package algorithms.geeksforgeeks;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

public class StockTikker {
	Map<String, Double> ds = new HashMap<>();
	TreeSet<Entry<String, Double>> heap = new TreeSet<>(new Comparator<Entry<String, Double>>() {

		@Override
		public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
			return o2.getValue().compareTo(o2.getValue());
		}
	});

	public void addUpdate(String stock, Double price) {
		if (ds.containsKey(stock)) {
			heap.remove(ds.get(stock));
		}
		ds.put(stock, price);
		heap.add(new AbstractMap.SimpleEntry(stock, price));
	}

	public List<String> topKStocks(int k) {
		List<String> topStocks = new ArrayList<>();
		Iterator<Entry<String, Double>> stock = this.heap.iterator();
		int count = 0;
		while (count < k && stock.hasNext()) {
			topStocks.add(stock.next().getKey());
			count ++;
		}
		return topStocks;
	}

	public static void main(String[] args) {
       
	}
}
