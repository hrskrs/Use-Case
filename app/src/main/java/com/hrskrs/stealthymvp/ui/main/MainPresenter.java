package com.hrskrs.stealthymvp.ui.main;

import com.hrskrs.stealthymvp.ui.base.BasePresenter;
import com.hrskrs.stealthymvp.ui.base.BaseView;

import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by hrskrs on 5/24/2017.
 */

public interface MainPresenter<V extends BaseView> extends BasePresenter<V>{

  void getProfiles();

  void getProfileDetails(@NotNull long id);
}
