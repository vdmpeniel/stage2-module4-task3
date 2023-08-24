package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponentType;
import com.mjc.stage2.tokenizer.impl.TokenizerImpl;

import java.util.List;

public class LexemeParser extends AbstractTextParser{
    private static final String LEXEME_REGEX = "[\\w!=?()\\.':]";


    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        TokenizerImpl.getMatches(LEXEME_REGEX, string)
        .forEach(part -> {
            abstractTextComponent.add(new SymbolLeaf(null, part.charAt(0)));
        });
    }

}
