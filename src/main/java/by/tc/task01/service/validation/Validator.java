package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.exception.ValidationException;

import java.util.List;

import static java.util.Arrays.asList;

public class Validator {

	private static final List<String> supportedCriteriaSearchNames = asList(SearchCriteria.Laptop.class.getSimpleName(),
			SearchCriteria.Oven.class.getSimpleName(), SearchCriteria.TabletPC.class.getSimpleName(),
			SearchCriteria.Refrigerator.class.getSimpleName(), SearchCriteria.Speakers.class.getSimpleName(),
			SearchCriteria.VacuumCleaner.class.getSimpleName());

    private Validator() {

    }

    public static void validateCriteria(Criteria criteria) {
        if (criteria == null) {
            throw new ValidationException("Criteria cannot be null");
        }
        if (criteria.getGroupSearchName() == null || criteria.getGroupSearchName().isBlank()
				|| !supportedCriteriaSearchNames.contains(criteria.getGroupSearchName())) {
			throw new ValidationException("Incorrect criteria search name");
        }
    }

}