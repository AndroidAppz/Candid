package defpackage;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: JsonObject */
public final class aif extends aid {
    private final LinkedTreeMap<String, aid> a = new LinkedTreeMap();

    public void a(String property, aid value) {
        if (value == null) {
            value = aie.a;
        }
        this.a.put(property, value);
    }

    public void a(String property, String value) {
        a(property, a((Object) value));
    }

    public void a(String property, Boolean value) {
        a(property, a((Object) value));
    }

    private aid a(Object value) {
        return value == null ? aie.a : new aih(value);
    }

    public Set<Entry<String, aid>> a() {
        return this.a.entrySet();
    }

    public boolean a(String memberName) {
        return this.a.containsKey(memberName);
    }

    public aid b(String memberName) {
        return (aid) this.a.get(memberName);
    }

    public aib c(String memberName) {
        return (aib) this.a.get(memberName);
    }

    public aif d(String memberName) {
        return (aif) this.a.get(memberName);
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof aif) && ((aif) o).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
