package com.simonrobins.pe;

import java.util.HashMap;
import java.util.Map;

public class PromotionEngine {
	public static Double calculateOrderCost(final String skus) {
		return 0.0;
	}

	private static Map<Character, Integer> countUniqueSKUs(final String skus) {
		Map<Character, Integer> groupedSKUs = new HashMap<>();

		for (int i = 0; i < skus.length(); i++) {
			char sku = skus.charAt(i);

			switch (sku) {
			case 'A':
			case 'B':
			case 'C':
				Integer count = groupedSKUs.get(sku);
				if(null == count)
					groupedSKUs.put(sku, 1);
				else
					groupedSKUs.replace(sku, count + 1);
				break;
			default:
				System.out.println("Unrecognised SKU - ignoring.");
				break;
			}
		}

		return groupedSKUs;
	}
}
