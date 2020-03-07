package by.tsarionok.dao;

import by.tsarionok.Main;
import by.tsarionok.entity.Content;
import by.tsarionok.entity.Lexeme;
import by.tsarionok.entity.LexemeType;
import by.tsarionok.service.*;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileDao {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

    private static final String FILE_PATH = "data/text.txt";

    public Content readFile() {
        BufferedReader br = null;
        String contentFilePath = FILE_PATH;
        File contentFile = new File(contentFilePath);
        try {
            br = new BufferedReader(new FileReader(contentFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOGGER.info("File not exist or can't read: " + e.getMessage());
        }
        try {
            LOGGER.info("Input file: " + contentFile.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Input content file not found! " + e.getMessage());
        }
        int charCode;
        StringBuilder textBuilder = new StringBuilder();
        try {
            while ((charCode = br.read()) != -1) {
                textBuilder.append((char) charCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Error with content line reading from file: " + e.getMessage());
        }
        Service service = new ArticleService();
        service.nextProcessor(new ParagraphService()).nextProcessor(new SentenceService())
                .nextProcessor(new WordService()).nextProcessor(new SymbolService());
        List<Lexeme> articleList = new ArrayList<>();
        articleList.add(new Lexeme(textBuilder.toString()));
        Content content = new Content();
        content.setLexemes(LexemeType.ARTICLE, articleList);
        service.processContent(content, LexemeType.ARTICLE);
        return content;
    }
}
