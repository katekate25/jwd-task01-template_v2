package by.tc.task01.dao.impl.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Objects;

/**
 * LaptopFilter
 */
public class LaptopFilter extends AbstractAppliancesFilter {

    @Override
    protected boolean isMatches(Appliance appliance, String key, Object value) {
        Laptop laptop = (Laptop) appliance;
        if (key.equals(SearchCriteria.Laptop.BATTERY_CAPACITY.toString())) {
            return Objects.equals(laptop.getBatteryCapacity(), value);
        }
        if (key.equals(SearchCriteria.Laptop.DISPLAY_INCHES.toString())) {
            return Objects.equals(laptop.getDisplayInches(), value);
        }
        if (key.equals(SearchCriteria.Laptop.MEMORY_ROM.toString())) {
            return Objects.equals(laptop.getMemoryRom(), value);
        }
        if (key.equals(SearchCriteria.Laptop.SYSTEM_MEMORY.toString())) {
            return Objects.equals(laptop.getSystemMemory(), value);
        }
        if (key.equals(SearchCriteria.Laptop.OS.toString())) {
            return Objects.equals(laptop.getOs(), value);
        }
        if (key.equals(SearchCriteria.Laptop.CPU.toString())) {
            return Objects.equals(laptop.getCpu(), value);
        }
        return false;
    }
}
