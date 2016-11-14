package defpackage;

import java.io.IOException;

/* compiled from: Phonemetadata */
public final class ajx$c extends aka {
    public ajx$b[] a;

    public /* synthetic */ aka b(ajy ajy) throws IOException {
        return a(ajy);
    }

    public ajx$c() {
        a();
    }

    public ajx$c a() {
        this.a = ajx$b.a();
        this.F = -1;
        return this;
    }

    public ajx$c a(ajy input) throws IOException {
        while (true) {
            int tag = input.a();
            switch (tag) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    int i;
                    int arrayLength = akc.b(input, 10);
                    if (this.a == null) {
                        i = 0;
                    } else {
                        i = this.a.length;
                    }
                    ajx$b[] newArray = new ajx$b[(i + arrayLength)];
                    if (i != 0) {
                        System.arraycopy(this.a, 0, newArray, 0, i);
                    }
                    while (i < newArray.length - 1) {
                        newArray[i] = new ajx$b();
                        input.a(newArray[i]);
                        input.a();
                        i++;
                    }
                    newArray[i] = new ajx$b();
                    input.a(newArray[i]);
                    this.a = newArray;
                    continue;
                default:
                    if (!akc.a(input, tag)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
