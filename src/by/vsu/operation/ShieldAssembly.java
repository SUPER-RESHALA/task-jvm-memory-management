package by.vsu.operation;

import by.vsu.Component;
import by.vsu.ammunition.Shield;
import by.vsu.node.Plank;
import by.vsu.node.ShieldHandle;
import by.vsu.node.Umbo;

public class ShieldAssembly extends Operation {
	private Plank[] planks;
	private ShieldHandle shieldHandle;
	private Umbo umbo;
	private Shield shield;

	private ShieldAssembly() {
		super(7);
	}

	private static ShieldAssembly instance;
	public static ShieldAssembly getInstance() {
		if (instance == null) {
			instance = new ShieldAssembly();
		}
		return instance;
	}

	@Override
	public void add(Component[] components) {
		if(components.length == 7) {
			if(components[0] instanceof ShieldHandle) {
				shieldHandle = (ShieldHandle) components[0];
				planks = new Plank[5];
				boolean planksCorrect = true;
				for(int i = 0; i < planks.length; i++) {
					if(components[i + 1] instanceof Plank) {
						planks[i] = (Plank) components[i + 1];
					} else {
						planksCorrect = false;
						break;
					}
				}
				if(planksCorrect) {
					if(components[6] instanceof Umbo) {
						umbo = (Umbo) components[6];
						return;
					}
				}
			}
		}
		throw new IllegalArgumentException("Необходимо семь компонентов - рукоять щита, пять досок и умбон");
	}

	@Override
	public void build() {
		if(planks != null && shieldHandle != null && umbo != null) {
			shield = new Shield();
		} else {
			throw new IllegalStateException("Отсутствуют необходимые компоненты. См. метод add()");
		}
	}

	@Override
	public Component[] result() {
		if(shield != null) {
			return new Component[] {shield};
		} else {
			throw new IllegalStateException("Щит ещё не изготовлен. См. метод build()");
		}
	}

	@Override
	public String toString() {
		return "Изготовление щита";
	}
}
