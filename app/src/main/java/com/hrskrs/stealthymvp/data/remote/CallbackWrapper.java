package com.hrskrs.stealthymvp.data.remote;

import com.hrskrs.stealthymvp.data.remote.responses.BaseResponse;
import com.hrskrs.stealthymvp.ui.base.BaseView;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;

/**
 * Created by hrskrs on 3/20/2017.
 *
 * DisposableObserver wrapper for handling errors on a single place
 */
public abstract class CallbackWrapper<T extends BaseResponse> extends DisposableObserver<T> {

  private BaseView view;

  public CallbackWrapper(BaseView view) {
    this.view = view;
  }

  @Override
  public void onNext(T t) {
    onSuccess(t);
  }

  @Override
  public void onError(Throwable t) {
    if (t instanceof HttpException) {
      ResponseBody responseBody = ((HttpException) t).response().errorBody();
      view.onUnknownError(getErrorMessage(responseBody));
    } else if (t instanceof SocketTimeoutException) {
      view.onTimeout();
    } else if (t instanceof IOException) {
      view.onNetworkError();
    } else {
      view.onUnknownError(t.getMessage());
    }
  }

  @Override
  public void onComplete() {

  }

  protected abstract void onSuccess(T t);

  private String getErrorMessage(ResponseBody responseBody) {
    try {
      JSONObject jsonObject = new JSONObject(responseBody.string());
      return jsonObject.getString("message");
    } catch (Exception e) {
      return e.getMessage();
    }
  }
}
