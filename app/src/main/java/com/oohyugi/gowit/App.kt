package com.oohyugi.gowit

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration



/**
 * Created by oohyugi on 12/01/19.
 * github: https://github.com/oohyugi
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
//        val realmConfigurationconfig = RealmConfiguration.Builder().name(Realm.DEFAULT_REALM_NAME)
//            .schemaVersion(0)
//            .deleteRealmIfMigrationNeeded()
//            .build()
//        Realm.setDefaultConfiguration(realmConfigurationconfig)
    }
}