package com.simonrobins.pe;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		assertEquals(100, cost);
		cost = PromotionEngine.calculateOrderCost("CBBBBBAAAAA");
		assertEquals(100, cost);
	}

	@Test
	void testScenarioC() {
		Double cost = PromotionEngine.calculateOrderCost("AAABBBBBCD");
		assertEquals(100, cost);
	}
}
