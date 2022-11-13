package com.squad.project.spring.Enum;

public enum PizzaType {
    Cheese(0), Vegetable(1), Pepperoni(2);

    private final int value;

    PizzaType(int value) {
        this.value = value;
    }

    public int getIntValue() {
        return this.value;
    }

}
