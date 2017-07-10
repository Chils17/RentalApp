package com.webmyne.rentalapp.custom;

import android.app.Application;

import com.google.gson.Gson;

/**
 * Created by sagartahelyani on 27-12-2016.
 */

public class MyApplication extends Application {

    private static Gson gson;

    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        initGson();

    }

    private void initGson() {
        gson = new Gson();
    }

    public static Gson getGson() {
        return gson;
    }

    /**
     * @return ApplicationController singleton instance
     */
    public static synchronized MyApplication getInstance() {
        return sInstance;
    }

}
