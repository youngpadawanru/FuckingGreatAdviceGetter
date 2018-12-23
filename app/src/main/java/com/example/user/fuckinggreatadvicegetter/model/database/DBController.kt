package com.example.user.fuckinggreatadvicegetter.model.database

import com.example.user.fuckinggreatadvicegetter.model.Advice
import io.realm.Realm
import io.realm.RealmResults

class DBController {

    fun add(advice: Advice) {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealm(advice)
        realm.commitTransaction()
        realm.close()
    }

    fun remove(id: String) {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.where(Advice::class.java).equalTo("id", id).findFirst()?.deleteFromRealm()
        realm.commitTransaction()
        realm.close()
    }

    fun findAll(): RealmResults<Advice>? {
        val realm = Realm.getDefaultInstance()
        return realm.where(Advice::class.java).findAll()
    }
}