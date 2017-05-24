package com.hrskrs.stealthymvp.ui.base;

/**
 * Created by hrskrs on 3/19/2017.
 */

public interface BaseView {
  void showLoading(String message);

  void showLoading();

  void hideLoading();

  void onUnknownError(String error);

  void onTimeout();

  void onNetworkError();

  boolean isNetworkConnected();

  void onConnectionError();
}
