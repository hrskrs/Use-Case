package com.hrskrs.stealthymvp;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.hrskrs.stealthymvp.di.component.AppComponent;
import com.hrskrs.stealthymvp.di.component.DaggerAppComponent;
import com.hrskrs.stealthymvp.di.module.AppModule;
import com.hrskrs.stealthymvp.di.module.NetworkModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by hrskrs on 5/24/2017.
 */

public class App extends Application {

  private AppComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    initApplicationComponent();

    if (BuildConfig.DEBUG) {
      Stetho.initializeWithDefaults(this);
      LeakCanary.install(this);
    }
  }

  private void initApplicationComponent() {
    applicationComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .networkModule(new NetworkModule(BuildConfig.ENDPOINT_URL))
        .build();
    applicationComponent.inject(this);
  }

  public AppComponent getAppComponent() {
    return applicationComponent;
  }

}
