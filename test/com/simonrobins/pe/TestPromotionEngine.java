package com.simonrobins.pe;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

class TestPromotionEngine {
	@Test
	void testScenarioA() {
		Integer cost = PromotionEngine.calculateOrderCost("ABC");
		assertEquals(100, cost);
		cost = PromotionEngine.calculateOrderCost("CBA");
		assertEquals(100, cost);
	}

	@Test
	void testScenarioB() {
		Integer cost = PromotionEngine.calculateOrderCost("AAAAABBBBBC");
		assertEquals(370, cost);
		cost = PromotionEngine.calculateOrderCost("CBBBBBAAAAA");
		assertEquals(370, cost);
	}

	@Test
	void testScenarioC() {
		Integer cost = PromotionEngine.calculateOrderCost("AAABBBBBCD");
		assertEquals(280, cost);
		cost = PromotionEngine.calculateOrderCost("DCBBBBBAAA");
		assertEquals(280, cost);
	}

	@Test
	void testCountUniqueSKUs() {
		Map<Character, Integer> groupedSKUs = PromotionEngine.countUniqueSKUs("AAABBBBBCCCCCCCDDDDDDDDD");

		Character[] expectedKeys = { 'A', 'B', 'C', 'D' };
		assertArrayEquals(expectedKeys, groupedSKUs.keySet().toArray());

		Integer[] expectedValues = { 3, 5, 7, 9 };
		assertArrayEquals(expectedValues, groupedSKUs.values().toArray());
	}
}
