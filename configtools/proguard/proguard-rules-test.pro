# Proguard rules run against the test module (split since Gradle plugin v 1.1.0)
-dontobfuscate
-ignorewarnings
-dontoptimize

-dontwarn android.test.**
-dontwarn android.support.test.**
-dontwarn org.junit.**
-dontwarn org.hamcrest.**
-dontwarn com.squareup.javawriter.JavaWriter
-dontwarn org.mockito.**

-dontnote junit.framework.**
-dontnote junit.runner.**

-keepattributes *Annotation*