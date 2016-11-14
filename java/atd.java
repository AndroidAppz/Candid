/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
import android.util.Log;

public class atd
implements atc {
    @Override
    public int a(String string2, String string3) {
        return Log.d((String)string2, (String)string3);
    }

    @Override
    public int b(String string2, String string3) {
        return Log.i((String)string2, (String)string3);
    }
}

