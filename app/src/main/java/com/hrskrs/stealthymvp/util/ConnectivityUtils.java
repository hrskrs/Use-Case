package com.hrskrs.stealthymvp.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by hrskrs on 7/18/2016.
 */
public final class ConnectivityUtils {

  private ConnectivityUtils() {
  }

  public static boolean isConnectedToInternet(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context
        .getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo ni = cm.getActiveNetworkInfo();
    return ni != null && ni.isConnected() && ni.isAvailable();
  }

  public static boolean isWifiEnabled(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context
        .getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo ni = cm.getActiveNetworkInfo();
    if (ni != null && ni.getType() == ConnectivityManager.TYPE_WIFI) {
      return true;
    }
    return false;
  }

  public static boolean isMobileDataEnabled(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context
        .getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo ni = cm.getActiveNetworkInfo();
    if (ni != null && ni.getType() == ConnectivityManager.TYPE_MOBILE) {
      return true;
    }
    return false;
  }

}
