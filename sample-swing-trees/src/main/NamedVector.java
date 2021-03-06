package main;

import java.util.Vector;

public class NamedVector<E> extends Vector<E> {
	String name;

	public NamedVector(String name) {
		this.name = name;
	}
	
	public NamedVector(String name, E elements[]) {
		this.name = name;
		for (int i = 0; i < elements.length; i++) {
			add(elements[i]);
		}
	}
	
	public String toString() {
		return "[" + name + "]";
	}
}
