package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TextComponent extends AbstractTextComponent {
    protected List<AbstractTextComponent> componentList = new ArrayList<>();


    public TextComponent(TextComponentType textComponentType){
        super(textComponentType);
    }

    @Override
    public String operation() {
        return componentList.stream().map(AbstractTextComponent::operation).collect(Collectors.joining(this.componentType.getDelimiter()));
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        componentList.add(textComponent);
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        componentList.remove(textComponent);
    }

    @Override
    public int getSize() {
        return componentList.size();
    }

}
