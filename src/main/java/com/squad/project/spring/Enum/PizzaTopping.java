package com.squad.project.spring.Enum;

public enum PizzaTopping {
    MUSHROOMS(0), ONIONS(1), OLIVES(2), XTRACHEESE(3);

    private final int value;

    PizzaTopping(int value) {
        this.value = value;
    }

    public int getIntValue() {
        return value;
    }
}
