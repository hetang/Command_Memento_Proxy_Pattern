package com.assignment3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MovieMemento implements Serializable{	

	private static final long serialVersionUID = 5136883432574141231L;

	private ArrayList<Map<?,Movie>> objInventory = null;
	
	public void setState(TreeMap<Double,Movie> m_hashIdSortedMap, HashMap<String,Movie> m_hashNameSortedMap) throws IOException{
		String filename = "inventory.txt";
		String tempFileName = "inventory_new.txt";
		
		FileOutputStream objFileOutput = null;		
		ObjectOutputStream objOutputStream = null;
		
		objInventory = makeDeepCopy(m_hashIdSortedMap, m_hashNameSortedMap);		
		objFileOutput = new FileOutputStream(tempFileName);
		objOutputStream = new ObjectOutputStream(objFileOutput);
		objOutputStream.writeObject(objInventory);
		objOutputStream.close();
		objFileOutput.close();
		
		File objInv = new File(filename);
		File objInv_new = new File(tempFileName);
		if(objInv.exists()){
			objInv.delete();
		}
		objInv_new.renameTo(objInv);		
	}
	
	public ArrayList<Map<?,Movie>> getState() throws IOException, ClassNotFoundException{
		if(null == objInventory){
			FileInputStream objFileInput = null;
			ObjectInputStream objInputStream = null;
			String filename = "inventory.txt";
			
			objFileInput = new FileInputStream(filename);
			objInputStream = new ObjectInputStream(objFileInput);
			objInventory = (ArrayList<Map<?,Movie>>) objInputStream.readObject();
			objInputStream.close();
			objFileInput.close();
		}
		return makeDeepCopy((TreeMap<Double,Movie>)objInventory.get(0),(HashMap<String,Movie>)objInventory.get(1));
	}
	
	private ArrayList<Map<?,Movie>> makeDeepCopy(TreeMap<Double,Movie> m_hashIdSortedMap, HashMap<String,Movie> m_hashNameSortedMap){
    	ArrayList<Map<?,Movie>> objArrayList = new ArrayList<Map<?,Movie>>();
    	
    	TreeMap<Double,Movie> lObjCopyId = new TreeMap<Double,Movie>();
    	Object[] objKeyId = (m_hashIdSortedMap.keySet()).toArray();
    	for(int i=0;i<objKeyId.length;i++){
    		lObjCopyId.put((Double) objKeyId[i], new Movie(m_hashIdSortedMap.get((Double)objKeyId[i])));
    	}
    	objKeyId = (m_hashNameSortedMap.keySet()).toArray();
    	
    	HashMap<String,Movie> lObjCopyName = new HashMap<String,Movie>();
    	for(int i=0;i<objKeyId.length;i++){
    		lObjCopyName.put((String) objKeyId[i], new Movie(m_hashNameSortedMap.get((String)objKeyId[i])));
    	}
    	objArrayList.add(lObjCopyId);
    	objArrayList.add(lObjCopyName);
    	return objArrayList;
    }	
}