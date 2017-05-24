package com.hrskrs.stealthymvp.di.component;

import android.app.Application;
import android.content.Context;

import com.hrskrs.stealthymvp.di.module.AppModule;
import com.hrskrs.stealthymvp.di.module.NetworkModule;

/**
 * Created by hrskrs on 4/28/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

  void inject(App app);

  @ApplicationContext Context context();

  Application application();

  DataManger dataManger();
}
