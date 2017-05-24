package com.hrskrs.stealthymvp.event;

/**
 * Created by hrskrs on 5/24/2017.
 */

public class ProfileClickEvent {

  private long id;

  public ProfileClickEvent(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }
}
