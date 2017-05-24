package com.hrskrs.stealthymvp.ui.main.profile_details;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.hrskrs.stealthymvp.R;
import com.hrskrs.stealthymvp.model.ProfileDetail;
import com.hrskrs.stealthymvp.ui.base.BaseFragment;
import com.hrskrs.stealthymvp.util.ImageUtils;
import com.hrskrs.stealthymvp.view.HKImageView;
import com.hrskrs.stealthymvp.view.HKTextView;

import org.parceler.Parcels;

import butterknife.BindView;

/**
 * Created by hrskrs on 5/24/2017.
 */

public class ProfileDetailsFragment extends BaseFragment {

  private static final String KEY_PROFILE_DETAILS = "key.profile.details";

  @BindView(R.id.profile_details_full_name)
  HKTextView fullName;
  @BindView(R.id.profile_details_image)
  HKImageView image;

  public static ProfileDetailsFragment newInstance(ProfileDetail details) {
    Bundle b = new Bundle();
    b.putParcelable(KEY_PROFILE_DETAILS, Parcels.wrap(details));
    ProfileDetailsFragment fragment = new ProfileDetailsFragment();
    fragment.setArguments(b);
    return fragment;
  }

  @Override
  protected int getContentLayoutResId() {
    return R.layout.fragment_profile_details;
  }

  @Override
  protected void setupToolbar(Toolbar toolbar) {
    toolbar.setTitle(R.string.title_profile_details);
    toolbar.setNavigationIcon(R.drawable.ic_back);
  }

  @Override
  protected void populateUI(LayoutInflater inflater, View rootView, Bundle savedInstanceState) {
    ProfileDetail details = Parcels.unwrap(getArguments().getParcelable(KEY_PROFILE_DETAILS));
    ImageUtils.loadImage(getActivity(), details.getProfilePictureUrl(), image);
    fullName.setText(getString(R.string.full_name,
        details.getFirstName(),
        details.getLastName()));
  }
}
