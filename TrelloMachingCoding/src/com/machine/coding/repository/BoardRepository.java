package com.machine.coding.repository;

import java.io.Serializable;

import com.machine.coding.model.Base;

//Making singleton repository to have single copy.
public class BoardRepository<K extends Serializable,V extends Base> extends GenericRepository<K, V> {

	private static BoardRepository<Serializable, Base> repository = new BoardRepository<>();
	
	private BoardRepository() {
		
	}
	public static BoardRepository getInstance() {
		return repository;
	}
}
