package defpackage;

import com.google.android.gms.common.api.GoogleApiActivity;

class aav$a implements Runnable {
    final /* synthetic */ aav a;

    private aav$a(aav aav) {
        this.a = aav;
    }

    public void run() {
        if (!this.a.a) {
            return;
        }
        if (this.a.e.a()) {
            this.a.d.startActivityForResult(GoogleApiActivity.b(this.a.e(), this.a.e.d(), this.a.f, false), 1);
        } else if (this.a.c.a(this.a.e.c())) {
            this.a.c.a(this.a.e(), this.a.d, this.a.e.c(), 2, this.a);
        } else if (this.a.e.c() == 18) {
            this.a.c.a(this.a.e().getApplicationContext(), new aav$a$1(this, this.a.c.a(this.a.e(), this.a)));
        } else {
            this.a.a(this.a.e, this.a.f);
        }
    }
}
