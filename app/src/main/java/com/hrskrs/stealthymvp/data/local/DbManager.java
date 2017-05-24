package com.hrskrs.stealthymvp.data.local;

import com.hrskrs.stealthymvp.model.Profile;

import java.util.concurrent.Callable;

/**
 * Created by hrskrs on 4/28/2017.
 */

public interface DbManager {
  Callable<Long> insertProfile(Profile profile);

  Callable<Boolean> deleteProfile(long id);
}
