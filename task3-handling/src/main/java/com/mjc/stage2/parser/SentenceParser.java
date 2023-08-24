package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import java.util.List;


public class SentenceParser extends AbstractTextParser{
    private static final String SENTENCE_REGEX = "([!?.]+)";

    public SentenceParser(AbstractTextParser nextParser){
        super.setNextParser(nextParser);
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        List.of(string.split(SENTENCE_REGEX))
            .forEach(part -> {
                AbstractTextComponent inner = new TextComponent(TextComponentType.WORD);
                this.nextParser.parse(inner, part);
                abstractTextComponent.add(inner);
            });
    }
}
