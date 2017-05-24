package com.hrskrs.stealthymvp.di.module;

import android.app.Application;
import android.content.Context;


/**
 * Created by hrskrs on 4/28/2017.
 */

@Module
public class AppModule {

  private final Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides
  @ApplicationContext
  Context provideApplicationContext() {
    return application;
  }

  @Provides
  Application provideApplication() {
    return application;
  }

  @Provides
  @DatabaseInfo
  String provideDatabaseName() {
    return AppUtils.DB_NAME;
  }

  @Provides
  @Singleton
  Gson provideGson() {
    GsonBuilder gsonBuilder = new GsonBuilder();
//    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    return gsonBuilder.create();
  }

  @Provides
  @Singleton
  SharedPrefsHelper provideSharedPreferencesHelper(@ApplicationContext Context context, Gson gson) {
    return new SharedPrefsHelperImp(context, gson);
  }

  @Provides
  @Singleton
  DbOpenHelper provideDbHelper(@ApplicationContext Context context,
                               @DatabaseInfo String dbName) {
    return new DbOpenHelper(context, dbName);
  }

  @Provides
  @Singleton
  DbManager provideDbManager(DbOpenHelper dbOpenHelper) {
    return new DbManagerImp(dbOpenHelper);
  }

  @Provides
  @Singleton
  DataManger providesDataManger(@ApplicationContext Context context,
                                SharedPrefsHelper sharedPrefsHelper,
                                DbManager dbManager,
                                ApiManger apiManger) {
    return new DataManagerImp(context, sharedPrefsHelper, dbManager, apiManger);
  }

  @Provides
  @Singleton
  ApiManger provideApiManager(Retrofit retrofit) {
    return new ApiMangerImp(retrofit);
  }

}
