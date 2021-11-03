package by.tc.task01.dao.impl.handler;

import by.tc.task01.entity.TabletPC;
import org.xml.sax.Attributes;

import java.util.Arrays;
import java.util.List;

import static by.tc.task01.dao.impl.constant.XmlElementConstants.*;

/**
 * TabletPCSaxHandler
 */
public class TabletPCSaxHandler extends AbstractAppliancesSaxHandler {

    private boolean isTabletPCElement = false;
    private boolean isReadValue = false;
    private String currentValue = null;
    private TabletPC currentElement = null;
    private List<String> supportedElements = Arrays.asList(ID_ELEMENT, DISPLAY_INCHES_ELEMENT, MEMORY_ROM_ELEMENT,
            FLASH_MEMORY_CAPACITY_ELEMENT, COLOR_ELEMENT, BATTERY_CAPACITY_ELEMENT);

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes)
    {
        if (TABLETPC_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement = new TabletPC();
            isTabletPCElement = true;
        }
        else if (supportedElements.contains(qName.toLowerCase()))
        {
            isReadValue = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isTabletPCElement && isReadValue)
        {
            currentValue = new String(ch, start, length);
        }
    }

    @Override
    public void endElement (String uri, String localName, String qName)
    {
        if (TABLETPC_ELEMENT.equalsIgnoreCase(qName)) {
            addAppliance(currentElement);
            isTabletPCElement = false;
            currentElement = null;
        }
        if (isTabletPCElement && ID_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setId(currentValue);
        }
        if (isTabletPCElement && DISPLAY_INCHES_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setDisplayInches(Integer.valueOf(currentValue));
        }
        if (isTabletPCElement && MEMORY_ROM_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setMemoryRom(Integer.valueOf(currentValue));
        }
        if (isTabletPCElement && FLASH_MEMORY_CAPACITY_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setFlashMemoryCapacity(Integer.valueOf(currentValue));
        }
        if (isTabletPCElement && COLOR_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setColor(String.valueOf(currentValue));
        }
        if (isTabletPCElement && BATTERY_CAPACITY_ELEMENT.equalsIgnoreCase(qName))
        {
            currentElement.setBatteryCapacity(Integer.valueOf(currentValue));
        }
        isReadValue = false;
        currentValue = null;
    }
}