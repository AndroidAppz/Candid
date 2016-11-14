/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.TreeSet
 *  java.util.concurrent.CopyOnWriteArrayList
 */
import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class amj<T> {
    protected final Context a;
    protected final ami<T> b;
    protected final alm c;
    protected final amk d;
    protected volatile long e;
    protected final List<aml> f = new CopyOnWriteArrayList();
    private final int g;

    public amj(Context context, ami<T> ami2, alm alm2, amk amk2, int n2) throws IOException {
        this.a = context.getApplicationContext();
        this.b = ami2;
        this.d = amk2;
        this.c = alm2;
        this.e = this.c.a();
        this.g = n2;
    }

    private void a(int n2) throws IOException {
        if (!this.d.a(n2, this.c())) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.d.a(), n2, this.c()};
            String string2 = String.format((Locale)locale, (String)"session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", (Object[])arrobject);
            CommonUtils.a((Context)this.a, (int)4, (String)"Fabric", (String)string2);
            this.d();
        }
    }

    private void b(String string2) {
        for (aml aml2 : this.f) {
            try {
                aml2.a(string2);
            }
            catch (Exception var4_3) {
                CommonUtils.a((Context)this.a, (String)"One of the roll over listeners threw an exception", (Throwable)var4_3);
            }
        }
    }

    public long a(String string2) {
        String[] arrstring = string2.split("_");
        if (arrstring.length != 3) {
            return 0;
        }
        try {
            long l2 = Long.valueOf((String)arrstring[2]);
            return l2;
        }
        catch (NumberFormatException var3_4) {
            return 0;
        }
    }

    protected abstract String a();

    public void a(aml aml2) {
        if (aml2 != null) {
            this.f.add((Object)aml2);
        }
    }

    public void a(T t2) throws IOException {
        byte[] arrby = this.b.a(t2);
        super.a(arrby.length);
        this.d.a(arrby);
    }

    public void a(List<File> list) {
        this.d.a(list);
    }

    protected int b() {
        return this.g;
    }

    protected int c() {
        return 8000;
    }

    public boolean d() throws IOException {
        boolean bl2 = this.d.b();
        boolean bl3 = false;
        String string2 = null;
        if (!bl2) {
            string2 = this.a();
            this.d.a(string2);
            CommonUtils.a((Context)this.a, (int)4, (String)"Fabric", (String)String.format((Locale)Locale.US, (String)"generated new file %s", (Object[])new Object[]{string2}));
            this.e = this.c.a();
            bl3 = true;
        }
        this.b(string2);
        return bl3;
    }

    public List<File> e() {
        return this.d.a(1);
    }

    public void f() {
        this.d.a(this.d.c());
        this.d.d();
    }

    public void g() {
        List<File> list = this.d.c();
        int n2 = this.b();
        if (list.size() <= n2) {
            return;
        }
        int n3 = list.size() - n2;
        Context context = this.a;
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{list.size(), n2, n3};
        CommonUtils.a((Context)context, (String)String.format((Locale)locale, (String)"Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", (Object[])arrobject));
        TreeSet treeSet = new TreeSet((Comparator)new Comparator<a>(){

            public int a(a a2, a a3) {
                return (int)(a2.b - a3.b);
            }

            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((a)object, (a)object2);
            }
        });
        for (File file : list) {
            treeSet.add((Object)new a(file, this.a(file.getName())));
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)((a)iterator.next()).a);
            if (arrayList.size() != n3) continue;
        }
        this.d.a((List<File>)arrayList);
    }

    static class a {
        final File a;
        final long b;

        public a(File file, long l2) {
            this.a = file;
            this.b = l2;
        }
    }

}

