/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class dm<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public dm(int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = n2;
        this.map = new LinkedHashMap(0, 0.75f, true);
    }

    private int safeSizeOf(K k2, V v2) {
        int n2 = this.sizeOf(k2, v2);
        if (n2 < 0) {
            throw new IllegalStateException("Negative size: " + k2 + "=" + v2);
        }
        return n2;
    }

    protected V create(K k2) {
        return null;
    }

    public final int createCount() {
        dm dm2 = this;
        synchronized (dm2) {
            int n2 = this.createCount;
            return n2;
        }
    }

    protected void entryRemoved(boolean bl2, K k2, V v2, V v3) {
    }

    public final void evictAll() {
        this.trimToSize(-1);
    }

    public final int evictionCount() {
        dm dm2 = this;
        synchronized (dm2) {
            int n2 = this.evictionCount;
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final V get(K k2) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        void var8_2 = this;
        // MONITORENTER : var8_2
        Object object = this.map.get(k2);
        if (object != null) {
            this.hitCount = 1 + this.hitCount;
            // MONITOREXIT : var8_2
            return (V)object;
        }
        this.missCount = 1 + this.missCount;
        // MONITOREXIT : var8_2
        V v2 = this.create(k2);
        if (v2 == null) {
            return null;
        }
        var8_2 = this;
        // MONITORENTER : var8_2
        this.createCount = 1 + this.createCount;
        Object object2 = this.map.put(k2, v2);
        if (object2 != null) {
            this.map.put(k2, object2);
        } else {
            this.size += super.safeSizeOf(k2, v2);
        }
        // MONITOREXIT : var8_2
        if (object2 != null) {
            this.entryRemoved(false, k2, v2, object2);
            return (V)object2;
        }
        this.trimToSize(this.maxSize);
        return v2;
    }

    public final int hitCount() {
        dm dm2 = this;
        synchronized (dm2) {
            int n2 = this.hitCount;
            return n2;
        }
    }

    public final int maxSize() {
        dm dm2 = this;
        synchronized (dm2) {
            int n2 = this.maxSize;
            return n2;
        }
    }

    public final int missCount() {
        dm dm2 = this;
        synchronized (dm2) {
            int n2 = this.missCount;
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final V put(K k2, V v2) {
        if (k2 == null) throw new NullPointerException("key == null || value == null");
        if (v2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        void var5_3 = this;
        // MONITORENTER : var5_3
        this.putCount = 1 + this.putCount;
        this.size += super.safeSizeOf(k2, v2);
        Object object = this.map.put(k2, v2);
        if (object != null) {
            this.size -= super.safeSizeOf(k2, object);
        }
        // MONITOREXIT : var5_3
        if (object != null) {
            this.entryRemoved(false, k2, object, v2);
        }
        this.trimToSize(this.maxSize);
        return (V)object;
    }

    public final int putCount() {
        dm dm2 = this;
        synchronized (dm2) {
            int n2 = this.putCount;
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final V remove(K k2) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        void var4_2 = this;
        // MONITORENTER : var4_2
        Object object = this.map.remove(k2);
        if (object != null) {
            this.size -= super.safeSizeOf(k2, object);
        }
        // MONITOREXIT : var4_2
        if (object == null) return (V)object;
        this.entryRemoved(false, k2, object, null);
        return (V)object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void resize(int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        void var3_2 = this;
        synchronized (var3_2) {
            this.maxSize = n2;
        }
        this.trimToSize(n2);
    }

    public final int size() {
        dm dm2 = this;
        synchronized (dm2) {
            int n2 = this.size;
            return n2;
        }
    }

    protected int sizeOf(K k2, V v2) {
        return 1;
    }

    public final Map<K, V> snapshot() {
        dm dm2 = this;
        synchronized (dm2) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.map);
            return linkedHashMap;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String toString() {
        dm dm2 = this;
        synchronized (dm2) {
            int n2 = this.hitCount + this.missCount;
            int n3 = 0;
            if (n2 != 0) {
                n3 = 100 * this.hitCount / n2;
            }
            Object[] arrobject = new Object[]{this.maxSize, this.hitCount, this.missCount, n3};
            return String.format((String)"LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", (Object[])arrobject);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void trimToSize(int n2) {
        do {
            Object object;
            Object object2;
            void var7_3 = this;
            synchronized (var7_3) {
                if (this.size < 0 || this.map.isEmpty() && this.size != 0) {
                    throw new IllegalStateException(this.getClass().getName() + ".sizeOf() is reporting inconsistent results!");
                }
                if (this.size <= n2 || this.map.isEmpty()) {
                    return;
                }
                Map.Entry entry = (Map.Entry)this.map.entrySet().iterator().next();
                object2 = entry.getKey();
                object = entry.getValue();
                this.map.remove(object2);
                this.size -= super.safeSizeOf(object2, object);
                this.evictionCount = 1 + this.evictionCount;
            }
            this.entryRemoved(true, object2, object, null);
        } while (true);
    }
}

