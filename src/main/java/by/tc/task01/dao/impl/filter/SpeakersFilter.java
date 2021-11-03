package by.tc.task01.dao.impl.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Objects;

/**
 * SpeakersFilter
 */
public class SpeakersFilter extends AbstractAppliancesFilter {

    @Override
    protected boolean isMatches(Appliance appliance, String key, Object value) {
        Speakers speakers = (Speakers) appliance;
        if (key.equals(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString())) {
            return Objects.equals(speakers.getNumberOfSpeakers(), value);
        }
        if (key.equals(SearchCriteria.Speakers.POWER_CONSUMPTION.toString())) {
            return Objects.equals(speakers.getPowerConsumption(), value);
        }
        if (key.equals(SearchCriteria.Speakers.FREQUENCY_RANGE.toString())) {
            return Objects.equals(speakers.getFrequencyRange(), value);
        }
        if (key.equals(SearchCriteria.Speakers.CORD_LENGTH.toString())) {
            return Objects.equals(speakers.getCordLength(), value);
        }

        return false;
    }
}