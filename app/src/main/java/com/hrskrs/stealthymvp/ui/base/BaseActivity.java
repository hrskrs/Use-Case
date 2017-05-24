package com.hrskrs.stealthymvp.ui.base;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hrskrs.stealthymvp.App;
import com.hrskrs.stealthymvp.R;
import com.hrskrs.stealthymvp.di.component.ActivityComponent;
import com.hrskrs.stealthymvp.di.component.DaggerActivityComponent;
import com.hrskrs.stealthymvp.di.module.ActivityModule;
import com.hrskrs.stealthymvp.util.ConnectivityUtils;
import com.hrskrs.stealthymvp.util.DialogUtils;
import com.hrskrs.stealthymvp.util.FragmentTransactionUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hrskrs on 7/14/2016.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

  @BindView(R.id.toolbar)
  protected Toolbar toolbar;

  private Unbinder unbinder;
  private ActivityComponent activityComponent;
  protected Dialog progressDialog;

  @LayoutRes
  protected int getContentViewLayoutResId() {
    return R.layout.activity_base;
  }

  @IdRes
  protected int getFragmentContainerId() {
    return R.id.fragment_container;
  }

  protected abstract void setupToolbar(Toolbar toolbar);

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getContentViewLayoutResId());
    initActivityComponent();
    unbinder = ButterKnife.bind(this);
    initToolbar();
  }

  private void initActivityComponent() {
    activityComponent = DaggerActivityComponent.builder()
        .appComponent(((App) getApplication()).getAppComponent())
        .activityModule(new ActivityModule(this))
        .build();
  }

  protected ActivityComponent getActivityComponent() {
    return activityComponent;
  }

  private void initToolbar() {
    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayShowTitleEnabled(true);
    }
    setupToolbar(toolbar);
  }

  protected void addFragment(@NonNull Fragment fragment) {
    addFragment(fragment, false);
  }

  protected void addFragment(@NonNull Fragment fragment, boolean addToBackStack) {
    FragmentTransactionUtil.addFragment(getSupportFragmentManager(),
        fragment, getFragmentContainerId(), addToBackStack);
  }

  protected void replaceFragment(@NonNull Fragment fragment) {
    replaceFragment(fragment, false);
  }

  protected void replaceFragment(@NonNull Fragment fragment, boolean addToBackStack) {
    FragmentTransactionUtil.replaceFragment(getSupportFragmentManager(),
        fragment, getFragmentContainerId(), addToBackStack);
  }

  @TargetApi(Build.VERSION_CODES.M)
  public void requestPermissionsSafely(String[] permissions, int requestCode) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      requestPermissions(permissions, requestCode);
    }
  }

  @TargetApi(Build.VERSION_CODES.M)
  public boolean hasPermission(String permission) {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
        checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
  }

  @Override
  public void showLoading(String message) {
    progressDialog = DialogUtils.showLoading(this, message);
  }

  @Override
  public void showLoading() {
    progressDialog = DialogUtils.showLoading(this);
  }

  @Override
  public void hideLoading() {
    if (progressDialog != null && progressDialog.isShowing()) {
      progressDialog.cancel();
    }
    progressDialog = null;
  }

  @Override
  public void onUnknownError(@NonNull String error) {
    hideLoading();
    //Todo: show error view
  }

  @Override
  public void onNetworkError() {
    hideLoading();
    //Todo: show network error view
  }

  @Override
  public void onTimeout() {
    hideLoading();
  }

  @Override
  public boolean isNetworkConnected() {
    return ConnectivityUtils.isConnectedToInternet(this);
  }

  @Override
  public void onConnectionError() {
    //TODO: show connection error
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override
  protected void onDestroy() {
    if (unbinder != null) {
      unbinder.unbind();
    }
    activityComponent = null;
    super.onDestroy();
  }

}
