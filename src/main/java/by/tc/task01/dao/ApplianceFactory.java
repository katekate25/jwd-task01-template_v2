package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.SearchCriteria;

public class ApplianceFactory {

    public Appliance getAppliance(String dbLine) {
        if (dbLine.startsWith(Oven.class.getSimpleName())) {
            return createOven(dbLine);
        }
        if (dbLine.startsWith(Laptop.class.getSimpleName())) {
            return createLaptop(dbLine);
        }
        return null;
    }

    private Appliance createLaptop(String dbLine) {
        return null;
    }

    private Appliance createOven(String dbLine) {
        Oven oven = new Oven();
        oven.setCode(getStringPropertyValue(SearchCriteria.Common.CODE.name(), dbLine));
        oven.setCapacity(getIntegerPropertyValue(SearchCriteria.Oven.CAPACITY.name(), dbLine));

        return oven;
    }

    String getStringPropertyValue(String key, String line) {
        return null;
    }

    Integer getIntegerPropertyValue(String key, String line) {
        return null;
    }

    Double getDoublePropertyValue(String key, String line) {
        return null;
    }
}
