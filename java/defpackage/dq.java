package defpackage;

import java.util.Map;

/* compiled from: SimpleArrayMap */
public class dq<K, V> {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;

    int a(Object key, int hash) {
        int N = this.h;
        if (N == 0) {
            return -1;
        }
        int index = di.a(this.f, N, hash);
        if (index < 0 || key.equals(this.g[index << 1])) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.f[end] == hash) {
            if (key.equals(this.g[end << 1])) {
                return end;
            }
            end++;
        }
        int i = index - 1;
        while (i >= 0 && this.f[i] == hash) {
            if (key.equals(this.g[i << 1])) {
                return i;
            }
            i--;
        }
        return end ^ -1;
    }

    int a() {
        int N = this.h;
        if (N == 0) {
            return -1;
        }
        int index = di.a(this.f, N, 0);
        if (index < 0 || this.g[index << 1] == null) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.f[end] == 0) {
            if (this.g[end << 1] == null) {
                return end;
            }
            end++;
        }
        int i = index - 1;
        while (i >= 0 && this.f[i] == 0) {
            if (this.g[i << 1] == null) {
                return i;
            }
            i--;
        }
        return end ^ -1;
    }

    private void e(int size) {
        Object[] array;
        if (size == 8) {
            synchronized (dh.class) {
                if (d != null) {
                    array = d;
                    this.g = array;
                    d = (Object[]) array[0];
                    this.f = (int[]) array[1];
                    array[1] = null;
                    array[0] = null;
                    e--;
                    return;
                }
            }
        } else if (size == 4) {
            synchronized (dh.class) {
                if (b != null) {
                    array = b;
                    this.g = array;
                    b = (Object[]) array[0];
                    this.f = (int[]) array[1];
                    array[1] = null;
                    array[0] = null;
                    c--;
                    return;
                }
            }
        }
        this.f = new int[size];
        this.g = new Object[(size << 1)];
    }

    private static void a(int[] hashes, Object[] array, int size) {
        int i;
        if (hashes.length == 8) {
            synchronized (dh.class) {
                if (e < 10) {
                    array[0] = d;
                    array[1] = hashes;
                    for (i = (size << 1) - 1; i >= 2; i--) {
                        array[i] = null;
                    }
                    d = array;
                    e++;
                }
            }
        } else if (hashes.length == 4) {
            synchronized (dh.class) {
                if (c < 10) {
                    array[0] = b;
                    array[1] = hashes;
                    for (i = (size << 1) - 1; i >= 2; i--) {
                        array[i] = null;
                    }
                    b = array;
                    c++;
                }
            }
        }
    }

    public dq() {
        this.f = di.a;
        this.g = di.c;
        this.h = 0;
    }

    public dq(int capacity) {
        if (capacity == 0) {
            this.f = di.a;
            this.g = di.c;
        } else {
            e(capacity);
        }
        this.h = 0;
    }

    public void clear() {
        if (this.h != 0) {
            dq.a(this.f, this.g, this.h);
            this.f = di.a;
            this.g = di.c;
            this.h = 0;
        }
    }

    public void a(int minimumCapacity) {
        if (this.f.length < minimumCapacity) {
            int[] ohashes = this.f;
            Object[] oarray = this.g;
            e(minimumCapacity);
            if (this.h > 0) {
                System.arraycopy(ohashes, 0, this.f, 0, this.h);
                System.arraycopy(oarray, 0, this.g, 0, this.h << 1);
            }
            dq.a(ohashes, oarray, this.h);
        }
    }

    public boolean containsKey(Object key) {
        return a(key) >= 0;
    }

    public int a(Object key) {
        return key == null ? a() : a(key, key.hashCode());
    }

    int b(Object value) {
        int N = this.h * 2;
        Object[] array = this.g;
        int i;
        if (value == null) {
            for (i = 1; i < N; i += 2) {
                if (array[i] == null) {
                    return i >> 1;
                }
            }
        } else {
            for (i = 1; i < N; i += 2) {
                if (value.equals(array[i])) {
                    return i >> 1;
                }
            }
        }
        return -1;
    }

    public boolean containsValue(Object value) {
        return b(value) >= 0;
    }

    public V get(Object key) {
        int index = a(key);
        return index >= 0 ? this.g[(index << 1) + 1] : null;
    }

    public K b(int index) {
        return this.g[index << 1];
    }

    public V c(int index) {
        return this.g[(index << 1) + 1];
    }

    public V a(int index, V value) {
        index = (index << 1) + 1;
        V old = this.g[index];
        this.g[index] = value;
        return old;
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K key, V value) {
        int hash;
        int index;
        int n = 8;
        if (key == null) {
            hash = 0;
            index = a();
        } else {
            hash = key.hashCode();
            index = a((Object) key, hash);
        }
        if (index >= 0) {
            index = (index << 1) + 1;
            V old = this.g[index];
            this.g[index] = value;
            return old;
        }
        index ^= -1;
        if (this.h >= this.f.length) {
            if (this.h >= 8) {
                n = this.h + (this.h >> 1);
            } else if (this.h < 4) {
                n = 4;
            }
            int[] ohashes = this.f;
            Object[] oarray = this.g;
            e(n);
            if (this.f.length > 0) {
                System.arraycopy(ohashes, 0, this.f, 0, ohashes.length);
                System.arraycopy(oarray, 0, this.g, 0, oarray.length);
            }
            dq.a(ohashes, oarray, this.h);
        }
        if (index < this.h) {
            System.arraycopy(this.f, index, this.f, index + 1, this.h - index);
            System.arraycopy(this.g, index << 1, this.g, (index + 1) << 1, (this.h - index) << 1);
        }
        this.f[index] = hash;
        this.g[index << 1] = key;
        this.g[(index << 1) + 1] = value;
        this.h++;
        return null;
    }

    public void a(dq<? extends K, ? extends V> array) {
        int N = array.h;
        a(this.h + N);
        if (this.h != 0) {
            for (int i = 0; i < N; i++) {
                put(array.b(i), array.c(i));
            }
        } else if (N > 0) {
            System.arraycopy(array.f, 0, this.f, 0, N);
            System.arraycopy(array.g, 0, this.g, 0, N << 1);
            this.h = N;
        }
    }

    public V remove(Object key) {
        int index = a(key);
        if (index >= 0) {
            return d(index);
        }
        return null;
    }

    public V d(int index) {
        int n = 8;
        Object old = this.g[(index << 1) + 1];
        if (this.h <= 1) {
            dq.a(this.f, this.g, this.h);
            this.f = di.a;
            this.g = di.c;
            this.h = 0;
        } else if (this.f.length <= 8 || this.h >= this.f.length / 3) {
            this.h--;
            if (index < this.h) {
                System.arraycopy(this.f, index + 1, this.f, index, this.h - index);
                System.arraycopy(this.g, (index + 1) << 1, this.g, index << 1, (this.h - index) << 1);
            }
            this.g[this.h << 1] = null;
            this.g[(this.h << 1) + 1] = null;
        } else {
            if (this.h > 8) {
                n = this.h + (this.h >> 1);
            }
            int[] ohashes = this.f;
            Object[] oarray = this.g;
            e(n);
            this.h--;
            if (index > 0) {
                System.arraycopy(ohashes, 0, this.f, 0, index);
                System.arraycopy(oarray, 0, this.g, 0, index << 1);
            }
            if (index < this.h) {
                System.arraycopy(ohashes, index + 1, this.f, index, this.h - index);
                System.arraycopy(oarray, (index + 1) << 1, this.g, index << 1, (this.h - index) << 1);
            }
        }
        return old;
    }

    public int size() {
        return this.h;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Map)) {
            return false;
        }
        Map<?, ?> map = (Map) object;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.h) {
            try {
                K key = b(i);
                V mine = c(i);
                Object theirs = map.get(key);
                if (mine == null) {
                    if (theirs != null || !map.containsKey(key)) {
                        return false;
                    }
                } else if (!mine.equals(theirs)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] hashes = this.f;
        Object[] array = this.g;
        int result = 0;
        int i = 0;
        int v = 1;
        int s = this.h;
        while (i < s) {
            Object value = array[v];
            result += (value == null ? 0 : value.hashCode()) ^ hashes[i];
            i++;
            v += 2;
        }
        return result;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.h * 28);
        buffer.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            dq key = b(i);
            if (key != this) {
                buffer.append(key);
            } else {
                buffer.append("(this Map)");
            }
            buffer.append('=');
            dq value = c(i);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Map)");
            }
        }
        buffer.append('}');
        return buffer.toString();
    }
}
