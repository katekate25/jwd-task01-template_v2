package by.tc.task01.dao.impl.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Objects;

public class RefrigeratorFilter extends AbstractAppliancesFilter {

    @Override
    protected boolean isMatches(Appliance appliance, String key, Object value) {
        Refrigerator refrigerator = (Refrigerator) appliance;
        if (key.equals(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString())) {
            return Objects.equals(refrigerator.getFreezerCapacity(), value);
        }
        if (key.equals(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString())) {
            return Objects.equals(refrigerator.getPowerConsumption(), value);
        }
        if (key.equals(SearchCriteria.Refrigerator.WEIGHT.toString())) {
            return Objects.equals(refrigerator.getWeight(), value);
        }
        if (key.equals(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString())) {
            return Objects.equals(refrigerator.getOverallCapacity(), value);
        }
        if (key.equals(SearchCriteria.Refrigerator.HEIGHT.toString())) {
            return Objects.equals(refrigerator.getHeight(), value);
        }
        if (key.equals(SearchCriteria.Refrigerator.WIDTH.toString())) {
            return Objects.equals(refrigerator.getWidth(), value);
        }
        return false;
    }
}