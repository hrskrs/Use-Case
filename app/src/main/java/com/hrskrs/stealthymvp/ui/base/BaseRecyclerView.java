package com.hrskrs.stealthymvp.ui.base;


import android.support.v7.widget.RecyclerView;

/**
 * Created by hrskrs on 8/12/2016.
 */
public abstract class BaseRecyclerView<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

  protected abstract T getItem(int position);

  @Override
  public void onBindViewHolder(BaseViewHolder<T> holder, int position) {
    holder.populateItem(getItem(position));
  }
}
