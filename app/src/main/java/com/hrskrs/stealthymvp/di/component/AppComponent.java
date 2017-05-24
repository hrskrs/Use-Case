package com.hrskrs.stealthymvp.di.component;

import android.app.Application;
import android.content.Context;

import com.hrskrs.stealthymvp.App;
import com.hrskrs.stealthymvp.data.DataManger;
import com.hrskrs.stealthymvp.di.ApplicationContext;
import com.hrskrs.stealthymvp.di.module.AppModule;
import com.hrskrs.stealthymvp.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hrskrs on 4/28/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

  void inject(App app);

  @ApplicationContext
  Context context();

  Application application();

  DataManger dataManger();
}
