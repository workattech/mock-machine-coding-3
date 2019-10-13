package com.machine.coding.service;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import com.machine.coding.model.Base;
import com.machine.coding.repository.GenericRepository;

public class GenericService<K extends Serializable, V extends Base> {

	protected GenericRepository<K, V> repository;

	public K create(V object) {
		K id = repository.create(object);
		System.out.println("Created " + object.getClass().getName() + " : " + id);
		return id;
	}

	public void delete(K id) {
		 repository.delete(id);
	}

	public V getById(K id) {
		return repository.getById(id);
	}

	public List<V> getAll() {
		return repository.getAll();
	}

	public void update(V object) {
		repository.update(object);
	}
	public void updateField(String fieldName, Object fieldValue, K id)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		V obj = getById(id);
		Class<?> objClass = obj.getClass();
		Field field = objClass.getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(obj, fieldValue);
		
		update(obj);
	}
}
