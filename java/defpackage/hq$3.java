package defpackage;

import android.content.Context;

/* compiled from: MeActivityFragment */
class hq$3 extends io {
    final /* synthetic */ hq a;

    hq$3(hq this$0, Context context) {
        this.a = this$0;
        super(context);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(android.view.View r10, int r11) {
        /*
        r9 = this;
        r6 = 1;
        r4 = 0;
        if (r11 < 0) goto L_0x0014;
    L_0x0004:
        r5 = r9.a;
        r5 = r5.c;
        r5 = r5.e();
        r5 = r5.size();
        if (r11 < r5) goto L_0x0024;
    L_0x0014:
        r5 = r9.a;
        r5 = r5.getContext();
        r6 = "Unable to find that notification";
        r4 = android.widget.Toast.makeText(r5, r6, r4);
        r4.show();
    L_0x0023:
        return;
    L_0x0024:
        r5 = r9.a;
        r5 = r5.c;
        r5 = r5.e();
        r0 = r5.get(r11);
        r0 = (com.becandid.candid.data.Notification) r0;
        r0.unread = r4;
        r5 = r9.a;
        r5 = r5.c;
        r5.notifyItemChanged(r11);
        r5 = defpackage.ie.a();
        r7 = r0.activity_id;
        r5 = r5.a(r7);
        r7 = rx.schedulers.Schedulers.io();
        r5 = r5.b(r7);
        r7 = defpackage.apn.a();
        r5 = r5.a(r7);
        r7 = new com.becandid.candid.models.EmptySubscriber;
        r7.<init>();
        r5.b(r7);
        r5 = com.becandid.candid.data.AppState.account;
        r5.unread_activity_count = r4;
        r5 = r0.onclick;
        r7 = ":";
        r2 = r5.split(r7);
        r5 = r2[r6];
        r5 = java.lang.Integer.valueOf(r5);
        r3 = r5.intValue();
        r7 = r2[r4];
        r5 = -1;
        r8 = r7.hashCode();
        switch(r8) {
            case -1925545598: goto L_0x00c6;
            case -1572993592: goto L_0x00bc;
            case -338943683: goto L_0x00b3;
            case 2067279704: goto L_0x00d0;
            default: goto L_0x0081;
        };
    L_0x0081:
        r4 = r5;
    L_0x0082:
        switch(r4) {
            case 0: goto L_0x0086;
            case 1: goto L_0x00da;
            case 2: goto L_0x0103;
            case 3: goto L_0x0120;
            default: goto L_0x0085;
        };
    L_0x0085:
        goto L_0x0023;
    L_0x0086:
        r1 = new android.content.Intent;
        r4 = r9.a;
        r4 = r4.getContext();
        r5 = com.becandid.candid.activities.PostDetailsActivity.class;
        r1.<init>(r4, r5);
        r4 = "post_id";
        r1.putExtra(r4, r3);
        r4 = r0.comment_id;
        if (r4 <= 0) goto L_0x00a8;
    L_0x009c:
        r4 = "comment_id";
        r5 = r0.comment_id;
        r1.putExtra(r4, r5);
        r4 = "scrollToBottom";
        r1.putExtra(r4, r6);
    L_0x00a8:
        r4 = r9.a;
        r4 = r4.getContext();
        r4.startActivity(r1);
        goto L_0x0023;
    L_0x00b3:
        r8 = "showPost";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x0081;
    L_0x00bb:
        goto L_0x0082;
    L_0x00bc:
        r4 = "showPostBottom";
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x0081;
    L_0x00c4:
        r4 = r6;
        goto L_0x0082;
    L_0x00c6:
        r4 = "showGroup";
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x0081;
    L_0x00ce:
        r4 = 2;
        goto L_0x0082;
    L_0x00d0:
        r4 = "showTab";
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x0081;
    L_0x00d8:
        r4 = 3;
        goto L_0x0082;
    L_0x00da:
        r1 = new android.content.Intent;
        r4 = r9.a;
        r4 = r4.getContext();
        r5 = com.becandid.candid.activities.PostDetailsActivity.class;
        r1.<init>(r4, r5);
        r4 = "post_id";
        r1.putExtra(r4, r3);
        r4 = "comment_id";
        r5 = r0.comment_id;
        r1.putExtra(r4, r5);
        r4 = "scrollToBottom";
        r1.putExtra(r4, r6);
        r4 = r9.a;
        r4 = r4.getContext();
        r4.startActivity(r1);
        goto L_0x0023;
    L_0x0103:
        r1 = new android.content.Intent;
        r4 = r9.a;
        r4 = r4.getContext();
        r5 = com.becandid.candid.activities.GroupDetailsActivity.class;
        r1.<init>(r4, r5);
        r4 = "group_id";
        r1.putExtra(r4, r3);
        r4 = r9.a;
        r4 = r4.getContext();
        r4.startActivity(r1);
        goto L_0x0023;
    L_0x0120:
        r4 = defpackage.iq.a();
        r5 = new ih$e;
        r5.<init>(r3);
        r4.a(r5);
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: hq$3.onItemClick(android.view.View, int):void");
    }
}
