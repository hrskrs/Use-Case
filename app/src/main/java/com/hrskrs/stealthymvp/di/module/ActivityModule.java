package com.hrskrs.stealthymvp.di.module;

import android.app.Activity;
import android.content.Context;

import com.hrskrs.stealthymvp.di.ActivityContext;
import com.hrskrs.stealthymvp.di.ActivityScope;
import com.hrskrs.stealthymvp.ui.main.MainPresenter;
import com.hrskrs.stealthymvp.ui.main.MainPresenterImp;
import com.hrskrs.stealthymvp.ui.main.MainView;
import com.hrskrs.stealthymvp.util.rx.scheduler.SchedulerProvider;
import com.hrskrs.stealthymvp.util.rx.scheduler.SchedulerProviderImp;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by hrskrs on 4/28/2017.
 */

@Module
public class ActivityModule {

  private Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  @Provides
  CompositeDisposable provideCompositeDisposable() {
    return new CompositeDisposable();
  }

  @Provides
  SchedulerProvider provideSchedulerProvider() {
    return new SchedulerProviderImp();
  }

  @Provides
  @ActivityContext
  Context provideContext() {
    return activity;
  }

  @Provides
  Activity provideActivity() {
    return activity;
  }

  @Provides
  @ActivityScope
  MainPresenter<MainView> provideMainPresenter(MainPresenterImp<MainView> presenterImp) {
    return presenterImp;
  }
}
