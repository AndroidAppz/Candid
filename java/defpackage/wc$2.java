package defpackage;

import android.view.View;
import com.facebook.login.LoginClient.a;

/* compiled from: LoginFragment */
class wc$2 implements a {
    final /* synthetic */ View a;
    final /* synthetic */ wc b;

    wc$2(wc this$0, View view) {
        this.b = this$0;
        this.a = view;
    }

    public void a() {
        this.a.findViewById(um$d.com_facebook_login_activity_progress_bar).setVisibility(0);
    }

    public void b() {
        this.a.findViewById(um$d.com_facebook_login_activity_progress_bar).setVisibility(8);
    }
}
