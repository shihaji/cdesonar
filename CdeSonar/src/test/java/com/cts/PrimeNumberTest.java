package com.cts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PrimeNumberTest {
	
	PrimeNumber pn;

	@Before
	public void setUp() throws Exception {
		pn=new PrimeNumber();
	}

	@Test
	public void testFindPrime() {
		
		assertTrue(pn.findPrime(3));
		
	}
	
	@Test
	public void testFindPrimeNegative() {
		
		assertFalse(pn.findPrime(4));
		
	}
	
	@Test
	public void testFindPrimeNegative1() {
		
		assertFalse(pn.findPrime(0));
		
	}
	
	@Test
	public void testFindPrimeNegative2() {
		
		assertFalse(pn.findPrime(1));
		
	}

}
