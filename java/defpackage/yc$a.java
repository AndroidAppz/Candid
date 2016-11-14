package defpackage;

import java.util.ArrayList;
import java.util.List;

class yc$a extends yc {
    List<yc> p;

    yc$a(List<yc> list) {
        this.p = list;
    }

    public yc a(yc ycVar) {
        List arrayList = new ArrayList(this.p);
        arrayList.add((yc) xr.a((Object) ycVar));
        return new yc$a(arrayList);
    }

    public boolean b(char c) {
        for (yc b : this.p) {
            if (b.b(c)) {
                return true;
            }
        }
        return false;
    }
}
