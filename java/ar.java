/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.zip.CRC32
 *  java.util.zip.ZipException
 */
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class ar {
    static long a(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            long l2 = ar.a(randomAccessFile, ar.a(randomAccessFile));
            return l2;
        }
        finally {
            randomAccessFile.close();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static long a(RandomAccessFile randomAccessFile, a a2) throws IOException {
        CRC32 cRC32 = new CRC32();
        long l2 = a2.b;
        randomAccessFile.seek(a2.a);
        int n2 = (int)Math.min((long)16384, (long)l2);
        byte[] arrby = new byte[16384];
        int n3 = randomAccessFile.read(arrby, 0, n2);
        while (n3 != -1) {
            cRC32.update(arrby, 0, n3);
            if ((l2 -= (long)n3) == 0) {
                return cRC32.getValue();
            }
            n3 = randomAccessFile.read(arrby, 0, (int)Math.min((long)16384, (long)l2));
        }
        return cRC32.getValue();
    }

    static a a(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long l2 = randomAccessFile.length() - 22;
        if (l2 < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long l3 = l2 - 65536;
        if (l3 < 0) {
            l3 = 0;
        }
        int n2 = Integer.reverseBytes((int)101010256);
        do {
            randomAccessFile.seek(l2);
            if (randomAccessFile.readInt() != n2) continue;
            randomAccessFile.skipBytes(2);
            randomAccessFile.skipBytes(2);
            randomAccessFile.skipBytes(2);
            randomAccessFile.skipBytes(2);
            a a2 = new a();
            a2.b = 0xFFFFFFFFL & (long)Integer.reverseBytes((int)randomAccessFile.readInt());
            a2.a = 0xFFFFFFFFL & (long)Integer.reverseBytes((int)randomAccessFile.readInt());
            return a2;
        } while (--l2 >= l3);
        throw new ZipException("End Of Central Directory signature not found");
    }

    static class a {
        long a;
        long b;

        a() {
        }
    }

}

