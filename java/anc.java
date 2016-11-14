/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.network.HttpMethod
 *  io.fabric.sdk.android.services.network.HttpRequest
 *  java.io.Closeable
 *  java.io.InputStream
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Locale
 */
import android.content.Context;
import android.content.res.Resources;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Locale;

abstract class anc
extends ald {
    public anc(aku aku2, String string2, String string3, amt amt2, HttpMethod httpMethod) {
        super(aku2, string2, string3, amt2, httpMethod);
    }

    private HttpRequest a(HttpRequest httpRequest, anf anf2) {
        return httpRequest.a("X-CRASHLYTICS-API-KEY", anf2.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private HttpRequest b(HttpRequest var1, anf var2_2) {
        var3_3 = var1.e("app[identifier]", var2_2.b).e("app[name]", var2_2.f).e("app[display_version]", var2_2.c).e("app[build_version]", var2_2.d).a("app[source]", (Number)var2_2.g).e("app[minimum_sdk_version]", var2_2.h).e("app[built_sdk_version]", var2_2.i);
        if (!CommonUtils.c((String)var2_2.e)) {
            var3_3.e("app[instance_identifier]", var2_2.e);
        }
        if (var2_2.j != null) {
            var8_4 = null;
            var8_4 = this.a.E().getResources().openRawResource(var2_2.j.b);
            var3_3.e("app[icon][hash]", var2_2.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", var8_4).a("app[icon][width]", (Number)var2_2.j.c).a("app[icon][height]", (Number)var2_2.j.d);
        }
lbl9: // 5 sources:
        while (var2_2.k != null) {
            for (akw var5_7 : var2_2.k) {
                var3_3.e(this.a(var5_7), var5_7.b());
                var3_3.e(this.b(var5_7), var5_7.c());
            }
            return var3_3;
        }
        return var3_3;
        catch (Resources.NotFoundException var10_5) {
            akp.h().e("Fabric", "Failed to find app icon with resource ID: " + var2_2.j.b, (Throwable)var10_5);
        }
        finally {
            CommonUtils.a((Closeable)var8_4, (String)"Failed to close app icon InputStream.");
        }
        ** GOTO lbl9
    }

    String a(akw akw2) {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{akw2.a()};
        return String.format((Locale)locale, (String)"app[build][libraries][%s][version]", (Object[])arrobject);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(anf anf2) {
        HttpRequest httpRequest = super.b(super.a(this.b(), anf2), anf2);
        akp.h().a("Fabric", "Sending app info to " + this.a());
        if (anf2.j != null) {
            akp.h().a("Fabric", "App icon hash is " + anf2.j.a);
            akp.h().a("Fabric", "App icon size is " + anf2.j.c + "x" + anf2.j.d);
        }
        int n2 = httpRequest.b();
        String string2 = "POST".equals((Object)httpRequest.p()) ? "Create" : "Update";
        akp.h().a("Fabric", string2 + " app request ID: " + httpRequest.b("X-REQUEST-ID"));
        akp.h().a("Fabric", "Result was " + n2);
        if (alr.a(n2) == 0) {
            return true;
        }
        return false;
    }

    String b(akw akw2) {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{akw2.a()};
        return String.format((Locale)locale, (String)"app[build][libraries][%s][type]", (Object[])arrobject);
    }
}

