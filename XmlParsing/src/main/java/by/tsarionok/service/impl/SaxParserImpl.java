package by.tsarionok.service.impl;

import by.tsarionok.entity.Entity;
import by.tsarionok.service.EntityHandler;
import by.tsarionok.service.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxParserImpl extends Parser {

    private static final Logger LOGGER = LogManager.getLogger(SaxParserImpl.class);

    private XMLReader reader;

    private EntityHandler handler;

    public SaxParserImpl() {
        handler = new EntityHandler();
        // create schema
        // TODO
        //DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // try
//        String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;
//        SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
//        Schema schema = xsdFactory.newSchema(new File(xsdFile));
//
//        // set schema
//        factory.setNamespaceAware(true);
//        factory.setValidating(false);
//        factory.setSchema(schema);
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(handler);
        } catch (ParserConfigurationException e) {
            LOGGER.error("SAX parser configuration error", e);
        } catch (SAXException e) {
            LOGGER.error("SAX parser error", e);
        }
    }

    private void addEntities(final List<Entity> parsedEntities) {
        this.getEntities().addAll(parsedEntities);
    }

    @Override
    public void buildEntities(final String filePath) {
        try {
            reader.parse(filePath);
        } catch (IOException e) {
            LOGGER.error("File error", e);
        } catch (SAXException e) {
            LOGGER.error("SAX parser error", e);
        }
        addEntities(handler.getEntities());
    }
}
