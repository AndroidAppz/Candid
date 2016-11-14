package defpackage;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.facebook.GraphRequest;
import java.net.HttpURLConnection;
import java.util.List;

/* compiled from: GraphRequestAsyncTask */
public class ue extends AsyncTask<Void, Void, List<ug>> {
    private static final String a = ue.class.getCanonicalName();
    private final HttpURLConnection b;
    private final uf c;
    private Exception d;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((List) obj);
    }

    public ue(uf requests) {
        this(null, requests);
    }

    public ue(HttpURLConnection connection, uf requests) {
        this.c = requests;
        this.b = connection;
    }

    public String toString() {
        return "{RequestAsyncTask: " + " connection: " + this.b + ", requests: " + this.c + "}";
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (ud.b()) {
            Log.d(a, String.format("execute async task: %s", new Object[]{this}));
        }
        if (this.c.c() == null) {
            Handler handler;
            if (Thread.currentThread() instanceof HandlerThread) {
                handler = new Handler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            this.c.a(handler);
        }
    }

    protected void a(List<ug> result) {
        super.onPostExecute(result);
        if (this.d != null) {
            Log.d(a, String.format("onPostExecute: exception encountered during request: %s", new Object[]{this.d.getMessage()}));
        }
    }

    protected List<ug> a(Void... params) {
        try {
            if (this.b == null) {
                return this.c.g();
            }
            return GraphRequest.a(this.b, this.c);
        } catch (Exception e) {
            this.d = e;
            return null;
        }
    }
}
