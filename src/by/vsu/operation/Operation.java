package by.vsu.operation;

import by.vsu.Component;
import by.vsu.GameObject;

public class Operation extends GameObject {
	private final int requiredComponentsNumber;

	public Operation(int requiredComponentsNumber) {
		this.requiredComponentsNumber = requiredComponentsNumber;
	}

	public int getRequiredComponentsNumber() {
		return requiredComponentsNumber;
	}

	public void add(Component[] components) {
		throw new UnsupportedOperationException();
	}

	public void build() {
		throw new UnsupportedOperationException();
	}

	public Component[] result() {
		throw new UnsupportedOperationException();
	}
}
