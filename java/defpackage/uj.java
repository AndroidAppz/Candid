package defpackage;

import android.content.Intent;
import com.facebook.Profile;

/* compiled from: ProfileManager */
public final class uj {
    private static volatile uj a;
    private final bn b;
    private final ui c;
    private Profile d;

    uj(bn localBroadcastManager, ui profileCache) {
        vx.a((Object) localBroadcastManager, "localBroadcastManager");
        vx.a((Object) profileCache, "profileCache");
        this.b = localBroadcastManager;
        this.c = profileCache;
    }

    public static uj a() {
        if (a == null) {
            synchronized (uj.class) {
                if (a == null) {
                    a = new uj(bn.a(ud.f()), new ui());
                }
            }
        }
        return a;
    }

    public Profile b() {
        return this.d;
    }

    boolean c() {
        Profile profile = this.c.a();
        if (profile == null) {
            return false;
        }
        a(profile, false);
        return true;
    }

    public void a(Profile currentProfile) {
        a(currentProfile, true);
    }

    private void a(Profile currentProfile, boolean writeToCache) {
        Profile oldProfile = this.d;
        this.d = currentProfile;
        if (writeToCache) {
            if (currentProfile != null) {
                this.c.a(currentProfile);
            } else {
                this.c.b();
            }
        }
        if (!vw.a((Object) oldProfile, (Object) currentProfile)) {
            a(oldProfile, currentProfile);
        }
    }

    private void a(Profile oldProfile, Profile currentProfile) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", oldProfile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", currentProfile);
        this.b.a(intent);
    }
}
