/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.graphics.Bitmap;

public abstract class nk
implements kj<Bitmap> {
    private lf a;

    public nk(Context context) {
        super(jp.a(context).a());
    }

    public nk(lf lf2) {
        this.a = lf2;
    }

    protected abstract Bitmap a(lf var1, Bitmap var2, int var3, int var4);

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final lb<Bitmap> a(lb<Bitmap> lb2, int n2, int n3) {
        if (!ra.a(n2, n3)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + n2 + " or height: " + n3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        Bitmap bitmap = lb2.b();
        int n4 = n2 == Integer.MIN_VALUE ? bitmap.getWidth() : n2;
        int n5 = n3 == Integer.MIN_VALUE ? bitmap.getHeight() : n3;
        Bitmap bitmap2 = this.a(this.a, bitmap, n4, n5);
        if (bitmap.equals((Object)bitmap2)) {
            return lb2;
        }
        return nj.a(bitmap2, this.a);
    }
}

