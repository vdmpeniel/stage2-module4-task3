package com.mjc.stage2.entity;

import java.util.Objects;

public class SymbolLeaf extends AbstractTextComponent{

    private char value;



    public SymbolLeaf(TextComponentType textComponentType, char value){
        super(textComponentType);
        this.value = value;
    }

    @Override
    public String operation() {
        return String.valueOf(value);
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        return Objects.nonNull(Character.valueOf(value))  ? 1 : 0;
    }

    // Write your code here!
}
