package defpackage;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: EventsFilesManager */
public abstract class amj<T> {
    protected final Context a;
    protected final ami<T> b;
    protected final alm c;
    protected final amk d;
    protected volatile long e;
    protected final List<aml> f = new CopyOnWriteArrayList();
    private final int g;

    protected abstract String a();

    public amj(Context context, ami<T> transform, alm currentTimeProvider, amk eventStorage, int defaultMaxFilesToKeep) throws IOException {
        this.a = context.getApplicationContext();
        this.b = transform;
        this.d = eventStorage;
        this.c = currentTimeProvider;
        this.e = this.c.a();
        this.g = defaultMaxFilesToKeep;
    }

    public void a(T event) throws IOException {
        byte[] eventBytes = this.b.a(event);
        a(eventBytes.length);
        this.d.a(eventBytes);
    }

    public void a(aml listener) {
        if (listener != null) {
            this.f.add(listener);
        }
    }

    public boolean d() throws IOException {
        boolean fileRolledOver = false;
        String targetFileName = null;
        if (!this.d.b()) {
            targetFileName = a();
            this.d.a(targetFileName);
            CommonUtils.a(this.a, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{targetFileName}));
            this.e = this.c.a();
            fileRolledOver = true;
        }
        b(targetFileName);
        return fileRolledOver;
    }

    private void a(int newEventSizeInBytes) throws IOException {
        if (!this.d.a(newEventSizeInBytes, c())) {
            CommonUtils.a(this.a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.d.a()), Integer.valueOf(newEventSizeInBytes), Integer.valueOf(c())}));
            d();
        }
    }

    protected int b() {
        return this.g;
    }

    protected int c() {
        return 8000;
    }

    private void b(String rolledOverFile) {
        for (aml eventStorageRollOverListener : this.f) {
            try {
                eventStorageRollOverListener.a(rolledOverFile);
            } catch (Exception e) {
                CommonUtils.a(this.a, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    public List<File> e() {
        return this.d.a(1);
    }

    public void a(List<File> files) {
        this.d.a((List) files);
    }

    public void f() {
        this.d.a(this.d.c());
        this.d.d();
    }

    public void g() {
        List<File> allFiles = this.d.c();
        int maxFiles = b();
        if (allFiles.size() > maxFiles) {
            int numberOfFilesToDelete = allFiles.size() - maxFiles;
            CommonUtils.a(this.a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(allFiles.size()), Integer.valueOf(maxFiles), Integer.valueOf(numberOfFilesToDelete)}));
            TreeSet<amj$a> sortedFiles = new TreeSet(new amj$1(this));
            for (File file : allFiles) {
                sortedFiles.add(new amj$a(file, a(file.getName())));
            }
            List toDelete = new ArrayList();
            Iterator i$ = sortedFiles.iterator();
            while (i$.hasNext()) {
                toDelete.add(((amj$a) i$.next()).a);
                if (toDelete.size() == numberOfFilesToDelete) {
                    break;
                }
            }
            this.d.a(toDelete);
        }
    }

    public long a(String fileName) {
        long j = 0;
        String[] fileNameParts = fileName.split("_");
        if (fileNameParts.length == 3) {
            try {
                j = Long.valueOf(fileNameParts[2]).longValue();
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }
}
