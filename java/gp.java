/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class gp {
    private static final a a = Build.VERSION.SDK_INT >= 19 ? new c() : (Build.VERSION.SDK_INT >= 16 ? new b() : new d());
    private final Object b;

    public gp() {
        this.b = a.a(this);
    }

    public gp(Object object) {
        this.b = object;
    }

    public gi createAccessibilityNodeInfo(int n2) {
        return null;
    }

    public List<gi> findAccessibilityNodeInfosByText(String string2, int n2) {
        return null;
    }

    public gi findFocus(int n2) {
        return null;
    }

    public Object getProvider() {
        return this.b;
    }

    public boolean performAction(int n2, int n3, Bundle bundle) {
        return false;
    }

    static interface a {
        public Object a(gp var1);
    }

    static class b
    extends d {
        b() {
        }

        @Override
        public Object a(final gp gp2) {
            return gq.a(new gq.a(){

                @Override
                public Object a(int n2) {
                    gi gi2 = gp2.createAccessibilityNodeInfo(n2);
                    if (gi2 == null) {
                        return null;
                    }
                    return gi2.a();
                }

                @Override
                public List<Object> a(String string2, int n2) {
                    List<gi> list = gp2.findAccessibilityNodeInfosByText(string2, n2);
                    ArrayList arrayList = new ArrayList();
                    int n3 = list.size();
                    for (int i2 = 0; i2 < n3; ++i2) {
                        arrayList.add(((gi)list.get(i2)).a());
                    }
                    return arrayList;
                }

                @Override
                public boolean a(int n2, int n3, Bundle bundle) {
                    return gp2.performAction(n2, n3, bundle);
                }
            });
        }

    }

    static class c
    extends d {
        c() {
        }

        @Override
        public Object a(final gp gp2) {
            return gr.a(new gr.a(){

                @Override
                public Object a(int n2) {
                    gi gi2 = gp2.createAccessibilityNodeInfo(n2);
                    if (gi2 == null) {
                        return null;
                    }
                    return gi2.a();
                }

                @Override
                public List<Object> a(String string2, int n2) {
                    List<gi> list = gp2.findAccessibilityNodeInfosByText(string2, n2);
                    ArrayList arrayList = new ArrayList();
                    int n3 = list.size();
                    for (int i2 = 0; i2 < n3; ++i2) {
                        arrayList.add(((gi)list.get(i2)).a());
                    }
                    return arrayList;
                }

                @Override
                public boolean a(int n2, int n3, Bundle bundle) {
                    return gp2.performAction(n2, n3, bundle);
                }

                @Override
                public Object b(int n2) {
                    gi gi2 = gp2.findFocus(n2);
                    if (gi2 == null) {
                        return null;
                    }
                    return gi2.a();
                }
            });
        }

    }

    static class d
    implements a {
        d() {
        }

        @Override
        public Object a(gp gp2) {
            return null;
        }
    }

}

