package by.tc.task01.dao.impl.handler;


import by.tc.task01.entity.Speakers;
import org.xml.sax.Attributes;

import java.util.Arrays;
import java.util.List;

import static by.tc.task01.dao.impl.constant.XmlElementConstants.*;

/**
 * SpeakersSaxHandler
 */
public class SpeakersSaxHandler extends AbstractAppliancesSaxHandler {

    private boolean isSpeakersElement = false;
    private boolean isReadValue = false;
    private String currentValue = null;
    private Speakers currentElement = null;
    private List<String> supportedElements = Arrays.asList(ID_ELEMENT, POWER_CONSUMPTION_ELEMENT,
            NUMBER_OF_SPEAKERS_ELEMENT, FREQUENCY_RANGE_ELEMENT, CORD_LENGTH_ELEMENT);

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (SPEAKERS_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement = new Speakers();
            isSpeakersElement = true;
        } else if (supportedElements.contains(qName.toLowerCase())) {
            isReadValue = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isSpeakersElement && isReadValue) {
            currentValue = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (SPEAKERS_ELEMENT.equalsIgnoreCase(qName)) {
            addAppliance(currentElement);
            isSpeakersElement = false;
            currentElement = null;
        }
        if (isSpeakersElement && ID_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setId(currentValue);
        }
        if (isSpeakersElement && NUMBER_OF_SPEAKERS_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setNumberOfSpeakers(Integer.valueOf(currentValue));
        }
        if (isSpeakersElement && POWER_CONSUMPTION_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setPowerConsumption(Integer.valueOf(currentValue));
        }
        if (isSpeakersElement && FREQUENCY_RANGE_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setFrequencyRange(String.valueOf(currentValue));
        }
        if (isSpeakersElement && CORD_LENGTH_ELEMENT.equalsIgnoreCase(qName)) {
            currentElement.setCordLength(Integer.valueOf(currentValue));
        }

        isReadValue = false;
        currentValue = null;
    }
}

