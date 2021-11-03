package by.tc.task01.dao.impl.handler;


import by.tc.task01.entity.Laptop;
import org.xml.sax.Attributes;

import java.util.Arrays;
import java.util.List;

import static by.tc.task01.dao.impl.constant.XmlElementConstants.*;

/**
 * LaptopSaxHandler
 */
public class LaptopSaxHandler extends AbstractAppliancesSaxHandler {

    private boolean isLaptopElement = false;
    private boolean isReadValue = false;
    private String currentValue = null;
    private Laptop currentElement = null;
    private List<String> supportedElements = Arrays.asList(ID_ELEMENT, DISPLAY_INCHES_ELEMENT, MEMORY_ROM_ELEMENT,
            BATTERY_CAPACITY_ELEMENT, SYSTEM_MEMORY_ELEMENT, OS_ELEMENT, CPU_ELEMENT);

    /**
     * {@inheritdoc}
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (LAPTOP_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement = new Laptop();
            isLaptopElement = true;
        } else if (supportedElements.contains(qName.toLowerCase())) {
            isReadValue = true;
        }
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void characters(char[] ch, int start, int length) {
        if (isLaptopElement && isReadValue) {
            currentValue = new String(ch, start, length);
        }
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void endElement(String uri, String localName, String qName) {
        if (LAPTOP_ELEMENT.equalsIgnoreCase(qName)) {
            addAppliance(currentElement);
            isLaptopElement = false;
            currentElement = null;
        }
        if (isLaptopElement && ID_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setId(currentValue);
        }
        if (isLaptopElement && DISPLAY_INCHES_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setDisplayInches(Integer.valueOf(currentValue));
        }
        if (isLaptopElement && MEMORY_ROM_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setMemoryRom(Integer.valueOf(currentValue));
        }
        if (isLaptopElement && BATTERY_CAPACITY_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setBatteryCapacity(Double.valueOf(currentValue));
        }
        if (isLaptopElement && SYSTEM_MEMORY_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setSystemMemory(Integer.valueOf(currentValue));
        }
        if (isLaptopElement && OS_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setOs(String.valueOf(currentValue));
        }
        if (isLaptopElement && CPU_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setCpu(Double.valueOf(currentValue));
        }
        isReadValue = false;
        currentValue = null;
    }
}


