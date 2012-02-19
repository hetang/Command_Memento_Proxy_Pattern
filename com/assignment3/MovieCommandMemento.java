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

public class MovieCommandMemento implements Serializable{	

	private static final long serialVersionUID = 2040460876145242239L;
	
	private transient ObjectOutputStream objOutputStream = null;	
	
	public MovieCommandMemento() throws Exception{
		String filename = "command.txt";
		objOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
	}
	public void setState(Command<?> p_objCommand) throws Exception{		
		objOutputStream.writeObject(p_objCommand);
	}
	
	public ArrayList<Command<?>> getState() throws IOException, ClassNotFoundException{
		ArrayList<Command<?>> m_objQue = new ArrayList<Command<?>>();
		String filename = "command.txt";
		FileInputStream objFileInput = null;
		ObjectInputStream objInputStream = null;
		Command<?> objCommand = null;
		
		try{
			objFileInput = new FileInputStream(filename);
			objInputStream = new ObjectInputStream(objFileInput);
			
			while((objCommand = (Command<?>) objInputStream.readObject()) != null){				
				m_objQue.add(objCommand);				
			}
			
			objInputStream.close();
			objFileInput.close();
		}catch(EOFException e){
			System.err.println("End of File Reached");
		}catch(FileNotFoundException e){
			System.err.println("File Not Present");
		}
		return m_objQue;
	}
	
	public void clearCommands() throws IOException{
		String filename = "command.txt";
		objOutputStream.close();
		ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
		objOutputStream.close();
	}
	
	protected void finalize(){
        try{
        	objOutputStream.close();
        }catch (IOException e) {
            System.err.println("Error while closing the output stream to a file.");
        }
    }
}