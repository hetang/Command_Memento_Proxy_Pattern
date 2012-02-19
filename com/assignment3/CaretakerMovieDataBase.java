package com.assignment3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CaretakerMovieDataBase {
	private MovieDataBaseMemento savedStates = null;
	
	public void addMemento(MovieDataBaseMemento objMemento) throws IOException {
		String filename = "command_memento.txt";
		String tempFileName = "command_memento_new.txt";
		FileOutputStream objFileOutput = null;
		ObjectOutputStream objOutputStream = null;
		
		savedStates= objMemento;		
		objFileOutput = new FileOutputStream(tempFileName);
		objOutputStream = new ObjectOutputStream(objFileOutput);
		objOutputStream.writeObject(savedStates);
		objOutputStream.close();
		
		File objInv = new File(filename);
		File objInv_new = new File(tempFileName);
		if(objInv.exists()){
			objInv.delete();
		}
		objInv_new.renameTo(objInv);
	}
	
	public MovieDataBaseMemento getMemento() throws IOException, ClassNotFoundException {
		String filename = "command_memento.txt";
		FileInputStream objFileInput = null;
		ObjectInputStream objInputStream = null;
		
		objFileInput = new FileInputStream(filename);
		objInputStream = new ObjectInputStream(objFileInput);
		savedStates = (MovieDataBaseMemento) objInputStream.readObject();
		objInputStream.close();
		objFileInput.close();
		return savedStates; 
	}
}