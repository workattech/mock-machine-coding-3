package com.machine.coding.repository;

import java.io.Serializable;

import com.machine.coding.model.Base;

public class CardRepository <K extends Serializable,V extends Base> extends GenericRepository<K, V> {

	private static CardRepository<Serializable, Base> repository = new CardRepository<>();

	private CardRepository() {

	}

	public static CardRepository getInstance() {
		return repository;
	}

	
}
