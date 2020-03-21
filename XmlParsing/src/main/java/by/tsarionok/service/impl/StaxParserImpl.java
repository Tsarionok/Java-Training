package by.tsarionok.service.impl;

import by.tsarionok.entity.EntitiesTagEnum;
import by.tsarionok.entity.Serial;
import by.tsarionok.entity.User;
import by.tsarionok.entity.UserInfo;
import by.tsarionok.exception.IllegalTagNameException;
import by.tsarionok.service.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StaxParserImpl extends Parser {

    private static final Logger LOGGER = LogManager.getLogger(StaxParserImpl.class);

    private XMLInputFactory inputFactory;

    public StaxParserImpl() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildEntities(final String filePath) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filePath))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (EntitiesTagEnum.USER.getValue().equals(name)) {
                        User user = buildUser(reader);
                        this.addEntity(user);
                    } else if (EntitiesTagEnum.SERIAL.getValue().equals(name)) {
                        Serial serial = buildSerial(reader);
                        this.addEntity(serial);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found", e);
        } catch (XMLStreamException e) {
            LOGGER.error("StAX parsing error", e);
        } catch (IOException e) {
            LOGGER.error("Closing stream error", e);
        } catch (IllegalTagNameException e) {
            LOGGER.error("Unknown tag name in tariff", e);
        }
    }

    private User buildUser(final XMLStreamReader reader) throws XMLStreamException, IllegalTagNameException {
        User user = new User();
        user.setRole(Integer.parseInt(reader.getAttributeValue(null, EntitiesTagEnum.ROLE.getValue())));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                name = reader.getLocalName();
                switch (name) {
                    case "id":
                        user.setId(Long.parseLong(getXMLText(reader)));
                        break;
                    case "login":
                        user.setLogin(getXMLText(reader));
                        break;
                    case "password":
                        user.setPassword(getXMLText(reader));
                        break;
                    case "user-info":
                        user.setInfo(getXMLUserInfo(reader));
                }
            } else if (type == XMLStreamConstants.END_ELEMENT) {
                name = reader.getLocalName();
                if (name.equals(EntitiesTagEnum.USER.getValue())) {
                    return user;
                }
            }
        }
        throw new IllegalTagNameException("Find tag error");
    }

    private Serial buildSerial(final XMLStreamReader reader) throws XMLStreamException, IllegalTagNameException {
        Serial serial = new Serial();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                name = reader.getLocalName();
                switch (name) {
                    case "id":
                        serial.setId(Long.parseLong(getXMLText(reader)));
                        break;
                    case "name":
                        serial.setName(getXMLText(reader));
                        break;
                    case "premier-date":
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                        try {
                            serial.setPremiereDate(format.parse(getXMLText(reader)));
                        } catch (ParseException e) {
                            LOGGER.error("Date parse error");
                        }
                        break;
                    case "image-path":
                        serial.setImgPath(getXMLText(reader));
                        break;
                    case "description":
                        serial.setDescription(getXMLText(reader));
                        break;
                    case "country":
                        serial.setCountry(getXMLText(reader));
                        break;
                    case "category":
                        serial.setCategory(getXMLText(reader));
                        break;
                }
            } else if (type == XMLStreamConstants.END_ELEMENT) {
                name = reader.getLocalName();
                if (name.equals(EntitiesTagEnum.SERIAL.getValue())) {
                    return serial;
                }
            }
        }
        throw new IllegalTagNameException("Find tag error");
    }

    private String getXMLText(final XMLStreamReader reader) throws
            XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private UserInfo getXMLUserInfo(final XMLStreamReader reader) throws IllegalTagNameException, XMLStreamException {
        UserInfo info = new UserInfo();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                name = reader.getLocalName();
                switch (name) {
                    case "phone-num":
                        info.setPhoneNumber(getXMLText(reader));
                        break;
                    case "birth-date":
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                        try {
                            info.setBirthDate(format.parse(getXMLText(reader)));
                        } catch (ParseException e) {
                            LOGGER.error("Date parse error");
                        }
                        break;
                    case "sex":
                        info.setSex(getXMLText(reader));
                        break;
                    default:
                        throw new IllegalTagNameException("Unknown tag");
                }
            } else if (type == XMLStreamConstants.END_ELEMENT) {
                name = reader.getLocalName();
                if (name.equals(EntitiesTagEnum.USER_INFO.getValue())) {
                    return info;
                }
            }
        }
        throw new IllegalTagNameException("Unknown tag name");
    }
}
