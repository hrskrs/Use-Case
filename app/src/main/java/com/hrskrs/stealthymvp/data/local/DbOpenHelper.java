package com.hrskrs.stealthymvp.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.hrskrs.stealthymvp.di.ApplicationContext;
import com.hrskrs.stealthymvp.di.DatabaseInfo;
import com.hrskrs.stealthymvp.model.DaoMaster;

import javax.inject.Inject;

/**
 * Created by hrskrs on 4/3/2017.
 */
public class DbOpenHelper extends DaoMaster.OpenHelper {

  @Inject
  public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String dbName) {
    super(context, dbName);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    super.onUpgrade(sqLiteDatabase, oldVersion, newVersion);
//    if (oldVersion < newVersion) {
    //TODO: handle migration if DB_VERSION changed
//    }
  }
}
