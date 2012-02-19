package com.assignment3;

public class AddCopiesCommand implements Command<Boolean> {

	private static final long serialVersionUID = -6102502143949415414L;
	private double m_dblMovieId = 0;
	private String m_strMovieName = null;
	private int m_dblQty = 0;
	
	public AddCopiesCommand(double p_dblMovieId,String p_strMovieName,int pIntQty){
		this.m_dblMovieId = p_dblMovieId;
		this.m_strMovieName = p_strMovieName;
		this.m_dblQty = pIntQty;
	}
	public Boolean execute(Inventory pObjInventory) throws Exception {
		return pObjInventory.addCopies(m_dblMovieId, m_strMovieName, m_dblQty);
	}	
}
