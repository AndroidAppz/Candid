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

public class acf {
    public static final wx<Object> a;
    public static final acb b;
    public static final acd c;
    public static final acg d;
    private static final wx.d<Object> e;
    private static final wx.b<Object, Object> f;

    static {
        e = new wx.d();
        f = new wx.b<Object, Object>(){};
        a = new wx("LocationServices.API", f, e);
        b = new aci();
        c = new acj();
        d = new acl();
    }

    public static abstract class a<R extends xc>
    extends zza.zza<R, Object> {
        public a(wz wz2) {
            super((Api.zzc)e, (GoogleApiClient)wz2);
        }
    }

}

