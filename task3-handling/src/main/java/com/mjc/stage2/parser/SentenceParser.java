package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import com.mjc.stage2.tokenizer.impl.TokenizerImpl;

import java.util.List;
import java.util.Objects;

public class SentenceParser extends AbstractTextParser{
    private static final String SENTENCE_REGEX = "([!?.]+)";

    public SentenceParser(AbstractTextParser nextParser){
        super.setNextParser(nextParser);
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        List<String> parts = List.of(string.split(SENTENCE_REGEX));
        TokenizerImpl.print(parts);
        parts.stream()
            .filter(str -> Objects.nonNull(str) && !str.trim().isEmpty() && !str.trim().isBlank())
            .forEach(part -> {
                AbstractTextComponent inner = new TextComponent(TextComponentType.WORD);
                this.nextParser.parse(inner, part);
                abstractTextComponent.add(inner);
            });
    }
}
