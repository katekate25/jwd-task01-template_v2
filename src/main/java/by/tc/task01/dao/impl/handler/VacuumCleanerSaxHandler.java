package by.tc.task01.dao.impl.handler;

import by.tc.task01.entity.VacuumCleaner;
import org.xml.sax.Attributes;

import java.util.Arrays;
import java.util.List;

/**
 * VacuumCleanerSaxHandler
 */
public class VacuumCleanerSaxHandler extends AbstractAppliancesSaxHandler {
    private static final String VACUUM_CLEANER_ELEMENT = "vacuumCleaner";
    private static final String ID_ELEMENT = "id";
    private static final String FILTER_TYPE_ELEMENT = "filter_type";
    private static final String POWER_CONSUMPTION_ELEMENT = "power_consumption";
    private static final String BAG_TYPE_ELEMENT = "bag_type";
    private static final String WAND_TYPE_ELEMENT = "wand_type";
    private static final String MOTOR_SPEED_REGULATION_ELEMENT = "motor_speed_regulation";
    private static final String CLEANING_WIDTH_ELEMENT = "cleaning_width";

    private boolean isVacuumCleanerElement = false;
    private boolean isReadValue = false;
    private String currentValue = null;
    private VacuumCleaner currentElement = null;
    private final List<String> supportedElements = Arrays.asList(ID_ELEMENT, FILTER_TYPE_ELEMENT, POWER_CONSUMPTION_ELEMENT,
            BAG_TYPE_ELEMENT, WAND_TYPE_ELEMENT, MOTOR_SPEED_REGULATION_ELEMENT, CLEANING_WIDTH_ELEMENT);

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (VACUUM_CLEANER_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement = new VacuumCleaner();
            isVacuumCleanerElement = true;
        } else if (supportedElements.contains(qName.toLowerCase())) {
            isReadValue = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isVacuumCleanerElement && isReadValue) {
            currentValue = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (VACUUM_CLEANER_ELEMENT.equalsIgnoreCase(qName)) {
            addAppliance(currentElement);
            isVacuumCleanerElement = false;
            currentElement = null;
        }
        if (isVacuumCleanerElement && ID_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setId(currentValue);
        }
        if (isVacuumCleanerElement && FILTER_TYPE_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setFilterType(String.valueOf(currentValue));
        }
        if (isVacuumCleanerElement && POWER_CONSUMPTION_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setPowerConsumption(Integer.valueOf(currentValue));
        }
        if (isVacuumCleanerElement && BAG_TYPE_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setBagType(String.valueOf(currentValue));
        }
        if (isVacuumCleanerElement && WAND_TYPE_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setWandType(String.valueOf(currentValue));
        }
        if (isVacuumCleanerElement && MOTOR_SPEED_REGULATION_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setMotorSpeedRegulation(Integer.valueOf(currentValue));
        }
        if (isVacuumCleanerElement && CLEANING_WIDTH_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setCleaningWidth(Integer.valueOf(currentValue));
        }
        isReadValue = false;
        currentValue = null;
    }
}
