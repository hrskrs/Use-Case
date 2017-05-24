package com.hrskrs.stealthymvp.util.rx.scheduler;

import io.reactivex.Scheduler;

/**
 * Created by hrskrs on 5/8/2017.
 */

public interface SchedulerProvider {

  Scheduler ui();

  Scheduler computation();

  Scheduler io();
}
