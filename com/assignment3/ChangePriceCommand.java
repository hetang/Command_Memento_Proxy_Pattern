package com.assignment3;

public class ChangePriceCommand implements Command<Boolean> {

	private static final long serialVersionUID = -7429785893368885284L;
	private double m_dblMovieId = 0;
	private String m_strMovieName = null;
	private double m_dblNewPrice = 0;
	
	public ChangePriceCommand(double p_dblMovieId,String p_strMovieName,double pNewPrice){
		this.m_dblMovieId = p_dblMovieId;
		this.m_strMovieName = p_strMovieName;
		this.m_dblNewPrice = pNewPrice;
	}
	public Boolean execute(Inventory pObjInventory) throws Exception {
		return pObjInventory.changePrice(m_dblMovieId, m_strMovieName, m_dblNewPrice);
	}

}
