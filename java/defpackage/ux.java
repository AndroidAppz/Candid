package defpackage;

import android.content.Intent;
import java.util.UUID;

/* compiled from: AppCall */
public class ux {
    private static ux a;
    private UUID b;
    private Intent c;
    private int d;

    public static ux a() {
        return a;
    }

    public static synchronized ux a(UUID callId, int requestCode) {
        ux pendingCall;
        synchronized (ux.class) {
            pendingCall = ux.a();
            if (pendingCall != null && pendingCall.c().equals(callId) && pendingCall.d() == requestCode) {
                ux.a(null);
            } else {
                pendingCall = null;
            }
        }
        return pendingCall;
    }

    private static synchronized boolean a(ux appCall) {
        boolean z;
        synchronized (ux.class) {
            ux oldAppCall = ux.a();
            a = appCall;
            z = oldAppCall != null;
        }
        return z;
    }

    public ux(int requestCode) {
        this(requestCode, UUID.randomUUID());
    }

    public ux(int requestCode, UUID callId) {
        this.b = callId;
        this.d = requestCode;
    }

    public Intent b() {
        return this.c;
    }

    public UUID c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public void a(Intent requestIntent) {
        this.c = requestIntent;
    }

    public boolean e() {
        return ux.a(this);
    }
}
