/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.String
 *  java.util.zip.GZIPOutputStream
 */
import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class amo
extends amp {
    public amo(Context context, File file, String string2, String string3) throws IOException {
        super(context, file, string2, string3);
    }

    @Override
    public OutputStream a(File file) throws IOException {
        return new GZIPOutputStream((OutputStream)new FileOutputStream(file));
    }
}

