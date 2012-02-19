package com.assignment3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CaretakerMovie {
	private MovieMemento savedStates = null;	
	
	public void addMemento(MovieMemento objMemento) throws IOException {
		String filename = "movie_memento.txt";
		String tempFileName = "movie_memento_new.txt";
		FileOutputStream objFileOutput = null;		
		ObjectOutputStream objOutputStream = null;
		
		savedStates= objMemento;		
		objFileOutput = new FileOutputStream(tempFileName);
		objOutputStream = new ObjectOutputStream(objFileOutput);
		objOutputStream.writeObject(savedStates);
		objOutputStream.close();
		objFileOutput.close();
		
		File objInv = new File(filename);
		File objInv_new = new File(tempFileName);
		if(objInv.exists()){
			objInv.delete();
		}
		objInv_new.renameTo(objInv);
	}
	public MovieMemento getMemento() throws IOException, ClassNotFoundException {
		String filename = "movie_memento.txt";
		FileInputStream objFileInput = null;
		ObjectInputStream objInputStream = null;
		objFileInput = new FileInputStream(filename);
		objInputStream = new ObjectInputStream(objFileInput);
		savedStates = (MovieMemento) objInputStream.readObject();
		objInputStream.close();
		objFileInput.close();
		return savedStates; 
	}
}