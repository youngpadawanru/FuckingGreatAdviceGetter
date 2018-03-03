package com.example.user.fuckinggreatadvicegetter;

import io.realm.Realm;

class DBController {

    private Realm realm;

    public void add(String string) {
        Advice advice = new Advice();
        advice.setText(string);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(advice);
        realm.commitTransaction();
        realm.close();
    }

    public void remove(String id) {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        try {
            realm.where(Advice.class).equalTo("id", id).findFirst().deleteFromRealm();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        realm.commitTransaction();
        realm.close();
    }
}