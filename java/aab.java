/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.Callable
 */
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

public abstract class aab<T> {

    public static class a
    extends aab<Boolean> {
        public static Boolean a(SharedPreferences sharedPreferences, final String string, final Boolean bl2) {
            return (Boolean)abp.a(new Callable<Boolean>(){

                public Boolean a() {
                    return SharedPreferences.this.getBoolean(string, bl2.booleanValue());
                }

                public /* synthetic */ Object call() throws Exception {
                    return this.a();
                }
            });
        }

    }

    public static class b
    extends aab<Integer> {
        public static Integer a(SharedPreferences sharedPreferences, final String string, final Integer n2) {
            return (Integer)abp.a(new Callable<Integer>(){

                public Integer a() {
                    return SharedPreferences.this.getInt(string, n2.intValue());
                }

                public /* synthetic */ Object call() throws Exception {
                    return this.a();
                }
            });
        }

    }

    public static class c
    extends aab<Long> {
        public static Long a(SharedPreferences sharedPreferences, final String string, final Long l2) {
            return (Long)abp.a(new Callable<Long>(){

                public Long a() {
                    return SharedPreferences.this.getLong(string, l2.longValue());
                }

                public /* synthetic */ Object call() throws Exception {
                    return this.a();
                }
            });
        }

    }

    public static class d
    extends aab<String> {
        public static String a(SharedPreferences sharedPreferences, final String string, final String string2) {
            return (String)abp.a(new Callable<String>(){

                public String a() {
                    return SharedPreferences.this.getString(string, string2);
                }

                public /* synthetic */ Object call() throws Exception {
                    return this.a();
                }
            });
        }

    }

}

