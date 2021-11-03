package by.tc.task01.dao.impl.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * AbstractAppliancesFilter
 */
public abstract class AbstractAppliancesFilter {

    /**
     * Filters appliances
     *
     * @param appliances list of appliances
     * @param criteria criteria
     * @return appliances
     */
    public List<Appliance> filter(List<Appliance> appliances, Criteria criteria) {
        for(Map.Entry<String, Object> entry : criteria.getSearchParams().entrySet()) {
            appliances = appliances.stream()
                    .filter(appliance -> isMatches(appliance, entry.getKey(), entry.getValue()))
                    .collect(Collectors.toList());
        }
        return appliances;
    }

    abstract boolean isMatches(Appliance appliance, String key, Object value);

}
