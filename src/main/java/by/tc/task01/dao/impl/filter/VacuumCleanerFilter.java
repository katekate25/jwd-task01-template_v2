package by.tc.task01.dao.impl.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Objects;

/**
 * VacuumCleanerFilter
 */
public class VacuumCleanerFilter extends AbstractAppliancesFilter {

    @Override
    protected boolean isMatches(Appliance appliance, String key, Object value) {
        VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;
        if (key.equals(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString())) {
            return Objects.equals(vacuumCleaner.getFilterType(), value);
        }
        if (key.equals(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString())) {
            return Objects.equals(vacuumCleaner.getPowerConsumption(), value);
        }
        if (key.equals(SearchCriteria.VacuumCleaner.BAG_TYPE.toString())) {
            return Objects.equals(vacuumCleaner.getBagType(), value);
        }
        if (key.equals(SearchCriteria.VacuumCleaner.WAND_TYPE.toString())) {
            return Objects.equals(vacuumCleaner.getWandType(), value);
        }
        if (key.equals(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString())) {
            return Objects.equals(vacuumCleaner.getMotorSpeedRegulation(), value);
        }
        if (key.equals(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString())) {
            return Objects.equals(vacuumCleaner.getCleaningWidth(), value);
        }
        return false;
    }
}