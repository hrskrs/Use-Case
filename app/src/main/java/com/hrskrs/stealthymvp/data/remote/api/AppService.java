package com.hrskrs.stealthymvp.data.remote.api;

import com.hrskrs.stealthymvp.model.Profile;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by hrskrs on 3/18/2017.
 */

public interface AppService {

  @GET("profiles")
  Observable<ArrayList<Profile>> getProfiles();
}
