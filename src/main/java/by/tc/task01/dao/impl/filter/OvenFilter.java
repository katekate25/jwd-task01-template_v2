package by.tc.task01.dao.impl.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Objects;

public class OvenFilter extends AbstractAppliancesFilter {

    @Override
    protected boolean isMatches(Appliance appliance, String key, Object value) {
        Oven oven = (Oven) appliance;
        if (key.equals(SearchCriteria.Oven.CAPACITY.toString())) {
            return Objects.equals(oven.getCapacity(), value);
        }
        if (key.equals(SearchCriteria.Oven.DEPTH.toString())) {
            return Objects.equals(oven.getDepth(), value);
        }
        if (key.equals(SearchCriteria.Oven.POWER_CONSUMPTION.toString())) {
            return Objects.equals(oven.getPowerConsumption(), value);
        }
        if (key.equals(SearchCriteria.Oven.WIDTH.toString())) {
            return Objects.equals(oven.getWidth(), value);
        }
        if (key.equals(SearchCriteria.Oven.WEIGHT.toString())) {
            return Objects.equals(oven.getWeight(), value);
        }
        if (key.equals(SearchCriteria.Oven.HEIGHT.toString())) {
            return Objects.equals(oven.getHeight(), value);
        }
        return false;
    }
}
