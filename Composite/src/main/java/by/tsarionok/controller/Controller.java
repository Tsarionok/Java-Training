package by.tsarionok.controller;

import by.tsarionok.Main;
import by.tsarionok.entity.Content;
import by.tsarionok.entity.Lexeme;
import by.tsarionok.entity.LexemeType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private Controller nextController;
    private LexemeType type;
    private String patternString;
    private Pattern pattern;
    private Matcher matcher;
    private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());


    public Controller(LexemeType type) {
        this.type = type;
        this.patternString = type.getPattern();
        this.pattern = Pattern.compile(patternString);
    }

    public LexemeType getType() {
        return type;
    }

    public Controller nextProcessor(Controller controller) {
        this.nextController = controller;
        return controller;
    }

    public Map<Lexeme, List<Lexeme>> processContent(Content content, LexemeType prevTypeToProcess) {
        LOGGER.info("Lexeme type to process: " + prevTypeToProcess);
        StringBuilder textBuilder = new StringBuilder();
        List<Lexeme> lexemesToProcess = content.getLexemeMap().get(prevTypeToProcess);
        List<Lexeme> resultLexemes = new ArrayList<>();
        Map<Lexeme, List<Lexeme>> lexemeResultListMap = new TreeMap<>();
        List<Lexeme> separateLexemes;
        if (type.equals(LexemeType.ARTICLE)) {
            processNext(content, type);
            return null;
        }
        for (Lexeme lexeme : lexemesToProcess) {
            matcher = pattern.matcher(lexeme.getContent());
            separateLexemes = new ArrayList<>();
            while (matcher.find()) {
                int matchStart = matcher.start();
                int matchEnd = matcher.end();
                textBuilder.append(lexeme.getPart(matchStart, matchEnd));
                resultLexemes.add(new Lexeme(textBuilder.toString()));
                separateLexemes.add(new Lexeme(textBuilder.toString()));
                textBuilder.delete(0, textBuilder.length());
            }
            lexemeResultListMap.put(lexeme, separateLexemes);
        }
        content.setLexemes(type, resultLexemes);
        processNext(content, type);
        return lexemeResultListMap;
    }

    protected void processNext(Content content, LexemeType type) {
        if (nextController != null) {
            nextController.processContent(content, type);
        }
    }
}
