package com.squad.project.spring.Enum;

public enum OrderStatus {
    ACCEPTED(0 ),READY_TO_COOK(1), COOKING(2), FINISHED(3);

    private int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getIntValue() {
        return value;
    }
}
