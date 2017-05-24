package com.hrskrs.stealthymvp.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * Created by hrskrs on 3/17/2017.
 */

public class HKProgressBar extends ProgressBar {

  public HKProgressBar(Context context) {
    super(context);
  }

  public HKProgressBar(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public HKProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
  public HKProgressBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }
}
