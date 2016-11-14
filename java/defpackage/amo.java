package defpackage;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: GZIPQueueFileEventStorage */
public class amo extends amp {
    public amo(Context context, File workingDirectory, String workingFileName, String targetDirectoryName) throws IOException {
        super(context, workingDirectory, workingFileName, targetDirectoryName);
    }

    public OutputStream a(File targetFile) throws IOException {
        return new GZIPOutputStream(new FileOutputStream(targetFile));
    }
}
