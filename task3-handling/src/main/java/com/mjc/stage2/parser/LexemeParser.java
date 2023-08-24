package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import com.mjc.stage2.tokenizer.impl.TokenizerImpl;

public class LexemeParser extends AbstractTextParser{
    private static final String LEXEME_REGEX = "([\\w!=?()\\.':]+)";

    public LexemeParser(){}
    public LexemeParser(AbstractTextParser nextParser){
        super.setNextParser(nextParser);
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        TokenizerImpl.getMatches(LEXEME_REGEX, string)
            .stream()
            .forEach(part -> {
                AbstractTextComponent inner = new TextComponent(TextComponentType.SYMBOL);
                this.nextParser.parse(inner, part);
                abstractTextComponent.add(inner);
            });
    }

}
