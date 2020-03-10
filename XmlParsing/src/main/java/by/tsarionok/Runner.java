package by.tsarionok;

import by.tsarionok.service.impl.DomParserImpl;

public class Runner {
    public static void main(String[] args) {
        DomParserImpl domParser = new DomParserImpl();
        domParser.parseDocument();
    }
}
