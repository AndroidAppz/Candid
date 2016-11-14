package com.facebook;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import defpackage.tz;
import defpackage.ud;
import defpackage.ue;
import defpackage.uf;
import defpackage.uf$a;
import defpackage.uf$b;
import defpackage.ug;
import defpackage.uk;
import defpackage.ul;
import defpackage.un;
import defpackage.vn;
import defpackage.vp;
import defpackage.vu;
import defpackage.vw;
import defpackage.vx;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphRequest {
    public static final String a = GraphRequest.class.getSimpleName();
    private static String b;
    private static Pattern c = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private static volatile String q;
    private AccessToken d;
    private HttpMethod e;
    private String f;
    private JSONObject g;
    private String h;
    private String i;
    private boolean j;
    private Bundle k;
    private b l;
    private String m;
    private Object n;
    private String o;
    private boolean p;

    public interface b {
        void onCompleted(ug ugVar);
    }

    public interface c {
        void onCompleted(JSONObject jSONObject, ug ugVar);
    }

    interface d {
        void a(String str, String str2) throws IOException;
    }

    public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Creator<ParcelableResourceWithMimeType> CREATOR = new Creator<ParcelableResourceWithMimeType>() {
            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return a(i);
            }

            public ParcelableResourceWithMimeType a(Parcel in) {
                return new ParcelableResourceWithMimeType(in);
            }

            public ParcelableResourceWithMimeType[] a(int size) {
                return new ParcelableResourceWithMimeType[size];
            }
        };
        private final String a;
        private final RESOURCE b;

        public String a() {
            return this.a;
        }

        public RESOURCE b() {
            return this.b;
        }

        public int describeContents() {
            return 1;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeString(this.a);
            out.writeParcelable(this.b, flags);
        }

        private ParcelableResourceWithMimeType(Parcel in) {
            this.a = in.readString();
            this.b = in.readParcelable(ud.f().getClassLoader());
        }
    }

    static class a {
        private final GraphRequest a;
        private final Object b;

        public a(GraphRequest request, Object value) {
            this.a = request;
            this.b = value;
        }

        public GraphRequest a() {
            return this.a;
        }

        public Object b() {
            return this.b;
        }
    }

    public interface e extends b {
        void a(long j, long j2);
    }

    static class f implements d {
        private final OutputStream a;
        private final vp b;
        private boolean c = true;
        private boolean d = false;

        public f(OutputStream outputStream, vp logger, boolean useUrlEncode) {
            this.a = outputStream;
            this.b = logger;
            this.d = useUrlEncode;
        }

        public void a(String key, Object value, GraphRequest request) throws IOException {
            if (this.a instanceof un) {
                ((un) this.a).a(request);
            }
            if (GraphRequest.e(value)) {
                a(key, GraphRequest.f(value));
            } else if (value instanceof Bitmap) {
                a(key, (Bitmap) value);
            } else if (value instanceof byte[]) {
                a(key, (byte[]) value);
            } else if (value instanceof Uri) {
                a(key, (Uri) value, null);
            } else if (value instanceof ParcelFileDescriptor) {
                a(key, (ParcelFileDescriptor) value, null);
            } else if (value instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType resourceWithMimeType = (ParcelableResourceWithMimeType) value;
                Parcelable resource = resourceWithMimeType.b();
                String mimeType = resourceWithMimeType.a();
                if (resource instanceof ParcelFileDescriptor) {
                    a(key, (ParcelFileDescriptor) resource, mimeType);
                } else if (resource instanceof Uri) {
                    a(key, (Uri) resource, mimeType);
                } else {
                    throw b();
                }
            } else {
                throw b();
            }
        }

        private RuntimeException b() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public void a(String key, JSONArray requestJsonArray, Collection<GraphRequest> requests) throws IOException, JSONException {
            if (this.a instanceof un) {
                un requestOutputStream = this.a;
                a(key, null, null);
                a("[", new Object[0]);
                int i = 0;
                for (GraphRequest request : requests) {
                    JSONObject requestJson = requestJsonArray.getJSONObject(i);
                    requestOutputStream.a(request);
                    if (i > 0) {
                        a(",%s", requestJson.toString());
                    } else {
                        a("%s", requestJson.toString());
                    }
                    i++;
                }
                a("]", new Object[0]);
                if (this.b != null) {
                    this.b.a("    " + key, requestJsonArray.toString());
                    return;
                }
                return;
            }
            a(key, requestJsonArray.toString());
        }

        public void a(String key, String value) throws IOException {
            a(key, null, null);
            b("%s", value);
            a();
            if (this.b != null) {
                this.b.a("    " + key, (Object) value);
            }
        }

        public void a(String key, Bitmap bitmap) throws IOException {
            a(key, key, "image/png");
            bitmap.compress(CompressFormat.PNG, 100, this.a);
            b("", new Object[0]);
            a();
            if (this.b != null) {
                this.b.a("    " + key, (Object) "<Image>");
            }
        }

        public void a(String key, byte[] bytes) throws IOException {
            a(key, key, "content/unknown");
            this.a.write(bytes);
            b("", new Object[0]);
            a();
            if (this.b != null) {
                this.b.a("    " + key, String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(bytes.length)}));
            }
        }

        public void a(String key, Uri contentUri, String mimeType) throws IOException {
            if (mimeType == null) {
                mimeType = "content/unknown";
            }
            a(key, key, mimeType);
            int totalBytes = 0;
            if (this.a instanceof uk) {
                ((uk) this.a).a(vw.e(contentUri));
            } else {
                totalBytes = 0 + vw.a(ud.f().getContentResolver().openInputStream(contentUri), this.a);
            }
            b("", new Object[0]);
            a();
            if (this.b != null) {
                this.b.a("    " + key, String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(totalBytes)}));
            }
        }

        public void a(String key, ParcelFileDescriptor descriptor, String mimeType) throws IOException {
            if (mimeType == null) {
                mimeType = "content/unknown";
            }
            a(key, key, mimeType);
            int totalBytes = 0;
            if (this.a instanceof uk) {
                ((uk) this.a).a(descriptor.getStatSize());
            } else {
                totalBytes = 0 + vw.a(new AutoCloseInputStream(descriptor), this.a);
            }
            b("", new Object[0]);
            a();
            if (this.b != null) {
                this.b.a("    " + key, String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(totalBytes)}));
            }
        }

        public void a() throws IOException {
            if (this.d) {
                this.a.write("&".getBytes());
                return;
            }
            b("--%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
        }

        public void a(String name, String filename, String contentType) throws IOException {
            if (this.d) {
                this.a.write(String.format("%s=", new Object[]{name}).getBytes());
                return;
            }
            a("Content-Disposition: form-data; name=\"%s\"", name);
            if (filename != null) {
                a("; filename=\"%s\"", filename);
            }
            b("", new Object[0]);
            if (contentType != null) {
                b("%s: %s", "Content-Type", contentType);
            }
            b("", new Object[0]);
        }

        public void a(String format, Object... args) throws IOException {
            if (this.d) {
                this.a.write(URLEncoder.encode(String.format(Locale.US, format, args), "UTF-8").getBytes());
                return;
            }
            if (this.c) {
                this.a.write("--".getBytes());
                this.a.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
                this.a.write("\r\n".getBytes());
                this.c = false;
            }
            this.a.write(String.format(format, args).getBytes());
        }

        public void b(String format, Object... args) throws IOException {
            a(format, args);
            if (!this.d) {
                a("\r\n", new Object[0]);
            }
        }
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    public GraphRequest(AccessToken accessToken, String graphPath, Bundle parameters, HttpMethod httpMethod) {
        this(accessToken, graphPath, parameters, httpMethod, null);
    }

    public GraphRequest(AccessToken accessToken, String graphPath, Bundle parameters, HttpMethod httpMethod, b callback) {
        this(accessToken, graphPath, parameters, httpMethod, callback, null);
    }

    public GraphRequest(AccessToken accessToken, String graphPath, Bundle parameters, HttpMethod httpMethod, b callback, String version) {
        this.j = true;
        this.p = false;
        this.d = accessToken;
        this.f = graphPath;
        this.o = version;
        a(callback);
        a(httpMethod);
        if (parameters != null) {
            this.k = new Bundle(parameters);
        } else {
            this.k = new Bundle();
        }
        if (this.o == null) {
            this.o = vu.d();
        }
    }

    public static GraphRequest a(AccessToken accessToken, final c callback) {
        return new GraphRequest(accessToken, "me", null, null, new b() {
            public void onCompleted(ug response) {
                if (callback != null) {
                    callback.onCompleted(response.b(), response);
                }
            }
        });
    }

    public static GraphRequest a(AccessToken accessToken, String graphPath, JSONObject graphObject, b callback) {
        GraphRequest request = new GraphRequest(accessToken, graphPath, null, HttpMethod.POST, callback);
        request.a(graphObject);
        return request;
    }

    public static GraphRequest a(AccessToken accessToken, String graphPath, b callback) {
        return new GraphRequest(accessToken, graphPath, null, null, callback);
    }

    public final JSONObject a() {
        return this.g;
    }

    public final void a(JSONObject graphObject) {
        this.g = graphObject;
    }

    public final String b() {
        return this.f;
    }

    public final HttpMethod c() {
        return this.e;
    }

    public final void a(HttpMethod httpMethod) {
        if (this.m == null || httpMethod == HttpMethod.GET) {
            if (httpMethod == null) {
                httpMethod = HttpMethod.GET;
            }
            this.e = httpMethod;
            return;
        }
        throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }

    public final String d() {
        return this.o;
    }

    public final void a(String version) {
        this.o = version;
    }

    public final void a(boolean skipClientToken) {
        this.p = skipClientToken;
    }

    public final Bundle e() {
        return this.k;
    }

    public final void a(Bundle parameters) {
        this.k = parameters;
    }

    public final AccessToken f() {
        return this.d;
    }

    public final b g() {
        return this.l;
    }

    public final void a(final b callback) {
        if (ud.a(LoggingBehavior.GRAPH_API_DEBUG_INFO) || ud.a(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.l = new b(this) {
                final /* synthetic */ GraphRequest b;

                public void onCompleted(ug response) {
                    JSONObject debug;
                    JSONArray debugMessages;
                    JSONObject responseObject = response.b();
                    if (responseObject != null) {
                        debug = responseObject.optJSONObject("__debug__");
                    } else {
                        debug = null;
                    }
                    if (debug != null) {
                        debugMessages = debug.optJSONArray("messages");
                    } else {
                        debugMessages = null;
                    }
                    if (debugMessages != null) {
                        for (int i = 0; i < debugMessages.length(); i++) {
                            String debugMessage;
                            String debugMessageType;
                            String debugMessageLink;
                            JSONObject debugMessageObject = debugMessages.optJSONObject(i);
                            if (debugMessageObject != null) {
                                debugMessage = debugMessageObject.optString("message");
                            } else {
                                debugMessage = null;
                            }
                            if (debugMessageObject != null) {
                                debugMessageType = debugMessageObject.optString("type");
                            } else {
                                debugMessageType = null;
                            }
                            if (debugMessageObject != null) {
                                debugMessageLink = debugMessageObject.optString("link");
                            } else {
                                debugMessageLink = null;
                            }
                            if (!(debugMessage == null || debugMessageType == null)) {
                                LoggingBehavior behavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                                if (debugMessageType.equals("warning")) {
                                    behavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                                }
                                if (!vw.a(debugMessageLink)) {
                                    debugMessage = debugMessage + " Link: " + debugMessageLink;
                                }
                                vp.a(behavior, GraphRequest.a, debugMessage);
                            }
                        }
                    }
                    if (callback != null) {
                        callback.onCompleted(response);
                    }
                }
            };
        } else {
            this.l = callback;
        }
    }

    public final void a(Object tag) {
        this.n = tag;
    }

    public final Object h() {
        return this.n;
    }

    public final ug i() {
        return a(this);
    }

    public final ue j() {
        return b(this);
    }

    public static HttpURLConnection a(uf requests) {
        Throwable e;
        d(requests);
        try {
            URL url;
            if (requests.size() == 1) {
                url = new URL(requests.a(0).l());
            } else {
                url = new URL(vu.b());
            }
            URLConnection uRLConnection = null;
            try {
                uRLConnection = a(url);
                a(requests, (HttpURLConnection) uRLConnection);
                return uRLConnection;
            } catch (IOException e2) {
                e = e2;
                vw.a(uRLConnection);
                throw new FacebookException("could not construct request body", e);
            } catch (JSONException e3) {
                e = e3;
                vw.a(uRLConnection);
                throw new FacebookException("could not construct request body", e);
            }
        } catch (Throwable e4) {
            throw new FacebookException("could not construct URL for request", e4);
        }
    }

    public static ug a(GraphRequest request) {
        List<ug> responses = a(request);
        if (responses != null && responses.size() == 1) {
            return (ug) responses.get(0);
        }
        throw new FacebookException("invalid state: expected a single response");
    }

    public static List<ug> a(GraphRequest... requests) {
        vx.a((Object) requests, "requests");
        return a(Arrays.asList(requests));
    }

    public static List<ug> a(Collection<GraphRequest> requests) {
        return b(new uf((Collection) requests));
    }

    public static List<ug> b(uf requests) {
        List<ug> responses;
        vx.c(requests, "requests");
        URLConnection connection = null;
        try {
            connection = a(requests);
            responses = a((HttpURLConnection) connection, requests);
        } catch (Throwable ex) {
            responses = ug.a(requests.d(), null, new FacebookException(ex));
            a(requests, (List) responses);
        } finally {
            vw.a(connection);
        }
        return responses;
    }

    public static ue b(GraphRequest... requests) {
        vx.a((Object) requests, "requests");
        return b(Arrays.asList(requests));
    }

    public static ue b(Collection<GraphRequest> requests) {
        return c(new uf((Collection) requests));
    }

    public static ue c(uf requests) {
        vx.c(requests, "requests");
        ue asyncTask = new ue(requests);
        asyncTask.executeOnExecutor(ud.d(), new Void[0]);
        return asyncTask;
    }

    public static List<ug> a(HttpURLConnection connection, uf requests) {
        List responses = ug.a(connection, requests);
        vw.a((URLConnection) connection);
        if (requests.size() != responses.size()) {
            throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", new Object[]{Integer.valueOf(responses.size()), Integer.valueOf(requests.size())}));
        }
        a(requests, responses);
        tz.a().d();
        return responses;
    }

    public String toString() {
        return "{Request: " + " accessToken: " + (this.d == null ? "null" : this.d) + ", graphPath: " + this.f + ", graphObject: " + this.g + ", httpMethod: " + this.e + ", parameters: " + this.k + "}";
    }

    static void a(final uf requests, List<ug> responses) {
        int numRequests = requests.size();
        final ArrayList<Pair<b, ug>> callbacks = new ArrayList();
        for (int i = 0; i < numRequests; i++) {
            GraphRequest request = requests.a(i);
            if (request.l != null) {
                callbacks.add(new Pair(request.l, responses.get(i)));
            }
        }
        if (callbacks.size() > 0) {
            Runnable runnable = new Runnable() {
                public void run() {
                    Iterator it = callbacks.iterator();
                    while (it.hasNext()) {
                        Pair<b, ug> pair = (Pair) it.next();
                        ((b) pair.first).onCompleted((ug) pair.second);
                    }
                    for (uf$a batchCallback : requests.e()) {
                        batchCallback.a(requests);
                    }
                }
            };
            Handler callbackHandler = requests.c();
            if (callbackHandler == null) {
                runnable.run();
            } else {
                callbackHandler.post(runnable);
            }
        }
    }

    private static HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", p());
        connection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        connection.setChunkedStreamingMode(0);
        return connection;
    }

    private void m() {
        if (this.d != null) {
            if (!this.k.containsKey("access_token")) {
                String token = this.d.b();
                vp.a(token);
                this.k.putString("access_token", token);
            }
        } else if (!(this.p || this.k.containsKey("access_token"))) {
            String appID = ud.i();
            String clientToken = ud.k();
            if (vw.a(appID) || vw.a(clientToken)) {
                Log.d(a, "Warning: Request without access token missing application ID or client token.");
            } else {
                this.k.putString("access_token", appID + "|" + clientToken);
            }
        }
        this.k.putString("sdk", "android");
        this.k.putString("format", "json");
        if (ud.a(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            this.k.putString("debug", "info");
        } else if (ud.a(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.k.putString("debug", "warning");
        }
    }

    private String b(String baseUrl) {
        Builder uriBuilder = new Builder().encodedPath(baseUrl);
        for (String key : this.k.keySet()) {
            Object value = this.k.get(key);
            if (value == null) {
                value = "";
            }
            if (e(value)) {
                uriBuilder.appendQueryParameter(key, f(value).toString());
            } else if (this.e == HttpMethod.GET) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[]{value.getClass().getSimpleName()}));
            }
        }
        return uriBuilder.toString();
    }

    final String k() {
        if (this.m != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String baseUrl = n();
        m();
        return b(baseUrl);
    }

    final String l() {
        if (this.m != null) {
            return this.m.toString();
        }
        String graphBaseUrlBase;
        if (c() == HttpMethod.POST && this.f != null && this.f.endsWith("/videos")) {
            graphBaseUrlBase = vu.c();
        } else {
            graphBaseUrlBase = vu.b();
        }
        String baseUrl = String.format("%s/%s", new Object[]{graphBaseUrlBase, n()});
        m();
        return b(baseUrl);
    }

    private String n() {
        if (c.matcher(this.f).matches()) {
            return this.f;
        }
        return String.format("%s/%s", new Object[]{this.o, this.f});
    }

    private void a(JSONArray batch, Map<String, a> attachments) throws JSONException, IOException {
        JSONObject batchEntry = new JSONObject();
        if (this.h != null) {
            batchEntry.put("name", this.h);
            batchEntry.put("omit_response_on_success", this.j);
        }
        if (this.i != null) {
            batchEntry.put("depends_on", this.i);
        }
        String relativeURL = k();
        batchEntry.put("relative_url", relativeURL);
        batchEntry.put("method", this.e);
        if (this.d != null) {
            vp.a(this.d.b());
        }
        ArrayList<String> attachmentNames = new ArrayList();
        for (String key : this.k.keySet()) {
            Object value = this.k.get(key);
            if (d(value)) {
                String name = String.format(Locale.ROOT, "%s%d", new Object[]{"file", Integer.valueOf(attachments.size())});
                attachmentNames.add(name);
                attachments.put(name, new a(this, value));
            }
        }
        if (!attachmentNames.isEmpty()) {
            batchEntry.put("attached_files", TextUtils.join(",", attachmentNames));
        }
        if (this.g != null) {
            final ArrayList<String> keysAndValues = new ArrayList();
            a(this.g, relativeURL, new d(this) {
                final /* synthetic */ GraphRequest b;

                public void a(String key, String value) throws IOException {
                    keysAndValues.add(String.format(Locale.US, "%s=%s", new Object[]{key, URLEncoder.encode(value, "UTF-8")}));
                }
            });
            batchEntry.put("body", TextUtils.join("&", keysAndValues));
        }
        batch.put(batchEntry);
    }

    private static boolean e(uf requests) {
        for (uf$a callback : requests.e()) {
            if (callback instanceof uf$b) {
                return true;
            }
        }
        Iterator it = requests.iterator();
        while (it.hasNext()) {
            if (((GraphRequest) it.next()).g() instanceof e) {
                return true;
            }
        }
        return false;
    }

    private static void a(HttpURLConnection connection, boolean shouldUseGzip) {
        if (shouldUseGzip) {
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Encoding", "gzip");
            return;
        }
        connection.setRequestProperty("Content-Type", o());
    }

    private static boolean f(uf requests) {
        Iterator it = requests.iterator();
        while (it.hasNext()) {
            GraphRequest request = (GraphRequest) it.next();
            for (String key : request.k.keySet()) {
                if (d(request.k.get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

    static final boolean b(GraphRequest request) {
        boolean z = false;
        String version = request.d();
        if (vw.a(version)) {
            return true;
        }
        if (version.startsWith("v")) {
            version = version.substring(1);
        }
        String[] versionParts = version.split("\\.");
        if ((versionParts.length >= 2 && Integer.parseInt(versionParts[0]) > 2) || (Integer.parseInt(versionParts[0]) >= 2 && Integer.parseInt(versionParts[1]) >= 4)) {
            z = true;
        }
        return z;
    }

    static final void d(uf requests) {
        Iterator it = requests.iterator();
        while (it.hasNext()) {
            GraphRequest request = (GraphRequest) it.next();
            if (HttpMethod.GET.equals(request.c()) && b(request)) {
                Bundle params = request.e();
                if (!params.containsKey("fields") || vw.a(params.getString("fields"))) {
                    vp.a(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", request.b());
                }
            }
        }
    }

    static final void a(uf requests, HttpURLConnection connection) throws IOException, JSONException {
        Throwable th;
        vp vpVar = new vp(LoggingBehavior.REQUESTS, "Request");
        int numRequests = requests.size();
        boolean shouldUseGzip = f(requests);
        HttpMethod connectionHttpMethod = numRequests == 1 ? requests.a(0).e : HttpMethod.POST;
        connection.setRequestMethod(connectionHttpMethod.name());
        a(connection, shouldUseGzip);
        URL url = connection.getURL();
        vpVar.c("Request:\n");
        vpVar.a("Id", requests.b());
        vpVar.a("URL", (Object) url);
        vpVar.a("Method", connection.getRequestMethod());
        vpVar.a("User-Agent", connection.getRequestProperty("User-Agent"));
        vpVar.a("Content-Type", connection.getRequestProperty("Content-Type"));
        connection.setConnectTimeout(requests.a());
        connection.setReadTimeout(requests.a());
        if (connectionHttpMethod == HttpMethod.POST) {
            connection.setDoOutput(true);
            OutputStream outputStream = null;
            try {
                OutputStream outputStream2 = new BufferedOutputStream(connection.getOutputStream());
                if (shouldUseGzip) {
                    try {
                        outputStream2 = new GZIPOutputStream(outputStream2);
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                }
                if (e(requests)) {
                    uk countingStream = new uk(requests.c());
                    a(requests, null, numRequests, url, countingStream, shouldUseGzip);
                    outputStream = new ul(outputStream2, requests, countingStream.b(), (long) countingStream.a());
                } else {
                    outputStream = outputStream2;
                }
                a(requests, vpVar, numRequests, url, outputStream, shouldUseGzip);
                if (outputStream != null) {
                    outputStream.close();
                }
                vpVar.a();
                return;
            } catch (Throwable th3) {
                th = th3;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        }
        vpVar.a();
    }

    private static void a(uf requests, vp logger, int numRequests, URL url, OutputStream outputStream, boolean shouldUseGzip) throws IOException, JSONException {
        f serializer = new f(outputStream, logger, shouldUseGzip);
        Map attachments;
        if (numRequests == 1) {
            GraphRequest request = requests.a(0);
            attachments = new HashMap();
            for (String key : request.k.keySet()) {
                Object value = request.k.get(key);
                if (d(value)) {
                    attachments.put(key, new a(request, value));
                }
            }
            if (logger != null) {
                logger.c("  Parameters:\n");
            }
            a(request.k, serializer, request);
            if (logger != null) {
                logger.c("  Attachments:\n");
            }
            a(attachments, serializer);
            if (request.g != null) {
                a(request.g, url.getPath(), (d) serializer);
                return;
            }
            return;
        }
        String batchAppID = g(requests);
        if (vw.a(batchAppID)) {
            throw new FacebookException("App ID was not specified at the request or Settings.");
        }
        serializer.a("batch_app_id", batchAppID);
        attachments = new HashMap();
        a(serializer, (Collection) requests, attachments);
        if (logger != null) {
            logger.c("  Attachments:\n");
        }
        a(attachments, serializer);
    }

    private static boolean c(String path) {
        Matcher matcher = c.matcher(path);
        if (matcher.matches()) {
            path = matcher.group(1);
        }
        if (path.startsWith("me/") || path.startsWith("/me/")) {
            return true;
        }
        return false;
    }

    private static void a(JSONObject graphObject, String path, d serializer) throws IOException {
        boolean isOGAction = false;
        if (c(path)) {
            int colonLocation = path.indexOf(":");
            int questionMarkLocation = path.indexOf("?");
            if (colonLocation <= 3 || (questionMarkLocation != -1 && colonLocation >= questionMarkLocation)) {
                isOGAction = false;
            } else {
                isOGAction = true;
            }
        }
        Iterator<String> keyIterator = graphObject.keys();
        while (keyIterator.hasNext()) {
            boolean passByValue;
            String key = (String) keyIterator.next();
            Object value = graphObject.opt(key);
            if (isOGAction && key.equalsIgnoreCase("image")) {
                passByValue = true;
            } else {
                passByValue = false;
            }
            a(key, value, serializer, passByValue);
        }
    }

    private static void a(String key, Object value, d serializer, boolean passByValue) throws IOException {
        Class<?> valueClass = value.getClass();
        if (JSONObject.class.isAssignableFrom(valueClass)) {
            JSONObject jsonObject = (JSONObject) value;
            if (passByValue) {
                Iterator<String> keys = jsonObject.keys();
                while (keys.hasNext()) {
                    Object[] objArr = new Object[]{key, (String) keys.next()};
                    a(String.format("%s[%s]", objArr), jsonObject.opt((String) keys.next()), serializer, passByValue);
                }
            } else if (jsonObject.has("id")) {
                a(key, jsonObject.optString("id"), serializer, passByValue);
            } else if (jsonObject.has("url")) {
                a(key, jsonObject.optString("url"), serializer, passByValue);
            } else if (jsonObject.has("fbsdk:create_object")) {
                a(key, jsonObject.toString(), serializer, passByValue);
            }
        } else if (JSONArray.class.isAssignableFrom(valueClass)) {
            JSONArray jsonArray = (JSONArray) value;
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                a(String.format(Locale.ROOT, "%s[%d]", new Object[]{key, Integer.valueOf(i)}), jsonArray.opt(i), serializer, passByValue);
            }
        } else if (String.class.isAssignableFrom(valueClass) || Number.class.isAssignableFrom(valueClass) || Boolean.class.isAssignableFrom(valueClass)) {
            serializer.a(key, value.toString());
        } else if (Date.class.isAssignableFrom(valueClass)) {
            d dVar = serializer;
            String str = key;
            dVar.a(str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) value));
        }
    }

    private static void a(Bundle bundle, f serializer, GraphRequest request) throws IOException {
        for (String key : bundle.keySet()) {
            Object value = bundle.get(key);
            if (e(value)) {
                serializer.a(key, value, request);
            }
        }
    }

    private static void a(Map<String, a> attachments, f serializer) throws IOException {
        for (String key : attachments.keySet()) {
            a attachment = (a) attachments.get(key);
            if (d(attachment.b())) {
                serializer.a(key, attachment.b(), attachment.a());
            }
        }
    }

    private static void a(f serializer, Collection<GraphRequest> requests, Map<String, a> attachments) throws JSONException, IOException {
        JSONArray batch = new JSONArray();
        for (GraphRequest request : requests) {
            request.a(batch, (Map) attachments);
        }
        serializer.a("batch", batch, (Collection) requests);
    }

    private static String o() {
        return String.format("multipart/form-data; boundary=%s", new Object[]{"3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"});
    }

    private static String p() {
        if (q == null) {
            q = String.format("%s.%s", new Object[]{"FBAndroidSDK", "4.12.1"});
            if (!vw.a(vn.a())) {
                q = String.format(Locale.ROOT, "%s/%s", new Object[]{q, vn.a()});
            }
        }
        return q;
    }

    private static String g(uf batch) {
        if (!vw.a(batch.f())) {
            return batch.f();
        }
        Iterator it = batch.iterator();
        while (it.hasNext()) {
            AccessToken accessToken = ((GraphRequest) it.next()).d;
            if (accessToken != null) {
                String applicationId = accessToken.h();
                if (applicationId != null) {
                    return applicationId;
                }
            }
        }
        if (vw.a(b)) {
            return ud.i();
        }
        return b;
    }

    private static boolean d(Object value) {
        return (value instanceof Bitmap) || (value instanceof byte[]) || (value instanceof Uri) || (value instanceof ParcelFileDescriptor) || (value instanceof ParcelableResourceWithMimeType);
    }

    private static boolean e(Object value) {
        return (value instanceof String) || (value instanceof Boolean) || (value instanceof Number) || (value instanceof Date);
    }

    private static String f(Object value) {
        if (value instanceof String) {
            return (String) value;
        }
        if ((value instanceof Boolean) || (value instanceof Number)) {
            return value.toString();
        }
        if (value instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(value);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }
}
