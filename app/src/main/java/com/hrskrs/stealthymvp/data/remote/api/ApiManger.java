package com.hrskrs.stealthymvp.data.remote.api;


import com.hrskrs.stealthymvp.model.Profile;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by hrskrs on 4/7/2017.
 */
public interface ApiManger {

  Observable<ArrayList<Profile>> getProfiles();

}
