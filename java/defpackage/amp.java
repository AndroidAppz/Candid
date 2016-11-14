package defpackage;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: QueueFileEventStorage */
public class amp implements amk {
    private final Context a;
    private final File b;
    private final String c;
    private final File d;
    private alq e = new alq(this.d);
    private File f;

    public amp(Context context, File workingDirectory, String workingFileName, String targetDirectoryName) throws IOException {
        this.a = context;
        this.b = workingDirectory;
        this.c = targetDirectoryName;
        this.d = new File(this.b, workingFileName);
        e();
    }

    private void e() {
        this.f = new File(this.b, this.c);
        if (!this.f.exists()) {
            this.f.mkdirs();
        }
    }

    public void a(byte[] data) throws IOException {
        this.e.a(data);
    }

    public int a() {
        return this.e.a();
    }

    public void a(String targetName) throws IOException {
        this.e.close();
        a(this.d, new File(this.f, targetName));
        this.e = new alq(this.d);
    }

    private void a(File sourceFile, File targetFile) throws IOException {
        Throwable th;
        OutputStream fos = null;
        FileInputStream fis = null;
        try {
            FileInputStream fis2 = new FileInputStream(sourceFile);
            try {
                fos = a(targetFile);
                CommonUtils.a(fis2, fos, new byte[1024]);
                CommonUtils.a(fis2, "Failed to close file input stream");
                CommonUtils.a(fos, "Failed to close output stream");
                sourceFile.delete();
            } catch (Throwable th2) {
                th = th2;
                fis = fis2;
                CommonUtils.a(fis, "Failed to close file input stream");
                CommonUtils.a(fos, "Failed to close output stream");
                sourceFile.delete();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.a(fis, "Failed to close file input stream");
            CommonUtils.a(fos, "Failed to close output stream");
            sourceFile.delete();
            throw th;
        }
    }

    public OutputStream a(File targetFile) throws IOException {
        return new FileOutputStream(targetFile);
    }

    public List<File> a(int maxBatchSize) {
        List<File> batch = new ArrayList();
        for (File file : this.f.listFiles()) {
            batch.add(file);
            if (batch.size() >= maxBatchSize) {
                break;
            }
        }
        return batch;
    }

    public void a(List<File> files) {
        for (File file : files) {
            CommonUtils.a(this.a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    public List<File> c() {
        return Arrays.asList(this.f.listFiles());
    }

    public void d() {
        try {
            this.e.close();
        } catch (IOException e) {
        }
        this.d.delete();
    }

    public boolean b() {
        return this.e.b();
    }

    public boolean a(int newEventSizeInBytes, int maxByteSizePerFile) {
        return this.e.a(newEventSizeInBytes, maxByteSizePerFile);
    }
}
