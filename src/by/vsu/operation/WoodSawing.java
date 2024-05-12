package by.vsu.operation;

import by.vsu.Component;
import by.vsu.ingredient.Wood;
import by.vsu.node.Plank;

public class WoodSawing extends Operation {
	private Wood wood;
	private Plank[] planks;

	private WoodSawing() {
		super(1);
	}

	private static WoodSawing instance;
	public static WoodSawing getInstance() {
		if (instance == null) {
			instance = new WoodSawing();
		}
		return instance;
	}

	@Override
	public void add(Component[] components) {
		if(components.length == 1 && components[0] instanceof Wood) {
			wood = (Wood) components[0];
		} else {
			throw new IllegalArgumentException("Необходим один компонент - древесина");
		}
	}

	@Override
	public void build() {
		if(wood != null) {
			planks = new Plank[3];
			for(int i = 0; i < planks.length; i++) {
				planks[i] = new Plank();
			}
		} else {
			throw new IllegalStateException("Отсутствуют необходимые компоненты. См. метод add()");
		}
	}

	@Override
	public Component[] result() {
		if(planks != null) {
			return planks;
		} else {
			throw new IllegalStateException("Древесина ещё не распилена на доски. См. метод build()");
		}
	}

	@Override
	public String toString() {
		return "Распил древесины на доски";
	}
}
