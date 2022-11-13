package com.squad.project.spring.Enum;

public enum UserRole {
    Student(0), Chef(1);

    private final int value;

    UserRole(int value) {
        this.value = value;
    }

    public int getIntValue() {
        return this.value;
    }
}
