package by.tsarionok.service.impl;

import by.tsarionok.dao.XmlDao;
import by.tsarionok.entity.Serial;
import by.tsarionok.entity.User;
import by.tsarionok.entity.UserInfo;
import by.tsarionok.service.Parser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DomParserImpl extends Parser {
    private static final Logger LOGGER = LogManager.getLogger(DomParserImpl.class);

    public DomParserImpl() {
        super();
    }

    @Override
    public void buildEntities(final String filePath) {
        XmlDao xmlDao = new XmlDao();
        Document document = xmlDao.readXmlFile(filePath);
        Element root = document.getDocumentElement();

        NodeList userNodes = root.getElementsByTagName("user");
        for (int i = 0; i < userNodes.getLength(); i++) {
            Element userElement = (Element) userNodes.item(i);
            User user = buildUser(userElement);
            setEntity(user);
        }

        NodeList serialNodes = root.getElementsByTagName("serial");
        for (int i = 0; i < serialNodes.getLength(); i++) {
            Element serialElement = (Element) serialNodes.item(i);
            Serial serial = buildSerial(serialElement);
            setEntity(serial);
        }
    }

    private User buildUser(final Element element) {
        User user = null;
        user = new User();
        user.setId(Long.parseLong(getElementContext(element, "id")));
        user.setLogin(getElementContext(element, "login"));
        user.setPassword(getElementContext(element, "password"));
        user.setRole(Integer.parseInt(element.getAttribute("role")));
        user.setInfo(buildUserInfo(element));
        return user;
    }

    private UserInfo buildUserInfo(final Element element) {
        UserInfo info = null;
        info = new UserInfo();
        info.setPhoneNumber(getElementContext(element, "phone-num"));
        info.setSex(getElementContext(element, "sex"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            info.setBirthDate(format.parse(getElementContext(element, "birth-date")));
        } catch (ParseException e) {
            LOGGER.error("Parse date exception. " + e);
        }
        return info;
    }

    private Serial buildSerial(final Element element) {
        Serial serial = new Serial();
        serial.setId(Long.parseLong(getElementContext(element, "id")));
        serial.setName(getElementContext(element, "name"));
        serial.setDescription(getElementContext(element, "description"));
        serial.setImgPath(getElementContext(element, "image-path"));
        NodeList countryNodes = element.getElementsByTagName("country");
        List<String> countries = new ArrayList<>();
        for (int i = 0; i < countryNodes.getLength(); i++) {
            countries.add(countryNodes.item(i).getTextContent());
        }
        serial.setCountries(countries);
        NodeList categoryNodes = element.getElementsByTagName("category");
        List<String> categories = new ArrayList<>();
        for (int i = 0; i < categoryNodes.getLength(); i++) {
            categories.add(categoryNodes.item(i).getTextContent());
        }
        serial.setCategories(categories);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            serial.setPremiereDate(format.parse(getElementContext(element, "premier-date")));
        } catch (ParseException e) {
            LOGGER.error("Parse date exception. " + e);
        }
        return serial;
    }

    private String getElementContext(final Element element, final String name) {
        NodeList list = element.getElementsByTagName(name);
        Node node = list.item(0);
        return node.getTextContent();
    }
}
