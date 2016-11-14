package defpackage;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;

/* compiled from: LayoutInflaterCompatBase */
class ed {
    static void a(LayoutInflater inflater, eg factory) {
        inflater.setFactory(factory != null ? new ed$a(factory) : null);
    }

    static eg a(LayoutInflater inflater) {
        Factory factory = inflater.getFactory();
        if (factory instanceof ed$a) {
            return ((ed$a) factory).a;
        }
        return null;
    }
}
