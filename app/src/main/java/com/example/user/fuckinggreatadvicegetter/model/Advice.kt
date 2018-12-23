package com.example.user.fuckinggreatadvicegetter.model

import io.realm.RealmObject
import java.util.*

open class Advice(var id: String) : RealmObject() {
    constructor() : this(UUID.randomUUID().toString())

    var text = ""
}