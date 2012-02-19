package com.assignment3;

import java.lang.Double;

public class AddMovieCommand implements Command<Double>{

	private static final long serialVersionUID = -4139302220076227999L;
	private String m_strMovieName = null;
	private double m_dblPrice = 0;
	private double m_dblMovieQty = 0;
	
	public AddMovieCommand(String pStrMovieName,double pDblPrice,double pDblMovieQty){
		this.m_strMovieName = pStrMovieName;
		this.m_dblPrice = pDblPrice;
		this.m_dblMovieQty = pDblMovieQty;
	}
		
	public Double execute(Inventory pObjInventory) throws Exception {
		return pObjInventory.addNewMovie(this.m_strMovieName, this.m_dblPrice, this.m_dblMovieQty);
	}	
}
