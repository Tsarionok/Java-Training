package by.tsarionok.service.impl;

import by.tsarionok.dao.XmlDao;
import by.tsarionok.service.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomParserImpl implements Parser {
    public void parseDocument() {
        XmlDao xmlDao = new XmlDao();
        Document document = xmlDao.readXmlFile();
        Element element = document.getDocumentElement();
        System.out.println(element);
    }
}
