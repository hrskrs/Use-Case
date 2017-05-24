package com.hrskrs.stealthymvp.data.local;

import android.support.annotation.NonNull;

import com.hrskrs.stealthymvp.model.DaoMaster;
import com.hrskrs.stealthymvp.model.DaoSession;
import com.hrskrs.stealthymvp.model.Profile;

import java.util.concurrent.Callable;

import javax.inject.Inject;

/**
 * Created by hrskrs on 4/28/2017.
 */
public class DbManagerImp implements DbManager {

  private final DaoSession daoSession;

  @Inject
  public DbManagerImp(DbOpenHelper dbOpenHelper) {
    daoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
  }

  @Override
  public Callable<Long> insertProfile(@NonNull Profile quote) {
    return () -> daoSession.getProfileDao().insert(quote);
  }

  @Override
  public Callable<Boolean> deleteProfile(@NonNull long id) {
    return () -> {
      daoSession.getProfileDao().deleteByKey(id);
      return true;
    };
  }

}
