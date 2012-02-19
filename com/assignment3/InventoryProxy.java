package com.assignment3;

import java.io.IOException;

public class InventoryProxy implements InventoryOperations {

	private Inventory objInventory = null;
	private MovieCommandInvoker objInvoker = null;
	
	public InventoryProxy(){
		try {
			objInventory = new Inventory();
			objInvoker = new MovieCommandInvoker(objInventory);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean addCopies(double pDblMovieId, String pStrMovieName,
			int pIntQty) throws Exception {
		Command<?> objCommand = new AddCopiesCommand(pDblMovieId,pStrMovieName,pIntQty);
		return objInvoker.addCopies(objCommand);
	}

	@Override
	public double addNewMovie(String pStrMovieName, double pDblPrice,
			double pDblMovieQty) throws Exception {
		Command<?> objCommand = new AddMovieCommand(pStrMovieName,pDblPrice,pDblMovieQty);
		return objInvoker.addNewMovie(objCommand);
	}

	@Override
	public boolean changePrice(double pDblMovieId, String pStrMovieName,
			double pNewPrice) throws Exception {
		Command<?> objCommand = new ChangePriceCommand(pDblMovieId,pStrMovieName,pNewPrice);
		return objInvoker.changePrice(objCommand);
	}

	@Override
	public Movie findMovie(double pDblMovieId, String pStrMovieName) throws Exception {
		Command<?> objCommand = new FindMovieCommand(pStrMovieName,pDblMovieId);
		return objInvoker.findMovie(objCommand);
	}

	@Override
	public boolean sellMovie(double pDblMovieId, String pStrMovieName) throws Exception {
		Command<?> objCommand = new SellMovieCommand(pDblMovieId,pStrMovieName);
		return objInvoker.sellMovie(objCommand);
	}

}
