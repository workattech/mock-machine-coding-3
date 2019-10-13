package com.machine.coding.repository;

import java.io.Serializable;

import com.machine.coding.model.Base;

public class CardListRepository<K extends Serializable, V extends Base> extends GenericRepository<K, V> {

	private static CardListRepository<Serializable, Base> repository = new CardListRepository<>();

	private CardListRepository() {

	}

	public static CardListRepository getInstance() {
		return repository;
	}
}
