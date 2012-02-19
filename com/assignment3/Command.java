package com.assignment3;

import java.io.Serializable;

public interface Command<E> extends Serializable{	
 	public E execute(Inventory pObjInventory) throws Exception; 	
}
