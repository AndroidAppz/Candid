/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 *  android.util.SparseArray
 *  com.google.android.gms.common.api.Status
 *  java.lang.Object
 */
import android.os.DeadObjectException;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;

public abstract class aar {
    public final int a;
    public final int b;

    public void a(SparseArray<abi> sparseArray) {
    }

    public abstract void a(Status var1);

    public abstract void a(wx.c var1) throws DeadObjectException;

    public boolean a() {
        return true;
    }

    public static final class a
    extends aar {
        public final aau.a<? extends xc, wx.c> c;

        @Override
        public void a(SparseArray<abi> sparseArray) {
            abi abi2 = (abi)sparseArray.get(this.a);
            if (abi2 != null) {
                abi2.a(this.c);
            }
        }

        @Override
        public void a(Status status) {
            this.c.a(status);
        }

        @Override
        public void a(wx.c c2) throws DeadObjectException {
            this.c.a((xc)((Object)c2));
        }

        @Override
        public boolean a() {
            return this.c.g();
        }
    }

}

