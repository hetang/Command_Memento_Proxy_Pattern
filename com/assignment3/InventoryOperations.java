package com.assignment3;

public interface InventoryOperations {
	public double addNewMovie(String pStrMovieName,double pDblPrice,double pDblMovieQty) throws Exception;
	public Movie findMovie(double p_dblMovieId,String p_strMovieName) throws Exception;
	public boolean sellMovie(double p_dblMovieId,String p_strMovieName) throws Exception;
	public boolean addCopies(double p_dblMovieId,String p_strMovieName,int pIntQty) throws Exception;
	public boolean changePrice(double p_dblMovieId,String p_strMovieName,double pNewPrice) throws Exception;
}