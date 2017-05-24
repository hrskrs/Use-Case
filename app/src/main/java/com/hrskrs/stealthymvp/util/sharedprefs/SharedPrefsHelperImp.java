package com.hrskrs.stealthymvp.util.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.hrskrs.stealthymvp.di.ApplicationContext;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by hrskrs on 4/7/2017.
 */
public class SharedPrefsHelperImp<T> implements SharedPrefsHelper<T> {

  private SharedPreferences sharedPreferences;
  private Gson gson;

  @Inject
  public SharedPrefsHelperImp(@ApplicationContext Context context, Gson gson) {
    this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    this.gson = gson;
  }

  @Override
  public Observable<T> put(String key, T value) {
    return Observable.fromCallable(() -> {
      sharedPreferences.edit().putString(key, gson.toJson(value)).apply();
      return value;
    });
  }

  @Override
  public Observable<T> get(String key, Class<T> generic) {
    return Observable.fromCallable(() -> {
      String json = sharedPreferences.getString(key, "");
      return gson.fromJson(json, generic);
    });
  }

  @Override
  public Observable<Boolean> clear() {
    return Observable.fromCallable(() -> {
      sharedPreferences.edit().clear().apply();
      return true;
    });
  }

  @Override
  public Observable<Boolean> remove(String key) {
    return Observable.fromCallable(() -> {
      sharedPreferences.edit().remove(key).apply();
      return true;
    });
  }

}
