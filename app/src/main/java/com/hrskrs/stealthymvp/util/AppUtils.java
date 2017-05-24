package com.hrskrs.stealthymvp.util;

import java.util.List;

/**
 * Created by hrskrs on 3/20/2017.
 */

public final class AppUtils {
  public static final String DB_NAME = "StealthyMvp.db";
  public static final int RETRY_NETWORK_REQUEST_COUNT = 3;

  private AppUtils() {
    throw new AssertionError();
  }

  public static <T> boolean isListEmpty(List<T> list) {
    return list == null || list.size() <= 0;
  }

}
