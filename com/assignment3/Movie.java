package com.assignment3;

import java.io.Serializable;

public class Movie implements Serializable{

	private static final long serialVersionUID = -3907861297260537916L;
	private double dblMovieId = 0;
	private String strMovieName = null;
	private double dblMoviePrice = 0;
	private double dblMovieQty = 0;
	
	public Movie(double pUniqueId,String pStrMovieName,double pDblPrice,double pDblMovieQty){
		this.strMovieName = pStrMovieName;
		this.dblMoviePrice = pDblPrice;
		this.dblMovieQty = pDblMovieQty;
		this.dblMovieId = pUniqueId;		
	}
	
	public Movie(Movie pObjCopy){
		this.strMovieName = pObjCopy.strMovieName;
		this.dblMoviePrice = pObjCopy.dblMoviePrice;
		this.dblMovieQty = pObjCopy.dblMovieQty;
		this.dblMovieId = pObjCopy.dblMovieId;		
	}
	
	public boolean sellMovies(int pIntQty){
		this.dblMovieQty -= pIntQty;
		return true;
	}
	
	public boolean addCopies(int pIntQty){
		this.dblMovieQty += pIntQty;
		return true;
	}
	
	public boolean setPrice(double pNewPrice){
		this.dblMoviePrice = pNewPrice;
		return true;
	}
	
	public Double getMovieId(){
		return this.dblMovieId;
	}
}
