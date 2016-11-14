/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.RandomAccessFile
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.channels.FileChannel
 *  java.nio.channels.WritableByteChannel
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class alq
implements Closeable {
    private static final Logger b = Logger.getLogger((String)alq.class.getName());
    int a;
    private final RandomAccessFile c;
    private int d;
    private a e;
    private a f;
    private final byte[] g = new byte[16];

    public alq(File file) throws IOException {
        if (!file.exists()) {
            alq.a(file);
        }
        this.c = alq.b(file);
        super.c();
    }

    private static int a(byte[] arrby, int n2) {
        return ((255 & arrby[n2]) << 24) + ((255 & arrby[n2 + 1]) << 16) + ((255 & arrby[n2 + 2]) << 8) + (255 & arrby[n2 + 3]);
    }

    private a a(int n2) throws IOException {
        if (n2 == 0) {
            return a.a;
        }
        this.c.seek((long)n2);
        return new a(n2, this.c.readInt());
    }

    private void a(int n2, int n3, int n4, int n5) throws IOException {
        alq.a(this.g, n2, n3, n4, n5);
        this.c.seek(0);
        this.c.write(this.g);
    }

    private void a(int n2, byte[] arrby, int n3, int n4) throws IOException {
        int n5 = super.b(n2);
        if (n5 + n4 <= this.a) {
            this.c.seek((long)n5);
            this.c.write(arrby, n3, n4);
            return;
        }
        int n6 = this.a - n5;
        this.c.seek((long)n5);
        this.c.write(arrby, n3, n6);
        this.c.seek(16);
        this.c.write(arrby, n3 + n6, n4 - n6);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFile = alq.b(file2);
        randomAccessFile.setLength(4096);
        randomAccessFile.seek(0);
        byte[] arrby = new byte[16];
        alq.a(arrby, 4096, 0, 0, 0);
        randomAccessFile.write(arrby);
        if (file2.renameTo(file)) return;
        throw new IOException("Rename failed!");
        finally {
            randomAccessFile.close();
        }
    }

    private static /* varargs */ void a(byte[] arrby, int ... arrn) {
        int n2 = 0;
        int n3 = arrn.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            alq.b(arrby, n2, arrn[i2]);
            n2 += 4;
        }
    }

    private int b(int n2) {
        if (n2 < this.a) {
            return n2;
        }
        return n2 + 16 - this.a;
    }

    private static RandomAccessFile b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private static <T> T b(T t2, String string2) {
        if (t2 == null) {
            throw new NullPointerException(string2);
        }
        return t2;
    }

    private void b(int n2, byte[] arrby, int n3, int n4) throws IOException {
        int n5 = super.b(n2);
        if (n5 + n4 <= this.a) {
            this.c.seek((long)n5);
            this.c.readFully(arrby, n3, n4);
            return;
        }
        int n6 = this.a - n5;
        this.c.seek((long)n5);
        this.c.readFully(arrby, n3, n6);
        this.c.seek(16);
        this.c.readFully(arrby, n3 + n6, n4 - n6);
    }

    private static void b(byte[] arrby, int n2, int n3) {
        arrby[n2] = (byte)(n3 >> 24);
        arrby[n2 + 1] = (byte)(n3 >> 16);
        arrby[n2 + 2] = (byte)(n3 >> 8);
        arrby[n2 + 3] = (byte)n3;
    }

    private void c() throws IOException {
        this.c.seek(0);
        this.c.readFully(this.g);
        this.a = alq.a(this.g, 0);
        if ((long)this.a > this.c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.a + ", Actual length: " + this.c.length());
        }
        this.d = alq.a(this.g, 4);
        int n2 = alq.a(this.g, 8);
        int n3 = alq.a(this.g, 12);
        this.e = this.a(n2);
        this.f = this.a(n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(int n2) throws IOException {
        int n3;
        int n4 = n2 + 4;
        int n5 = super.d();
        if (n5 >= n4) {
            return;
        }
        int n6 = this.a;
        while ((n5 += (n6 = (n3 = n6 << 1))) < n4) {
        }
        super.d(n3);
        int n7 = super.b(4 + this.f.b + this.f.c);
        if (n7 < this.e.b) {
            FileChannel fileChannel = this.c.getChannel();
            fileChannel.position((long)this.a);
            int n8 = n7 - 4;
            if (fileChannel.transferTo(16, (long)n8, (WritableByteChannel)fileChannel) != (long)n8) {
                throw new AssertionError((Object)"Copied insufficient number of bytes!");
            }
        }
        if (this.f.b < this.e.b) {
            int n9 = -16 + (this.a + this.f.b);
            super.a(n3, this.d, this.e.b, n9);
            this.f = new a(n9, this.f.c);
        } else {
            super.a(n3, this.d, this.e.b, this.f.b);
        }
        this.a = n3;
    }

    private int d() {
        return this.a - this.a();
    }

    private void d(int n2) throws IOException {
        this.c.setLength((long)n2);
        this.c.getChannel().force(true);
    }

    public int a() {
        if (this.d == 0) {
            return 16;
        }
        if (this.f.b >= this.e.b) {
            return 16 + (4 + (this.f.b - this.e.b) + this.f.c);
        }
        return 4 + this.f.b + this.f.c + this.a - this.e.b;
    }

    public void a(c c2) throws IOException {
        void var7_2 = this;
        synchronized (var7_2) {
            int n2 = this.e.b;
            int n3 = 0;
            do {
                int n4;
                if (n3 >= this.d) break;
                a a2 = super.a(n2);
                c2.a(new b((alq)this, a2, null), a2.c);
                n2 = n4 = super.b(4 + a2.b + a2.c);
                ++n3;
            } while (true);
            return;
        }
    }

    public void a(byte[] arrby) throws IOException {
        this.a(arrby, 0, arrby.length);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(byte[] arrby, int n2, int n3) throws IOException {
        void var10_4 = this;
        synchronized (var10_4) {
            alq.b(arrby, "buffer");
            if ((n2 | n3) < 0 || n3 > arrby.length - n2) {
                throw new IndexOutOfBoundsException();
            }
            super.c(n3);
            boolean bl2 = this.b();
            int n4 = bl2 ? 16 : super.b(4 + this.f.b + this.f.c);
            a a2 = new a(n4, n3);
            alq.b(this.g, 0, n3);
            super.a(a2.b, this.g, 0, 4);
            super.a(4 + a2.b, arrby, n2, n3);
            int n5 = bl2 ? a2.b : this.e.b;
            super.a(this.a, 1 + this.d, n5, a2.b);
            this.f = a2;
            this.d = 1 + this.d;
            if (bl2) {
                this.e = this.f;
            }
            return;
        }
    }

    public boolean a(int n2, int n3) {
        if (n2 + (4 + this.a()) <= n3) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean b() {
        alq alq2 = this;
        synchronized (alq2) {
            int n2 = this.d;
            if (n2 != 0) return false;
            return true;
        }
    }

    public void close() throws IOException {
        alq alq2 = this;
        synchronized (alq2) {
            this.c.close();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName()).append('[');
        stringBuilder.append("fileLength=").append(this.a);
        stringBuilder.append(", size=").append(this.d);
        stringBuilder.append(", first=").append((Object)this.e);
        stringBuilder.append(", last=").append((Object)this.f);
        stringBuilder.append(", element lengths=[");
        try {
            this.a(new c(){
                boolean a;

                /*
                 * Enabled aggressive block sorting
                 */
                @Override
                public void a(InputStream inputStream, int n2) throws IOException {
                    if (this.a) {
                        this.a = false;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(n2);
                }
            });
        }
        catch (IOException var8_2) {
            b.log(Level.WARNING, "read error", (Throwable)var8_2);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }

    static class a {
        static final a a = new a(0, 0);
        final int b;
        final int c;

        a(int n2, int n3) {
            this.b = n2;
            this.c = n3;
        }

        public String toString() {
            return this.getClass().getSimpleName() + "[" + "position = " + this.b + ", length = " + this.c + "]";
        }
    }

    final class b
    extends InputStream {
        final /* synthetic */ alq a;
        private int b;
        private int c;

        private b(alq alq2, a a2) {
            this.a = alq2;
            this.b = alq2.b(4 + a2.b);
            this.c = a2.c;
        }

        /* synthetic */ b(alq alq2, a a2,  var3_2) {
            super(alq2, a2);
        }

        public int read() throws IOException {
            if (this.c == 0) {
                return -1;
            }
            this.a.c.seek((long)this.b);
            int n2 = this.a.c.read();
            this.b = this.a.b(1 + this.b);
            this.c = -1 + this.c;
            return n2;
        }

        public int read(byte[] arrby, int n2, int n3) throws IOException {
            alq.b((Object)arrby, "buffer");
            if ((n2 | n3) < 0 || n3 > arrby.length - n2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (this.c > 0) {
                if (n3 > this.c) {
                    n3 = this.c;
                }
                this.a.b(this.b, arrby, n2, n3);
                this.b = this.a.b(n3 + this.b);
                this.c -= n3;
                return n3;
            }
            return -1;
        }
    }

    public static interface c {
        public void a(InputStream var1, int var2) throws IOException;
    }

}

