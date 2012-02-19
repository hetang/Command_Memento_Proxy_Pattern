package com.assignment3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* Invoker of Command */
public class MovieCommandInvoker {
	
	private ArrayList<Command<?>> objQue = new ArrayList<Command<?>>();
	private final int QUEUE_CAPACITY = 10;
	
	private Inventory m_objInv = null;
	private CaretakerMovieCommand m_objCare = null;
	private MovieCommandMemento m_objMemento = null;
	
	public MovieCommandInvoker(Inventory pObjInventory){		
		try {
			this.m_objInv = pObjInventory;
			m_objCare = new CaretakerMovieCommand();
			restoreFromMemento();
			CaretakerMovie objCaretaker = new CaretakerMovie();
			objCaretaker.addMemento(this.m_objInv.saveToMemento());			
		}catch(FileNotFoundException e){
			System.err.println("File Not Present. Creating New One");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			m_objMemento = new MovieCommandMemento();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Double addNewMovie(Command<?> p_objAddMovie) throws Exception{
		saveToMomento(p_objAddMovie);		
		return (Double) p_objAddMovie.execute(m_objInv);
	}
	
	public Movie findMovie(Command<?> p_objFindMovie) throws Exception{
		saveToMomento(p_objFindMovie);
		return (Movie) p_objFindMovie.execute(m_objInv);
	}
	
	public Boolean sellMovie(Command<?> p_objSellMovie) throws Exception{
		saveToMomento(p_objSellMovie);
		return (Boolean) p_objSellMovie.execute(m_objInv);
	}
	
	public boolean addCopies(Command<?> p_objAddCopies) throws Exception{
		saveToMomento(p_objAddCopies);
		return (Boolean) p_objAddCopies.execute(m_objInv);
	}
	
	public boolean changePrice(Command<?> p_objChangePrice) throws Exception{
		saveToMomento(p_objChangePrice);
		return (Boolean) p_objChangePrice.execute(m_objInv);
	}
	
	public void saveToMomento(Command<?> p_obj) throws Exception{
		objQue.add(p_obj);
		if(objQue.size() == QUEUE_CAPACITY){
			try {
				CaretakerMovie lobj = new CaretakerMovie();
				lobj.addMemento(m_objInv.saveToMemento());
				objQue.clear();
				m_objMemento.clearCommands();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		m_objMemento.setState(p_obj);
		m_objCare.addMemento(m_objMemento);
	}
	
	public void restoreFromMemento() throws Exception{
		m_objMemento = m_objCare.getMemento();
		this.objQue = (ArrayList<Command<?>>)m_objMemento.getState();
		Iterator<Command<?>> objIterate = (Iterator<Command<?>>) this.objQue.iterator();
		while(objIterate.hasNext()){
			Command<?> l_obj = objIterate.next();
			l_obj.execute(this.m_objInv);
		}
	}
}