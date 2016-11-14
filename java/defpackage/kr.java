package defpackage;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamAssetPathFetcher */
public class kr extends kk<InputStream> {
    protected /* synthetic */ Object a(AssetManager x0, String x1) throws IOException {
        return b(x0, x1);
    }

    public kr(AssetManager assetManager, String assetPath) {
        super(assetManager, assetPath);
    }

    protected InputStream b(AssetManager assetManager, String path) throws IOException {
        return assetManager.open(path);
    }

    protected void a(InputStream data) throws IOException {
        data.close();
    }
}
