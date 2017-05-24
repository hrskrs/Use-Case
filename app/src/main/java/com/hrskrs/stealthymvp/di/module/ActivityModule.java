package com.hrskrs.stealthymvp.di.module;

import android.app.Activity;
import android.content.Context;

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

  @Provides
  QuotesPresenter<QuotesView> provideQuotesPresenter(
      QuotesPresenterImp<QuotesView> quotesPresenterImp) {
    return quotesPresenterImp;
  }
}
