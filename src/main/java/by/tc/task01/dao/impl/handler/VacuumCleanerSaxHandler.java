package by.tc.task01.dao.impl.handler;

import by.tc.task01.entity.VacuumCleaner;
import org.xml.sax.Attributes;

import java.util.Arrays;
import java.util.List;

import static by.tc.task01.dao.impl.constant.XmlElementConstants.*;

/**
 * VacuumCleanerSaxHandler
 */
public class VacuumCleanerSaxHandler extends AbstractAppliancesSaxHandler {

    private boolean isVacuumCleanerElement = false;
    private boolean isReadValue = false;
    private String currentValue = null;
    private VacuumCleaner currentElement = null;
    private final List<String> supportedElements = Arrays.asList(ID_ELEMENT, FILTER_TYPE_ELEMENT, POWER_CONSUMPTION_ELEMENT,
            BAG_TYPE_ELEMENT, WAND_TYPE_ELEMENT, MOTOR_SPEED_REGULATION_ELEMENT, CLEANING_WIDTH_ELEMENT);

    /**
     * {@inheritdoc}
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (VACUUM_CLEANER_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement = new VacuumCleaner();
            isVacuumCleanerElement = true;
        } else if (supportedElements.contains(qName.toLowerCase())) {
            isReadValue = true;
        }
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void characters(char[] ch, int start, int length) {
        if (isVacuumCleanerElement && isReadValue) {
            currentValue = new String(ch, start, length);
        }
    }

    /**
     * {@inheritdoc}
     */
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
