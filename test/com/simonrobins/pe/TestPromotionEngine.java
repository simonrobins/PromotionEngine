package com.simonrobins.pe;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

class TestPromotionEngine {
	@Test
	void testScenarioA() {
		Double cost = PromotionEngine.calculateOrderCost("ABC");
		assertEquals(100, cost);
		cost = PromotionEngine.calculateOrderCost("CBA");
		assertEquals(100, cost);
	}

	@Test
	void testScenarioB() {
		Double cost = PromotionEngine.calculateOrderCost("AAAAABBBBBC");
		assertEquals(370, cost);
		cost = PromotionEngine.calculateOrderCost("CBBBBBAAAAA");
		assertEquals(370, cost);
	}

	@Test
	void testScenarioC() {
		Double cost = PromotionEngine.calculateOrderCost("AAABBBBBCD");
		assertEquals(280, cost);
		cost = PromotionEngine.calculateOrderCost("DCBBBBBAAA");
		assertEquals(280, cost);
	}

	@Test
	void testCountUniqueSKUs() {
		Character[] expectedKeys = { 'A', 'B', 'C' };
		Map<Character, Integer> groupedSKUs = PromotionEngine.countUniqueSKUs("AAABBBBBCD");
		assertArrayEquals(expectedKeys, groupedSKUs.keySet().toArray());
	}
}
