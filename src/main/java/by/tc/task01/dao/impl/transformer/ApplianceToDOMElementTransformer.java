package by.tc.task01.dao.impl.transformer;

import by.tc.task01.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import static by.tc.task01.dao.impl.constant.XmlElementConstants.*;

public class ApplianceToDOMElementTransformer {

    private ApplianceToDOMElementTransformer() {}

    public static Element createElementFromAppliance(Document document, Appliance appliance) {
        Element element = null;
        if (appliance instanceof Oven)
        {
            element = transformOven(document, (Oven) appliance);
        }
        if (appliance instanceof Laptop)
        {
            element = transformLaptop(document, (Laptop) appliance);
        }
        if (appliance instanceof Refrigerator)
        {
            element = transformRefrigerator(document, (Refrigerator) appliance);
        }
        if (appliance instanceof VacuumCleaner)
        {
            element = transformVacuumCleaner(document, (VacuumCleaner) appliance);
        }
        if (appliance instanceof TabletPC)
        {
            element = transformTabletPC(document, (TabletPC) appliance);
        }
        if (appliance instanceof Speakers)
        {
            element = transformSpeakers(document, (Speakers) appliance);
        }
        return element;
    }

    private static Element transformLaptop(Document document, Laptop laptop) {
        Element laptopElement = document.createElement(OVEN_ELEMENT);
        buildAndAppendElement(document, laptopElement, ID_ELEMENT, laptop.getId());
        buildAndAppendElement(document, laptopElement, BATTERY_CAPACITY_ELEMENT, laptop.getBatteryCapacity().toString());
        buildAndAppendElement(document, laptopElement, OS_ELEMENT, laptop.getOs().toString());
        buildAndAppendElement(document, laptopElement, MEMORY_ROM_ELEMENT, laptop.getMemoryRom().toString());
        buildAndAppendElement(document, laptopElement, CPU_ELEMENT, laptop.getCpu().toString());
        buildAndAppendElement(document, laptopElement, DISPLAY_INCHES_ELEMENT, laptop.getDisplayInches().toString());
        buildAndAppendElement(document, laptopElement, SYSTEM_MEMORY_ELEMENT, laptop.getSystemMemory().toString());
        return laptopElement;
    }

    private static Element transformOven(Document document, Oven oven)
    {
        Element ovenElement = document.createElement(OVEN_ELEMENT);
        buildAndAppendElement(document, ovenElement, ID_ELEMENT, oven.getId());
        buildAndAppendElement(document, ovenElement, POWER_CONSUMPTION_ELEMENT, oven.getPowerConsumption().toString());
        buildAndAppendElement(document, ovenElement, WEIGHT_ELEMENT, oven.getWeight().toString());
        buildAndAppendElement(document, ovenElement, CAPACITY_ELEMENT, oven.getCapacity().toString());
        buildAndAppendElement(document, ovenElement, DEPTH_ELEMENT, oven.getDepth().toString());
        buildAndAppendElement(document, ovenElement, HEIGHT_ELEMENT, oven.getHeight().toString());
        buildAndAppendElement(document, ovenElement, WEIGHT_ELEMENT, oven.getWeight().toString());
        return ovenElement;
    }

    private static Element transformRefrigerator(Document document, Refrigerator refrigerator)
    {
        Element refrigeratorElement = document.createElement(REFRIGERATOR_ELEMENT);
        buildAndAppendElement(document, refrigeratorElement, ID_ELEMENT, refrigerator.getId());
        buildAndAppendElement(document, refrigeratorElement, POWER_CONSUMPTION_ELEMENT, refrigerator.getPowerConsumption().toString());
        buildAndAppendElement(document, refrigeratorElement, WEIGHT_ELEMENT, refrigerator.getWeight().toString());
        buildAndAppendElement(document, refrigeratorElement, FREEZER_CAPACITY_ELEMENT, refrigerator.getFreezerCapacity().toString());
        buildAndAppendElement(document, refrigeratorElement, OVERALL_CAPACITY_ELEMENT, refrigerator.getOverallCapacity().toString());
        buildAndAppendElement(document, refrigeratorElement, HEIGHT_ELEMENT, refrigerator.getHeight().toString());
        buildAndAppendElement(document, refrigeratorElement, WIDTH_ELEMENT, refrigerator.getWidth().toString());

        return refrigeratorElement;
    }

