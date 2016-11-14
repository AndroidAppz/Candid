package defpackage;

import android.os.DeadObjectException;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;

public final class aar$a extends aar {
    public final aau$a<? extends xc, wx$c> c;

    public void a(SparseArray<abi> sparseArray) {
        abi abi = (abi) sparseArray.get(this.a);
        if (abi != null) {
            abi.a(this.c);
        }
    }

    public void a(Status status) {
        this.c.a(status);
    }

    public void a(wx$c wx_c) throws DeadObjectException {
        this.c.a(wx_c);
    }

    public boolean a() {
        return this.c.g();
    }
}
