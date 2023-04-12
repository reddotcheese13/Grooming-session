package com.sapient.model;

import static com.sapient.model.Role.*;

public enum TechStack {
    JAVA(8,MANAGER),
    SAP(4,SRASSOCIATE),
    QA(3,ASSOCIATE);

    public int getExperience() {
        return experience;
    }

    public Role getRole() {
        return role;
    }

    private final int experience;
    private final Role role;

    TechStack(int experience, Role role){

        this.experience = experience;
        this.role = role;
    }
}
