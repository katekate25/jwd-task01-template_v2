package by.tc.task01.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import by.tc.task01.dao.impl.filter.AbstractAppliancesFilter;
import by.tc.task01.dao.impl.filter.OvenFilter;
import by.tc.task01.entity.*;
import by.tc.task01.dao.impl.handler.*;
import org.xml.sax.SAXException;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.dao.impl.exception.DAOException;


public class ApplianceDAOImpl implements ApplianceDAO {

    private static final String APPLIANCES_XML_FILE_NAME = "appliances_db.xml";
    private static final String APPLIANCES_XSD_FILE_NAME = "appliances_db.xsd";

    private final Map<String, AbstractAppliancesSaxHandler> groupNameToHandlerMap = new HashMap<>();
    private final Map<String, AbstractAppliancesFilter> groupNameToFilterMap = new HashMap<>();

    public ApplianceDAOImpl() {
        populateGroupNameToHandlerMap();
        populateGroupNameToFilterMap();
    }

    private void populateGroupNameToHandlerMap() {
        groupNameToHandlerMap.put(Oven.class.getSimpleName(), new OvenSaxHandler());
        groupNameToHandlerMap.put(TabletPC.class.getSimpleName(), new TabletPCSaxHandler());
        groupNameToHandlerMap.put(Laptop.class.getSimpleName(), new LaptopSaxHandler());
        groupNameToHandlerMap.put(Refrigerator.class.getSimpleName(), new RefrigeratorSaxHandler());
        groupNameToHandlerMap.put(Speakers.class.getSimpleName(), new SpeakersSaxHandler());
        groupNameToHandlerMap.put(VacuumCleaner.class.getSimpleName(), new VacuumCleanerSaxHandler());
    }

    private void populateGroupNameToFilterMap() {
        groupNameToFilterMap.put(Oven.class.getSimpleName(), new OvenFilter());

    }

    @Override
    public List<Appliance> find(Criteria criteria) {
        validateXMLAgainstXSD();
        List<Appliance> appliances = findAppliancesByGroupName(criteria.getGroupSearchName());
        return groupNameToFilterMap.get(criteria.getGroupSearchName()).filter(appliances, criteria);
    }

    private List<Appliance> findAppliancesByGroupName(String groupSearchName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try (InputStream appliancesXmlIS = getClass().getClassLoader().getResourceAsStream(APPLIANCES_XML_FILE_NAME)) {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            AbstractAppliancesSaxHandler handler = groupNameToHandlerMap.get(groupSearchName);
            saxParser.parse(appliancesXmlIS, handler);
            return handler.getAppliances();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DAOException("There was an error during finding appliances", e);
        }
    }

    private void validateXMLAgainstXSD() {
        try (InputStream xml = getClass().getClassLoader().getResourceAsStream(APPLIANCES_XML_FILE_NAME);
             InputStream xsd = getClass().getClassLoader().getResourceAsStream(APPLIANCES_XSD_FILE_NAME)) {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
        } catch (Exception e) {
            throw new DAOException("There was an error during validating XML against XSD scheme", e);
        }
    }

}