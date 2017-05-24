package com.hrskrs.stealthymvp.util;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Created by hrskrs on 6/23/2016.
 */
public final class FontCache {

  private static HashMap<String, Typeface> typeFaces = new HashMap<>();

  private FontCache() {
    throw new AssertionError();
  }

  public static Typeface getTypeface(String fontName, Context context) {
    Typeface typeface = typeFaces.get(fontName);

    if (typeface == null) {
      try {
        typeface = Typeface.createFromAsset(context.getAssets(), fontName);
      } catch (Exception e) {
        return null;
      }
      typeFaces.put(fontName, typeface);
    }

    return typeface;
  }

}
