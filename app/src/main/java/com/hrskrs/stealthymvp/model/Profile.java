package com.hrskrs.stealthymvp.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by hrskrs on 5/24/2017.
 */

@Parcel
public class Profile {

  @SerializedName("id")
  long id;
  @SerializedName("profile_picture")
  String profilePictureUrl;

  public long getId() {
    return id;
  }

  public String getProfilePictureUrl() {
    return profilePictureUrl;
  }
}
