package defpackage;

/* compiled from: NativeProtocol */
class vr$1 implements Runnable {
    vr$1() {
    }

    public void run() {
        try {
            for (vr$c appInfo : vr.b) {
                appInfo.a(true);
            }
        } finally {
            vr.d.set(false);
        }
    }
}
