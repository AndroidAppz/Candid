/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LinkedTreeMap
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

public final class aif
extends aid {
    private final LinkedTreeMap<String, aid> a = new LinkedTreeMap();

    private aid a(Object object) {
        if (object == null) {
            return aie.a;
        }
        return new aih(object);
    }

    public Set<Map.Entry<String, aid>> a() {
        return this.a.entrySet();
    }

    public void a(String string2, aid aid2) {
        if (aid2 == null) {
            aid2 = aie.a;
        }
        this.a.put((Object)string2, (Object)aid2);
    }

    public void a(String string2, Boolean bl2) {
        this.a(string2, super.a((Object)bl2));
    }

    public void a(String string2, String string3) {
        this.a(string2, super.a((Object)string3));
    }

    public boolean a(String string2) {
        return this.a.containsKey((Object)string2);
    }

    public aid b(String string2) {
        return (aid)this.a.get((Object)string2);
    }

    public aib c(String string2) {
        return (aib)this.a.get((Object)string2);
    }

    public aif d(String string2) {
        return (aif)this.a.get((Object)string2);
    }

    public boolean equals(Object object) {
        if (object == this || object instanceof aif && ((aif)object).a.equals(this.a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

