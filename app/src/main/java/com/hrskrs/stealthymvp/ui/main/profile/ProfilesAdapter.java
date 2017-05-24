package com.hrskrs.stealthymvp.ui.main.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hrskrs.stealthymvp.R;
import com.hrskrs.stealthymvp.model.Profile;
import com.hrskrs.stealthymvp.ui.base.BaseRecyclerView;
import com.hrskrs.stealthymvp.ui.base.BaseViewHolder;
import com.hrskrs.stealthymvp.util.ImageUtils;
import com.hrskrs.stealthymvp.view.HKImageView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by hrskrs on 5/24/2017.
 */

public class ProfilesAdapter extends BaseRecyclerView<Profile> {

  private LayoutInflater inflater;
  private ArrayList<Profile> profiles;

  public ProfilesAdapter(Context context, ArrayList<Profile> profiles) {
    this.inflater = LayoutInflater.from(context);
    this.profiles = profiles;
  }

  @Override
  protected Profile getItem(int position) {
    return profiles.get(position);
  }

  @Override
  public BaseViewHolder<Profile> onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ProfileViewHolder(inflater.inflate(R.layout.item_profile, parent, false));
  }

  @Override
  public int getItemCount() {
    return profiles.size();
  }

  static class ProfileViewHolder extends BaseViewHolder<Profile>{

    @BindView(R.id.item_profile_image)
    HKImageView profileImage;

    public ProfileViewHolder(View itemView) {
      super(itemView);
    }

    @Override
    public void populateItem(Profile profile) {
      ImageUtils.loadImage(itemView.getContext(), profile.getProfilePictureUrl(), profileImage);
    }
  }
}
