package com.assignment3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Inventory implements InventoryOperations, Serializable {	

	private static final long serialVersionUID = 5611024118788436616L;
	private TreeMap<Double,Movie> m_hashIdSortedMap = new TreeMap<Double,Movie>();
	private HashMap<String,Movie> m_hashNameSortedMap = new HashMap<String,Movie>();
	
	public Inventory() throws IOException, ClassNotFoundException{
		try{
			CaretakerMovie objCaretaker = new CaretakerMovie();
			restoreFromMemento(objCaretaker.getMemento());	
		}catch(FileNotFoundException e){
			System.err.println("File Not Present. Creating New One");			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public double addNewMovie(String pStrMovieName,double pDblPrice,double pDblMovieQty){
		double l_dblLastKey = 0;
		if(m_hashIdSortedMap != null && m_hashIdSortedMap.size() > 0){
			l_dblLastKey = m_hashIdSortedMap.lastKey();
		}
		Movie objNewMovie = new Movie(++l_dblLastKey,pStrMovieName,pDblPrice,pDblMovieQty);
		m_hashIdSortedMap.put(objNewMovie.getMovieId(), objNewMovie);
		m_hashNameSortedMap.put(pStrMovieName, objNewMovie);
		return objNewMovie.getMovieId();
	}
	
	public Movie findMovie(double p_dblMovieId,String p_strMovieName){
		Movie objMovie = null;
		if(p_dblMovieId != 0){
			objMovie = m_hashIdSortedMap.get(p_dblMovieId);
		}else if(p_strMovieName != null){
			objMovie = m_hashNameSortedMap.get(p_strMovieName);
		}
		
		return objMovie;
	}
	
	public boolean sellMovie(double p_dblMovieId,String p_strMovieName){
		Movie objMovie = findMovie(p_dblMovieId,p_strMovieName);
		objMovie.sellMovies(1);
		return true;
	}
	
	public boolean addCopies(double p_dblMovieId,String p_strMovieName,int pIntQty){
		Movie objMovie = findMovie(p_dblMovieId,p_strMovieName);
		return objMovie.addCopies(pIntQty);		
	}
	
	public boolean changePrice(double p_dblMovieId,String p_strMovieName,double pNewPrice){ 
		Movie objMovie = findMovie(p_dblMovieId,p_strMovieName);
		return objMovie.setPrice(pNewPrice);
	}
	
	public MovieMemento saveToMemento() throws IOException {
		MovieMemento memento = new MovieMemento();
		memento.setState(this.m_hashIdSortedMap,this.m_hashNameSortedMap);
		return memento;
    }
 
    public void restoreFromMemento(MovieMemento memento) throws IOException, ClassNotFoundException {
    	ArrayList<Map<?,Movie>> objArrayList = memento.getState();
        this.m_hashIdSortedMap = (TreeMap<Double, Movie>) objArrayList.get(0);
		this.m_hashNameSortedMap = (HashMap<String, Movie>) objArrayList.get(1);
    }
    
    
    
    

}
