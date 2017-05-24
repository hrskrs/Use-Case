package com.hrskrs.stealthymvp.ui.base;


import android.view.View;

/**
 * Created by hrskrs on 8/12/2016.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

  public abstract void populateItem(T t);

  public BaseViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }
}
