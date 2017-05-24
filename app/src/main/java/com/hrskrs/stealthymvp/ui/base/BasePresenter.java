package com.hrskrs.stealthymvp.ui.base;

/**
 * Created by hrskrs on 3/20/2017.
 */

public interface BasePresenter<V extends BaseView> {

  void onAttach(V view);

  void onDetach();
}
