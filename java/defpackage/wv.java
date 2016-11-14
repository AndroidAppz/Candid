package defpackage;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzol.a;

public class wv extends zs {
    public static final int a = zs.b;
    private static final wv c = new wv();

    wv() {
    }

    public static wv a() {
        return c;
    }

    public int a(Context context) {
        return super.a(context);
    }

    public Dialog a(Activity activity, int i, int i2) {
        return GooglePlayServicesUtil.getErrorDialog(i, activity, i2);
    }

    public Dialog a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        String zzam = GooglePlayServicesUtil.zzam(activity);
        builder.setMessage(activity.getResources().getString(R.string.common_google_play_services_updating_text, new Object[]{zzam}));
        builder.setTitle(R.string.common_google_play_services_updating_title);
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        GooglePlayServicesUtil.zza(activity, onCancelListener, "GooglePlayServicesUpdatingDialog", create);
        return create;
    }

    public PendingIntent a(Context context, int i, int i2) {
        return super.a(context, i, i2);
    }

    public PendingIntent a(Context context, int i, int i2, String str) {
        return super.a(context, i, i2, str);
    }

    public PendingIntent a(Context context, ConnectionResult connectionResult) {
        if (connectionResult.a()) {
            return connectionResult.d();
        }
        int c = connectionResult.c();
        if (zi.a(context) && c == 2) {
            c = 42;
        }
        return a(context, c, 0);
    }

    public Intent a(Context context, int i, String str) {
        return super.a(context, i, str);
    }

    public zzol a(Context context, a aVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zzol com_google_android_gms_internal_zzol = new zzol(aVar);
        context.registerReceiver(com_google_android_gms_internal_zzol, intentFilter);
        com_google_android_gms_internal_zzol.a(context);
        if (a(context, zu.GOOGLE_PLAY_SERVICES_PACKAGE)) {
            return com_google_android_gms_internal_zzol;
        }
        aVar.a();
        com_google_android_gms_internal_zzol.a();
        return null;
    }

    public void a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a = a(context, connectionResult);
        if (a != null) {
            GooglePlayServicesUtil.zza(connectionResult.c(), context, GoogleApiActivity.a(context, a, i));
        }
    }

    public final boolean a(int i) {
        return super.a(i);
    }

    public boolean a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return GooglePlayServicesUtil.showErrorDialogFragment(i, activity, i2, onCancelListener);
    }

    public boolean a(Activity activity, abb abb, int i, int i2, OnCancelListener onCancelListener) {
        Dialog zza = GooglePlayServicesUtil.zza(i, activity, yf.a(abb, a((Context) activity, i, "d"), i2), onCancelListener);
        if (zza == null) {
            return false;
        }
        GooglePlayServicesUtil.zza(activity, onCancelListener, "GooglePlayServicesErrorDialog", zza);
        return true;
    }

    public boolean b(Activity activity, int i, int i2) {
        return GooglePlayServicesUtil.showErrorDialogFragment(i, activity, i2);
    }
}
