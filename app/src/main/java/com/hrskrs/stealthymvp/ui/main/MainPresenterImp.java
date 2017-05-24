package com.hrskrs.stealthymvp.ui.main;

import android.support.annotation.NonNull;

import com.hrskrs.stealthymvp.data.DataManger;
import com.hrskrs.stealthymvp.model.Profile;
import com.hrskrs.stealthymvp.model.ProfileDetail;
import com.hrskrs.stealthymvp.ui.base.BasePresenterImp;
import com.hrskrs.stealthymvp.util.rx.scheduler.SchedulerProvider;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by hrskrs on 5/24/2017.
 */

public class MainPresenterImp<V extends MainView>
    extends BasePresenterImp<V> implements MainPresenter<V> {

  @Inject
  protected MainPresenterImp(DataManger dataManger,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
    super(dataManger, schedulerProvider, compositeDisposable);
  }

  @Override
  public void getProfiles() {
    if (getView().isNetworkConnected()) {
      getView().showLoading();
      Disposable disposable = getDataManger().getProfiles()
          .subscribeOn(getSchedulerProvider().io())
          .observeOn(getSchedulerProvider().ui())
          .subscribeWith(new DisposableObserver<ArrayList<Profile>>() {
            @Override
            public void onNext(ArrayList<Profile> profiles) {
              if (!isViewAttached()) {
                return;
              }
              getView().onProfilesLoaded(profiles);
              getView().hideLoading();
            }

            @Override
            public void onError(Throwable e) {
              if (!isViewAttached()) {
                return;
              }
              getView().onUnknownError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
          });
      getCompositeDisposable().add(disposable);
    } else {
      getView().onConnectionError();
    }
  }

  @Override
  public void getProfileDetails(long id) {
    if (getView().isNetworkConnected()) {
      getView().showLoading();
      Disposable disposable = getDataManger().getProfileDetails(id)
          .subscribeOn(getSchedulerProvider().io())
          .observeOn(getSchedulerProvider().ui())
          .subscribeWith(new DisposableObserver<ProfileDetail>() {
            @Override
            public void onNext(ProfileDetail details) {
              if (!isViewAttached()) {
                return;
              }
              getView().onProfileDetailsLoaded(details);
              getView().hideLoading();
            }

            @Override
            public void onError(Throwable e) {
              if (!isViewAttached()) {
                return;
              }
              getView().onUnknownError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
          });
      getCompositeDisposable().add(disposable);
    } else {
      getView().onConnectionError();
    }
  }

  @Override
  public void addProfile(@NonNull Profile profile) {
    Disposable disposable = getDataManger().addProfile(profile)
        .subscribeOn(getSchedulerProvider().io())
        .subscribe();
    getCompositeDisposable().add(disposable);
  }

  @Override
  public void deleteProfile(@NonNull Profile profile) {
    Disposable disposable = getDataManger().deleteProfile(profile)
        .subscribeOn(getSchedulerProvider().io())
        .subscribe();
    getCompositeDisposable().add(disposable);
  }
}
