package defpackage;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* compiled from: FileDescriptorAssetPathFetcher */
public class kn extends kk<ParcelFileDescriptor> {
    protected /* synthetic */ Object a(AssetManager x0, String x1) throws IOException {
        return b(x0, x1);
    }

    public kn(AssetManager assetManager, String assetPath) {
        super(assetManager, assetPath);
    }

    protected ParcelFileDescriptor b(AssetManager assetManager, String path) throws IOException {
        return assetManager.openFd(path).getParcelFileDescriptor();
    }

    protected void a(ParcelFileDescriptor data) throws IOException {
        data.close();
    }
}
