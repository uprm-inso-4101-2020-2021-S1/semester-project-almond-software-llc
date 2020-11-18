package com.macademia.main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.macademia.main.Turn;

class TurnTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void TurnInstantiationTest() {
		new Turn("12/25/2020 15:00-12/25/2020 15:30");
		//if this didn't crash it worked
	}
	
	@Test
	void TurnNowTest() {
		Turn turn = new Turn("8/25/2020 15:00-12/25/2020 15:30");
		assertTrue(turn.isTime());
	}
	
	@Test
	void TurnNotNowTest() {
		Turn turn = new Turn("1/1/2021 15:00-2/2/2021 1:00");
		assertFalse(turn.isTime());
	}

}
