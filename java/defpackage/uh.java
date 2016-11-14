package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessTokenSource;
import com.facebook.LoggingBehavior;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LegacyTokenHelper */
public final class uh {
    private static final String a = uh.class.getSimpleName();
    private String b;
    private SharedPreferences c;

    public uh(Context context) {
        this(context, null);
    }

    public uh(Context context, String cacheKey) {
        vx.a((Object) context, "context");
        if (vw.a(cacheKey)) {
            cacheKey = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
        }
        this.b = cacheKey;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.c = context.getSharedPreferences(this.b, 0);
    }

    public Bundle a() {
        Bundle settings = new Bundle();
        for (String key : this.c.getAll().keySet()) {
            try {
                a(key, settings);
            } catch (JSONException e) {
                vp.a(LoggingBehavior.CACHE, 5, a, "Error reading cached value for key: '" + key + "' -- " + e);
                return null;
            }
        }
        return settings;
    }

    public void b() {
        this.c.edit().clear().apply();
    }

    public static boolean a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String token = bundle.getString("com.facebook.TokenCachingStrategy.Token");
        if (token == null || token.length() == 0 || bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0) == 0) {
            return false;
        }
        return true;
    }

    public static String b(Bundle bundle) {
        vx.a((Object) bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.Token");
    }

    public static AccessTokenSource c(Bundle bundle) {
        vx.a((Object) bundle, "bundle");
        if (bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
            return (AccessTokenSource) bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
        }
        return bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO") ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
    }

    public static String d(Bundle bundle) {
        vx.a((Object) bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
    }

    public static Date a(Bundle bundle, String key) {
        if (bundle == null) {
            return null;
        }
        long n = bundle.getLong(key, Long.MIN_VALUE);
        if (n != Long.MIN_VALUE) {
            return new Date(n);
        }
        return null;
    }

    private void a(String key, Bundle bundle) throws JSONException {
        JSONObject json = new JSONObject(this.c.getString(key, "{}"));
        String valueType = json.getString("valueType");
        if (valueType.equals("bool")) {
            bundle.putBoolean(key, json.getBoolean("value"));
        } else if (valueType.equals("bool[]")) {
            jsonArray = json.getJSONArray("value");
            boolean[] array = new boolean[jsonArray.length()];
            for (i = 0; i < array.length; i++) {
                array[i] = jsonArray.getBoolean(i);
            }
            bundle.putBooleanArray(key, array);
        } else if (valueType.equals("byte")) {
            bundle.putByte(key, (byte) json.getInt("value"));
        } else if (valueType.equals("byte[]")) {
            jsonArray = json.getJSONArray("value");
            byte[] array2 = new byte[jsonArray.length()];
            for (i = 0; i < array2.length; i++) {
                array2[i] = (byte) jsonArray.getInt(i);
            }
            bundle.putByteArray(key, array2);
        } else if (valueType.equals("short")) {
            bundle.putShort(key, (short) json.getInt("value"));
        } else if (valueType.equals("short[]")) {
            jsonArray = json.getJSONArray("value");
            short[] array3 = new short[jsonArray.length()];
            for (i = 0; i < array3.length; i++) {
                array3[i] = (short) jsonArray.getInt(i);
            }
            bundle.putShortArray(key, array3);
        } else if (valueType.equals("int")) {
            bundle.putInt(key, json.getInt("value"));
        } else if (valueType.equals("int[]")) {
            jsonArray = json.getJSONArray("value");
            int[] array4 = new int[jsonArray.length()];
            for (i = 0; i < array4.length; i++) {
                array4[i] = jsonArray.getInt(i);
            }
            bundle.putIntArray(key, array4);
        } else if (valueType.equals("long")) {
            bundle.putLong(key, json.getLong("value"));
        } else if (valueType.equals("long[]")) {
            jsonArray = json.getJSONArray("value");
            long[] array5 = new long[jsonArray.length()];
            for (i = 0; i < array5.length; i++) {
                array5[i] = jsonArray.getLong(i);
            }
            bundle.putLongArray(key, array5);
        } else if (valueType.equals("float")) {
            bundle.putFloat(key, (float) json.getDouble("value"));
        } else if (valueType.equals("float[]")) {
            jsonArray = json.getJSONArray("value");
            float[] array6 = new float[jsonArray.length()];
            for (i = 0; i < array6.length; i++) {
                array6[i] = (float) jsonArray.getDouble(i);
            }
            bundle.putFloatArray(key, array6);
        } else if (valueType.equals("double")) {
            bundle.putDouble(key, json.getDouble("value"));
        } else if (valueType.equals("double[]")) {
            jsonArray = json.getJSONArray("value");
            double[] array7 = new double[jsonArray.length()];
            for (i = 0; i < array7.length; i++) {
                array7[i] = jsonArray.getDouble(i);
            }
            bundle.putDoubleArray(key, array7);
        } else if (valueType.equals("char")) {
            charString = json.getString("value");
            if (charString != null && charString.length() == 1) {
                bundle.putChar(key, charString.charAt(0));
            }
        } else if (valueType.equals("char[]")) {
            jsonArray = json.getJSONArray("value");
            char[] array8 = new char[jsonArray.length()];
            for (i = 0; i < array8.length; i++) {
                charString = jsonArray.getString(i);
                if (charString != null && charString.length() == 1) {
                    array8[i] = charString.charAt(0);
                }
            }
            bundle.putCharArray(key, array8);
        } else if (valueType.equals("string")) {
            bundle.putString(key, json.getString("value"));
        } else if (valueType.equals("stringList")) {
            jsonArray = json.getJSONArray("value");
            int numStrings = jsonArray.length();
            ArrayList<String> stringList = new ArrayList(numStrings);
            for (i = 0; i < numStrings; i++) {
                Object jsonStringValue = jsonArray.get(i);
                if (jsonStringValue == JSONObject.NULL) {
                    jsonStringValue = null;
                } else {
                    String jsonStringValue2 = (String) jsonStringValue;
                }
                stringList.add(i, jsonStringValue);
            }
            bundle.putStringArrayList(key, stringList);
        } else if (valueType.equals("enum")) {
            try {
                bundle.putSerializable(key, Enum.valueOf(Class.forName(json.getString("enumType")), json.getString("value")));
            } catch (ClassNotFoundException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
    }
}
