package me.wcy.music.application;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import me.wcy.music.service.PlayService;
import me.wcy.music.storage.db.DBManager;

/**
 * 自定义Application
 *
 */
public class MusicApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppCache.get().init(this);
        ForegroundObserver.init(this);
        DBManager.get().init(this);

        Intent intent = new Intent(this, PlayService.class);
        startService(intent);
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
