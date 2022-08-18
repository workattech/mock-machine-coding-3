package com.machine.coding;

import java.util.List;

public class Formattor<V> {

	// Due to time constraint using toString format.
	public String format(V object) {
		if (object == null)
			return "No Boards";
		return object.toString();
	}

	public String format(List<V> objects) {
		StringBuilder builder = new StringBuilder();
		if (objects == null || objects.isEmpty())
			return "No Boards";
		for (V v : objects) {
			builder.append(v.toString());
			builder.append("\n");
		}
		return builder.toString();
	}

}
