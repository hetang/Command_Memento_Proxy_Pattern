package com.assignment3;

import org.junit.Test;

import junit.framework.TestCase;

public class InventoryTestCases extends TestCase {
	
	private InventoryProxy objProxy = null;
	
	protected void setUp() throws Exception {
		objProxy = new InventoryProxy();
	}

	protected void tearDown() throws Exception {
	}
	
	@Test
	public void testAdd() throws Exception {
		assertNotSame(0,objProxy.addNewMovie("Avatar",20.00,10));		
	}
	
	@Test
	public void testFind() throws Exception {
		assertNotNull(objProxy.findMovie(0,"Avatar"));		
	}
	
	@Test
	public void testAddCopies() throws Exception {
		assertTrue(objProxy.addCopies(0,"Avatar",10));		
	}
	
	@Test
	public void testSellCopies() throws Exception {
		assertTrue(objProxy.sellMovie(0,"Avatar"));		
	}
	
	@Test
	public void testChangePrice() throws Exception {
		assertTrue(objProxy.changePrice(0,"Avatar",100.00));		
	}
	
	@Test
	public void testAddSellMovies() throws Exception {
		objProxy.addNewMovie("Die Hard",20.00,10);
		objProxy.addCopies(0,"Die Hard",10);
		assertTrue(objProxy.sellMovie(0,"Die Hard"));		
	}
	
	@Test
	public void testFindNewlyAddedMovies() throws Exception {
		objProxy.addNewMovie("American Pie",20.00,10);		
		assertNotNull(objProxy.findMovie(0,"American Pie"));		
	}
	
	@Test
	public void testFindById() throws Exception {
		assertNotNull(objProxy.findMovie(1,null));		
	}
}
