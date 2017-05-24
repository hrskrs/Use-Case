package com.hrskrs.stealthymvp.di.component;


/**
 * Created by hrskrs on 4/28/2017.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  void inject(MainActivity activity);

}
