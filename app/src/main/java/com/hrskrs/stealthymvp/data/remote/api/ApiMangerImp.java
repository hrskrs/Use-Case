package com.hrskrs.stealthymvp.data.remote.api;


import com.hrskrs.stealthymvp.model.Profile;
import com.hrskrs.stealthymvp.model.ProfileDetail;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by hrskrs on 4/7/2017.
 */
public class ApiMangerImp implements ApiManger {

  private RetrofitService retrofitService;

  @Inject
  public ApiMangerImp(Retrofit retrofit) {
    this.retrofitService = retrofit.create(RetrofitService.class);
  }

  @Override
  public Observable<ArrayList<Profile>> getProfiles() {
    return retrofitService.getProfiles();
  }

  @Override
  public Observable<ProfileDetail> getProfileDetails(long id) {
    return retrofitService.getProfileDetails(id);
  }
}
