# GreenDao rules
# Source: http://greendao-orm.com/documentation/technical-faq
#
-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
  public static java.lang.String TABLENAME;
}
-keep class **$Properties

# If you do not use SQLCipher:
-dontwarn org.greenrobot.greendao.database.**
# If you do not use RxJava:
#-dontwarn rx.**