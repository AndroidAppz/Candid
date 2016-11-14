package defpackage;

import java.util.List;

/* compiled from: Utility */
public class vw$e {
    List<String> a;
    List<String> b;

    public vw$e(List<String> grantedPermissions, List<String> declinedPermissions) {
        this.a = grantedPermissions;
        this.b = declinedPermissions;
    }

    public List<String> a() {
        return this.a;
    }

    public List<String> b() {
        return this.b;
    }
}
