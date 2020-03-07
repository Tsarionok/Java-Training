package by.tsarionok;

import by.tsarionok.dao.TextFileDao;
import by.tsarionok.service.SortService;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        SortService sortService = new SortService();
        TextFileDao fileDao = new TextFileDao();
        LOGGER.info("Sorting paragraphs by sentence count:");
        sortService.sortParagraphSentence(fileDao.readFile());
        LOGGER.info("Sorting sentences words by length:");
        sortService.sortSentenceWordByLength(fileDao.readFile());
        LOGGER.info("Sorting paragraphs by words amount:");
        sortService.sortParagraphBySentenceWordAmount(fileDao.readFile());
    }
}
