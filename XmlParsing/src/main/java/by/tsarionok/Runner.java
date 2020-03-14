package by.tsarionok;

import by.tsarionok.entity.Entity;
import by.tsarionok.service.impl.DomParserImpl;

import javax.xml.XMLConstants;
import java.util.List;

public class Runner {
    //private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    private static final String FILE_PATH = "src/main/resources/xml/serials.xml";
    private static final String SCHEMA_PATH = "xml/serials.xsd";
    private static final String LOG_PATH = "log/log.txt";
    private static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;

    public static void main(String[] args) {


//        SchemaFactory factory = SchemaFactory.newInstance(LANGUAGE);
////        Schema schema = null;
////
////        try {
////            File file = new File(FILE_PATH);
////            if (file.exists()) {
////                schema = factory.newSchema(file);
////            }
////            else {
////                throw new FileNotFoundException();
////            }
////            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
////            parserFactory.setSchema(schema);
////            SAXParser parser = parserFactory.newSAXParser();
////            parser.parse(FILE_PATH, new SerialsErrorHandler(LOG_PATH));
////            LOGGER.info(FILE_PATH + " file is valid");
////        } catch (ParserConfigurationException e) {
////            LOGGER.error("Parser config exception");
////        } catch (SAXException e) {
////            LOGGER.error("SAX exception");
////        } catch (FileNotFoundException e) {
////            LOGGER.error("File not found exception");
////        } catch (IOException e) {
////            LOGGER.error("Input/output exception");
////        }

        DomParserImpl domParser = new DomParserImpl();
        domParser.buildSetEntities();
        List<Entity> entities = domParser.getEntities();
        for (Entity entity : entities) {
            System.out.println(entity);
        }
    }
}

