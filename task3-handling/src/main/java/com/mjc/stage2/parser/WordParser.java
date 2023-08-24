package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.tokenizer.impl.TokenizerImpl;

public class WordParser extends AbstractTextParser{

    private static final String WORD_REGEX = "\\S"; //""[\\w!=?()\\.':]";


    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        TokenizerImpl.getMatches(WORD_REGEX, string)
            .forEach(part -> {
                abstractTextComponent.add(new SymbolLeaf(null, part.charAt(0)));
            });
    }
}


