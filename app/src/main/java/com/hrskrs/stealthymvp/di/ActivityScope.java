package com.hrskrs.stealthymvp.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by hrskrs on 3/18/2017.
 */

@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
