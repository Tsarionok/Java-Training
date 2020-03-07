package by.tsarionok.service;

import by.tsarionok.Main;
import by.tsarionok.controller.Controller;
import by.tsarionok.controller.ParagraphController;
import by.tsarionok.controller.SentenceController;
import by.tsarionok.controller.WordController;
import by.tsarionok.entity.Content;
import by.tsarionok.entity.Lexeme;
import by.tsarionok.entity.LexemeType;
import org.apache.log4j.Logger;

import java.util.*;

public class SortService {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

    public void sortParagraphSentence(Content content) {
        Controller controller = new SentenceController();
        Map<Lexeme, List<Lexeme>> paragraphSentenceListMap = controller.processContent(content, LexemeType.PARAGRAPH);
        paragraphSentenceListMap.entrySet().stream().sorted((o1, o2) ->
                ((Integer) o1.getValue().size()).compareTo(o2.getValue().size())).forEach(lexemeListEntry -> {
            LOGGER.info("Amount of sentences: " + lexemeListEntry.getValue().size() + ": " + lexemeListEntry
                    .getKey()
                    .getContent());
        });
    }

    public void sortSentenceWordByLength(Content content) {
        Controller controller = new WordController();
        Map<Lexeme, List<Lexeme>> sentenceWordListMap = controller.processContent(content, LexemeType.SENTENCE);
        sentenceWordListMap.entrySet().stream().forEach(sentenceWordEntry -> {
            LOGGER.info("Sentence: " + sentenceWordEntry.getKey().getContent());
            LOGGER.info("Sentence word amount: " + sentenceWordEntry.getValue().size());
            sentenceWordEntry.getValue().stream().sorted(Comparator.comparing(Lexeme::getLength))
                    .forEach(word -> LOGGER.info(word.getContent()));
        });
    }

    public void sortParagraphBySentenceWordAmount(Content content) {
        Controller controller = new ParagraphController().nextProcessor(new SentenceController());
        Map<Lexeme, List<Lexeme>> paragraphSentenceListMap = controller.processContent(content, LexemeType.PARAGRAPH);
        controller = new SentenceController().nextProcessor(new WordController());
        Map<Lexeme, List<Lexeme>> sentenceWordListMap = controller.processContent(content, LexemeType.SENTENCE);
        Map<Lexeme, List<Lexeme>> paragraphWordListMap = new HashMap<>();
        paragraphSentenceListMap.entrySet().stream().forEach(paragraphSentenceEntry -> {
            List<Lexeme> paragraphWords = new ArrayList<>();
            paragraphSentenceEntry.getValue().stream().forEach(sentence -> {
                paragraphWords.addAll(sentenceWordListMap.get(sentence));
            });
            paragraphWordListMap.put(paragraphSentenceEntry.getKey(), paragraphWords);
        });
        paragraphWordListMap.entrySet().stream().sorted((entry1, entry2) -> ((Integer) entry1.getValue().size())
                .compareTo(entry2.getValue().size()))
                .forEach(paragraphWordEntry -> LOGGER.info(paragraphWordEntry.getKey().getContent()));
    }
}
