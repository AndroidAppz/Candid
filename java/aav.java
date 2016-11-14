/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.GoogleApiActivity
 *  com.google.android.gms.internal.zzol
 *  com.google.android.gms.internal.zzol$a
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.zzol;

public abstract class aav
extends aba
implements DialogInterface.OnCancelListener {
    protected boolean a;
    protected boolean b;
    protected final wv c;
    private ConnectionResult e;
    private int f;
    private final Handler g;

    @Override
    public void a() {
        super.a();
        this.a = true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void a(int var1, int var2_3, Intent var3_2) {
        var4_4 = true;
        switch (var1) {
            case 2: {
                var6_5 = this.c.a((Context)this.e());
                if (var6_5 != 0) ** GOTO lbl14
                ** GOTO lbl15
            }
            case 1: {
                if (var2_3 == -1) ** GOTO lbl19
                if (var2_3 != 0) break;
                var5_6 = var3_2 != null ? var3_2.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13;
                this.e = new ConnectionResult(var5_6, null);
            }
        }
        var4_4 = false;
        ** GOTO lbl19
lbl14: // 1 sources:
        var4_4 = false;
lbl15: // 2 sources:
        if (this.e.c() == 18) {
            if (var6_5 == 18) {
                return;
            } else {
                ** GOTO lbl19
            }
        }
        ** GOTO lbl22
lbl19: // 4 sources:
        if (var4_4) {
            this.d();
            return;
        }
lbl22: // 3 sources:
        this.a(this.e, this.f);
    }

    @Override
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null) {
            this.b = bundle.getBoolean("resolving_error", false);
            if (this.b) {
                this.f = bundle.getInt("failed_client_id", -1);
                this.e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution"));
            }
        }
    }

    protected abstract void a(ConnectionResult var1, int var2);

    @Override
    public void b() {
        super.b();
        this.a = false;
    }

    @Override
    public void b(Bundle bundle) {
        super.b(bundle);
        bundle.putBoolean("resolving_error", this.b);
        if (this.b) {
            bundle.putInt("failed_client_id", this.f);
            bundle.putInt("failed_status", this.e.c());
            bundle.putParcelable("failed_resolution", (Parcelable)this.e.d());
        }
    }

    public void b(ConnectionResult connectionResult, int n2) {
        if (!this.b) {
            this.b = true;
            this.f = n2;
            this.e = connectionResult;
            this.g.post((Runnable)new a((aav)this, null));
        }
    }

    protected abstract void c();

    protected void d() {
        this.f = -1;
        this.b = false;
        this.e = null;
        this.c();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a(new ConnectionResult(13, null), this.f);
        this.d();
    }

    class a
    implements Runnable {
        final /* synthetic */ aav a;

        private a(aav aav2) {
            this.a = aav2;
        }

        /* synthetic */ a(aav aav2, aav$1 var2_2) {
            super(aav2);
        }

        public void run() {
            if (!this.a.a) {
                return;
            }
            if (this.a.e.a()) {
                this.a.d.startActivityForResult(GoogleApiActivity.b((Context)this.a.e(), (PendingIntent)this.a.e.d(), (int)this.a.f, (boolean)false), 1);
                return;
            }
            if (this.a.c.a(this.a.e.c())) {
                this.a.c.a(this.a.e(), this.a.d, this.a.e.c(), 2, this.a);
                return;
            }
            if (this.a.e.c() == 18) {
                final Dialog dialog = this.a.c.a(this.a.e(), this.a);
                this.a.c.a(this.a.e().getApplicationContext(), new zzol.a(){

                    public void a() {
                        a.this.a.d();
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    }
                });
                return;
            }
            this.a.a(this.a.e, this.a.f);
        }

    }

}

