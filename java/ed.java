/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory
 *  android.view.View
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

class ed {
    static eg a(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof a) {
            return ((a)factory).a;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    static void a(LayoutInflater layoutInflater, eg eg2) {
        a a2 = eg2 != null ? new a(eg2) : null;
        layoutInflater.setFactory((LayoutInflater.Factory)a2);
    }

    static class a
    implements LayoutInflater.Factory {
        final eg a;

        a(eg eg2) {
            this.a = eg2;
        }

        public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
            return this.a.onCreateView(null, string2, context, attributeSet);
        }

        public String toString() {
            return this.getClass().getName() + "{" + this.a + "}";
        }
    }

}

