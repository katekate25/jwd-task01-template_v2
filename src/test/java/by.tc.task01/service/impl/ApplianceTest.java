package by.tc.task01.service.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import by.tc.task01.service.validation.exception.ValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * ApplianceTest
 */
public class ApplianceTest {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ApplianceService service = factory.getApplianceService();

    @Test
    public void shouldFindAppliance() {
        Criteria criteriaTabletPC = new Criteria(SearchCriteria.TabletPC.class.getSimpleName());
        criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR.toString(), "BLUE");
        criteriaTabletPC.add(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), 14);
        criteriaTabletPC.add(SearchCriteria.TabletPC.MEMORY_ROM.toString(), 8000);
        List<Appliance> appliances = service.find(criteriaTabletPC);
        Assert.assertNotNull(appliances);
        Assert.assertFalse(appliances.isEmpty());
        Assert.assertEquals(1, appliances.size());
        TabletPC tabletPC = (TabletPC) appliances.iterator().next();
        Assert.assertEquals("BLUE", tabletPC.getColor());
        Assert.assertEquals(Integer.valueOf(14), tabletPC.getDisplayInches());
        Assert.assertEquals(Integer.valueOf(8000), tabletPC.getMemoryRom());
    }

    @Test
    public void shouldNotFindAppliance() {
        Criteria criteriaTabletPC = new Criteria(SearchCriteria.TabletPC.class.getSimpleName());
        criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR.toString(), "BLU");
        List<Appliance> appliances = service.find(criteriaTabletPC);
        Assert.assertNotNull(appliances);
        Assert.assertTrue(appliances.isEmpty());
    }

    @Test(expected = ValidationException.class)
    public void shouldThrowValidationException() {
        Criteria criteriaTabletPC = new Criteria("TaaaablePC");
        criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR.toString(), "BLUE");
        service.find(criteriaTabletPC);
    }
}
