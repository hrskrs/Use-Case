package com.hrskrs.stealthymvp.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.hrskrs.stealthymvp.event.FavProfileClickEvent;
import com.hrskrs.stealthymvp.event.ProfileClickEvent;
import com.hrskrs.stealthymvp.model.Profile;
import com.hrskrs.stealthymvp.model.ProfileDetail;
import com.hrskrs.stealthymvp.ui.base.BaseActivity;
import com.hrskrs.stealthymvp.ui.main.profile.ProfilesFragment;
import com.hrskrs.stealthymvp.ui.main.profile_details.ProfileDetailsFragment;
import com.hrskrs.stealthymvp.util.rx.RxEventBus;

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

    RxEventBus.getInstance().getEvents().subscribe(o -> {
      if (o instanceof FavProfileClickEvent) {
        FavProfileClickEvent event = ((FavProfileClickEvent) o);
        switch (event.getType()) {
          case INSERT:
//            mainPresenter.addProfile(event.getProfile());
            break;
          case DELETE:
//            mainPresenter.deleteProfile(event.getProfile());
            break;
          default:
            break;
        }
      } else if (o instanceof ProfileClickEvent) {
        ProfileClickEvent event = (ProfileClickEvent) o;
        mainPresenter.getProfileDetails(event.getId());
      }
    });
  }

  @Override
  public void onProfilesLoaded(ArrayList<Profile> profiles) {
    addFragment(ProfilesFragment.newInstance(profiles));
  }

  @Override
  public void onProfileDetailsLoaded(ProfileDetail profileDetail) {
    replaceFragment(ProfileDetailsFragment.newInstance(profileDetail), true);
  }

  @Override
  protected void onDestroy() {
    mainPresenter.onDetach();
    super.onDestroy();
  }
}
