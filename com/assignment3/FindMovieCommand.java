package com.assignment3;

public class FindMovieCommand implements Command<Movie>{

	private static final long serialVersionUID = -8084959116724738118L;
	private String m_strMovieName = null;
	private double m_dblId = 0;
	
	public FindMovieCommand(String pStrMovieName,double pDblId){
		this.m_strMovieName = pStrMovieName;
		this.m_dblId = pDblId;
	}
	
	public Movie execute(Inventory pObjInventory) throws Exception {
		return pObjInventory.findMovie(m_dblId, m_strMovieName);
	}
}