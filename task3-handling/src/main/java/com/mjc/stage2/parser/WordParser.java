package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import com.mjc.stage2.tokenizer.impl.TokenizerImpl;

import java.util.List;
import java.util.Objects;

public class WordParser extends AbstractTextParser{
    private static final String WORD_REGEX = "([\\w!=?().':]+)";

    public WordParser(){}
    public WordParser(AbstractTextParser nextParser){
        super.setNextParser(nextParser);
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        TokenizerImpl.getMatches(WORD_REGEX, string)
            .stream()
            .forEach(part -> {
                AbstractTextComponent inner = new TextComponent(TextComponentType.SYMBOL);
                this.nextParser.parse(inner, part);
                abstractTextComponent.add(inner);
            });
    }
}


