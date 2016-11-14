/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 */
import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class amp
implements amk {
    private final Context a;
    private final File b;
    private final String c;
    private final File d;
    private alq e;
    private File f;

    public amp(Context context, File file, String string2, String string3) throws IOException {
        this.a = context;
        this.b = file;
        this.c = string3;
        this.d = new File(this.b, string2);
        this.e = new alq(this.d);
        super.e();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        OutputStream outputStream = null;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        }
        catch (Throwable var6_6) {}
        try {
            outputStream = this.a(file2);
            CommonUtils.a((InputStream)fileInputStream, (OutputStream)outputStream, (byte[])new byte[1024]);
        }
        catch (Throwable var6_8) {
            fileInputStream2 = fileInputStream;
        }
        CommonUtils.a((Closeable)fileInputStream, (String)"Failed to close file input stream");
        CommonUtils.a((Closeable)outputStream, (String)"Failed to close output stream");
        file.delete();
        return;
        {
            void var6_7;
            CommonUtils.a((Closeable)fileInputStream2, (String)"Failed to close file input stream");
            CommonUtils.a((Closeable)outputStream, (String)"Failed to close output stream");
            file.delete();
            throw var6_7;
        }
    }

    private void e() {
        this.f = new File(this.b, this.c);
        if (!this.f.exists()) {
            this.f.mkdirs();
        }
    }

    @Override
    public int a() {
        return this.e.a();
    }

    public OutputStream a(File file) throws IOException {
        return new FileOutputStream(file);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public List<File> a(int n2) {
        ArrayList arrayList = new ArrayList();
        File[] arrfile = this.f.listFiles();
        int n3 = arrfile.length;
        int n4 = 0;
        while (n4 < n3) {
            arrayList.add((Object)arrfile[n4]);
            if (arrayList.size() >= n2) {
                return arrayList;
            }
            ++n4;
        }
        return arrayList;
    }

    @Override
    public void a(String string2) throws IOException {
        this.e.close();
        super.a(this.d, new File(this.f, string2));
        this.e = new alq(this.d);
    }

    @Override
    public void a(List<File> list) {
        for (File file : list) {
            Context context = this.a;
            Object[] arrobject = new Object[]{file.getName()};
            CommonUtils.a((Context)context, (String)String.format((String)"deleting sent analytics file %s", (Object[])arrobject));
            file.delete();
        }
    }

    @Override
    public void a(byte[] arrby) throws IOException {
        this.e.a(arrby);
    }

    @Override
    public boolean a(int n2, int n3) {
        return this.e.a(n2, n3);
    }

    @Override
    public boolean b() {
        return this.e.b();
    }

    @Override
    public List<File> c() {
        return Arrays.asList((Object[])this.f.listFiles());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    @Override
    public void d() {
        try {
            this.e.close();
        }
        catch (IOException var1_1) {
            ** continue;
        }
lbl5: // 2 sources:
        do {
            this.d.delete();
            return;
            break;
        } while (true);
    }
}

