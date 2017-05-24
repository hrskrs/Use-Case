package com.hrskrs.stealthymvp.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.parceler.Parcel;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by hrskrs on 5/24/2017.
 */

@Parcel
@Entity(nameInDb = "profile")
public class Profile {

  @SerializedName("id")
  @Id
  @NotNull
  long id;

  @SerializedName("profile_picture")
  @Property(nameInDb = "url")
  @NotNull
  String profilePictureUrl;

  @Generated(hash = 1834387028)
  public Profile(long id, @NotNull String profilePictureUrl) {
      this.id = id;
      this.profilePictureUrl = profilePictureUrl;
  }

  @Generated(hash = 782787822)
  public Profile() {
  }

  public long getId() {
    return id;
  }

  public String getProfilePictureUrl() {
    return profilePictureUrl;
  }

  public void setId(long id) {
      this.id = id;
  }

  public void setProfilePictureUrl(String profilePictureUrl) {
      this.profilePictureUrl = profilePictureUrl;
  }
}
