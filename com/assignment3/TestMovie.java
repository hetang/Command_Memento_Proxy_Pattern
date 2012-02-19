package com.assignment3;

public class TestMovie {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		InventoryProxy objProxy = new InventoryProxy();
		objProxy.addNewMovie("asd",20.00,10);
		objProxy.addNewMovie("adfd",20.00,10);
		objProxy.addNewMovie("dfs",20.00,10);
		System.out.println(objProxy.findMovie(0,"Hetang"));
	}
}
