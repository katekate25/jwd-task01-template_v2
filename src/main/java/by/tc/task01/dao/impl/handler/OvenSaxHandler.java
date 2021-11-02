package by.tc.task01.dao.impl.handler;

import by.tc.task01.entity.Oven;
import org.xml.sax.Attributes;

import java.util.Arrays;
import java.util.List;

/**
 * OvenSaxHandler
 */
public class OvenSaxHandler extends AbstractAppliancesSaxHandler
{
    private static final String OVEN_ELEMENT = "oven";
    private static final String ID_ELEMENT = "id";
    private static final String CAPACITY_ELEMENT = "capacity";
    private static final String POWER_CONSUMPTION_ELEMENT = "power_consumption";
    private static final String WEIGHT_ELEMENT = "weight";
    private static final String DEPTH_ELEMENT = "depth";
    private static final String HEIGHT_ELEMENT = "height";
    private static final String WIDTH_ELEMENT = "width";
    private boolean isOvenElement = false;
    private boolean isReadValue = false;
    private String currentValue = null;
    private Oven currentElement = null;
    private List<String> supportedElements = Arrays.asList(ID_ELEMENT, CAPACITY_ELEMENT, POWER_CONSUMPTION_ELEMENT,
            WEIGHT_ELEMENT, DEPTH_ELEMENT, HEIGHT_ELEMENT, WIDTH_ELEMENT);

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes)
    {
        if (OVEN_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement = new Oven();
            isOvenElement = true;
        }
        else if (supportedElements.contains(qName.toLowerCase()))
        {
            isReadValue = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isOvenElement && isReadValue)
        {
            currentValue = new String(ch, start, length);
        }
    }

    @Override
    public void endElement (String uri, String localName, String qName)
    {
        if (OVEN_ELEMENT.equalsIgnoreCase(qName)) {
            addAppliance(currentElement);
            isOvenElement = false;
            currentElement = null;
        }
        if (isOvenElement && ID_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setId(currentValue);
        }
        if (isOvenElement && CAPACITY_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setCapacity(Integer.valueOf(currentValue));
        }
        if (isOvenElement && POWER_CONSUMPTION_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setPowerConsumption(Integer.valueOf(currentValue));
        }
        if (isOvenElement && WEIGHT_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setWeight(Integer.valueOf(currentValue));
        }
        if (isOvenElement && DEPTH_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setDepth(Integer.valueOf(currentValue));
        }
        if (isOvenElement && HEIGHT_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setHeight(Integer.valueOf(currentValue));
        }
        if (isOvenElement && WIDTH_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setWidth(Integer.valueOf(currentValue));
        }
        isReadValue = false;
        currentValue = null;
    }
}
