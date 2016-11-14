/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.content.Context;
import android.content.pm.PackageManager;

public class alp {
    private final alc<String> a;
    private final ala<String> b;

    public alp() {
        this.a = new alc<String>(){

            public String a(Context context) throws Exception {
                String string2 = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                if (string2 == null) {
                    string2 = "";
                }
                return string2;
            }

            @Override
            public /* synthetic */ Object b(Context context) throws Exception {
                return this.a(context);
            }
        };
        this.b = new ala();
    }

    public String a(Context context) {
        try {
            String string2 = this.b.a(context, this.a);
            boolean bl2 = "".equals((Object)string2);
            if (bl2) {
                string2 = null;
            }
            return string2;
        }
        catch (Exception var2_4) {
            akp.h().e("Fabric", "Failed to determine installer package name", (Throwable)var2_4);
            return null;
        }
    }

}

