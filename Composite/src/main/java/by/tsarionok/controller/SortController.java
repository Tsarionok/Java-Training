package by.tsarionok.controller;

import by.tsarionok.Main;
import by.tsarionok.entity.Content;
import by.tsarionok.entity.Lexeme;
import by.tsarionok.entity.LexemeType;
import by.tsarionok.service.ParagraphService;
import by.tsarionok.service.SentenceService;
import by.tsarionok.service.Service;
import by.tsarionok.service.WordService;
import org.apache.log4j.Logger;

import java.util.*;

public class SortController {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

    public void sortParagraphSentence(Content content) {
        Service service = new SentenceService();
        Map<Lexeme, List<Lexeme>> paragraphSentenceListMap = service.processContent(content, LexemeType.PARAGRAPH);
        paragraphSentenceListMap.entrySet().stream().sorted((o1, o2) ->
                ((Integer) o1.getValue().size()).compareTo(o2.getValue().size())).forEach(lexemeListEntry -> {
            LOGGER.info("Amount of sentences: " + lexemeListEntry.getValue().size() + ": " + lexemeListEntry
                    .getKey()
                    .getContent());
        });
    }

    public void sortSentenceWordByLength(Content content) {
        Service service = new WordService();
        Map<Lexeme, List<Lexeme>> sentenceWordListMap = service.processContent(content, LexemeType.SENTENCE);
        sentenceWordListMap.entrySet().stream().forEach(sentenceWordEntry -> {
            LOGGER.info("Sentence: " + sentenceWordEntry.getKey().getContent());
            LOGGER.info("Sentence word amount: " + sentenceWordEntry.getValue().size());
            sentenceWordEntry.getValue().stream().sorted(Comparator.comparing(Lexeme::getLength))
                    .forEach(word -> LOGGER.info(word.getContent()));
        });
    }

    public void sortParagraphBySentenceWordAmount(Content content) {
        Service service = new ParagraphService().nextProcessor(new SentenceService());
        Map<Lexeme, List<Lexeme>> paragraphSentenceListMap = service.processContent(content, LexemeType.PARAGRAPH);
        service = new SentenceService().nextProcessor(new WordService());
        Map<Lexeme, List<Lexeme>> sentenceWordListMap = service.processContent(content, LexemeType.SENTENCE);
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
