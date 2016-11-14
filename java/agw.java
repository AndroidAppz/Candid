/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  com.google.android.gms.measurement.internal.zzw
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.List
 *  java.util.Map
 */
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.measurement.internal.zzw;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class agw
extends afv {
    public agw(ahc ahc2) {
        super(ahc2);
    }

    static /* synthetic */ byte[] a(agw agw2, HttpURLConnection httpURLConnection) throws IOException {
        return agw2.a(httpURLConnection);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private byte[] a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            int n2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] arrby = new byte[1024];
            while ((n2 = inputStream.read(arrby)) > 0) {
                byteArrayOutputStream.write(arrby, 0, n2);
            }
            byte[] arrby2 = byteArrayOutputStream.toByteArray();
            return arrby2;
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected HttpURLConnection a(URL uRL) throws IOException {
        URLConnection uRLConnection = uRL.openConnection();
        if (!(uRLConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRLConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout((int)this.y().I());
        httpURLConnection.setReadTimeout((int)this.y().J());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    protected void a(String string2) {
    }

    public void a(String string2, URL uRL, Map<String, String> map, a a2) {
        this.j();
        this.c();
        xr.a(uRL);
        xr.a(a2);
        this.v().b((Runnable)(agw)this.new c(string2, uRL, null, map, a2));
    }

    public void a(String string2, URL uRL, byte[] arrby, Map<String, String> map, a a2) {
        this.j();
        this.c();
        xr.a(uRL);
        xr.a(arrby);
        xr.a(a2);
        this.v().b((Runnable)new c(string2, uRL, arrby, map, a2));
    }

    @Override
    protected void e() {
    }

    public boolean f() {
        NetworkInfo networkInfo;
        this.c();
        ConnectivityManager connectivityManager = (ConnectivityManager)this.q().getSystemService("connectivity");
        try {
            NetworkInfo networkInfo2;
            networkInfo = networkInfo2 = connectivityManager.getActiveNetworkInfo();
        }
        catch (SecurityException var2_4) {
            networkInfo = null;
        }
        while (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    protected void g() {
    }

    static interface a {
        public void a(String var1, int var2, Throwable var3, byte[] var4, Map<String, List<String>> var5);
    }

    static class b
    implements Runnable {
        private final a a;
        private final int b;
        private final Throwable c;
        private final byte[] d;
        private final String e;
        private final Map<String, List<String>> f;

        private b(String string2, a a2, int n2, Throwable throwable, byte[] arrby, Map<String, List<String>> map) {
            xr.a(a2);
            this.a = a2;
            this.b = n2;
            this.c = throwable;
            this.d = arrby;
            this.e = string2;
            this.f = map;
        }

        public void run() {
            this.a.a(this.e, this.b, this.c, this.d, this.f);
        }
    }

    class c
    implements Runnable {
        private final URL b;
        private final byte[] c;
        private final a d;
        private final String e;
        private final Map<String, String> f;

        public c(String string2, URL uRL, byte[] arrby, Map<String, String> map, a a2) {
            xr.a(string2);
            xr.a(uRL);
            xr.a(a2);
            this.b = uRL;
            this.c = arrby;
            this.d = a2;
            this.e = string2;
            this.f = map;
        }

        /*
         * Exception decompiling
         */
        public void run() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl30 : TryStatement: try { 3[TRYBLOCK]

            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
            // org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.RemoveDeterministicJumps.apply(RemoveDeterministicJumps.java:35)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:507)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
            // org.benf.cfr.reader.Main.doJar(Main.java:128)
            // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
            // java.lang.Thread.run(Thread.java:818)
            throw new IllegalStateException("Decompilation failed");
        }
    }

}

