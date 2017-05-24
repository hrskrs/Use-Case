package com.hrskrs.stealthymvp.data.remote.api;


import com.hrskrs.stealthymvp.model.Profile;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by hrskrs on 4/7/2017.
 */
public class ApiMangerImp implements ApiManger {

  private AppService retrofitQuoteService;

  @Inject
  public ApiMangerImp(Retrofit retrofit) {
    this.retrofitQuoteService = retrofit.create(AppService.class);
  }

  @Override
  public Observable<ArrayList<Profile>> getProfiles() {
    return retrofitQuoteService.getProfiles();
  }
}
