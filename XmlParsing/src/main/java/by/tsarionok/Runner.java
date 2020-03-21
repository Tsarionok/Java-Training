package by.tsarionok;

import by.tsarionok.controller.ParseController;
import by.tsarionok.entity.Entity;
import by.tsarionok.service.impl.DomParserImpl;
import by.tsarionok.service.impl.SaxParserImpl;
import by.tsarionok.service.impl.StaxParserImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    private static final String XML_PATH = "src/main/resources/xml/serials.xml";

    public static void main(String[] args) {

        ParseController controller = new ParseController();

        List<Entity> entities1 = controller.parseDocument(XML_PATH, new DomParserImpl());
        System.out.println("\n____________________\nDOM parser results:");
        System.out.println(entities1);

        List<Entity> entities2 = controller.parseDocument(XML_PATH, new SaxParserImpl());
        System.out.println("\n____________________\nSAX parser results:");
        System.out.println(entities2);

        List<Entity> entities3 = controller.parseDocument(XML_PATH, new StaxParserImpl());
        System.out.println("\n____________________\nStAX parser results:");
        System.out.println(entities3);
    }
}

