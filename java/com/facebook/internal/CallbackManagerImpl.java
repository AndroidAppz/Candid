package com.facebook.internal;

import android.content.Intent;
import defpackage.ub;
import defpackage.ud;
import defpackage.vx;
import java.util.HashMap;
import java.util.Map;

public final class CallbackManagerImpl implements ub {
    private static Map<Integer, a> a = new HashMap();
    private Map<Integer, a> b = new HashMap();

    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8);
        
        private final int j;

        private RequestCodeOffset(int offset) {
            this.j = offset;
        }

        public int a() {
            return ud.n() + this.j;
        }
    }

    public interface a {
        boolean a(int i, Intent intent);
    }

    public static synchronized void a(int requestCode, a callback) {
        synchronized (CallbackManagerImpl.class) {
            vx.a((Object) callback, "callback");
            if (!a.containsKey(Integer.valueOf(requestCode))) {
                a.put(Integer.valueOf(requestCode), callback);
            }
        }
    }

    private static synchronized a a(Integer requestCode) {
        a aVar;
        synchronized (CallbackManagerImpl.class) {
            aVar = (a) a.get(requestCode);
        }
        return aVar;
    }

    private static boolean b(int requestCode, int resultCode, Intent data) {
        a callback = a(Integer.valueOf(requestCode));
        if (callback != null) {
            return callback.a(resultCode, data);
        }
        return false;
    }

    public void b(int requestCode, a callback) {
        vx.a((Object) callback, "callback");
        this.b.put(Integer.valueOf(requestCode), callback);
    }

    public boolean a(int requestCode, int resultCode, Intent data) {
        a callback = (a) this.b.get(Integer.valueOf(requestCode));
        if (callback != null) {
            return callback.a(resultCode, data);
        }
        return b(requestCode, resultCode, data);
    }
}
