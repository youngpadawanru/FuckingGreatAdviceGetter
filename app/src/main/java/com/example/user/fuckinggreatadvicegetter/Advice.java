package com.example.user.fuckinggreatadvicegetter;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import io.realm.RealmObject;

public class Advice extends RealmObject {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("sound")
    @Expose
    private String sound;

    public Advice() {
        this(UUID.randomUUID().toString());
    }

    public Advice(String inId) {
        id = inId;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String advice) {
        this.text = advice;
    }
}