package defpackage;

/* compiled from: TextDirectionHeuristicsCompat */
abstract class de$d implements dd {
    private final de$c a;

    protected abstract boolean a();

    public de$d(de$c algorithm) {
        this.a = algorithm;
    }

    public boolean a(CharSequence cs, int start, int count) {
        if (cs == null || start < 0 || count < 0 || cs.length() - count < start) {
            throw new IllegalArgumentException();
        } else if (this.a == null) {
            return a();
        } else {
            return b(cs, start, count);
        }
    }

    private boolean b(CharSequence cs, int start, int count) {
        switch (this.a.a(cs, start, count)) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return true;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return false;
            default:
                return a();
        }
    }
}
