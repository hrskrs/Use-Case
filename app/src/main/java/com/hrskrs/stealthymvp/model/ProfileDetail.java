package com.hrskrs.stealthymvp.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by hrskrs on 5/24/2017.
 */

@Parcel
public class ProfileDetail {

  @SerializedName("id")
  long id;
  @SerializedName("first_name")
  String firstName;
  @SerializedName("last_name")
  String lastName;
  @SerializedName("profile_picture")
  String profilePictureUrl;

  public long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getProfilePictureUrl() {
    return profilePictureUrl;
  }
}
