package algorithms.geeksforgeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopReviews {

	public static void main(String[] args) {
		List<String> reviews = new ArrayList<String>();
		reviews.add("pizza is amazing");
		reviews.add("i like panneer");
		reviews.add("tikka masala");
		reviews.add("amazing food");
		reviews.add("noodles is great");
		reviews.add("i like masala foods");
		Map<String, Integer> reviewCount = new HashMap<String, Integer>();
		for (String review : reviews) {
			String[] words = review.split(" ");
			for (String word : words) {
				if (reviewCount.containsKey(word)) {
					reviewCount.put(word, reviewCount.get(word) + 1);
				} else {
					reviewCount.put(word, 1);
				}
			}
		}
		List<Entry<String, Integer>> unsorted = new LinkedList<>(reviewCount.entrySet());
		// sort based on values
		Collections.sort(unsorted, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

				return o2.getValue().compareTo(o1.getValue());
			}
		});

		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Entry<String, Integer> sorted : unsorted) {
			sortedMap.put(sorted.getKey(), sorted.getValue());
			System.out.println(sorted.getKey() + " :" + sorted.getValue());
		}

	}
}
