package com.hrskrs.stealthymvp.util;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by hrskrs on 7/14/2016.
 */
public final class FragmentTransactionUtil {

  private FragmentTransactionUtil() {
    throw new AssertionError();
  }

  public static void addFragment(FragmentManager fragmentManager,
                                 @NonNull Fragment fragment,
                                 @IdRes int fragmentContainerId,
                                 boolean addToBackStack) {
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.add(fragmentContainerId, fragment);
    if (addToBackStack) {
      transaction.addToBackStack(fragment.getClass().getSimpleName());
    }
    transaction.commit();
  }

  public static void replaceFragment(FragmentManager fragmentManager,
                                     @NonNull Fragment fragment,
                                     @IdRes int fragmentContainerId,
                                     boolean addToBackStack) {
    FragmentTransaction transaction = fragmentManager.beginTransaction();
//    transaction.setCustomAnimations(
//        R.anim.slide_in_bottom, R.anim.zoom_out,
//        R.anim.zoom_out, R.anim.slide_out_bottom);
    transaction.replace(fragmentContainerId, fragment);
    if (addToBackStack) {
      transaction.addToBackStack(fragment.getClass().getSimpleName());
    }
    transaction.commit();
  }
}