    private static Element transformVacuumCleaner(Document document, VacuumCleaner vacuumCleaner)
    {
        Element vacuumCleanerElement = document.createElement(VACUUM_CLEANER_ELEMENT);
        buildAndAppendElement(document, vacuumCleanerElement, ID_ELEMENT, vacuumCleaner.getId());
        buildAndAppendElement(document, vacuumCleanerElement, POWER_CONSUMPTION_ELEMENT, vacuumCleaner.getPowerConsumption().toString());
        buildAndAppendElement(document, vacuumCleanerElement, FILTER_TYPE_ELEMENT, vacuumCleaner.getFilterType().toString());
        buildAndAppendElement(document, vacuumCleanerElement, BAG_TYPE_ELEMENT, vacuumCleaner.getBagType().toString());
        buildAndAppendElement(document, vacuumCleanerElement, WAND_TYPE_ELEMENT, vacuumCleaner.getWandType().toString());
        buildAndAppendElement(document, vacuumCleanerElement, MOTOR_SPEED_REGULATION_ELEMENT, vacuumCleaner.getMotorSpeedRegulation().toString());
        buildAndAppendElement(document, vacuumCleanerElement, CLEANING_WIDTH_ELEMENT, vacuumCleaner.getCleaningWidth().toString());

        return vacuumCleanerElement;
    }

    private static Element transformTabletPC(Document document, TabletPC tabletPC)
    {
        Element tabletPCElement = document.createElement(TABLETPC_ELEMENT);
        buildAndAppendElement(document, tabletPCElement, ID_ELEMENT, tabletPC.getId());
        buildAndAppendElement(document, tabletPCElement, BATTERY_CAPACITY_ELEMENT, tabletPC.getBatteryCapacity().toString());
        buildAndAppendElement(document, tabletPCElement, DISPLAY_INCHES_ELEMENT, tabletPC.getDisplayInches().toString());
        buildAndAppendElement(document, tabletPCElement, MEMORY_ROM_ELEMENT, tabletPC.getMemoryRom().toString());
        buildAndAppendElement(document, tabletPCElement, FLASH_MEMORY_CAPACITY_ELEMENT, tabletPC.getFlashMemoryCapacity().toString());
        buildAndAppendElement(document, tabletPCElement, COLOR_ELEMENT, tabletPC.getColor().toString());

        return tabletPCElement;
    }

    private static Element transformSpeakers(Document document, Speakers speakers)
    {
        Element speakersElement = document.createElement(SPEAKERS_ELEMENT);
        buildAndAppendElement(document, speakersElement, ID_ELEMENT, speakers.getId());
        buildAndAppendElement(document, speakersElement, POWER_CONSUMPTION_ELEMENT, speakers.getPowerConsumption().toString());
        buildAndAppendElement(document, speakersElement, NUMBER_OF_SPEAKERS_ELEMENT, speakers.getNumberOfSpeakers().toString());
        buildAndAppendElement(document, speakersElement, CORD_LENGTH_ELEMENT, speakers.getCordLength().toString());
        buildAndAppendElement(document, speakersElement, FREQUENCY_RANGE_ELEMENT, speakers.getFrequencyRange().toString());

        return speakersElement;
    }

    private static void buildAndAppendElement(Document document, Element parentElement, String elementName,
                                              String elementValue) {
        Element newElement = document.createElement(elementName);
        newElement.appendChild(document.createTextNode(elementValue));
        parentElement.appendChild(newElement);
    }

}
