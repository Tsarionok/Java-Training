package by.tsarionok;

import by.tsarionok.controller.ParseController;
import by.tsarionok.entity.Entity;
import by.tsarionok.service.impl.DomParserImpl;
import by.tsarionok.service.impl.SaxParserImpl;
import by.tsarionok.service.impl.StaxParserImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/servlet")
@MultipartConfig
public class XmlParsingServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(XmlParsingServlet.class);

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        String locale = request.getParameter("locale");
        request.getSession().setAttribute("sessionLocale", locale);
        try {
            request.getRequestDispatcher("/jsp/index.jsp")
                    .forward(request, response);
        } catch (ServletException e) {
            LOGGER.error("Servlet exception", e);
        } catch (IOException e) {
            LOGGER.error("IO Exception", e);
        }

    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        try {
            String filePath = "src/main/webapp/xml/serials.xml";
            String newFilePath = "/Users/sergey/JavaProjects/Training/XMLParsing/" + filePath;
            Part filePart = request.getPart("file");
            InputStream fileContent = filePart.getInputStream();
            OutputStream stream = new FileOutputStream(newFilePath);
            fileContent.transferTo(stream);

            ParseController controller = new ParseController();
            String param = request.getParameter("parser");
            List<Entity> entities = new ArrayList<>();
            switch (param) {
                case "dom":
                    DomParserImpl domParser = new DomParserImpl();
                    entities = controller.parseDocument(newFilePath, domParser);
                    break;
                case "sax":
                    SaxParserImpl saxParser = new SaxParserImpl();
                    entities = controller.parseDocument(newFilePath, saxParser);
                    break;
                case "stax":
                    StaxParserImpl staxParser = new StaxParserImpl();
                    entities = controller.parseDocument(newFilePath, staxParser);
                    break;
                default:
                    break;
            }
            request.setAttribute("res", entities);
            request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
        } catch (ServletException e) {
            LOGGER.error("Servlet exception", e);
        } catch (IOException e) {
            LOGGER.error("IO Exception", e);
        }
    }
}
