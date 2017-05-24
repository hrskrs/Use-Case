package com.hrskrs.stealthymvp.data;

import com.hrskrs.stealthymvp.model.Profile;
import com.hrskrs.stealthymvp.model.ProfileDetail;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by hrskrs on 4/28/2017.
 */
public interface DataManger {

  Observable<ArrayList<Profile>> getProfiles();

  Observable<ProfileDetail> getProfileDetails(@NotNull long id);

  Observable<Long> addProfile(Profile profile);

  Observable<Boolean> deleteProfile(Profile profile);
}
