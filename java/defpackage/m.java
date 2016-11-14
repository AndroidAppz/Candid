package defpackage;

import android.graphics.Outline;

/* compiled from: CircularBorderDrawableLollipop */
class m extends l {
    m() {
    }

    public void getOutline(Outline outline) {
        copyBounds(this.b);
        outline.setOval(this.b);
    }
}
