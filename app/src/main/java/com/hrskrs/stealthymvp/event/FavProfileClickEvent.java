package com.hrskrs.stealthymvp.event;

import com.hrskrs.stealthymvp.model.Profile;

/**
 * Created by hrskrs on 5/24/2017.
 */

public class FavProfileClickEvent {

  private Type type;
  private Profile profile;

  public enum Type{
    INSERT,
    DELETE
  }

  public FavProfileClickEvent(Type type, Profile profile) {
    this.type = type;
    this.profile = profile;
  }

  public Type getType() {
    return type;
  }

  public Profile getProfile() {
    return profile;
  }
}
