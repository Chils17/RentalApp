package crashreport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class QuickCrashReportInitClass {
    public static void init(Context mContext, Class<?> aClass) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
            @Override
            public void uncaughtException(Thread paramThread, Throwable paramThrowable)
            {
                Intent intent = mContext.getPackageManager().getLaunchIntentForPackage("com.webmyne.rentalapp");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("CRASHED", true);
                intent.putExtra("EXCEPTION", paramThrowable);
                mContext.startActivity(intent);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }
        });
    }
}
