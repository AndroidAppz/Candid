/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$zza
 *  com.google.android.gms.common.api.Api$zzc
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.internal.zza
 *  com.google.android.gms.common.api.internal.zza$zza
 *  java.lang.Object
 *  java.lang.String
 */
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zza;

public class abx {
    public static final wx<Object> a;
    public static final aby b;
    private static final wx.d<Object> c;
    private static final wx.b<Object, Object> d;

    static {
        c = new wx.d();
        d = new wx.b<Object, Object>(){};
        a = new wx("ActivityRecognition.API", d, c);
        b = new ach();
    }

    public static abstract class a<R extends xc>
    extends zza.zza<R, Object> {
        public a(wz wz2) {
            super((Api.zzc)c, (GoogleApiClient)wz2);
        }
    }

}

