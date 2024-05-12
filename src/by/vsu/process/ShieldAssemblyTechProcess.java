package by.vsu.process;

import by.vsu.GameObject;
import by.vsu.ingredient.Coal;
import by.vsu.ingredient.IronOre;
import by.vsu.ingredient.Wood;
import by.vsu.operation.*;

public class ShieldAssemblyTechProcess extends TechProcess {
	private final Wood[] woods;
	private final IronOre[] ironOres;
	private final Coal coal;

	public ShieldAssemblyTechProcess(Wood[] woods, IronOre[] ironOres, Coal coal) {
		if(woods.length == 2 && ironOres.length == 2) {
			this.woods = woods;
			this.ironOres = ironOres;
			this.coal = coal;
		} else {
			throw new IllegalArgumentException("Недостаточно компонентов");
		}
	}

	@Override
	public GameObject[] build() {
		return new GameObject[] {
			coal,
			ironOres[0],
			ironOres[1],
			OreSmelting.getInstance(),
			UmboForging.getInstance(),
			woods[0],
			WoodSawing.getInstance(),
			woods[1],
			WoodSawing.getInstance(),
			ShieldHandleAssembly.getInstance(),
			ShieldAssembly.getInstance()
		};
	}
}
