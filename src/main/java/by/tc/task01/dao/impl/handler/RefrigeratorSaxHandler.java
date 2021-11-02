package by.tc.task01.dao.impl.handler;


import by.tc.task01.entity.Refrigerator;
import org.xml.sax.Attributes;

import java.util.Arrays;
import java.util.List;

/**
 * RefrigeratorSaxHandler
 */
public class RefrigeratorSaxHandler extends AbstractAppliancesSaxHandler {
    private static final String REFRIGERATOR_ELEMENT = "refrigerator";
    private static final String ID_ELEMENT = "id";
    private static final String FREEZER_CAPACITY_ELEMENT = "freezer_capacity";
    private static final String POWER_CONSUMPTION_ELEMENT = "power_consumption";
    private static final String WEIGHT_ELEMENT = "weight";
    private static final String OVERALL_CAPACITY_ELEMENT = "overall_capacity";
    private static final String HEIGHT_ELEMENT = "height";
    private static final String WIDTH_ELEMENT = "width";

    private boolean isRefrigeratorElement = false;
    private boolean isReadValue = false;
    private String currentValue = null;
    private Refrigerator currentElement = null;
    private List<String> supportedElements = Arrays.asList(ID_ELEMENT, FREEZER_CAPACITY_ELEMENT, POWER_CONSUMPTION_ELEMENT, WEIGHT_ELEMENT,
            OVERALL_CAPACITY_ELEMENT, HEIGHT_ELEMENT, WIDTH_ELEMENT);

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (REFRIGERATOR_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement = new Refrigerator();
            isRefrigeratorElement = true;
        } else if (supportedElements.contains(qName.toLowerCase())) {
            isReadValue = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isRefrigeratorElement && isReadValue) {
            currentValue = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (REFRIGERATOR_ELEMENT.equalsIgnoreCase(qName)) {
            addAppliance(currentElement);
            isRefrigeratorElement = false;
            currentElement = null;
        }
        if (isRefrigeratorElement && ID_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setId(currentValue);
        }
        if (isRefrigeratorElement && FREEZER_CAPACITY_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setFreezerCapacity(Integer.valueOf(currentValue));
        }
        if (isRefrigeratorElement && POWER_CONSUMPTION_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setPowerConsumption(Integer.valueOf(currentValue));
        }
        if (isRefrigeratorElement && WEIGHT_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setWeight(Integer.valueOf(currentValue));
        }
        if (isRefrigeratorElement && OVERALL_CAPACITY_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setOverallCapacity(Double.valueOf(currentValue));
        }
        if (isRefrigeratorElement && HEIGHT_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setHeight(Integer.valueOf(currentValue));
        }
        if (isRefrigeratorElement && WIDTH_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setWidth(Integer.valueOf(currentValue));
        }
        isReadValue = false;
        currentValue = null;
    }
}
