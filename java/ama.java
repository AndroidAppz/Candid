/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.concurrency.Priority
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicReference
 */
import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ama
implements alu<amc>,
alz,
amc {
    private final List<amc> a = new ArrayList();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicReference<Throwable> c = new AtomicReference((Object)null);

    public static boolean a(Object object) {
        try {
            alu alu2 = (alu)object;
            amc amc2 = (amc)object;
            alz alz2 = (alz)object;
            boolean bl2 = false;
            if (alu2 != null) {
                bl2 = false;
                if (amc2 != null) {
                    bl2 = false;
                    if (alz2 != null) {
                        bl2 = true;
                    }
                }
            }
            return bl2;
        }
        catch (ClassCastException var1_5) {
            return false;
        }
    }

    public void a(amc amc2) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.a.add((Object)amc2);
            return;
        }
    }

    @Override
    public void a(Throwable throwable) {
        this.c.set((Object)throwable);
    }

    @Override
    public Priority b() {
        return Priority.b;
    }

    @Override
    public void b(boolean bl2) {
        void var3_2 = this;
        synchronized (var3_2) {
            this.b.set(bl2);
            return;
        }
    }

    @Override
    public Collection<amc> c() {
        ama ama2 = this;
        synchronized (ama2) {
            Collection collection = Collections.unmodifiableCollection(this.a);
            return collection;
        }
    }

    @Override
    public /* synthetic */ void c(Object object) {
        this.a((amc)object);
    }

    public int compareTo(Object object) {
        return Priority.a((alz)this, (Object)object);
    }

    @Override
    public boolean d() {
        Iterator iterator = this.c().iterator();
        while (iterator.hasNext()) {
            if (((amc)iterator.next()).f()) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean f() {
        return this.b.get();
    }
}

