package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        IntStream.range(0, parsers.size() - 1).forEach(i ->
                parsers.get(i).setNextParser(parsers.get(i + 1))
        );
        parsers.get(parsers.size() - 1).setNextParser(null);
        return parsers.get(0);
    }
}
