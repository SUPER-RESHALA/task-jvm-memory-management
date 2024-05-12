package by.vsu.operation;

import by.vsu.Component;
import by.vsu.node.Plank;
import by.vsu.node.ShieldHandle;

public class ShieldHandleAssembly extends Operation {
	private Plank plank;
	private ShieldHandle shieldHandle;

	private ShieldHandleAssembly() {
		super(1);
	}

	private static ShieldHandleAssembly instance;
	public static ShieldHandleAssembly getInstance() {
		if (instance == null) {
			instance = new ShieldHandleAssembly();
		}
		return instance;
	}

	@Override
	public void add(Component[] components) {
		if(components.length == 1 && components[0] instanceof Plank) {
			plank = (Plank) components[0];
		} else {
			throw new IllegalArgumentException("Необходим один компонент - доска");
		}
	}

	@Override
	public void build() {
		if(plank != null) {
			shieldHandle = new ShieldHandle();
		} else {
			throw new IllegalStateException("Отсутствуют необходимые компоненты. См. метод add()");
		}
	}

	@Override
	public Component[] result() {
		if(shieldHandle != null) {
			return new Component[] {shieldHandle};
		} else {
			throw new IllegalStateException("Ручка щита ещё не изготовлена. См. метод build()");
		}
	}

	@Override
	public String toString() {
		return "Изготовление ручки щита";
	}
}
