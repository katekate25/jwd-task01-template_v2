package by.tc.task01.dao.impl.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Objects;

public class TabletPCFilter extends AbstractAppliancesFilter {

    @Override
    protected boolean isMatches(Appliance appliance, String key, Object value) {
        TabletPC tabletPC = (TabletPC) appliance;
        if (key.equals(SearchCriteria.TabletPC.DISPLAY_INCHES.toString())) {
            return Objects.equals(tabletPC.getDisplayInches(), value);
        }
        if (key.equals(SearchCriteria.TabletPC.MEMORY_ROM.toString())) {
            return Objects.equals(tabletPC.getMemoryRom(), value);
        }
        if (key.equals(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString())) {
            return Objects.equals(tabletPC.getFlashMemoryCapacity(), value);
        }
        if (key.equals(SearchCriteria.TabletPC.COLOR.toString())) {
            return Objects.equals(tabletPC.getColor(), value);
        }
        if (key.equals(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString())) {
            return Objects.equals(tabletPC.getBatteryCapacity(), value);
        }

        return false;
    }
}
