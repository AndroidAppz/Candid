/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.LightingColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.lang.reflect.Array;

public class ig {
    public static Bitmap a(Bitmap bitmap, int n2, int n3) {
        float f2 = (float)n2 / (float)n3;
        (float)bitmap.getWidth() / (float)bitmap.getHeight();
        int n4 = bitmap.getWidth();
        int n5 = (int)((float)bitmap.getWidth() / f2);
        int n6 = (bitmap.getHeight() - n5) / 2;
        try {
            Bitmap bitmap2 = ig.a(Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)n6, (int)n4, (int)n5), n4 / 32, true);
            Canvas canvas = new Canvas(bitmap2);
            Paint paint = new Paint(-65536);
            paint.setColorFilter((ColorFilter)new LightingColorFilter(-9408400, 1118481));
            canvas.drawBitmap(bitmap2, new Matrix(), paint);
            return bitmap2;
        }
        catch (Exception var8_10) {
            rb.a((Throwable)var8_10);
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Bitmap a(Bitmap bitmap, int n2, boolean bl2) {
        int n3;
        Bitmap bitmap2 = bl2 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (n2 < 1) {
            return null;
        }
        int n4 = bitmap2.getWidth();
        int n5 = bitmap2.getHeight();
        int[] arrn = new int[n4 * n5];
        bitmap2.getPixels(arrn, 0, n4, 0, 0, n4, n5);
        int n6 = n4 - 1;
        int n7 = n5 - 1;
        int n8 = n4 * n5;
        int n9 = 1 + (n2 + n2);
        int[] arrn2 = new int[n8];
        int[] arrn3 = new int[n8];
        int[] arrn4 = new int[n8];
        int[] arrn5 = new int[Math.max((int)n4, (int)n5)];
        int n10 = n9 + 1 >> 1;
        int n11 = n10 * n10;
        int[] arrn6 = new int[n11 * 256];
        for (int i2 = 0; i2 < (n3 = n11 * 256); ++i2) {
            arrn6[i2] = i2 / n11;
        }
        int n12 = 0;
        int n13 = 0;
        int[] arrn7 = new int[]{n9, 3};
        int[][] arrn8 = (int[][])Array.newInstance((Class)Integer.TYPE, (int[])arrn7);
        int n14 = n2 + 1;
        int n15 = 0;
        do {
            if (n15 >= n5) break;
            int n16 = 0;
            int n17 = 0;
            int n18 = 0;
            int n19 = 0;
            int n20 = 0;
            int n21 = 0;
            int n22 = 0;
            int n23 = 0;
            int n24 = 0;
            for (int i3 = - n2; i3 <= n2; ++i3) {
                int n25 = arrn[n12 + Math.min((int)n6, (int)Math.max((int)i3, (int)0))];
                int[] arrn9 = arrn8[i3 + n2];
                arrn9[0] = (16711680 & n25) >> 16;
                arrn9[1] = (65280 & n25) >> 8;
                arrn9[2] = n25 & 255;
                int n26 = n14 - Math.abs((int)i3);
                n18 += n26 * arrn9[0];
                n17 += n26 * arrn9[1];
                n16 += n26 * arrn9[2];
                if (i3 > 0) {
                    n24 += arrn9[0];
                    n23 += arrn9[1];
                    n22 += arrn9[2];
                    continue;
                }
                n21 += arrn9[0];
                n20 += arrn9[1];
                n19 += arrn9[2];
            }
            int n27 = n2;
            for (int i4 = 0; i4 < n4; ++n12, ++i4) {
                arrn2[n12] = arrn6[n18];
                arrn3[n12] = arrn6[n17];
                arrn4[n12] = arrn6[n16];
                int n28 = n18 - n21;
                int n29 = n17 - n20;
                int n30 = n16 - n19;
                int[] arrn10 = arrn8[(n9 + (n27 - n2)) % n9];
                int n31 = n21 - arrn10[0];
                int n32 = n20 - arrn10[1];
                int n33 = n19 - arrn10[2];
                if (n15 == 0) {
                    arrn5[i4] = Math.min((int)(1 + (i4 + n2)), (int)n6);
                }
                int n34 = arrn[n13 + arrn5[i4]];
                arrn10[0] = (16711680 & n34) >> 16;
                arrn10[1] = (65280 & n34) >> 8;
                arrn10[2] = n34 & 255;
                int n35 = n24 + arrn10[0];
                int n36 = n23 + arrn10[1];
                int n37 = n22 + arrn10[2];
                n18 = n28 + n35;
                n17 = n29 + n36;
                n16 = n30 + n37;
                n27 = (n27 + 1) % n9;
                int[] arrn11 = arrn8[n27 % n9];
                n21 = n31 + arrn11[0];
                n20 = n32 + arrn11[1];
                n19 = n33 + arrn11[2];
                n24 = n35 - arrn11[0];
                n23 = n36 - arrn11[1];
                n22 = n37 - arrn11[2];
            }
            n13 += n4;
            ++n15;
        } while (true);
        int n38 = 0;
        do {
            if (n38 >= n4) {
                bitmap2.setPixels(arrn, 0, n4, 0, 0, n4, n5);
                return bitmap2;
            }
            int n39 = 0;
            int n40 = 0;
            int n41 = 0;
            int n42 = 0;
            int n43 = 0;
            int n44 = 0;
            int n45 = 0;
            int n46 = 0;
            int n47 = 0;
            int n48 = n4 * (- n2);
            for (int i5 = - n2; i5 <= n2; ++i5) {
                int n49 = n38 + Math.max((int)0, (int)n48);
                int[] arrn12 = arrn8[i5 + n2];
                arrn12[0] = arrn2[n49];
                arrn12[1] = arrn3[n49];
                arrn12[2] = arrn4[n49];
                int n50 = n14 - Math.abs((int)i5);
                n41 += n50 * arrn2[n49];
                n40 += n50 * arrn3[n49];
                n39 += n50 * arrn4[n49];
                if (i5 > 0) {
                    n47 += arrn12[0];
                    n46 += arrn12[1];
                    n45 += arrn12[2];
                } else {
                    n44 += arrn12[0];
                    n43 += arrn12[1];
                    n42 += arrn12[2];
                }
                if (i5 >= n7) continue;
                n48 += n4;
            }
            int n51 = n38;
            int n52 = n2;
            for (int i6 = 0; i6 < n5; n51 += n4, ++i6) {
                arrn[n51] = -16777216 & arrn[n51] | arrn6[n41] << 16 | arrn6[n40] << 8 | arrn6[n39];
                int n53 = n41 - n44;
                int n54 = n40 - n43;
                int n55 = n39 - n42;
                int[] arrn13 = arrn8[(n9 + (n52 - n2)) % n9];
                int n56 = n44 - arrn13[0];
                int n57 = n43 - arrn13[1];
                int n58 = n42 - arrn13[2];
                if (n38 == 0) {
                    arrn5[i6] = n4 * Math.min((int)(i6 + n14), (int)n7);
                }
                int n59 = n38 + arrn5[i6];
                arrn13[0] = arrn2[n59];
                arrn13[1] = arrn3[n59];
                arrn13[2] = arrn4[n59];
                int n60 = n47 + arrn13[0];
                int n61 = n46 + arrn13[1];
                int n62 = n45 + arrn13[2];
                n41 = n53 + n60;
                n40 = n54 + n61;
                n39 = n55 + n62;
                n52 = (n52 + 1) % n9;
                int[] arrn14 = arrn8[n52];
                n44 = n56 + arrn14[0];
                n43 = n57 + arrn14[1];
                n42 = n58 + arrn14[2];
                n47 = n60 - arrn14[0];
                n46 = n61 - arrn14[1];
                n45 = n62 - arrn14[2];
            }
            ++n38;
        } while (true);
    }
}

