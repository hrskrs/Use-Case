package com.hrskrs.stealthymvp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.hrskrs.stealthymvp.R;
import com.hrskrs.stealthymvp.util.FontCache;


/**
 * Created by hrskrs on 6/23/2016.
 */
public class HKTextView extends AppCompatTextView {

  private static final String BACKSLASH = "/";
  private String fontSrcDirectory = "fonts" + BACKSLASH;
  private static final String fontExtension = ".ttf";
  private String fontName = "Roboto-Medium";

  public HKTextView(Context context) {
    super(context);
    setCustomFont(context, null);
  }

  public HKTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    setCustomFont(context, attrs);
  }

  public HKTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    setCustomFont(context, attrs);
  }

  private void setCustomFont(Context context, AttributeSet attrs) {
    if (attrs != null) {
      TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.HKViewAttrs);
      if (ta != null) {
        String userCustomFont = ta.getString(R.styleable.HKViewAttrs_hkCustomFont);
        if (!TextUtils.isEmpty(userCustomFont)) {
          fontName = userCustomFont;
        }

        ta.recycle();
      }
    }

    Typeface typeface = FontCache.getTypeface(fontSrcDirectory + fontName +
        fontExtension, context);
    setTypeface(typeface);
  }

  public void setFontSrcDirectory(String fontSrcDirectory) {
    this.fontSrcDirectory = fontSrcDirectory;
  }

  public String getFontSrcDirectory() {
    return fontSrcDirectory;
  }

  public void setFontName(String fontName) {
    this.fontName = fontName;
  }

  public String getFontName() {
    return fontName;
  }

}
