package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {
	
	public static void print(Appliance appliance) {
		if (appliance == null)
		{
			System.out.println("Nothing found");
		}
		else
		{
			System.out.println(appliance);
		}
	}

}
