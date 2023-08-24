package com.mjc.stage2.entity;

public abstract class AbstractTextComponent {
    protected TextComponentType componentType;

    public AbstractTextComponent(TextComponentType componentType) {
        this.componentType = componentType;
    }

    public abstract String operation();

    public abstract void add(AbstractTextComponent textComponent);

    public abstract void remove(AbstractTextComponent textComponent);

    public TextComponentType getComponentType() {
        return componentType;
    }

    public abstract int getSize();
}
