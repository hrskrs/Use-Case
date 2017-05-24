package com.hrskrs.stealthymvp.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by hrskrs on 5/24/2017.
 */

@Parcel
public class ProfileDetail {

  @SerializedName("id")
  private long id;
  @SerializedName("first_name")
  private String firstName;
  @SerializedName("last_name")
  private String lastName;
  @SerializedName("profile_picture")
  private String profilePictureUrl;

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
