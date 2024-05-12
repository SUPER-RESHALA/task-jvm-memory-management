package by.vsu;

import by.vsu.ingredient.Coal;
import by.vsu.ingredient.IronOre;
import by.vsu.ingredient.Wood;
import by.vsu.operation.Operation;
import by.vsu.process.ShieldAssemblyTechProcess;
import by.vsu.process.TechProcess;

public class Main {
	public static GameObject craft(TechProcess process) {
		GameObject[] objects = process.build();
		Component[] components = new Component[100];
		int top = -1;
		for(GameObject object : objects) {
			if(object instanceof Component) {
				System.out.println("Компонент " + object);
				components[++top] = (Component) object;
			} else if(object instanceof Operation operation) {
				System.out.println("Выполняется операция \"" + operation + "\"");
				Component[] params = new Component[operation.getRequiredComponentsNumber()];
				for(int i = 0; i < params.length; i++) {
					params[i] = components[top--];
				}
				operation.add(params);
				operation.build();
				Component[] result = operation.result();
				for(Component component : result) {
					components[++top] = component;
				}
			}
		}
		/*
		 * TODO: оптимизировать программу так, чтобы к этому моменту все использованные для
		 *       изготовления основного предмета дополнительные компоненты (детали и ингредиенты)
		 *       могли быть удалены из памяти, т.е. чтобы на эти объекты нигде не оставалось
		 *       лишних ссылок
		 */
		return components[0];
	}

	public static void main(String[] args) {
		TechProcess process = new ShieldAssemblyTechProcess(
			new Wood[] {
				new Wood(),
				new Wood()
			},
			new IronOre[] {
				new IronOre(),
				new IronOre()
			},
			new Coal()
		);
		GameObject gameObject = craft(process);
		System.out.println("Результат: " + gameObject);
	}
}
