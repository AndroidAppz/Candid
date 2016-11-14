package defpackage;

/* compiled from: ProducerArbiter */
public final class aqi implements apf {
    static final apf g = new aqi$1();
    long a;
    apf b;
    boolean c;
    long d;
    long e;
    apf f;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(long r12) {
        /*
        r11 = this;
        r8 = 0;
        r6 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));
        if (r6 >= 0) goto L_0x000e;
    L_0x0006:
        r6 = new java.lang.IllegalArgumentException;
        r7 = "n >= 0 required";
        r6.<init>(r7);
        throw r6;
    L_0x000e:
        r6 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));
        if (r6 != 0) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        monitor-enter(r11);
        r6 = r11.c;	 Catch:{ all -> 0x001f }
        if (r6 == 0) goto L_0x0022;
    L_0x0018:
        r6 = r11.d;	 Catch:{ all -> 0x001f }
        r6 = r6 + r12;
        r11.d = r6;	 Catch:{ all -> 0x001f }
        monitor-exit(r11);	 Catch:{ all -> 0x001f }
        goto L_0x0012;
    L_0x001f:
        r6 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x001f }
        throw r6;
    L_0x0022:
        r6 = 1;
        r11.c = r6;	 Catch:{ all -> 0x001f }
        monitor-exit(r11);	 Catch:{ all -> 0x001f }
        r1 = 0;
        r2 = r11.a;	 Catch:{ all -> 0x004c }
        r4 = r2 + r12;
        r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r6 >= 0) goto L_0x0034;
    L_0x002f:
        r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
    L_0x0034:
        r11.a = r4;	 Catch:{ all -> 0x004c }
        r0 = r11.b;	 Catch:{ all -> 0x004c }
        if (r0 == 0) goto L_0x003d;
    L_0x003a:
        r0.a(r12);	 Catch:{ all -> 0x004c }
    L_0x003d:
        r11.a();	 Catch:{ all -> 0x004c }
        r1 = 1;
        if (r1 != 0) goto L_0x0012;
    L_0x0043:
        monitor-enter(r11);
        r6 = 0;
        r11.c = r6;	 Catch:{ all -> 0x0049 }
        monitor-exit(r11);	 Catch:{ all -> 0x0049 }
        goto L_0x0012;
    L_0x0049:
        r6 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0049 }
        throw r6;
    L_0x004c:
        r6 = move-exception;
        if (r1 != 0) goto L_0x0054;
    L_0x004f:
        monitor-enter(r11);
        r7 = 0;
        r11.c = r7;	 Catch:{ all -> 0x0055 }
        monitor-exit(r11);	 Catch:{ all -> 0x0055 }
    L_0x0054:
        throw r6;
    L_0x0055:
        r6 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0055 }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: aqi.a(long):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(long r12) {
        /*
        r11 = this;
        r8 = 0;
        r3 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));
        if (r3 > 0) goto L_0x000e;
    L_0x0006:
        r3 = new java.lang.IllegalArgumentException;
        r6 = "n > 0 required";
        r3.<init>(r6);
        throw r3;
    L_0x000e:
        monitor-enter(r11);
        r3 = r11.c;	 Catch:{ all -> 0x0041 }
        if (r3 == 0) goto L_0x001a;
    L_0x0013:
        r6 = r11.e;	 Catch:{ all -> 0x0041 }
        r6 = r6 + r12;
        r11.e = r6;	 Catch:{ all -> 0x0041 }
        monitor-exit(r11);	 Catch:{ all -> 0x0041 }
    L_0x0019:
        return;
    L_0x001a:
        r3 = 1;
        r11.c = r3;	 Catch:{ all -> 0x0041 }
        monitor-exit(r11);	 Catch:{ all -> 0x0041 }
        r2 = 0;
        r0 = r11.a;	 Catch:{ all -> 0x0038 }
        r6 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r3 == 0) goto L_0x0046;
    L_0x002a:
        r4 = r0 - r12;
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x0044;
    L_0x0030:
        r3 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0038 }
        r6 = "more items arrived than were requested";
        r3.<init>(r6);	 Catch:{ all -> 0x0038 }
        throw r3;	 Catch:{ all -> 0x0038 }
    L_0x0038:
        r3 = move-exception;
        if (r2 != 0) goto L_0x0040;
    L_0x003b:
        monitor-enter(r11);
        r6 = 0;
        r11.c = r6;	 Catch:{ all -> 0x0055 }
        monitor-exit(r11);	 Catch:{ all -> 0x0055 }
    L_0x0040:
        throw r3;
    L_0x0041:
        r3 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0041 }
        throw r3;
    L_0x0044:
        r11.a = r4;	 Catch:{ all -> 0x0038 }
    L_0x0046:
        r11.a();	 Catch:{ all -> 0x0038 }
        r2 = 1;
        if (r2 != 0) goto L_0x0019;
    L_0x004c:
        monitor-enter(r11);
        r3 = 0;
        r11.c = r3;	 Catch:{ all -> 0x0052 }
        monitor-exit(r11);	 Catch:{ all -> 0x0052 }
        goto L_0x0019;
    L_0x0052:
        r3 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0052 }
        throw r3;
    L_0x0055:
        r3 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0055 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: aqi.b(long):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(defpackage.apf r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r1 = r4.c;	 Catch:{ all -> 0x002a }
        if (r1 == 0) goto L_0x000d;
    L_0x0005:
        if (r5 != 0) goto L_0x0009;
    L_0x0007:
        r5 = g;	 Catch:{ all -> 0x002a }
    L_0x0009:
        r4.f = r5;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
    L_0x000c:
        return;
    L_0x000d:
        r1 = 1;
        r4.c = r1;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        r0 = 0;
        r4.b = r5;	 Catch:{ all -> 0x002d }
        if (r5 == 0) goto L_0x001b;
    L_0x0016:
        r2 = r4.a;	 Catch:{ all -> 0x002d }
        r5.a(r2);	 Catch:{ all -> 0x002d }
    L_0x001b:
        r4.a();	 Catch:{ all -> 0x002d }
        r0 = 1;
        if (r0 != 0) goto L_0x000c;
    L_0x0021:
        monitor-enter(r4);
        r1 = 0;
        r4.c = r1;	 Catch:{ all -> 0x0027 }
        monitor-exit(r4);	 Catch:{ all -> 0x0027 }
        goto L_0x000c;
    L_0x0027:
        r1 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0027 }
        throw r1;
    L_0x002a:
        r1 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        throw r1;
    L_0x002d:
        r1 = move-exception;
        if (r0 != 0) goto L_0x0035;
    L_0x0030:
        monitor-enter(r4);
        r2 = 0;
        r4.c = r2;	 Catch:{ all -> 0x0036 }
        monitor-exit(r4);	 Catch:{ all -> 0x0036 }
    L_0x0035:
        throw r1;
    L_0x0036:
        r1 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0036 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: aqi.a(apf):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
        r14 = this;
    L_0x0000:
        monitor-enter(r14);
        r4 = r14.d;	 Catch:{ all -> 0x0053 }
        r0 = r14.e;	 Catch:{ all -> 0x0053 }
        r2 = r14.f;	 Catch:{ all -> 0x0053 }
        r12 = 0;
        r12 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1));
        if (r12 != 0) goto L_0x001a;
    L_0x000d:
        r12 = 0;
        r12 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1));
        if (r12 != 0) goto L_0x001a;
    L_0x0013:
        if (r2 != 0) goto L_0x001a;
    L_0x0015:
        r12 = 0;
        r14.c = r12;	 Catch:{ all -> 0x0053 }
        monitor-exit(r14);	 Catch:{ all -> 0x0053 }
        return;
    L_0x001a:
        r12 = 0;
        r14.d = r12;	 Catch:{ all -> 0x0053 }
        r12 = 0;
        r14.e = r12;	 Catch:{ all -> 0x0053 }
        r12 = 0;
        r14.f = r12;	 Catch:{ all -> 0x0053 }
        monitor-exit(r14);	 Catch:{ all -> 0x0053 }
        r6 = r14.a;
        r12 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r12 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r12 == 0) goto L_0x0049;
    L_0x0031:
        r8 = r6 + r4;
        r12 = 0;
        r12 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r12 < 0) goto L_0x0042;
    L_0x0039:
        r12 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r12 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r12 != 0) goto L_0x0056;
    L_0x0042:
        r6 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r14.a = r6;
    L_0x0049:
        if (r2 == 0) goto L_0x0070;
    L_0x004b:
        r12 = g;
        if (r2 != r12) goto L_0x006a;
    L_0x004f:
        r12 = 0;
        r14.b = r12;
        goto L_0x0000;
    L_0x0053:
        r12 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x0053 }
        throw r12;
    L_0x0056:
        r10 = r8 - r0;
        r12 = 0;
        r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r12 >= 0) goto L_0x0066;
    L_0x005e:
        r12 = new java.lang.IllegalStateException;
        r13 = "more produced than requested";
        r12.<init>(r13);
        throw r12;
    L_0x0066:
        r6 = r10;
        r14.a = r10;
        goto L_0x0049;
    L_0x006a:
        r14.b = r2;
        r2.a(r6);
        goto L_0x0000;
    L_0x0070:
        r3 = r14.b;
        if (r3 == 0) goto L_0x0000;
    L_0x0074:
        r12 = 0;
        r12 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1));
        if (r12 == 0) goto L_0x0000;
    L_0x007a:
        r3.a(r4);
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: aqi.a():void");
    }
}
