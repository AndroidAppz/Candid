package defpackage;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;

/* compiled from: CrashlyticsCore */
class sr$7 implements Runnable {
    final /* synthetic */ Activity a;
    final /* synthetic */ sr$c b;
    final /* synthetic */ tb c;
    final /* synthetic */ anq d;
    final /* synthetic */ sr e;

    sr$7(sr srVar, Activity activity, sr$c sr_c, tb tbVar, anq anq) {
        this.e = srVar;
        this.a = activity;
        this.b = sr_c;
        this.c = tbVar;
        this.d = anq;
    }

    public void run() {
        Builder builder = new Builder(this.a);
        OnClickListener sendClickListener = new sr$7$1(this);
        float density = this.a.getResources().getDisplayMetrics().density;
        int textViewPadding = sr.b(density, 5);
        TextView textView = new TextView(this.a);
        textView.setAutoLinkMask(15);
        textView.setText(this.c.b());
        textView.setTextAppearance(this.a, 16973892);
        textView.setPadding(textViewPadding, textViewPadding, textViewPadding, textViewPadding);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(this.a);
        scrollView.setPadding(sr.b(density, 14), sr.b(density, 2), sr.b(density, 10), sr.b(density, 12));
        scrollView.addView(textView);
        builder.setView(scrollView).setTitle(this.c.a()).setCancelable(false).setNeutralButton(this.c.c(), sendClickListener);
        if (this.d.d) {
            builder.setNegativeButton(this.c.e(), new sr$7$2(this));
        }
        if (this.d.f) {
            builder.setPositiveButton(this.c.d(), new sr$7$3(this));
        }
        builder.show();
    }
}
