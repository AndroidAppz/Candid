package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.internal.LikeContent.a;
import com.facebook.share.widget.LikeView.ObjectType;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LikeActionController */
public class wk {
    private static final String a = wk.class.getSimpleName();
    private static vh b;
    private static final ConcurrentHashMap<String, wk> c = new ConcurrentHashMap();
    private static vz d = new vz(1);
    private static vz e = new vz(1);
    private static Handler f;
    private static String g;
    private static boolean h;
    private static volatile int i;
    private static ua j;
    private String k;
    private ObjectType l;
    private boolean m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private boolean u;
    private boolean v;
    private Bundle w;
    private AppEventsLogger x;

    private static void b(java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextEntry(HashMap.java:789)
	at java.util.HashMap$KeyIterator.next(HashMap.java:814)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:173)
*/
        /*
        r1 = 0;
        r2 = b;	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r1 = r2.b(r4);	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r2 = r5.getBytes();	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r1.write(r2);	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        if (r1 == 0) goto L_0x0013;
    L_0x0010:
        defpackage.vw.a(r1);
    L_0x0013:
        return;
    L_0x0014:
        r0 = move-exception;
        r2 = a;	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r3 = "Unable to serialize controller to disk";	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        if (r1 == 0) goto L_0x0013;
    L_0x001e:
        defpackage.vw.a(r1);
        goto L_0x0013;
    L_0x0022:
        r2 = move-exception;
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        defpackage.vw.a(r1);
    L_0x0028:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: wk.b(java.lang.String, java.lang.String):void");
    }

    public static boolean a(int requestCode, int resultCode, Intent data) {
        if (vw.a(g)) {
            g = ud.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
        }
        if (vw.a(g)) {
            return false;
        }
        wk.a(g, ObjectType.UNKNOWN, new wk$1(requestCode, resultCode, data));
        return true;
    }

    public static void a(String objectId, ObjectType objectType, wk$c callback) {
        if (!h) {
            wk.j();
        }
        wk controllerForObject = wk.a(objectId);
        if (controllerForObject != null) {
            wk.a(controllerForObject, objectType, callback);
        } else {
            e.a(new wk$b(objectId, objectType, callback));
        }
    }

    private static void a(wk likeActionController, ObjectType objectType, wk$c callback) {
        ObjectType bestObjectType = wr.a(objectType, likeActionController.l);
        FacebookException error = null;
        if (bestObjectType == null) {
            error = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", likeActionController.k, likeActionController.l.toString(), objectType.toString());
            likeActionController = null;
        } else {
            likeActionController.l = bestObjectType;
        }
        wk.a(callback, likeActionController, error);
    }

    private static void c(String objectId, ObjectType objectType, wk$c callback) {
        wk controllerForObject = wk.a(objectId);
        if (controllerForObject != null) {
            wk.a(controllerForObject, objectType, callback);
            return;
        }
        controllerForObject = wk.b(objectId);
        if (controllerForObject == null) {
            controllerForObject = new wk(objectId, objectType);
            wk.l(controllerForObject);
        }
        wk.a(objectId, controllerForObject);
        wk controllerToRefresh = controllerForObject;
        f.post(new wk$5(controllerToRefresh));
        wk.a(callback, controllerToRefresh, null);
    }

    private static synchronized void j() {
        synchronized (wk.class) {
            if (!h) {
                f = new Handler(Looper.getMainLooper());
                i = ud.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getInt("OBJECT_SUFFIX", 1);
                b = new vh(a, new vh$d());
                wk.k();
                CallbackManagerImpl.a(RequestCodeOffset.Like.a(), new wk$6());
                h = true;
            }
        }
    }

    private static void a(wk$c callback, wk controller, FacebookException error) {
        if (callback != null) {
            f.post(new wk$7(callback, controller, error));
        }
    }

    private static void k() {
        j = new wk$8();
    }

    private static void a(String objectId, wk controllerForObject) {
        String cacheKey = wk.d(objectId);
        d.a(new wk$j(cacheKey, true));
        c.put(cacheKey, controllerForObject);
    }

    private static wk a(String objectId) {
        String cacheKey = wk.d(objectId);
        wk controller = (wk) c.get(cacheKey);
        if (controller != null) {
            d.a(new wk$j(cacheKey, false));
        }
        return controller;
    }

    private static void l(wk controller) {
        String controllerJson = wk.m(controller);
        String cacheKey = wk.d(controller.k);
        if (!vw.a(controllerJson) && !vw.a(cacheKey)) {
            e.a(new wk$o(cacheKey, controllerJson));
        }
    }

    private static wk b(String objectId) {
        wk controller = null;
        try {
            Closeable inputStream = b.a(wk.d(objectId));
            if (inputStream != null) {
                String controllerJsonString = vw.a((InputStream) inputStream);
                if (!vw.a(controllerJsonString)) {
                    controller = wk.c(controllerJsonString);
                }
            }
            if (inputStream != null) {
                vw.a(inputStream);
            }
        } catch (IOException e) {
            Log.e(a, "Unable to deserialize controller from disk", e);
            controller = null;
            if (null != null) {
                vw.a(null);
            }
        } catch (Throwable th) {
            if (null != null) {
                vw.a(null);
            }
        }
        return controller;
    }

    private static wk c(String controllerJsonString) {
        try {
            JSONObject controllerJson = new JSONObject(controllerJsonString);
            if (controllerJson.optInt("com.facebook.share.internal.LikeActionController.version", -1) != 3) {
                return null;
            }
            wk controller = new wk(controllerJson.getString("object_id"), ObjectType.a(controllerJson.optInt("object_type", ObjectType.UNKNOWN.a())));
            controller.n = controllerJson.optString("like_count_string_with_like", null);
            controller.o = controllerJson.optString("like_count_string_without_like", null);
            controller.p = controllerJson.optString("social_sentence_with_like", null);
            controller.q = controllerJson.optString("social_sentence_without_like", null);
            controller.m = controllerJson.optBoolean("is_object_liked");
            controller.r = controllerJson.optString("unlike_token", null);
            JSONObject analyticsJSON = controllerJson.optJSONObject("facebook_dialog_analytics_bundle");
            if (analyticsJSON == null) {
                return controller;
            }
            controller.w = uz.a(analyticsJSON);
            return controller;
        } catch (JSONException e) {
            Log.e(a, "Unable to deserialize controller from JSON", e);
            return null;
        }
    }

    private static String m(wk controller) {
        JSONObject controllerJson = new JSONObject();
        try {
            controllerJson.put("com.facebook.share.internal.LikeActionController.version", 3);
            controllerJson.put("object_id", controller.k);
            controllerJson.put("object_type", controller.l.a());
            controllerJson.put("like_count_string_with_like", controller.n);
            controllerJson.put("like_count_string_without_like", controller.o);
            controllerJson.put("social_sentence_with_like", controller.p);
            controllerJson.put("social_sentence_without_like", controller.q);
            controllerJson.put("is_object_liked", controller.m);
            controllerJson.put("unlike_token", controller.r);
            if (controller.w != null) {
                JSONObject analyticsJSON = uz.a(controller.w);
                if (analyticsJSON != null) {
                    controllerJson.put("facebook_dialog_analytics_bundle", analyticsJSON);
                }
            }
            return controllerJson.toString();
        } catch (JSONException e) {
            Log.e(a, "Unable to serialize controller to JSON", e);
            return null;
        }
    }

    private static String d(String objectId) {
        String accessTokenPortion = null;
        AccessToken accessToken = AccessToken.a();
        if (accessToken != null) {
            accessTokenPortion = accessToken.b();
        }
        if (accessTokenPortion != null) {
            accessTokenPortion = vw.b(accessTokenPortion);
        }
        return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", new Object[]{objectId, vw.a(accessTokenPortion, ""), Integer.valueOf(i)});
    }

    private static void d(wk controller, String action) {
        wk.c(controller, action, null);
    }

    private static void c(wk controller, String action, Bundle data) {
        Intent broadcastIntent = new Intent(action);
        if (controller != null) {
            if (data == null) {
                data = new Bundle();
            }
            data.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", controller.a());
        }
        if (data != null) {
            broadcastIntent.putExtras(data);
        }
        bn.a(ud.f()).a(broadcastIntent);
    }

    private wk(String objectId, ObjectType objectType) {
        this.k = objectId;
        this.l = objectType;
    }

    public String a() {
        return this.k;
    }

    public String b() {
        return this.m ? this.n : this.o;
    }

    public String c() {
        return this.m ? this.p : this.q;
    }

    public boolean d() {
        return this.m;
    }

    public boolean e() {
        if (wl.e() || wl.f()) {
            return true;
        }
        if (this.t || this.l == ObjectType.PAGE) {
            return false;
        }
        AccessToken token = AccessToken.a();
        if (token == null || token.d() == null || !token.d().contains("publish_actions")) {
            return false;
        }
        return true;
    }

    public void a(Activity activity, vi fragment, Bundle analyticsParameters) {
        boolean shouldLikeObject;
        boolean z = true;
        if (this.m) {
            shouldLikeObject = false;
        } else {
            shouldLikeObject = true;
        }
        if (n()) {
            b(shouldLikeObject);
            if (this.v) {
                l().a("fb_like_control_did_undo_quickly", null, analyticsParameters);
                return;
            } else if (!a(shouldLikeObject, analyticsParameters)) {
                if (shouldLikeObject) {
                    z = false;
                }
                b(z);
                b(activity, fragment, analyticsParameters);
                return;
            } else {
                return;
            }
        }
        b(activity, fragment, analyticsParameters);
    }

    private AppEventsLogger l() {
        if (this.x == null) {
            this.x = AppEventsLogger.a(ud.f());
        }
        return this.x;
    }

    private boolean a(boolean shouldLikeObject, Bundle analyticsParameters) {
        if (!n()) {
            return false;
        }
        if (shouldLikeObject) {
            c(analyticsParameters);
            return true;
        } else if (vw.a(this.r)) {
            return false;
        } else {
            d(analyticsParameters);
            return true;
        }
    }

    private void a(boolean oldLikeState) {
        b(oldLikeState);
        Bundle errorBundle = new Bundle();
        errorBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
        wk.c(this, "com.facebook.sdk.LikeActionController.DID_ERROR", errorBundle);
    }

    private void b(boolean isObjectLiked) {
        a(isObjectLiked, this.n, this.o, this.p, this.q, this.r);
    }

    private void a(boolean isObjectLiked, String likeCountStringWithLike, String likeCountStringWithoutLike, String socialSentenceWithLike, String socialSentenceWithoutLike, String unlikeToken) {
        Object likeCountStringWithLike2 = vw.a(likeCountStringWithLike, null);
        Object likeCountStringWithoutLike2 = vw.a(likeCountStringWithoutLike, null);
        Object socialSentenceWithLike2 = vw.a(socialSentenceWithLike, null);
        Object socialSentenceWithoutLike2 = vw.a(socialSentenceWithoutLike, null);
        Object unlikeToken2 = vw.a(unlikeToken, null);
        boolean stateChanged = (isObjectLiked == this.m && vw.a(likeCountStringWithLike2, this.n) && vw.a(likeCountStringWithoutLike2, this.o) && vw.a(socialSentenceWithLike2, this.p) && vw.a(socialSentenceWithoutLike2, this.q) && vw.a(unlikeToken2, this.r)) ? false : true;
        if (stateChanged) {
            this.m = isObjectLiked;
            this.n = likeCountStringWithLike2;
            this.o = likeCountStringWithoutLike2;
            this.p = socialSentenceWithLike2;
            this.q = socialSentenceWithoutLike2;
            this.r = unlikeToken2;
            wk.l(this);
            wk.d(this, "com.facebook.sdk.LikeActionController.UPDATED");
        }
    }

    private void b(Activity activity, vi fragmentWrapper, Bundle analyticsParameters) {
        String analyticsEvent = null;
        if (wl.e()) {
            analyticsEvent = "fb_like_control_did_present_dialog";
        } else if (wl.f()) {
            analyticsEvent = "fb_like_control_did_present_fallback_dialog";
        } else {
            a("present_dialog", analyticsParameters);
            vw.b(a, "Cannot show the Like Dialog on this device.");
            wk.d(null, "com.facebook.sdk.LikeActionController.UPDATED");
        }
        if (analyticsEvent != null) {
            String objectTypeString;
            if (this.l != null) {
                objectTypeString = this.l.toString();
            } else {
                objectTypeString = ObjectType.UNKNOWN.toString();
            }
            LikeContent likeContent = new a().a(this.k).b(objectTypeString).a();
            if (fragmentWrapper != null) {
                new wl(fragmentWrapper).b(likeContent);
            } else {
                new wl(activity).b(likeContent);
            }
            b(analyticsParameters);
            l().a("fb_like_control_did_present_dialog", null, analyticsParameters);
        }
    }

    private void b(int requestCode, int resultCode, Intent data) {
        wr.a(requestCode, resultCode, data, a(this.w));
        m();
    }

    private wp a(Bundle analyticsParameters) {
        return new wk$9(this, null, analyticsParameters);
    }

    private void b(Bundle analyticsParameters) {
        wk.e(this.k);
        this.w = analyticsParameters;
        wk.l(this);
    }

    private void m() {
        this.w = null;
        wk.e(null);
    }

    private static void e(String objectId) {
        g = objectId;
        ud.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", g).apply();
    }

    private boolean n() {
        AccessToken accessToken = AccessToken.a();
        return (this.t || this.s == null || accessToken == null || accessToken.d() == null || !accessToken.d().contains("publish_actions")) ? false : true;
    }

    private void c(Bundle analyticsParameters) {
        this.v = true;
        a(new wk$10(this, analyticsParameters));
    }

    private void d(Bundle analyticsParameters) {
        this.v = true;
        uf requestBatch = new uf();
        wk$l unlikeRequest = new wk$l(this, this.r);
        unlikeRequest.a(requestBatch);
        requestBatch.a(new wk$11(this, unlikeRequest, analyticsParameters));
        requestBatch.h();
    }

    private void o() {
        if (AccessToken.a() == null) {
            p();
        } else {
            a(new wk$12(this));
        }
    }

    private void p() {
        wm likeStatusClient = new wm(ud.f(), ud.i(), this.k);
        if (likeStatusClient.a()) {
            likeStatusClient.a(new wk$2(this));
        }
    }

    private void e(Bundle analyticsParameters) {
        if (this.m != this.u && !a(this.m, analyticsParameters)) {
            a(!this.m);
        }
    }

    private void a(wk$m completionHandler) {
        if (vw.a(this.s)) {
            wk$e objectIdRequest = new wk$e(this, this.k, this.l);
            wk$g pageIdRequest = new wk$g(this, this.k, this.l);
            uf requestBatch = new uf();
            objectIdRequest.a(requestBatch);
            pageIdRequest.a(requestBatch);
            requestBatch.a(new wk$3(this, objectIdRequest, pageIdRequest, completionHandler));
            requestBatch.h();
        } else if (completionHandler != null) {
            completionHandler.a();
        }
    }

    private void a(String action, Bundle parameters) {
        Bundle logParams = new Bundle(parameters);
        logParams.putString("object_id", this.k);
        logParams.putString("object_type", this.l.toString());
        logParams.putString("current_action", action);
        l().a("fb_like_control_error", null, logParams);
    }

    private void a(String action, FacebookRequestError error) {
        Bundle logParams = new Bundle();
        if (error != null) {
            JSONObject requestResult = error.f();
            if (requestResult != null) {
                logParams.putString("error", requestResult.toString());
            }
        }
        a(action, logParams);
    }
}
