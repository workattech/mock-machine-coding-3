package com.machine.coding.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.machine.coding.model.Base;

public class GenericRepository<K extends Serializable, V extends Base> {

	private Map<K, V> repository = new HashMap<>();

	@SuppressWarnings("unchecked")
	public K create(V object) {
		// generate random id;
		UUID uuid = UUID.randomUUID();
		K id = (K) uuid.toString();
		object.setId((String) id);
		repository.put(id, object);
		return id;
	}

	public void delete(K key) {
		repository.remove(key);
	}

	public V getById(K key) {
		return repository.get(key);
	}

	public List<V> getAll() {
		List<V> outputList = new ArrayList<V>();
		Collection<V> values = repository.values();
		for (V v : values) {
			outputList.add(v);
		}
		return outputList;
	}

	@SuppressWarnings("unchecked")
	public void update( V object) {
		repository.put((K) object.getId(), object);
	}

}