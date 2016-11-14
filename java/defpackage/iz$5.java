package defpackage;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.data.Message;
import rx.schedulers.Schedulers;

/* compiled from: MessageViewHolder */
class iz$5 implements OnClickListener {
    final /* synthetic */ iz a;
    final /* synthetic */ Message b;
    final /* synthetic */ Context c;
    final /* synthetic */ hk d;

    iz$5(iz izVar, Message message, Context context, hk hkVar) {
        this.a = izVar;
        this.b = message;
        this.c = context;
        this.d = hkVar;
    }

    public void onClick(View v) {
        this.a.g.setEnabled(false);
        this.a.i.setEnabled(false);
        this.a.h.setEnabled(false);
        if (this.b.params != null) {
            ie.a().n(this.b.params).b(Schedulers.io()).a(apn.a()).b(new iz$5$1(this));
        }
    }
}
