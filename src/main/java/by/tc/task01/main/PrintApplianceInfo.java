package by.tc.task01.main;

import java.util.List;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {

	private PrintApplianceInfo() {}

	public static void print(List<Appliance> appliances) {
		if (appliances == null || appliances.isEmpty() ) {
			System.out.println("Nothing found");
		}
		else {
			appliances.forEach(System.out::println);
		}
	}

}
