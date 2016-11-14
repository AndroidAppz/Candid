package defpackage;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.FacebookInfo;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.JavaNetCookieJar;
import com.becandid.candid.data.PersistentCookieStore;
import com.becandid.candid.data.Post;
import com.becandid.candid.models.GroupNameCheck;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.models.NetworkData.UploadResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import okhttp3.OkHttpClient.Builder;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* compiled from: ApiService */
public class ie {
    public static CookieStore a;
    private static volatile ie b;
    private Retrofit c;
    private Retrofit d;
    private ie$a e;

    public static ie a() {
        if (b == null) {
            synchronized (ie.class) {
                if (b == null) {
                    b = new ie();
                }
            }
        }
        return b;
    }

    public ie() {
        if (this.c == null) {
            m(GossipApplication.d);
        }
        this.e = (ie$a) this.c.create(ie$a.class);
    }

    public void a(String baseUrl) {
        m(baseUrl);
        this.e = (ie$a) this.c.create(ie$a.class);
    }

    private void m(String baseUrl) {
        new HttpLoggingInterceptor().setLevel(Level.BODY);
        String userAgent = j();
        a = PersistentCookieStore.getCookieStore(GossipApplication.a().getApplicationContext());
        Builder builder = new Builder();
        if (AppState.config == null || AppState.config.getBoolean("use_limited_ca", true)) {
            SSLSocketFactory socketFactory = i();
            if (socketFactory != null) {
                builder.sslSocketFactory(socketFactory);
            }
        }
        builder.cookieJar(new JavaNetCookieJar(new CookieManager(a, CookiePolicy.ACCEPT_ALL)));
        builder.addInterceptor(new ie$c(this, userAgent));
        builder.addInterceptor(new ie$d(this));
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);
        this.c = new Retrofit.Builder().baseUrl(baseUrl).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(ik.a()).client(builder.build()).build();
    }

    private SSLSocketFactory i() {
        InputStream caInput;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            caInput = new BufferedInputStream(GossipApplication.a().getAssets().open("AddTrustExternalCARoot.crt"));
            Certificate ca = cf.generateCertificate(caInput);
            Log.d("CA", ((X509Certificate) ca).getSubjectDN().toString());
            caInput.close();
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, tmf.getTrustManagers(), null);
            return context.getSocketFactory();
        } catch (Exception e) {
            rb.a(e);
            Log.d("SSLSocketFactory", e.toString());
            return null;
        } catch (Throwable th) {
            caInput.close();
        }
    }

    private String j() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.becandid.candid/1.6.1 ");
        stringBuilder.append("androidver/" + VERSION.RELEASE + " ");
        stringBuilder.append("model/" + Build.MODEL + " ");
        stringBuilder.append("ver_code/136 ");
        stringBuilder.append("make/" + Build.MANUFACTURER);
        return stringBuilder.toString();
    }

    public ie$b b(String domain) {
        String host = "s3.amazonaws.com";
        if (this.d == null || !this.d.baseUrl().host().equals(host)) {
            this.d = new Retrofit.Builder().baseUrl("https://" + host + "/").addConverterFactory(ScalarsConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        }
        return (ie$b) this.d.create(ie$b.class);
    }

    public apd<EmptyClass> a(Map<String, String> params) {
        return this.e.o(params).a(new id("update user info failed"));
    }

    public apd<aif> b(Map<String, String> params) {
        return this.e.c((Map) params).a(new id("new user hash failed"));
    }

    public apd<aif> c(Map<String, String> params) {
        return this.e.d((Map) params).a(new id("sync friends failed"));
    }

    public apd<NetworkData> a(FacebookInfo fbInfo) {
        if (fbInfo.fbToken == null || fbInfo.fbToken.b() == null) {
            return null;
        }
        Map<String, String> fbJoinParams = new HashMap();
        fbJoinParams.put("fb_token", fbInfo.fbToken.b());
        if (fbInfo.schoolIds != null && fbInfo.schoolIds.size() > 0) {
            fbJoinParams.put("fb_school_ids", DataUtil.join(fbInfo.schoolIds));
        }
        if (fbInfo.jobIds != null && fbInfo.jobIds.size() > 0) {
            fbJoinParams.put("fb_job_ids", DataUtil.join(fbInfo.jobIds));
        }
        if (fbInfo.age != null) {
            fbJoinParams.put("age", fbInfo.age);
        }
        return this.e.f((Map) fbJoinParams).a(new id("auto join facebook failed"));
    }

    public apd<NetworkData> a(int groupId, String minPostId) {
        return this.e.d(Integer.toString(groupId), minPostId).a(new id("fetch group feed failed"));
    }

    public apd<EmptyClass> a(String data, String upId, String name) {
        String upsellId = "-7";
        if (upId == null || !upId.equals("0")) {
            upsellId = upId;
        }
        if (data == null) {
            return null;
        }
        return this.e.c(data, upsellId, name).a(new id("invite contacts failed"));
    }

    public apd<NetworkData> a(String otpCode, String phoneNumber) {
        return this.e.e(otpCode, phoneNumber).b(new ie$1(this)).a(new id("unable to verify phone number"));
    }

    public apd<EmptyClass> a(Post post, String reason) {
        if (reason == null) {
            reason = "owner";
        }
        return this.e.c(Integer.toString(post.post_id), reason).a(new id("delete post failed"));
    }

    public apd<EmptyClass> b(Post post, String reason) {
        return this.e.a(Integer.toString(post.post_id), reason).a(new id("report post failed"));
    }

    public apd<Post> b(String postId, String value, String isRumor) {
        return this.e.b(postId, value, isRumor).b(new ie$12(this)).a(new id("like post failed"));
    }

    public apd<List<Post>> c(String feedType, String minPostId, String impressionLog) {
        String type = feedType;
        if (feedType == null) {
            type = "home";
        }
        Map<String, String> params = new HashMap();
        if ("friends".equals(feedType)) {
            params.put("include_fb", "1");
            params.put("include_phone", "1");
        }
        if (!(impressionLog == null || impressionLog.isEmpty())) {
            params.put("seen_posts", impressionLog);
        }
        params.put("include_comments", "1");
        return this.e.a(type, minPostId, (Map) params).b(new ie$18(this)).a(new id("fetch feed failed"));
    }

    public apd<GroupNameCheck> a(String groupName, boolean forCreatePost) {
        return this.e.a(groupName, forCreatePost ? 1 : 0).a(new id("check group name failed"));
    }

    public apd<EmptyClass> c(String token) {
        return this.e.a(token, "android", "production").a(new id("send GCM Token failed"));
    }

    public apd<Group> a(String groupName, String about, String tags, String sourceUrl) {
        return this.e.a(groupName, about, tags, sourceUrl).b(new ie$19(this)).a(new id("create group failed"));
    }

    public apd<NetworkData> createPost(Post post, Map<String, String> linkParams) {
        HashMap<String, String> params = new HashMap();
        params.put("group_id", String.valueOf(post.group_id));
        if (post.caption != null) {
            params.put("caption", post.caption);
        }
        if (post.mentioned_groups_info != null) {
            params.put("mentioned_group_ids", post.mentioned_groups_info);
        }
        if (post.source_url != null) {
            params.put("source_url", post.source_url);
            params.put("width", String.valueOf(post.width));
            params.put("height", String.valueOf(post.height));
        }
        if (linkParams != null) {
            params.putAll(linkParams);
        }
        if (params.containsKey("source_url") && params.get("source_url") == null) {
            params.put("source_url", "");
        }
        if (post.friends_disabled == 1) {
            params.put("friends_disabled", "1");
        }
        return this.e.a((Map) params).b(new ie$20(this)).a(new id("create post failed"));
    }

    public apd<Map<String, String>> d(String url) {
        return this.e.a(url).b(new ie$21(this)).a(new id("Unable to get post info"));
    }

    public apd<Post> d(Map<String, String> params) {
        Context context = GossipApplication.a().getApplicationContext();
        try {
            if (context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode > 68) {
                params.put("threaded", Integer.toString(1));
            }
        } catch (NameNotFoundException e) {
            rb.a(e);
        }
        return this.e.b((Map) params).b(new ie$22(this)).a(new id("Get post comments failed"));
    }

    public apd<NetworkData> b(String markRead, String lastActivityId) {
        return this.e.b(markRead, lastActivityId).a(new id("Get activity failed"));
    }

    public apd<NetworkData> a(boolean forever) {
        return this.e.a(forever ? 1 : 0).a(new id("Unable to logout"));
    }

    public apd<EmptyClass> e(String postId) {
        return this.e.b(postId);
    }

    public apd<EmptyClass> f(String postId) {
        return this.e.c(postId);
    }

    public apd<Group> a(int groupId, String groupName, String about, String tags, String sourceUrl) {
        return this.e.a(groupId, groupName, about, tags, sourceUrl).b(new ie$23(this)).a(new id("update group failed"));
    }

    public apd<EmptyClass> a(int activityId) {
        return this.e.b(activityId);
    }

    public apd<NetworkData> b(int groupId) {
        return this.e.c(groupId).b(new ie$24(this)).a(new id("join group failed"));
    }

    public apd<EmptyClass> a(Group group) {
        return this.e.d(group.group_id).b(new ie$2(this)).a(new id("skip group failed"));
    }

    public apd<NetworkData> c(int group_id) {
        return this.e.e(group_id).b(new ie$3(this)).a(new id("leave group failed"));
    }

    public apd<EmptyClass> e(Map<String, String> params) {
        return this.e.g((Map) params).b(new ie$4(this)).a(new id("update activity settings failed"));
    }

    public apd<NetworkData> d(int userId) {
        return this.e.f(userId).b(new ie$5(this)).a(new id("unable to get user profile"));
    }

    public apd<NetworkData> b() {
        return this.e.a().b(new ie$6(this)).a(new id("unable to get your info"));
    }

    public apd<String> a(String domain, Map<String, String> s3_data, RequestBody fileBody) {
        return b(domain).a(s3_data, fileBody).b(new ie$7(this)).a(new id("error uploading image to s3"));
    }

    public apd<UploadResponse> c(String uri, String filepath) {
        String mimeType = "image/jpg";
        return this.e.f("image/jpg", "edit_account").b(new ie$8(this, new File(filepath)));
    }

    public apd<NetworkData> a(FacebookInfo fbInfo, boolean forYou) {
        HashMap<String, String> params = new HashMap();
        if (forYou) {
            params.put("for_you", "1");
        }
        if (!(fbInfo == null || fbInfo.fbToken == null)) {
            params.put("fb_token", fbInfo.fbToken.b());
            if (!(fbInfo.jobIds == null || fbInfo.jobIds.isEmpty())) {
                params.put("fb_job_ids", DataUtil.join(fbInfo.jobIds));
            }
            if (!(fbInfo.schoolIds == null || fbInfo.schoolIds.isEmpty())) {
                params.put("fb_school_ids", DataUtil.join(fbInfo.schoolIds));
            }
        }
        if (AppState.location != null) {
            params.put("location", AppState.location.getLatitude() + "," + AppState.location.getLongitude() + "@" + (AppState.location.hasAccuracy() ? Float.valueOf(AppState.location.getAccuracy()) : "50"));
        }
        return this.e.e((Map) params).b(new ie$9(this)).a(new id("unable to get suggested groups"));
    }

    public apd<NetworkData> f(Map<String, String> params) {
        return this.e.h((Map) params).b(new ie$10(this)).a(new id("unable to delete comment"));
    }

    public apd<NetworkData> g(Map<String, String> params) {
        return this.e.i((Map) params).b(new ie$11(this)).a(new id("unable to report comment"));
    }

    public apd<NetworkData> h(Map<String, String> params) {
        return this.e.j((Map) params).b(new ie$13(this)).a(new id("unable to add comment"));
    }

    public apd<EmptyClass> g(String upsellId) {
        return this.e.d(upsellId).a(new id("unable to skip upsell"));
    }

    public apd<NetworkData> i(Map<String, String> params) {
        return this.e.k((Map) params).b(new ie$14(this)).a(new id(""));
    }

    public apd<NetworkData> h(String phoneNumber) {
        return this.e.e(phoneNumber).a(new id("unable to generate otp code"));
    }

    public apd<EmptyClass> e(int groupId) {
        return this.e.g(groupId).a(new id("unable to invite friends to group"));
    }

    public apd<aif> j(Map<String, String> params) {
        return this.e.l(params).a(new id("unable to get search results"));
    }

    public apd<NetworkData> b(int groupId, String reason) {
        return this.e.a(groupId, reason).b(new ie$15(this)).a(new id("unable to report comment"));
    }

    public apd<NetworkData> f(int groupId) {
        return this.e.h(groupId).b(new ie$16(this)).a(new id("unable to delete group"));
    }

    public apd<EmptyClass> a(int commentId, int value) {
        return this.e.a(commentId, value).a(new id("unable to like comment"));
    }

    public apd<NetworkData> k(Map<String, String> params) {
        return this.e.m(params).a(new id("unable to edit post"));
    }

    public apd<NetworkData> l(Map<String, String> params) {
        return this.e.n(params).a(new id("unable to edit comment"));
    }

    public apd<aif> i(String query) {
        return this.e.f(query).a(new id("unable to search for images"));
    }

    public apd<aif> c() {
        return this.e.b().a(new id("unable to get splash page"));
    }

    public apd<NetworkData> g(int page) {
        return this.e.i(page).a(new id("unable to get history page"));
    }

    public apd<NetworkData> h(int page) {
        return this.e.j(page).a(new id("unable to get posts page"));
    }

    public apd<NetworkData> i(int page) {
        return this.e.k(page).a(new id("unable to get groups page"));
    }

    public apd<EmptyClass> j(String notificationId) {
        return this.e.g(notificationId).a(new id("unable to mark notification as clicked"));
    }

    public apd<NetworkData> d() {
        HashMap<String, String> params = new HashMap();
        if (!(AppState.fbInfo == null || AppState.fbInfo.fbToken == null)) {
            params.put("fb_uid", AppState.fbInfo.fbToken.i());
            params.put("fb_token", AppState.fbInfo.fbToken.b());
        }
        return this.e.u(params).a(new id("unable to check for an existing facebook account"));
    }

    public apd<NetworkData> e() {
        HashMap<String, String> params = new HashMap();
        if (!(AppState.fbInfo == null || AppState.fbInfo.fbToken == null)) {
            params.put("fb_uid", AppState.fbInfo.fbToken.i());
            params.put("fb_token", AppState.fbInfo.fbToken.b());
        }
        if (!(AppState.contactsInfo == null || AppState.contactsInfo.phone_number == null)) {
            params.put("phone_number", AppState.contactsInfo.phone_number);
            params.put("otp_code", AppState.contactsInfo.otpCode);
            if (!(AppState.contactsInfo.contacts == null || AppState.contactsInfo.contacts.isEmpty())) {
                params.put("phone_contacts", DataUtil.join(AppState.contactsInfo.contacts));
            }
        }
        if (AppState.referralId != null) {
            params.put("referral_id", AppState.referralId);
        }
        return this.e.v(params).b(new ie$17(this)).a(new id("unable to get or create a user"));
    }

    public apd<NetworkData> f() {
        HashMap<String, String> params = new HashMap();
        if (AppState.location != null) {
            params.put("location", AppState.location.getLatitude() + "," + AppState.location.getLongitude() + "@" + (AppState.location.hasAccuracy() ? Float.valueOf(AppState.location.getAccuracy()) : "50"));
        }
        if (AppState.fbInfo != null && AppState.fbInfo.age != null) {
            params.put("age", AppState.fbInfo.age);
        } else if (AppState.age != null) {
            params.put("age", AppState.age);
        }
        if (!(AppState.activeTags == null || AppState.activeTags.isEmpty())) {
            params.put("tags", DataUtil.join(AppState.activeTags));
        }
        if (AppState.fbInfo != null) {
            if (!(AppState.fbInfo.jobIds == null || AppState.fbInfo.jobIds.isEmpty())) {
                params.put("fb_job_ids", DataUtil.join(AppState.fbInfo.jobIds));
            }
            if (!(AppState.fbInfo.schoolIds == null || AppState.fbInfo.schoolIds.isEmpty())) {
                params.put("fb_school_ids", DataUtil.join(AppState.fbInfo.schoolIds));
            }
            if (!(AppState.fbInfo.friendIds == null || AppState.fbInfo.friendIds.isEmpty())) {
                params.put("fb_friends", DataUtil.join(AppState.fbInfo.friendIds));
            }
        }
        return this.e.w(params).a(new id("unable to get groups for user signup"));
    }

    public apd<EmptyClass> k(String messageType) {
        return this.e.h(messageType).a(new id("unable to set server message_sent seen"));
    }

    public apd<NetworkData> m(Map<String, String> params) {
        return this.e.s(params).a(new id("unable to read message_sent thread"));
    }

    public apd<NetworkData> n(Map<String, String> params) {
        return this.e.q(params).a(new id("unable to add message_sent"));
    }

    public apd<NetworkData> o(Map<String, String> params) {
        return this.e.r(params).a(new id("unable to get threads and requests"));
    }

    public apd<NetworkData> p(Map<String, String> params) {
        return this.e.x(params).a(new id("unable to report message"));
    }

    public apd<NetworkData> q(Map<String, String> params) {
        return this.e.y(params).a(new id("unable to set message settings"));
    }

    public apd<NetworkData> r(Map<String, String> params) {
        return this.e.z(params).a(new id("unable to block user"));
    }

    public apd<NetworkData> s(Map<String, String> params) {
        return this.e.A(params).a(new id("unable to unblock user"));
    }

    public apd<NetworkData> t(Map<String, String> params) {
        return this.e.B(params).a(new id("unable to delete thread"));
    }

    public apd<NetworkData> l(String searchString) {
        return this.e.i(searchString).a(new id("unable to search user threads"));
    }

    public apd<NetworkData> u(Map<String, String> params) {
        return this.e.p(params).a(new id("unable to handle message request"));
    }

    public apd<NetworkData> v(Map<String, String> params) {
        return this.e.t(params).a(new id("unable to mark thread read"));
    }

    public apd<NetworkData> g() {
        return this.e.d().a(new id("unable to mark messages visit"));
    }

    public apd<NetworkData> h() {
        return this.e.c().a(new id("unable to get unread message count"));
    }
}
