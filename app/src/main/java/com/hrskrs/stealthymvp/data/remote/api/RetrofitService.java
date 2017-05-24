package com.hrskrs.stealthymvp.data.remote.api;

import com.hrskrs.stealthymvp.model.Profile;
import com.hrskrs.stealthymvp.model.ProfileDetail;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hrskrs on 3/18/2017.
 */

public interface RetrofitService {

  @GET("profiles")
  Observable<ArrayList<Profile>> getProfiles();

  @GET("profiles/{id}")
  Observable<ProfileDetail> getProfileDetails(@Path("id") long id);
}
