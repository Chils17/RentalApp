package com.webmyne.rentalapp;

import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.google.gson.Gson;
import com.webmyne.rentalapp.helper.AppDebug;

/**
 * Created by chintans on 11-07-2017.
 */

public class RentalApplication extends MultiDexApplication {
    /**
     * The constant context.
     */
    private Context context;
    private static RentalApplication mInstance;
    private static Gson gson;

    public static synchronized RentalApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        mInstance = this;
        initGson();
        if (!new AppDebug().isDebuggable(this))
        {
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
            {
                @Override
                public void uncaughtException(Thread paramThread, Throwable paramThrowable)
                {
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.webmyne.rentalapp");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("CRASHED", true);
                    intent.putExtra("EXCEPTION", paramThrowable);
                    startActivity(intent);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(0);
                }
            });
        }
    }

    private void initGson() {
        gson = new Gson();
    }

    public static Gson getGson() {
        return gson;
    }

    @Override
    protected void attachBaseContext(Context base)
    {
        super.attachBaseContext(base);
        MultiDex.install(this);
        MultiDex.install(mInstance);
    }
}