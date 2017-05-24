package com.hrskrs.stealthymvp.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.hrskrs.stealthymvp.model.Profile;
import com.hrskrs.stealthymvp.ui.base.BaseActivity;
import com.hrskrs.stealthymvp.ui.main.profile.ProfilesFragment;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by hrskrs on 5/24/2017.
 */

public class MainActivity extends BaseActivity implements MainView {

  @Inject
  MainPresenter<MainView> mainPresenter;

  @Override
  protected void setupToolbar(Toolbar toolbar) {

  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivityComponent().inject(this);
    if (savedInstanceState == null) {
      mainPresenter.onAttach(this);
      mainPresenter.getProfiles();
    }
  }

  @Override
  public void onProfilesLoaded(ArrayList<Profile> profiles) {
    addFragment(ProfilesFragment.newInstance(profiles));
  }
}
