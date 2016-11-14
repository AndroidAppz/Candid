/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory2
 *  java.lang.Object
 */
import android.view.LayoutInflater;

class ef {
    /*
     * Enabled aggressive block sorting
     */
    static void a(LayoutInflater layoutInflater, eg eg2) {
        ee.a a2 = eg2 != null ? new ee.a(eg2) : null;
        layoutInflater.setFactory2((LayoutInflater.Factory2)a2);
    }
}

