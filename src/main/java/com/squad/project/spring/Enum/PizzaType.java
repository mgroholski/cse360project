package com.squad.project.spring.Enum;

public enum PizzaType {
    CHEESE(0), VEGETABLE(1), PEPPERONI(2);

    private final int value;

    PizzaType(int value) {
        this.value = value;
    }

    public int getIntValue() {
        return this.value;
    }

}
