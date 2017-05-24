package com.hrskrs.stealthymvp.ui.main.profile;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.hrskrs.stealthymvp.R;
import com.hrskrs.stealthymvp.model.Profile;
import com.hrskrs.stealthymvp.ui.base.BaseFragment;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by hrskrs on 5/24/2017.
 */

public class ProfilesFragment extends BaseFragment {

  private static final String KEY_PROFILES = "key.profiles";
  private static final int COL_SPAN = 2;

  @BindView(R.id.profiles_recyclerview)
  RecyclerView profilesRecyclerView;

  public static ProfilesFragment newInstance(ArrayList<Profile> profiles) {
    Bundle b = new Bundle();
    b.putParcelable(KEY_PROFILES, Parcels.wrap(profiles));
    ProfilesFragment fragment = new ProfilesFragment();
    fragment.setArguments(b);
    return fragment;
  }

  @Override
  protected int getContentLayoutResId() {
    return R.layout.fragment_profiles;
  }

  @Override
  protected void setupToolbar(Toolbar toolbar) {
    toolbar.setTitle(R.string.app_name);
    toolbar.setNavigationIcon(null);
  }

  @Override
  protected void populateUI(LayoutInflater inflater, View rootView, Bundle savedInstanceState) {
    ArrayList<Profile> profiles =
        Parcels.unwrap(getArguments().getParcelable(KEY_PROFILES));
    ProfilesAdapter adapter = new ProfilesAdapter(getActivity(), profiles);
    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), COL_SPAN);
    profilesRecyclerView.setLayoutManager(layoutManager);
    profilesRecyclerView.setAdapter(adapter);
  }
}
