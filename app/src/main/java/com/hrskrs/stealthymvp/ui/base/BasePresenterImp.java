package com.hrskrs.stealthymvp.ui.base;


/**
 * Created by hrskrs on 5/2/2017.
 */

public class BasePresenterImp<V extends BaseView> implements BasePresenter<V> {

  private final DataManger dataManger;
  private final SchedulerProvider schedulerProvider;
  private final CompositeDisposable compositeDisposable;
  private V view;

  protected BasePresenterImp(
      DataManger dataManger,
      SchedulerProvider schedulerProvider,
      CompositeDisposable compositeDisposable) {
    this.dataManger = dataManger;
    this.schedulerProvider = schedulerProvider;
    this.compositeDisposable = compositeDisposable;
  }

  @Override
  public void onAttach(V view) {
    this.view = view;
  }

  @Override
  public void onDetach() {
    if (this.compositeDisposable != null) {
      this.compositeDisposable.dispose();
    }
    this.view = null;
  }

  protected V getView() {
    return view;
  }

  protected boolean isViewAttached() {
    return view != null;
  }

  protected SchedulerProvider getSchedulerProvider() {
    return schedulerProvider;
  }

  protected CompositeDisposable getCompositeDisposable() {
    return this.compositeDisposable;
  }

  protected DataManger getDataManger() {
    return dataManger;
  }
}
