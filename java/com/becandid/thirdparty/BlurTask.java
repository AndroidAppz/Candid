package com.becandid.thirdparty;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import defpackage.ih$b;
import defpackage.ih$c;
import defpackage.ih$d;
import defpackage.iq;
import defpackage.jd;
import defpackage.je;

public class BlurTask extends AsyncTask<Void, Void, Void> {
    private Activity a;
    private int b;
    private Bitmap c;
    private String d;
    private String e;
    private BadgeType f;
    private View g;
    private String h;
    private String i;
    private String j;

    public enum BadgeType {
        BADGE,
        MOD,
        POST_QUALITY_SCORE,
        ME_QUALITY_SCORE,
        MESSAGE_ENABLED_NEW,
        MESSAGE_ENABLED_TAB
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }

    public BlurTask(Activity activity, int layoutId) {
        this.a = activity;
        this.b = layoutId;
    }

    public BlurTask(Activity activity, int layoutId, String badgeName) {
        this.a = activity;
        this.b = layoutId;
        this.e = badgeName;
    }

    public BlurTask(Activity activity, View layoutView, BadgeType type, String modTitle, String modDesc) {
        this.a = activity;
        this.g = layoutView;
        this.f = type;
        this.i = modTitle;
        this.j = modDesc;
    }

    public BlurTask(Activity activity, View layoutView, String score, BadgeType type, String scoreTitle, String scoreDesc) {
        this.a = activity;
        this.g = layoutView;
        this.f = type;
        this.h = score;
        this.i = scoreTitle;
        this.j = scoreDesc;
    }

    public BlurTask(Activity activity, View layoutView, BadgeType type) {
        this.a = activity;
        this.g = layoutView;
        this.f = type;
    }

    private View a() {
        return this.a.findViewById(this.b);
    }

    protected Void a(Void... params) {
        this.d = b();
        return null;
    }

    protected void onPreExecute() {
        if (this.g == null) {
            this.g = a();
        }
        this.c = je.a(this.g, Color.parseColor("#ff000000"));
    }

    protected void a(Void aVoid) {
        if (this.e != null) {
            iq.a().a(new ih$c(this.d, this.e));
        } else if (this.f != null) {
            iq.a().a(new ih$b(this.d, this.f, this.h, this.i, this.j));
        } else {
            iq.a().a(new ih$d(this.d));
        }
    }

    private String b() {
        Bitmap localBitmap = jd.a(this.a, this.c, 24);
        String str = je.a(this.a, localBitmap);
        this.c.recycle();
        localBitmap.recycle();
        return str;
    }
}
