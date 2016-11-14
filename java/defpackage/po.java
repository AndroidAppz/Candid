package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ManifestParser */
public final class po {
    private final Context a;

    public po(Context context) {
        this.a = context;
    }

    public List<pn> a() {
        List<pn> modules = new ArrayList();
        try {
            ApplicationInfo appInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
            if (appInfo.metaData != null) {
                for (String key : appInfo.metaData.keySet()) {
                    if ("GlideModule".equals(appInfo.metaData.get(key))) {
                        modules.add(po.a(key));
                    }
                }
            }
            return modules;
        } catch (NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    private static pn a(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            try {
                Object module = clazz.newInstance();
                if (module instanceof pn) {
                    return (pn) module;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + module);
            } catch (InstantiationException e) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + clazz, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + clazz, e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e3);
        }
    }
}
