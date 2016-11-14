package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* compiled from: PlatformServiceClient */
public abstract class vs implements ServiceConnection {
    private final Context a;
    private final Handler b;
    private vs$a c;
    private boolean d;
    private Messenger e;
    private int f;
    private int g;
    private final String h;
    private final int i;

    protected abstract void a(Bundle bundle);

    public vs(Context context, int requestMessage, int replyMessage, int protocolVersion, String applicationId) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.a = applicationContext;
        this.f = requestMessage;
        this.g = replyMessage;
        this.h = applicationId;
        this.i = protocolVersion;
        this.b = new vs$1(this);
    }

    public void a(vs$a listener) {
        this.c = listener;
    }

    public boolean a() {
        if (this.d || vr.b(this.i) == -1) {
            return false;
        }
        Intent intent = vr.a(this.a);
        if (intent == null) {
            return false;
        }
        this.d = true;
        this.a.bindService(intent, this, 1);
        return true;
    }

    public void b() {
        this.d = false;
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        this.e = new Messenger(service);
        c();
    }

    public void onServiceDisconnected(ComponentName name) {
        this.e = null;
        try {
            this.a.unbindService(this);
        } catch (IllegalArgumentException e) {
        }
        b(null);
    }

    private void c() {
        Bundle data = new Bundle();
        data.putString("com.facebook.platform.extra.APPLICATION_ID", this.h);
        a(data);
        Message request = Message.obtain(null, this.f);
        request.arg1 = this.i;
        request.setData(data);
        request.replyTo = new Messenger(this.b);
        try {
            this.e.send(request);
        } catch (RemoteException e) {
            b(null);
        }
    }

    protected void a(Message message) {
        if (message.what == this.g) {
            Bundle extras = message.getData();
            if (extras.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                b(null);
            } else {
                b(extras);
            }
            this.a.unbindService(this);
        }
    }

    private void b(Bundle result) {
        if (this.d) {
            this.d = false;
            vs$a callback = this.c;
            if (callback != null) {
                callback.a(result);
            }
        }
    }
}
