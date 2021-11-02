package by.tc.task01.dao.impl.handler;


import by.tc.task01.entity.Laptop;
import org.xml.sax.Attributes;

import java.util.Arrays;
import java.util.List;

/**
 * LaptopSaxHandler
 */
public class LaptopSaxHandler extends AbstractAppliancesSaxHandler {
    private static final String LAPTOP_ELEMENT = "laptop";
    private static final String ID_ELEMENT = "id";
    private static final String BATTERY_CAPACITY_ELEMENT = "battery_capacity";
    private static final String DISPLAY_INCHES_ELEMENT = "display_inches";
    private static final String MEMORY_ROM_ELEMENT = "memory_rom";
    private static final String SYSTEM_MEMORY_ELEMENT = "system_memory";
    private static final String OS_ELEMENT = "os";
    private static final String CPU_ELEMENT = "cpu";

    private boolean isLaptopElement = false;
    private boolean isReadValue = false;
    private String currentValue = null;
    private Laptop currentElement = null;
    private List<String> supportedElements = Arrays.asList(ID_ELEMENT, DISPLAY_INCHES_ELEMENT, MEMORY_ROM_ELEMENT,
            BATTERY_CAPACITY_ELEMENT, SYSTEM_MEMORY_ELEMENT, OS_ELEMENT, CPU_ELEMENT);

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (LAPTOP_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement = new Laptop();
            isLaptopElement = true;
        } else if (supportedElements.contains(qName.toLowerCase())) {
            isReadValue = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isLaptopElement && isReadValue) {
            currentValue = new String(ch, start, length);
        }
    }

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


