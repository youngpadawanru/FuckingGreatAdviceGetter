package com.example.user.fuckinggreatadvicegetter;


import java.util.UUID;

import io.realm.RealmObject;

public class Advice extends RealmObject {

    private String advice;
    private String id;

    public Advice() {
        this(UUID.randomUUID().toString());
    }

    public Advice(String inId) {
        id = inId;
    }

    public String getId() {
        return id;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
