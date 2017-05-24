package com.hrskrs.stealthymvp.data;

import com.hrskrs.stealthymvp.model.Profile;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by hrskrs on 4/28/2017.
 */
public interface DataManger {

  Observable<ArrayList<Profile>> getProfiles();
}
