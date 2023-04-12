package com.sapient.model;

public enum Role {
    ASSOCIATE(20),
    SRASSOCIATE(30),
    MANAGER(45);

    public double getIncrement() {
        return increment;
    }

    private final double increment;

    Role(double increment) {
        this.increment=increment;
    }
}
