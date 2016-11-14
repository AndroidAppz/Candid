package defpackage;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* compiled from: ZipUtil */
final class ar {
    static long a(File apk) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(apk, "r");
        try {
            long a = ar.a(raf, ar.a(raf));
            return a;
        } finally {
            raf.close();
        }
    }

    static ar$a a(RandomAccessFile raf) throws IOException, ZipException {
        long scanOffset = raf.length() - 22;
        if (scanOffset < 0) {
            throw new ZipException("File too short to be a zip file: " + raf.length());
        }
        long stopOffset = scanOffset - 65536;
        if (stopOffset < 0) {
            stopOffset = 0;
        }
        int endSig = Integer.reverseBytes(101010256);
        do {
            raf.seek(scanOffset);
            if (raf.readInt() == endSig) {
                raf.skipBytes(2);
                raf.skipBytes(2);
                raf.skipBytes(2);
                raf.skipBytes(2);
                ar$a dir = new ar$a();
                dir.b = ((long) Integer.reverseBytes(raf.readInt())) & 4294967295L;
                dir.a = ((long) Integer.reverseBytes(raf.readInt())) & 4294967295L;
                return dir;
            }
            scanOffset--;
        } while (scanOffset >= stopOffset);
        throw new ZipException("End Of Central Directory signature not found");
    }

    static long a(RandomAccessFile raf, ar$a dir) throws IOException {
        CRC32 crc = new CRC32();
        long stillToRead = dir.b;
        raf.seek(dir.a);
        byte[] buffer = new byte[16384];
        int length = raf.read(buffer, 0, (int) Math.min(16384, stillToRead));
        while (length != -1) {
            crc.update(buffer, 0, length);
            stillToRead -= (long) length;
            if (stillToRead == 0) {
                break;
            }
            length = raf.read(buffer, 0, (int) Math.min(16384, stillToRead));
        }
        return crc.getValue();
    }
}
