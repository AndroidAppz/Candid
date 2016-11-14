package defpackage;

class agy {
    final boolean a;
    final int b;
    long c;
    double d;
    long e;
    double f;
    long g;
    double h;
    final boolean i;

    public agy(abq$d abq_d) {
        boolean z;
        boolean z2 = true;
        xr.a((Object) abq_d);
        if (abq_d.b == null || abq_d.b.intValue() == 0) {
            z = false;
        } else {
            if (abq_d.b.intValue() != 4) {
                if (abq_d.d == null) {
                    z = false;
                }
            } else if (abq_d.e == null || abq_d.f == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.b = abq_d.b.intValue();
            if (abq_d.c == null || !abq_d.c.booleanValue()) {
                z2 = false;
            }
            this.a = z2;
            if (abq_d.b.intValue() == 4) {
                if (this.a) {
                    this.f = Double.parseDouble(abq_d.e);
                    this.h = Double.parseDouble(abq_d.f);
                } else {
                    this.e = Long.parseLong(abq_d.e);
                    this.g = Long.parseLong(abq_d.f);
                }
            } else if (this.a) {
                this.d = Double.parseDouble(abq_d.d);
            } else {
                this.c = Long.parseLong(abq_d.d);
            }
        } else {
            this.b = 0;
            this.a = false;
        }
        this.i = z;
    }

    public Boolean a(double d) {
        boolean z = true;
        boolean z2 = false;
        if (!this.i) {
            return null;
        }
        if (!this.a) {
            return null;
        }
        switch (this.b) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                if (d >= this.d) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                if (d <= this.d) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                if (d == this.d || Math.abs(d - this.d) < 2.0d * Math.max(Math.ulp(d), Math.ulp(this.d))) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                if (d < this.f || d > this.h) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }

    public Boolean a(long j) {
        boolean z = true;
        if (!this.i) {
            return null;
        }
        if (this.a) {
            return null;
        }
        switch (this.b) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                if (j >= this.c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                if (j <= this.c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                if (j != this.c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                if (j < this.e || j > this.g) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }
}
