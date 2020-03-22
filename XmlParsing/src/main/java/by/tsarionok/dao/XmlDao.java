package by.tsarionok.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlDao {
    private static final Logger LOGGER = LogManager.getLogger(XmlDao.class);

    private DocumentBuilder documentBuilder;

    public XmlDao() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Parser configuration exception" + e);
        }
    }

    public Document readXmlFile(final String filePath) {
        Document document = null;
        try {
            document = documentBuilder.parse(filePath);
        } catch (IOException | SAXException e) {
            LOGGER.error("File access exception");
        }
        return document;
    }
}
