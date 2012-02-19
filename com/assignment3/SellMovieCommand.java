package com.assignment3;

public class SellMovieCommand implements Command<Boolean> {

	private static final long serialVersionUID = -5809459118470940708L;
	private double m_dblMovieId = 0;
	private String m_strMovieName = null;
	
	public SellMovieCommand(double p_dblMovieId,String p_strMovieName){
		this.m_dblMovieId = p_dblMovieId;
		this.m_strMovieName = p_strMovieName;
	}
	
	public Boolean execute(Inventory pObjInventory) throws Exception {
		return pObjInventory.sellMovie(m_dblMovieId, m_strMovieName);
	}
}