package com.webmyne.rentalapp.helper;

import android.util.Log;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * The type Log utils.
 */
public class LogUtils extends Logger
{
    private static String tingg = "RENTALAPP";

    /**
     * Instantiates a new Log utils.
     *
     * @param name               the name
     * @param resourceBundleName the resource bundle name
     */
    public LogUtils(String name, String resourceBundleName)
    {
        super(name, resourceBundleName);
    }

    /**
     * Show info.
     *
     * @param tag     the tag
     * @param message the message
     */
    public static void showInfo(String tag, String message)
    {
        Log.i(tag, message);
    }

    /**
     * Show info.
     *
     * @param message the message
     */
    public static void showInfo(String message)
    {

        showInfo(tingg, AppConstants.DEFAULT_STRING + message);
    }

    /**
     * Show error.
     *
     * @param tag     the tag
     * @param message the message
     */
    public static void showError(String tag, String message)
    {
        Log.e(tag, message);
    }

    /**
     * Show error.
     *
     * @param message the message
     */
    public static void showError(String message)
    {
        showError(tingg, AppConstants.DEFAULT_STRING + message);
    }

    /**
     * just a blank method.
     *
     * @param objects the objects
     */
    public static void showMessage(Object... objects)
    {
        showError(tingg, Arrays.toString(objects));
    }
}
