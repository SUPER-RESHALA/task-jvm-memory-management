package by.vsu.operation;

import by.vsu.Component;
import by.vsu.ingredient.Coal;
import by.vsu.ingredient.IronOre;
import by.vsu.node.SteelPlate;

public class OreSmelting extends Operation {
	private IronOre[] ironOres;
	private Coal coal;
	private SteelPlate steelPlate;

	private OreSmelting() {
		super(3);
	}

	private static OreSmelting instance;
	public static OreSmelting getInstance() {
		if (instance == null) {
			instance = new OreSmelting();
		}
		return instance;
	}

	@Override
	public void add(Component[] components) {
		if(components.length == 3 && components[0] instanceof IronOre && components[1] instanceof IronOre && components[2] instanceof Coal) {
			ironOres = new IronOre[] {(IronOre) components[0], (IronOre) components[1]};
			coal = (Coal) components[2];
		} else {
			throw new IllegalArgumentException("Необходимо три компонента - два куска железной руды и один кусок угля");
		}
	}

	@Override
	public void build() {
		if(ironOres != null && coal != null) {
			steelPlate = new SteelPlate();
		} else {
			throw new IllegalStateException("Отсутствуют необходимые компоненты. См. метод add()");
		}
	}

	@Override
	public Component[] result() {
		if(steelPlate != null) {
			return new Component[] {steelPlate};
		} else {
			throw new IllegalStateException("Руда ещё не переплавлена. См. метод build()");
		}
	}

	@Override
	public String toString() {
		return "Плавка железной руды";
	}
}
