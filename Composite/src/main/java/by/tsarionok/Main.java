package by.tsarionok;

import by.tsarionok.controller.SortController;
import by.tsarionok.dao.TextFileDao;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        SortController sortController = new SortController();
        TextFileDao fileDao = new TextFileDao();
        LOGGER.info("Sorting paragraphs by sentence count:");
        sortController.sortParagraphSentence(fileDao.readFile());
        LOGGER.info("Sorting sentences words by length:");
        sortController.sortSentenceWordByLength(fileDao.readFile());
        LOGGER.info("Sorting paragraphs by words amount:");
        sortController.sortParagraphBySentenceWordAmount(fileDao.readFile());
    }
}
