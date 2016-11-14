package com.becandid.candid.activities;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import defpackage.apa;
import defpackage.apb;
import defpackage.um$h;
import defpackage.zu;
import java.lang.ref.WeakReference;

final class InviteContactsActivityPermissionsDispatcher {
    private static final String[] a = new String[]{"android.permission.READ_CONTACTS"};
    private static apa b;
    private static final String[] c = new String[]{"android.permission.READ_CONTACTS"};
    private static apa d;

    static final class ChooseContactsPermissionRequest implements apa {
        private final WeakReference<InviteContactsActivity> a;
        private final View b;

        private ChooseContactsPermissionRequest(InviteContactsActivity target, View v) {
            this.a = new WeakReference(target);
            this.b = v;
        }

        public void proceed() {
            InviteContactsActivity target = (InviteContactsActivity) this.a.get();
            if (target != null) {
                ActivityCompat.requestPermissions(target, InviteContactsActivityPermissionsDispatcher.c, 1);
            }
        }

        public void cancel() {
        }

        public void grant() {
            InviteContactsActivity target = (InviteContactsActivity) this.a.get();
            if (target != null) {
                target.chooseContacts(this.b);
            }
        }
    }

    static final class InviteAllPermissionRequest implements apa {
        private final WeakReference<InviteContactsActivity> a;
        private final View b;

        private InviteAllPermissionRequest(InviteContactsActivity target, View v) {
            this.a = new WeakReference(target);
            this.b = v;
        }

        public void proceed() {
            InviteContactsActivity target = (InviteContactsActivity) this.a.get();
            if (target != null) {
                ActivityCompat.requestPermissions(target, InviteContactsActivityPermissionsDispatcher.a, 0);
            }
        }

        public void cancel() {
        }

        public void grant() {
            InviteContactsActivity target = (InviteContactsActivity) this.a.get();
            if (target != null) {
                target.inviteAll(this.b);
            }
        }
    }

    private InviteContactsActivityPermissionsDispatcher() {
    }

    static void a(InviteContactsActivity target, View v) {
        if (apb.a((Context) target, a)) {
            target.inviteAll(v);
            return;
        }
        b = new InviteAllPermissionRequest(target, v);
        ActivityCompat.requestPermissions(target, a, 0);
    }

    static void b(InviteContactsActivity target, View v) {
        if (apb.a((Context) target, c)) {
            target.chooseContacts(v);
            return;
        }
        d = new ChooseContactsPermissionRequest(target, v);
        ActivityCompat.requestPermissions(target, c, 1);
    }

    static void a(InviteContactsActivity target, int requestCode, int[] grantResults) {
        switch (requestCode) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                if (apb.a((Context) target) >= 23 || apb.a((Context) target, a)) {
                    if (apb.a(grantResults) && b != null) {
                        b.grant();
                    }
                    b = null;
                    return;
                }
                return;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                if (apb.a((Context) target) >= 23 || apb.a((Context) target, c)) {
                    if (apb.a(grantResults) && d != null) {
                        d.grant();
                    }
                    d = null;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
