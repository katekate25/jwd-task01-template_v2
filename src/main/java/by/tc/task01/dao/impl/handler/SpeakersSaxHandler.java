package by.tc.task01.dao.impl.handler;


import by.tc.task01.entity.Speakers;
import org.xml.sax.Attributes;

import java.util.Arrays;
import java.util.List;

/**
 * SpeakersSaxHandler
 */
public class SpeakersSaxHandler extends AbstractAppliancesSaxHandler {
    private static final String SPEAKERS_ELEMENT = "speakers";
    private static final String ID_ELEMENT = "id";
    private static final String POWER_CONSUMPTION_ELEMENT = "power_consumption";
    private static final String NUMBER_OF_SPEAKERS_ELEMENT = "number_of_speakers";
    private static final String FREQUENCY_RANGE_ELEMENT = "frequency_range";
    private static final String CORD_LENGTH_ELEMENT = "cord_length";

    private boolean isSpeakersElement = false;
    private boolean isReadValue = false;
    private String currentValue = null;
    private Speakers currentElement = null;
    private List<String> supportedElements = Arrays.asList(ID_ELEMENT, POWER_CONSUMPTION_ELEMENT, NUMBER_OF_SPEAKERS_ELEMENT,
            FREQUENCY_RANGE_ELEMENT, CORD_LENGTH_ELEMENT);

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

