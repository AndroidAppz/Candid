/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class gq {
    public static Object a(final a a2) {
        return new AccessibilityNodeProvider(){

            public AccessibilityNodeInfo createAccessibilityNodeInfo(int n2) {
                return (AccessibilityNodeInfo)a2.a(n2);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String string2, int n2) {
                return a2.a(string2, n2);
            }

            public boolean performAction(int n2, int n3, Bundle bundle) {
                return a2.a(n2, n3, bundle);
            }
        };
    }

    static interface a {
        public Object a(int var1);

        public List<Object> a(String var1, int var2);

        public boolean a(int var1, int var2, Bundle var3);
    }

}

