# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\buldu\AppData\Local\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-ignorewarnings

# Remove logs
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

# Keep the BuildConfig
-keep class com.hrskrs.commonssample.BuildConfig { *; }
-keep class com.hrskrs.commonssample.App { *; }

# Keep the support library
-keep class android.support.** { *; }
-keep interface android.support.** { *; }

#http://stackoverflow.com/questions/6727872/when-obfuscating-with-proguard-does-keepattributes-sourcefile-linenumbertable
#https://developer.android.com/studio/build/shrink-code.html
-keepattributes *Annotation*
-keepattributes SourceFile, LineNumberTable

# Proguard configurations for common Android libraries:
# https://github.com/krschultz/android-proguard-snippets