package by.vsu.operation;

import by.vsu.Component;
import by.vsu.node.SteelPlate;
import by.vsu.node.Umbo;

public class UmboForging extends Operation {
	private SteelPlate steelPlate;
	private Umbo umbo;

	private UmboForging() {
		super(1);
	}

	private static UmboForging instance;
	public static UmboForging getInstance() {
		if (instance == null) {
			instance = new UmboForging();
		}
		return instance;
	}

	@Override
	public void add(Component[] components) {
		if(components.length == 1 && components[0] instanceof SteelPlate) {
			steelPlate = (SteelPlate) components[0];
		} else {
			throw new IllegalArgumentException("Необходим один компонент - стальная пластина");
		}
	}

	@Override
	public void build() {
		if(steelPlate != null) {
			umbo = new Umbo();
		} else {
			throw new IllegalStateException("Отсутствуют необходимые компоненты. См. метод add()");
		}
	}

	@Override
	public Component[] result() {
		if(umbo != null) {
			return new Component[] {umbo};
		} else {
			throw new IllegalStateException("Умбон ещё не выкован. См. метод build()");
		}
	}

	@Override
	public String toString() {
		return "Ковка умбона";
	}
}
