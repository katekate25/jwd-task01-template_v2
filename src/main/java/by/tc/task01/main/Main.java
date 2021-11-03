package by.tc.task01.main;

import java.util.List;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
		List<Appliance> appliances;


		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(SearchCriteria.Oven.CAPACITY.toString(), 33);

		appliances = service.find(criteriaOven);

		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(SearchCriteria.Oven.HEIGHT.toString(), 45);
		criteriaOven.add(SearchCriteria.Oven.DEPTH.toString(), 60);

		appliances = service.find(criteriaOven);

		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(SearchCriteria.TabletPC.MEMORY_ROM.toString(), 8000);

		appliances = service.find(criteriaTabletPC);

		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

		Oven oven = new Oven();
		oven.setId("104");
		oven.setWeight(14);
		oven.setDepth(20);
		oven.setHeight(47);
		oven.setCapacity(34);
		oven.setPowerConsumption(1700);
		oven.setWidth(72);

		service.add(oven);


		//////////////////////////////////////////////////////////////////
		Speakers speakers = new Speakers();
		speakers.setId("604");
		speakers.setCordLength(10);
		speakers.setPowerConsumption(30);
		speakers.setNumberOfSpeakers(2);
		speakers.setFrequencyRange("3-4");

		service.add(speakers);

	}


}
