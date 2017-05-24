package com.hrskrs.stealthymvp.util.sharedprefs;

import io.reactivex.Observable;

/**
 * Created by hrskrs on 4/7/2017.
 */

public interface SharedPrefsHelper<T> {

  Observable<T> put(String key, T value);

  Observable<T> get(String key, Class<T> generic);

  Observable<Boolean> clear();

  Observable<Boolean> remove(String key);
}
