package com.hrskrs.stealthymvp.util;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.hrskrs.stealthymvp.R;
import com.hrskrs.stealthymvp.view.HKImageView;


/**
 * Created by hrskrs on 2/28/2017.
 */

public final class ImageUtils {

  private ImageUtils() {
    throw new AssertionError();
  }

  public static void loadImage(Context context, String imageUrl, HKImageView view) {
    Glide.with(context).load(imageUrl).placeholder(R.drawable.ic_unhappy).into(view);
  }
}
