package com.hrskrs.stealthymvp.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hrskrs.stealthymvp.di.component.ActivityComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hrskrs on 7/14/2016.
 */
public abstract class BaseFragment extends Fragment implements BaseView {

  private BaseActivity baseActivity;
  private Unbinder unbinder;

  @LayoutRes
  protected abstract int getContentLayoutResId();

  protected abstract void setupToolbar(Toolbar toolbar);

  protected abstract void populateUI(LayoutInflater inflater,
                                     View rootView,
                                     Bundle savedInstanceState);

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof BaseActivity) {
      this.baseActivity = (BaseActivity) context;
//      this.baseActivity.onFragmentAttached();
    }
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater,
                           @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(getContentLayoutResId(), container, false);
    unbinder = ButterKnife.bind(this, rootView);
    if (baseActivity != null) {
      setupToolbar(baseActivity.toolbar);
    }
    populateUI(inflater, rootView, savedInstanceState);
    return rootView;
  }

  protected ActivityComponent getActivityComponent() {
    return baseActivity.getActivityComponent();
  }

  protected void addFragment(@NonNull Fragment fragment) {
    if (baseActivity != null) {
      baseActivity.addFragment(fragment);
    }
  }

  protected void replaceFragment(@NonNull Fragment fragment) {
    if (baseActivity != null) {
      baseActivity.replaceFragment(fragment);
    }
  }

  @Override
  public void onDestroyView() {
    if (unbinder != null) {
      unbinder.unbind();
    }
    super.onDestroyView();
  }

  @Override
  public void onDetach() {
    baseActivity = null;
    super.onDetach();
  }

  @Override
  public void showLoading(String message) {
    if (baseActivity != null) {
      baseActivity.showLoading(message);
    }
  }

  @Override
  public void showLoading() {
    if (baseActivity != null) {
      baseActivity.showLoading();
    }
  }

  @Override
  public void hideLoading() {
    if (baseActivity != null) {
      baseActivity.hideLoading();
    }
  }

  @Override
  public void onUnknownError(String error) {
    if (baseActivity != null) {
      baseActivity.onUnknownError(error);
    }
  }

  @Override
  public void onNetworkError() {
    if (baseActivity != null) {
      baseActivity.onNetworkError();
    }
  }

  @Override
  public void onTimeout() {
    if (baseActivity != null) {
      baseActivity.onTimeout();
    }
  }

  @Override
  public boolean isNetworkConnected() {
    if (baseActivity != null) {
      baseActivity.isNetworkConnected();
    }
    return false;
  }

  @Override
  public void onConnectionError() {
    if (baseActivity != null) {
      baseActivity.onConnectionError();
    }
  }
}
