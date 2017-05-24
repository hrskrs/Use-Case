package com.hrskrs.stealthymvp.ui.main;

import com.hrskrs.stealthymvp.model.Profile;
import com.hrskrs.stealthymvp.ui.base.BaseView;

import java.util.ArrayList;

/**
 * Created by hrskrs on 5/24/2017.
 */

public interface MainView extends BaseView {

  void onProfilesLoaded(ArrayList<Profile> profiles);
}
