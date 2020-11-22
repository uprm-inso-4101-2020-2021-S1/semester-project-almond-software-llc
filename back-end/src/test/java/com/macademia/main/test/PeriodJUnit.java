package com.macademia.main.test;

import static org.junit.jupiter.api.Assertions.*;
import com.macademia.main.Period;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PeriodJUnit {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {}

	@BeforeEach
	void setUp() throws Exception {}

	private static String MilitaryTimeString="15:00-15:30";
	private static String StandardTimeString="3:00 PM-3:30 PM";
	private static String ConflictTime=      "15:15-16:00";
	private static String NonConflictTime=   "12:00-12:30";
	private static String MinuteTime=        "1:30-2:30";
	private static String NoNoTime=          "3:30-2:30";
	
	@Test
	void CreatePeriodFromMilitaryTime() {
		Period FromMilitaryTime = Period.timetoPeriod(MilitaryTimeString); //create a period from military time
		assertEquals(MilitaryTimeString, FromMilitaryTime.toMilitaryTimeString()); //assert it stored it properly
	}

	@Test
	void CreatePeriodFromStandardTime() {
		Period FromMilitaryTime = Period.timetoPeriod(StandardTimeString); //create a period from standard time
		assertEquals(MilitaryTimeString, FromMilitaryTime.toMilitaryTimeString()); //assert it stored it properly (Also tests Standard to Military)			
	}
	
	@Test
	void MilitaryToStandardTime() {
		Period FromMilitaryTime = Period.timetoPeriod(StandardTimeString); //create a period from standard time
		assertEquals(StandardTimeString, FromMilitaryTime.toStandardTimeString()); //assert it can be reconverted back to standard time
	}

	@Test
	void ConflictYes() {
		Period Per1 = Period.timetoPeriod(MilitaryTimeString);
		Period Per2 = Period.timetoPeriod(ConflictTime); //Create two periods that conflict
		assertTrue(Per1.Conflict(Per2)); //Assert Period 1 conflicts with Period 2
		assertTrue(Per2.Conflict(Per1)); //Assert Period 2 conflicts with period 1
	}

	@Test
	void ConflictNo() {
		Period Per1 = Period.timetoPeriod(MilitaryTimeString);
		Period Per2 = Period.timetoPeriod(NonConflictTime); //Create two periods that conflict
		assertFalse(Per1.Conflict(Per2)); //Assert Period 1 doesn't conflict with Period 2
		assertFalse(Per2.Conflict(Per1)); //Assert Period 2 doesn't conflict with period 1
	}

	@Test
	void MinutesTest() {
		Period Per = Period.timetoPeriod(MinuteTime);
		assertEquals(Per.getStartMinutes(), 90);
		assertEquals(Per.getEndMinutes(), 150);
	}
	
	@Test
	void BeforeStartTest() {
		try {
			Period Per = Period.timetoPeriod(NoNoTime);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			//OK it worked.
		}
	}
}
