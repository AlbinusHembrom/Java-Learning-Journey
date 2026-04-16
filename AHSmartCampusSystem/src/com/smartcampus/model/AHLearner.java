package com.smartcampus.model;

import java.io.Serializable;

public class AHLearner implements Serializable {
    private int ahId;
    private String ahName;
    private String ahEmail;

    public AHLearner(int id, String name, String email) {
        this.ahId = id;
        this.ahName = name;
        this.ahEmail = email;
    }

    public int getId() { return ahId; }
    public String getName() { return ahName; }

    @Override
    public String toString() {
        return "Learner[ID=" + ahId + ", Name=" + ahName + "]";
    }
}