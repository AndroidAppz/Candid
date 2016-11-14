package defpackage;

import java.util.Comparator;

/* compiled from: EventsFilesManager */
class amj$1 implements Comparator<amj$a> {
    final /* synthetic */ amj a;

    amj$1(amj amj) {
        this.a = amj;
    }

    public /* synthetic */ int compare(Object x0, Object x1) {
        return a((amj$a) x0, (amj$a) x1);
    }

    public int a(amj$a arg0, amj$a arg1) {
        return (int) (arg0.b - arg1.b);
    }
}
