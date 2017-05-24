package com.hrskrs.stealthymvp.di.component;


import com.hrskrs.stealthymvp.di.ActivityScope;
import com.hrskrs.stealthymvp.di.module.ActivityModule;
import com.hrskrs.stealthymvp.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by hrskrs on 4/28/2017.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  void inject(MainActivity activity);

}
