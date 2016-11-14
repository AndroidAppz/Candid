package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: LocalBroadcastManager */
public final class bn {
    private static final Object f = new Object();
    private static bn g;
    private final Context a;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> b = new HashMap();
    private final HashMap<String, ArrayList<bn$b>> c = new HashMap();
    private final ArrayList<bn$a> d = new ArrayList();
    private final Handler e;

    public static bn a(Context context) {
        bn bnVar;
        synchronized (f) {
            if (g == null) {
                g = new bn(context.getApplicationContext());
            }
            bnVar = g;
        }
        return bnVar;
    }

    private bn(Context context) {
        this.a = context;
        this.e = new bn$1(this, context.getMainLooper());
    }

    public void a(BroadcastReceiver receiver, IntentFilter filter) {
        synchronized (this.b) {
            bn$b entry = new bn$b(filter, receiver);
            ArrayList<IntentFilter> filters = (ArrayList) this.b.get(receiver);
            if (filters == null) {
                filters = new ArrayList(1);
                this.b.put(receiver, filters);
            }
            filters.add(filter);
            for (int i = 0; i < filter.countActions(); i++) {
                String action = filter.getAction(i);
                ArrayList<bn$b> entries = (ArrayList) this.c.get(action);
                if (entries == null) {
                    entries = new ArrayList(1);
                    this.c.put(action, entries);
                }
                entries.add(entry);
            }
        }
    }

