package com.assignment3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class MovieDataBaseMemento implements Serializable{	

	private static final long serialVersionUID = 2040460876145242239L;
	
	private transient ObjectOutputStream objOutputStream = null;
	
	public MovieDataBaseMemento() throws FileNotFoundException, IOException{
		String filename = "command.txt";
		objOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
	}

	public void setState(Command<?> p_objCommand) throws IOException{
		objOutputStream.writeObject(p_objCommand);
	}
	
	public ArrayList<Command<?>> getState() throws IOException, ClassNotFoundException{
		ArrayList<Command<?>> m_objQue = new ArrayList<Command<?>>();
		String filename = "command.txt";
		FileInputStream objFileInput = null;
		ObjectInputStream objInputStream = null;
		
		objFileInput = new FileInputStream(filename);
		objInputStream = new ObjectInputStream(objFileInput);
		Command<?> objCommand = null;
		try{
			while((objCommand = (Command<?>) objInputStream.readObject()) != null){				
				m_objQue.add(objCommand);				
			}
		}catch(EOFException e){
			System.err.println("End of File Reached");
		}
		objInputStream.close();
		objFileInput.close();
		return m_objQue;
	}
	
	public void clearCommands() throws IOException{
		String filename = "command.txt";
		objOutputStream.close();
		objOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
	}
	
	protected void finalize(){
        try{
        	objOutputStream.close();
        }catch (IOException e) {
            System.err.println("Error while closing the output stream to a file.");
        }
    }
}