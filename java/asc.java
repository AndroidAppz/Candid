/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Properties
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicReference
 */
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class asc {
    static final arz a;
    private static final asc b;
    private final AtomicReference<arz> c = new AtomicReference();
    private final AtomicReference<asa> d = new AtomicReference();
    private final AtomicReference<asd> e = new AtomicReference();

    static {
        b = new asc();
        a = new arz(){};
    }

    asc() {
    }

    public static asc a() {
        return b;
    }

    static Object a(Class<?> class_, Properties properties) {
        String string2 = class_.getSimpleName();
        String string3 = properties.getProperty("rxjava.plugin." + string2 + ".implementation");
        if (string3 == null) {
            for (Map.Entry entry : properties.entrySet()) {
                String string4 = entry.getKey().toString();
                if (!string4.startsWith("rxjava.plugin.") || !string4.endsWith(".class") || !string2.equals((Object)entry.getValue().toString())) continue;
                String string5 = string4.substring(0, string4.length() - ".class".length()).substring("rxjava.plugin.".length());
                String string6 = "rxjava.plugin." + string5 + ".impl";
                string3 = properties.getProperty(string6);
                if (string3 != null) break;
                throw new RuntimeException("Implementing class declaration for " + string2 + " missing: " + string6);
            }
        }
        if (string3 != null) {
            try {
                Object object = Class.forName((String)string3).asSubclass(class_).newInstance();
                return object;
            }
            catch (ClassCastException var7_10) {
                throw new RuntimeException(string2 + " implementation is not an instance of " + string2 + ": " + string3);
            }
            catch (ClassNotFoundException var6_11) {
                throw new RuntimeException(string2 + " implementation class not found: " + string3, (Throwable)var6_11);
            }
            catch (InstantiationException var5_12) {
                throw new RuntimeException(string2 + " implementation not able to be instantiated: " + string3, (Throwable)var5_12);
            }
            catch (IllegalAccessException var4_13) {
                throw new RuntimeException(string2 + " implementation not able to be accessed: " + string3, (Throwable)var4_13);
            }
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public arz b() {
        if (this.c.get() != null) return (arz)this.c.get();
        Object object = asc.a(arz.class, System.getProperties());
        if (object == null) {
            this.c.compareAndSet((Object)null, (Object)a);
            return (arz)this.c.get();
        }
        this.c.compareAndSet((Object)null, (Object)((arz)object));
        return (arz)this.c.get();
    }

    /*
     * Enabled aggressive block sorting
     */
    public asa c() {
        if (this.d.get() != null) return (asa)this.d.get();
        Object object = asc.a(asa.class, System.getProperties());
        if (object == null) {
            this.d.compareAndSet((Object)null, (Object)asb.a());
            return (asa)this.d.get();
        }
        this.d.compareAndSet((Object)null, (Object)((asa)object));
        return (asa)this.d.get();
    }

    /*
     * Enabled aggressive block sorting
     */
    public asd d() {
        if (this.e.get() != null) return (asd)this.e.get();
        Object object = asc.a(asd.class, System.getProperties());
        if (object == null) {
            this.e.compareAndSet((Object)null, (Object)asd.d());
            return (asd)this.e.get();
        }
        this.e.compareAndSet((Object)null, (Object)((asd)object));
        return (asd)this.e.get();
    }

}

