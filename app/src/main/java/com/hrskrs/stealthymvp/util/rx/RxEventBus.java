package com.hrskrs.stealthymvp.util.rx;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by hrskrs on 4/5/2017.
 */

public class RxEventBus {

  private static volatile RxEventBus instance = null;
  private PublishSubject<Object> subject = PublishSubject.create();
  private BehaviorSubject<Object> stickySubject = BehaviorSubject.create();

  public static RxEventBus getInstance() {
    if (instance == null) {
      synchronized (RxEventBus.class) {
        if (instance == null) {
          instance = new RxEventBus();
        }
      }
    }
    return instance;
  }

  @SuppressWarnings("all")
  public Observable<Object> getEvents() {
    return subject.filter(o -> o != null);
  }

  public void postEvent(@NonNull Object event) {
    if (subject.hasObservers()) {
      subject.onNext(event);
    }
  }

  @SuppressWarnings("all")
  public Observable<Object> getStickyEvent() {
    return stickySubject.filter(o -> o != null);
  }

  public void postStickyEvent(@NonNull Object event) {
    if (stickySubject.hasObservers()) {
      stickySubject.onNext(event);
    }
  }

  public void removeStickyEvent() {
    stickySubject.onNext(null);
  }
}
