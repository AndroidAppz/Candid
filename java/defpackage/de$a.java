package defpackage;

/* compiled from: TextDirectionHeuristicsCompat */
class de$a implements de$c {
    public static final de$a a = new de$a(true);
    public static final de$a b = new de$a(false);
    private final boolean c;

    public int a(CharSequence cs, int start, int count) {
        boolean haveUnlookedFor = false;
        int e = start + count;
        for (int i = start; i < e; i++) {
            switch (de.c(Character.getDirectionality(cs.charAt(i)))) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    if (!this.c) {
                        haveUnlookedFor = true;
                        break;
                    }
                    return 0;
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    if (this.c) {
                        haveUnlookedFor = true;
                        break;
                    }
                    return 1;
                default:
                    break;
            }
        }
        if (!haveUnlookedFor) {
            return 2;
        }
        if (this.c) {
            return 1;
        }
        return 0;
    }

    private de$a(boolean lookForRtl) {
        this.c = lookForRtl;
    }
}