    public void a(BroadcastReceiver receiver) {
        synchronized (this.b) {
            ArrayList<IntentFilter> filters = (ArrayList) this.b.remove(receiver);
            if (filters == null) {
                return;
            }
            for (int i = 0; i < filters.size(); i++) {
                IntentFilter filter = (IntentFilter) filters.get(i);
                for (int j = 0; j < filter.countActions(); j++) {
                    String action = filter.getAction(j);
                    ArrayList<bn$b> receivers = (ArrayList) this.c.get(action);
                    if (receivers != null) {
                        int k = 0;
                        while (k < receivers.size()) {
                            if (((bn$b) receivers.get(k)).b == receiver) {
                                receivers.remove(k);
                                k--;
                            }
                            k++;
                        }
                        if (receivers.size() <= 0) {
                            this.c.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.content.Intent r18) {
        /*
        r17 = this;
        r0 = r17;
        r15 = r0.b;
        monitor-enter(r15);
        r2 = r18.getAction();	 Catch:{ all -> 0x010b }
        r0 = r17;
        r1 = r0.a;	 Catch:{ all -> 0x010b }
        r1 = r1.getContentResolver();	 Catch:{ all -> 0x010b }
        r0 = r18;
        r3 = r0.resolveTypeIfNeeded(r1);	 Catch:{ all -> 0x010b }
        r5 = r18.getData();	 Catch:{ all -> 0x010b }
        r4 = r18.getScheme();	 Catch:{ all -> 0x010b }
        r6 = r18.getCategories();	 Catch:{ all -> 0x010b }
        r1 = r18.getFlags();	 Catch:{ all -> 0x010b }
        r1 = r1 & 8;
        if (r1 == 0) goto L_0x00ce;
    L_0x002b:
        r8 = 1;
    L_0x002c:
        if (r8 == 0) goto L_0x0062;
    L_0x002e:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r7.<init>();	 Catch:{ all -> 0x010b }
        r16 = "Resolving type ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.append(r3);	 Catch:{ all -> 0x010b }
        r16 = " scheme ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.append(r4);	 Catch:{ all -> 0x010b }
        r16 = " of intent ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r0 = r18;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.toString();	 Catch:{ all -> 0x010b }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x010b }
    L_0x0062:
        r0 = r17;
        r1 = r0.c;	 Catch:{ all -> 0x010b }
        r7 = r18.getAction();	 Catch:{ all -> 0x010b }
        r9 = r1.get(r7);	 Catch:{ all -> 0x010b }
        r9 = (java.util.ArrayList) r9;	 Catch:{ all -> 0x010b }
        if (r9 == 0) goto L_0x0175;
    L_0x0072:
        if (r8 == 0) goto L_0x008e;
    L_0x0074:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r7.<init>();	 Catch:{ all -> 0x010b }
        r16 = "Action list: ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.append(r9);	 Catch:{ all -> 0x010b }
        r7 = r7.toString();	 Catch:{ all -> 0x010b }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x010b }
    L_0x008e:
        r14 = 0;
        r10 = 0;
    L_0x0090:
        r1 = r9.size();	 Catch:{ all -> 0x010b }
        if (r10 >= r1) goto L_0x013c;
    L_0x0096:
        r13 = r9.get(r10);	 Catch:{ all -> 0x010b }
        r13 = (defpackage.bn$b) r13;	 Catch:{ all -> 0x010b }
        if (r8 == 0) goto L_0x00be;
    L_0x009e:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r7.<init>();	 Catch:{ all -> 0x010b }
        r16 = "Matching against filter ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r0 = r13.a;	 Catch:{ all -> 0x010b }
        r16 = r0;
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.toString();	 Catch:{ all -> 0x010b }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x010b }
    L_0x00be:
        r1 = r13.c;	 Catch:{ all -> 0x010b }
        if (r1 == 0) goto L_0x00d1;
    L_0x00c2:
        if (r8 == 0) goto L_0x00cb;
    L_0x00c4:
        r1 = "LocalBroadcastManager";
        r7 = "  Filter's target already added";
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x010b }
    L_0x00cb:
        r10 = r10 + 1;
        goto L_0x0090;
    L_0x00ce:
        r8 = 0;
        goto L_0x002c;
    L_0x00d1:
        r1 = r13.a;	 Catch:{ all -> 0x010b }
        r7 = "LocalBroadcastManager";
        r11 = r1.match(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x010b }
        if (r11 < 0) goto L_0x010e;
    L_0x00db:
        if (r8 == 0) goto L_0x00fd;
    L_0x00dd:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r7.<init>();	 Catch:{ all -> 0x010b }
        r16 = "  Filter matched!  match=0x";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r16 = java.lang.Integer.toHexString(r11);	 Catch:{ all -> 0x010b }
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.toString();	 Catch:{ all -> 0x010b }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x010b }
    L_0x00fd:
        if (r14 != 0) goto L_0x0104;
    L_0x00ff:
        r14 = new java.util.ArrayList;	 Catch:{ all -> 0x010b }
        r14.<init>();	 Catch:{ all -> 0x010b }
    L_0x0104:
        r14.add(r13);	 Catch:{ all -> 0x010b }
        r1 = 1;
        r13.c = r1;	 Catch:{ all -> 0x010b }
        goto L_0x00cb;
    L_0x010b:
        r1 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x010b }
        throw r1;
    L_0x010e:
        if (r8 == 0) goto L_0x00cb;
    L_0x0110:
        switch(r11) {
            case -4: goto L_0x0133;
            case -3: goto L_0x0130;
            case -2: goto L_0x0136;
            case -1: goto L_0x0139;
            default: goto L_0x0113;
        };
    L_0x0113:
        r12 = "unknown reason";
    L_0x0115:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r7.<init>();	 Catch:{ all -> 0x010b }
        r16 = "  Filter did not match: ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.append(r12);	 Catch:{ all -> 0x010b }
        r7 = r7.toString();	 Catch:{ all -> 0x010b }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x010b }
        goto L_0x00cb;
    L_0x0130:
        r12 = "action";
        goto L_0x0115;
    L_0x0133:
        r12 = "category";
        goto L_0x0115;
    L_0x0136:
        r12 = "data";
        goto L_0x0115;
    L_0x0139:
        r12 = "type";
        goto L_0x0115;
    L_0x013c:
        if (r14 == 0) goto L_0x0175;
    L_0x013e:
        r10 = 0;
    L_0x013f:
        r1 = r14.size();	 Catch:{ all -> 0x010b }
        if (r10 >= r1) goto L_0x0151;
    L_0x0145:
        r1 = r14.get(r10);	 Catch:{ all -> 0x010b }
        r1 = (defpackage.bn$b) r1;	 Catch:{ all -> 0x010b }
        r7 = 0;
        r1.c = r7;	 Catch:{ all -> 0x010b }
        r10 = r10 + 1;
        goto L_0x013f;
    L_0x0151:
        r0 = r17;
        r1 = r0.d;	 Catch:{ all -> 0x010b }
        r7 = new bn$a;	 Catch:{ all -> 0x010b }
        r0 = r18;
        r7.<init>(r0, r14);	 Catch:{ all -> 0x010b }
        r1.add(r7);	 Catch:{ all -> 0x010b }
        r0 = r17;
        r1 = r0.e;	 Catch:{ all -> 0x010b }
        r7 = 1;
        r1 = r1.hasMessages(r7);	 Catch:{ all -> 0x010b }
        if (r1 != 0) goto L_0x0172;
    L_0x016a:
        r0 = r17;
        r1 = r0.e;	 Catch:{ all -> 0x010b }
        r7 = 1;
        r1.sendEmptyMessage(r7);	 Catch:{ all -> 0x010b }
    L_0x0172:
        r1 = 1;
        monitor-exit(r15);	 Catch:{ all -> 0x010b }
    L_0x0174:
        return r1;
    L_0x0175:
        monitor-exit(r15);	 Catch:{ all -> 0x010b }
        r1 = 0;
        goto L_0x0174;
        */
        throw new UnsupportedOperationException("Method not decompiled: bn.a(android.content.Intent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
        r8 = this;
    L_0x0000:
        r2 = 0;
        r6 = r8.b;
        monitor-enter(r6);
        r5 = r8.d;	 Catch:{ all -> 0x003e }
        r0 = r5.size();	 Catch:{ all -> 0x003e }
        if (r0 > 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r6);	 Catch:{ all -> 0x003e }
        return;
    L_0x000e:
        r2 = new defpackage.bn$a[r0];	 Catch:{ all -> 0x003e }
        r5 = r8.d;	 Catch:{ all -> 0x003e }
        r5.toArray(r2);	 Catch:{ all -> 0x003e }
        r5 = r8.d;	 Catch:{ all -> 0x003e }
        r5.clear();	 Catch:{ all -> 0x003e }
        monitor-exit(r6);	 Catch:{ all -> 0x003e }
        r3 = 0;
    L_0x001c:
        r5 = r2.length;
        if (r3 >= r5) goto L_0x0000;
    L_0x001f:
        r1 = r2[r3];
        r4 = 0;
    L_0x0022:
        r5 = r1.b;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x0041;
    L_0x002a:
        r5 = r1.b;
        r5 = r5.get(r4);
        r5 = (defpackage.bn$b) r5;
        r5 = r5.b;
        r6 = r8.a;
        r7 = r1.a;
        r5.onReceive(r6, r7);
        r4 = r4 + 1;
        goto L_0x0022;
    L_0x003e:
        r5 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x003e }
        throw r5;
    L_0x0041:
        r3 = r3 + 1;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: bn.a():void");
    }
}
