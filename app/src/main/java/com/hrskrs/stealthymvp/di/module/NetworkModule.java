package com.hrskrs.stealthymvp.di.module;

import android.app.Application;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.hrskrs.stealthymvp.di.InterceptorInfo;
import com.hrskrs.stealthymvp.util.AppUtils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hrskrs on 3/17/2017.
 */

@Module
public class NetworkModule {

  private String baseUrl;

  public NetworkModule(@NonNull String baseUrl) {
    this.baseUrl = baseUrl;
  }

  @Provides
  @Singleton
  Cache provideCache(Application application) {
    int cacheSize = 10 * 1024 * 1024;
    return new Cache(application.getCacheDir(), cacheSize);
  }

  @Singleton
  @Provides
  public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    return logging;

  }

  @Provides
  @InterceptorInfo
  public int provideRetryCount() {
    return AppUtils.RETRY_NETWORK_REQUEST_COUNT;
  }

  @Singleton
  @Provides
  public Interceptor provideRetryInterceptor(@InterceptorInfo int retryCount) {
    return chain -> {
      Request request = chain.request();
      Response response = null;
      IOException exception = null;

      int tryCount = 0;
      while (tryCount < retryCount && (null == response || !response.isSuccessful())) {
        try {
          response = chain.proceed(request);
        } catch (IOException e) {
          exception = e;
        } finally {
          tryCount++;
        }
      }

      if (null == response && null != exception) {
        throw exception;
      }

      return response;
    };
  }

  @Provides
  @Singleton
  OkHttpClient provideOkHttpClient(Cache cache,
                                   HttpLoggingInterceptor interceptor,
                                   Interceptor retryInterceptor) {
    return new OkHttpClient.Builder()
        .addNetworkInterceptor(interceptor)
        .addInterceptor(retryInterceptor)
        .cache(cache)
        .build();
  }

  @Provides
  @Singleton
  Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
    return new Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build();
  }

}
