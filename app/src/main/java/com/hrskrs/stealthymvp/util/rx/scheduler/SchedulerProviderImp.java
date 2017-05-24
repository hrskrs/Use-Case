package com.hrskrs.stealthymvp.util.rx.scheduler;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hrskrs on 5/8/2017.
 */

public class SchedulerProviderImp implements SchedulerProvider {

  @Override
  public Scheduler ui() {
    return AndroidSchedulers.mainThread();
  }

  @Override
  public Scheduler computation() {
    return Schedulers.computation();
  }

  @Override
  public Scheduler io() {
    return Schedulers.io();
  }
}
