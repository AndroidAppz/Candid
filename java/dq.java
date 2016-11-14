/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.ClassCastException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Map
 */
import java.util.Map;

public class dq<K, V> {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;

    public dq() {
        this.f = di.a;
        this.g = di.c;
        this.h = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public dq(int n2) {
        if (n2 == 0) {
            this.f = di.a;
            this.g = di.c;
        } else {
            super.e(n2);
        }
        this.h = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(int[] arrn, Object[] arrobject, int n2) {
        if (arrn.length == 8) {
            reference var7_3 = dh.class;
            synchronized (dh.class) {
                if (e < 10) {
                    arrobject[0] = d;
                    arrobject[1] = arrn;
                    for (int i2 = -1 + (n2 << 1); i2 >= 2; --i2) {
                        arrobject[i2] = null;
                    }
                    d = arrobject;
                    e = 1 + e;
                }
                // ** MonitorExit[var7_3] (shouldn't be in output)
                return;
            }
        }
        if (arrn.length != 4) {
            return;
        }
        reference var7_4 = dh.class;
        synchronized (dh.class) {
            if (c < 10) {
                arrobject[0] = b;
                arrobject[1] = arrn;
                for (int i3 = -1 + (n2 << 1); i3 >= 2; --i3) {
                    arrobject[i3] = null;
                }
                b = arrobject;
                c = 1 + c;
            }
            // ** MonitorExit[var7_4] (shouldn't be in output)
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void e(int n2) {
        if (n2 == 8) {
            reference var6_2 = dh.class;
            // MONITORENTER : dh.class
            if (d != null) {
                Object[] arrobject;
                this.g = arrobject = d;
                d = (Object[])arrobject[0];
                this.f = (int[])arrobject[1];
                arrobject[1] = null;
                arrobject[0] = null;
                e = -1 + e;
                // MONITOREXIT : var6_2
                return;
            }
            // MONITOREXIT : var6_2
        } else if (n2 == 4) {
            reference var6_3 = dh.class;
            // MONITORENTER : dh.class
            if (b != null) {
                Object[] arrobject;
                this.g = arrobject = b;
                b = (Object[])arrobject[0];
                this.f = (int[])arrobject[1];
                arrobject[1] = null;
                arrobject[0] = null;
                c = -1 + c;
                // MONITOREXIT : var6_3
                return;
            }
            // MONITOREXIT : var6_3
        }
        this.f = new int[n2];
        this.g = new Object[n2 << 1];
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    int a() {
        int n2;
        int n3 = this.h;
        if (n3 == 0) {
            return -1;
        }
        int n4 = di.a(this.f, n3, 0);
        if (n4 < 0) return n4;
        if (this.g[n4 << 1] == null) return n4;
        for (n2 = n4 + 1; n2 < n3 && this.f[n2] == 0; ++n2) {
            if (this.g[n2 << 1] != null) continue;
            return n2;
        }
        int n5 = n4 - 1;
        while (n5 >= 0) {
            if (this.f[n5] != 0) return ~ n2;
            if (this.g[n5 << 1] == null) {
                return n5;
            }
            --n5;
        }
        return ~ n2;
    }

    public int a(Object object) {
        if (object == null) {
            return this.a();
        }
        return this.a(object, object.hashCode());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    int a(Object object, int n2) {
        int n3;
        int n4 = this.h;
        if (n4 == 0) {
            return -1;
        }
        int n5 = di.a(this.f, n4, n2);
        if (n5 < 0) return n5;
        if (object.equals(this.g[n5 << 1])) return n5;
        for (n3 = n5 + 1; n3 < n4 && this.f[n3] == n2; ++n3) {
            if (!object.equals(this.g[n3 << 1])) continue;
            return n3;
        }
        int n6 = n5 - 1;
        while (n6 >= 0) {
            if (this.f[n6] != n2) return ~ n3;
            if (object.equals(this.g[n6 << 1])) {
                return n6;
            }
            --n6;
        }
        return ~ n3;
    }

    public V a(int n2, V v2) {
        int n3 = 1 + (n2 << 1);
        Object object = this.g[n3];
        this.g[n3] = v2;
        return (V)object;
    }

    public void a(int n2) {
        if (this.f.length < n2) {
            int[] arrn = this.f;
            Object[] arrobject = this.g;
            super.e(n2);
            if (this.h > 0) {
                System.arraycopy((Object)arrn, (int)0, (Object)this.f, (int)0, (int)this.h);
                System.arraycopy((Object)arrobject, (int)0, (Object)this.g, (int)0, (int)(this.h << 1));
            }
            dq.a(arrn, arrobject, this.h);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(dq<? extends K, ? extends V> dq2) {
        int n2 = dq2.h;
        this.a(n2 + this.h);
        if (this.h == 0) {
            if (n2 <= 0) return;
            System.arraycopy((Object)dq2.f, (int)0, (Object)this.f, (int)0, (int)n2);
            System.arraycopy((Object)dq2.g, (int)0, (Object)this.g, (int)0, (int)(n2 << 1));
            this.h = n2;
            return;
        }
        int n3 = 0;
        while (n3 < n2) {
            this.put(dq2.b(n3), dq2.c(n3));
            ++n3;
        }
    }

    int b(Object object) {
        int n2 = 2 * this.h;
        Object[] arrobject = this.g;
        if (object == null) {
            for (int i2 = 1; i2 < n2; i2 += 2) {
                if (arrobject[i2] != null) continue;
                return i2 >> 1;
            }
        } else {
            for (int i3 = 1; i3 < n2; i3 += 2) {
                if (!object.equals(arrobject[i3])) continue;
                return i3 >> 1;
            }
        }
        return -1;
    }

    public K b(int n2) {
        return (K)this.g[n2 << 1];
    }

    public V c(int n2) {
        return (V)this.g[1 + (n2 << 1)];
    }

    public void clear() {
        if (this.h != 0) {
            dq.a(this.f, this.g, this.h);
            this.f = di.a;
            this.g = di.c;
            this.h = 0;
        }
    }

    public boolean containsKey(Object object) {
        if (this.a(object) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object object) {
        if (this.b(object) >= 0) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public V d(int n2) {
        int n3 = 8;
        Object object = this.g[1 + (n2 << 1)];
        if (this.h <= 1) {
            dq.a(this.f, this.g, this.h);
            this.f = di.a;
            this.g = di.c;
            this.h = 0;
            return (V)object;
        }
        if (this.f.length > n3 && this.h < this.f.length / 3) {
            if (this.h > n3) {
                n3 = this.h + (this.h >> 1);
            }
            int[] arrn = this.f;
            Object[] arrobject = this.g;
            super.e(n3);
            this.h = -1 + this.h;
            if (n2 > 0) {
                System.arraycopy((Object)arrn, (int)0, (Object)this.f, (int)0, (int)n2);
                System.arraycopy((Object)arrobject, (int)0, (Object)this.g, (int)0, (int)(n2 << 1));
            }
            if (n2 >= this.h) return (V)object;
            {
                System.arraycopy((Object)arrn, (int)(n2 + 1), (Object)this.f, (int)n2, (int)(this.h - n2));
                System.arraycopy((Object)arrobject, (int)(n2 + 1 << 1), (Object)this.g, (int)(n2 << 1), (int)(this.h - n2 << 1));
                return (V)object;
            }
        }
        this.h = -1 + this.h;
        if (n2 < this.h) {
            System.arraycopy((Object)this.f, (int)(n2 + 1), (Object)this.f, (int)n2, (int)(this.h - n2));
            System.arraycopy((Object)this.g, (int)(n2 + 1 << 1), (Object)this.g, (int)(n2 << 1), (int)(this.h - n2 << 1));
        }
        this.g[this.h << 1] = null;
        this.g[1 + (this.h << 1)] = null;
        return (V)object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Map)) return false;
        Map map = (Map)object;
        if (this.size() != map.size()) {
            return false;
        }
        int n2 = 0;
        try {
            while (n2 < this.h) {
                K k2 = this.b(n2);
                V v2 = this.c(n2);
                Object object2 = map.get(k2);
                if (v2 == null) {
                    if (object2 != null) return false;
                    if (!map.containsKey(k2)) {
                        return false;
                    }
                } else {
                    boolean bl2 = v2.equals(object2);
                    if (!bl2) {
                        return false;
                    }
                }
                ++n2;
            }
            return true;
        }
        catch (NullPointerException var5_8) {
            return false;
        }
        catch (ClassCastException var4_9) {
            return false;
        }
    }

    public V get(Object object) {
        int n2 = this.a(object);
        if (n2 >= 0) {
            return (V)this.g[1 + (n2 << 1)];
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int hashCode() {
        int[] arrn = this.f;
        Object[] arrobject = this.g;
        int n2 = 0;
        int n3 = 0;
        int n4 = 1;
        int n5 = this.h;
        while (n3 < n5) {
            Object object = arrobject[n4];
            int n6 = arrn[n3];
            int n7 = object == null ? 0 : object.hashCode();
            n2 += n7 ^ n6;
            ++n3;
            n4 += 2;
        }
        return n2;
    }

    public boolean isEmpty() {
        if (this.h <= 0) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public V put(K k2, V v2) {
        int n2;
        int n3;
        int n4 = 8;
        if (k2 == null) {
            n2 = 0;
            n3 = this.a();
        } else {
            n2 = k2.hashCode();
            n3 = this.a(k2, n2);
        }
        if (n3 >= 0) {
            int n5 = 1 + (n3 << 1);
            Object object = this.g[n5];
            this.g[n5] = v2;
            return (V)object;
        }
        int n6 = ~ n3;
        if (this.h >= this.f.length) {
            if (this.h >= n4) {
                n4 = this.h + (this.h >> 1);
            } else if (this.h < 4) {
                n4 = 4;
            }
            int[] arrn = this.f;
            Object[] arrobject = this.g;
            super.e(n4);
            if (this.f.length > 0) {
                System.arraycopy((Object)arrn, (int)0, (Object)this.f, (int)0, (int)arrn.length);
                System.arraycopy((Object)arrobject, (int)0, (Object)this.g, (int)0, (int)arrobject.length);
            }
            dq.a(arrn, arrobject, this.h);
        }
        if (n6 < this.h) {
            System.arraycopy((Object)this.f, (int)n6, (Object)this.f, (int)(n6 + 1), (int)(this.h - n6));
            System.arraycopy((Object)this.g, (int)(n6 << 1), (Object)this.g, (int)(n6 + 1 << 1), (int)(this.h - n6 << 1));
        }
        this.f[n6] = n2;
        this.g[n6 << 1] = k2;
        this.g[1 + (n6 << 1)] = v2;
        this.h = 1 + this.h;
        return null;
    }

    public V remove(Object object) {
        int n2 = this.a(object);
        if (n2 >= 0) {
            return this.d(n2);
        }
        return null;
    }

    public int size() {
        return this.h;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(28 * this.h);
        stringBuilder.append('{');
        int n2 = 0;
        do {
            K k2;
            if (n2 >= this.h) {
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
            if (n2 > 0) {
                stringBuilder.append(", ");
            }
            if ((k2 = this.b(n2)) != this) {
                stringBuilder.append(k2);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            V v2 = this.c(n2);
            if (v2 != this) {
                stringBuilder.append(v2);
            } else {
                stringBuilder.append("(this Map)");
            }
            ++n2;
        } while (true);
    }
}

