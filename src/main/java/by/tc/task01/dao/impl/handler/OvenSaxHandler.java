package by.tc.task01.dao.impl.handler;

import by.tc.task01.entity.Oven;
import org.xml.sax.Attributes;

import java.util.Arrays;
import java.util.List;

import static by.tc.task01.dao.impl.constant.XmlElementConstants.*;


/**
 * OvenSaxHandler
 */
public class OvenSaxHandler extends AbstractAppliancesSaxHandler
{

    private boolean isOvenElement = false;
    private boolean isReadValue = false;
    private String currentValue = null;
    private Oven currentElement = null;
    private List<String> supportedElements = Arrays.asList(ID_ELEMENT, CAPACITY_ELEMENT, POWER_CONSUMPTION_ELEMENT,
            WEIGHT_ELEMENT, DEPTH_ELEMENT, HEIGHT_ELEMENT, WIDTH_ELEMENT);

    /**
     * {@inheritdoc}
     */
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
    /**
     * {@inheritdoc}
     */
    @Override
    public void characters(char[] ch, int start, int length) {
        if (isOvenElement && isReadValue)
        {
            currentValue = new String(ch, start, length);
        }
    }

    /**
     * {@inheritdoc}
     */
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
