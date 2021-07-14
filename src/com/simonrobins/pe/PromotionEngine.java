package com.simonrobins.pe;

import java.util.HashMap;
import java.util.Map;

public class PromotionEngine {
	
	private interface Function
	{
		public Double calculate(Map<Character, Integer> skuMap);
	}
	
	private static Function[] orderCostFunctions = { 
			new FunctionA(),
			new FunctionB(),
			new FunctionCD()
	};
	
	public static Double calculateOrderCost(final String skus) {

		Map<Character, Integer> groupedSKUs = countUniqueSKUs(skus);

		Double cost = 0.0;

		for(Function function : orderCostFunctions)
		{
			cost += function.calculate(groupedSKUs);
		}

		return cost;
	}

	protected static Map<Character, Integer> countUniqueSKUs(final String skus) {
		Map<Character, Integer> groupedSKUs = new HashMap<>();
		groupedSKUs.put('A', 0);
		groupedSKUs.put('B', 0);
		groupedSKUs.put('C', 0);
		groupedSKUs.put('D', 0);

		for (int i = 0; i < skus.length(); i++) {
			char sku = skus.charAt(i);

			switch (sku) {
			case 'A':
			case 'B':
			case 'C':
			case 'D':
				Integer count = groupedSKUs.get(sku);
				if (null == count)
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

	private static class FunctionA implements Function
	{
		@Override
		public Double calculate(Map<Character, Integer> skuMap) {
			Integer numberOfAs = skuMap.get('A');

			Integer numberOfPromotions = numberOfAs / 3;
			Integer numberOfUnits = numberOfAs % 3;
			
			return numberOfPromotions * 130.0 + numberOfUnits * 50.0;
		}		
	}

	private static class FunctionB implements Function
	{
		@Override
		public Double calculate(Map<Character, Integer> skuMap) {
			Integer numberOfBs = skuMap.get('B');

			Integer numberOfPromotions = numberOfBs / 2;
			Integer numberOfUnits = numberOfBs % 2;
			
			return numberOfPromotions * 45.0 + numberOfUnits * 30.0;
		}		
	}

	private static class FunctionCD implements Function
	{
		@Override
		public Double calculate(Map<Character, Integer> skuMap) {
			Integer numberOfCs = skuMap.get('C');
			Integer numberOfDs = skuMap.get('D');

			if(numberOfCs > numberOfDs)
			{
				return  ((numberOfCs - numberOfDs) * 45.0) + numberOfCs * 20.0;
			}
			else
			{
				return  ((numberOfDs - numberOfCs) * 45.0) + numberOfDs * 15.0;
				
			}
		}		
	}
}
