package by.tsarionok.service;

import by.tsarionok.entity.EntitiesTagEnum;
import by.tsarionok.entity.Entity;
import by.tsarionok.entity.Serial;
import by.tsarionok.entity.User;
import by.tsarionok.exception.IllegalTagNameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class EntityHandler extends DefaultHandler {

    private static final Logger LOGGER = LogManager.getLogger(EntityHandler.class);

    private List<Entity> entities;

    private Entity current = null;

    private EntitiesTagEnum currentEnum = null;

    private EnumSet<EntitiesTagEnum> withText;

    public EntityHandler() {
        entities = new ArrayList<>();
        withText = EnumSet.range(EntitiesTagEnum.ENTITIES, EntitiesTagEnum.CATEGORY);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    private EntitiesTagEnum findConstant(final String localName) throws IllegalTagNameException {
        for (EntitiesTagEnum tagName : EnumSet.allOf(EntitiesTagEnum.class)) {
            if (localName.equals(tagName.getValue())) {
                return tagName;
            }
        }
        throw new IllegalTagNameException("Incorrect tag name");
    }

    @Override
    public void startElement(final String uri, final String localName,
                             final String qName, final Attributes attributes) {
        switch (qName) {
            case "user":
                current = new User();
                ((User) current).setRole(Integer.parseInt(attributes.getValue(0)));
                break;
            case "serial":
                current = new Serial();
            default:
                try {
                    EntitiesTagEnum temp = findConstant(qName);
                    if (withText.contains(temp)) {
                        currentEnum = temp;
                    }
                } catch (IllegalTagNameException e) {
                    LOGGER.error("Define constant error", e);
                }
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) {
        if ("user".equals(qName) || "serial".equals(qName)) {
            entities.add(current);
        }
    }

    @Override
    public void characters(final char[] ch, final int start, final int length) {
        String s = new String(ch, start, length).trim();

        if (currentEnum != null) {
            if (current instanceof User) {
                switch (currentEnum) {
                    case ID:
                        current.setId(Long.parseLong(s));
                        break;
                    case LOGIN:
                        ((User) current).setLogin(s);
                    case PASSWORD:
                        ((User) current).setPassword(s);
                    case PHONE_NUM:
                        ((User) current).getInfo().setPhoneNumber(s);
                        break;
                    case BIRTH_DATE:
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                        try {
                            ((User) current).getInfo().setBirthDate(format.parse(s));
                        } catch (ParseException e) {
                            LOGGER.error("Date parse error");
                        }
                        break;
                    case SEX:
                        ((User) current).getInfo().setSex(s);
                        break;
                }
            }
            if (current instanceof Serial) {
                switch (currentEnum) {
                    case ID:
                        current.setId(Long.parseLong(s));
                        break;
                    case NAME:
                        ((Serial) current).setName(s);
                        break;
                    case PREMIER_DATE:
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                        try {
                            ((Serial) current).setPremiereDate(format.parse(s));
                        } catch (ParseException e) {
                            LOGGER.error("Date parse error");
                        }
                        break;
                    case IMAGE_PATH:
                        ((Serial) current).setImgPath(s);
                        break;
                    case DESCRIPTION:
                        ((Serial) current).setDescription(s);
                        break;
                    case COUNTRY:
                        ((Serial) current).setCountry(s);
                        break;
                    case CATEGORY:
                        ((Serial) current).setCategory(s);
                        break;
                }
            }
        }
        currentEnum = null;
    }
}
