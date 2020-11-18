package com.macademia.main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.macademia.main.Turn;

class TurnTest {

	/**
	 * Tests to make sure we can actually instantiate this
	 */
	@Test
	void TurnInstantiationTest() {new Turn("12/25/2020 15:00-12/25/2020 15:30");}
	
	/**
	 * Tests to make sure this knows its time (Doesn't work after Christmas 2030)
	 */
	@Test
	void TurnNowTest() {
		Turn turn = new Turn("8/25/2020 15:00-12/25/2030 15:30");
		assertTrue(turn.isTime());
	}
	
	/**
	 * Tests to make sure this knows it isn't time (Doesn't work if you get a time machine and travel to January 2019)
	 */
	@Test
	void TurnNotNowTest() {
		Turn turn = new Turn("1/1/2019 15:00-2/2/2019 1:00");
		assertFalse(turn.isTime());
	}

}
