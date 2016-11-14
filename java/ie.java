/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.AssetManager
 *  android.location.Location
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.io.BufferedInputStream
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.CookieHandler
 *  java.net.CookieManager
 *  java.net.CookiePolicy
 *  java.net.CookieStore
 *  java.security.KeyStore
 *  java.security.Principal
 *  java.security.SecureRandom
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateFactory
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.TimeUnit
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  retrofit2.CallAdapter
 *  retrofit2.CallAdapter$Factory
 *  retrofit2.Converter
 *  retrofit2.Converter$Factory
 *  retrofit2.Retrofit
 *  retrofit2.Retrofit$Builder
 *  retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
 *  retrofit2.converter.scalars.ScalarsConverterFactory
 *  retrofit2.http.Field
 *  retrofit2.http.FieldMap
 *  retrofit2.http.FormUrlEncoded
 *  retrofit2.http.Multipart
 *  retrofit2.http.POST
 *  retrofit2.http.Part
 *  retrofit2.http.PartMap
 *  rx.exceptions.CompositeException
 *  rx.schedulers.Schedulers
 */
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.location.Location;
import android.os.Build;
import android.util.Log;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.FacebookInfo;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.JavaNetCookieJar;
import com.becandid.candid.data.PersistentCookieStore;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import com.becandid.candid.models.GroupNameCheck;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.models.PostInfoResponse;
import com.facebook.AccessToken;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.security.KeyStore;
import java.security.Principal;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSink;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import rx.exceptions.CompositeException;
import rx.schedulers.Schedulers;

public class ie {
    public static CookieStore a;
    private static volatile ie b;
    private Retrofit c;
    private Retrofit d;
    private a e;

    public ie() {
        if (this.c == null) {
            this.m(GossipApplication.d);
        }
        this.e = (a)this.c.create((Class)a.class);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static ie a() {
        if (b != null) return b;
        reference var1 = ie.class;
        // MONITORENTER : ie.class
        if (b == null) {
            b = new ie();
        }
        // MONITOREXIT : var1
        return b;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private SSLSocketFactory i() {
        CertificateFactory certificateFactory;
        BufferedInputStream bufferedInputStream;
        try {
            certificateFactory = CertificateFactory.getInstance((String)"X.509");
            bufferedInputStream = new BufferedInputStream(GossipApplication.a().getAssets().open("AddTrustExternalCARoot.crt"));
        }
        catch (Exception exception) {
            rb.a((Throwable)exception);
            Log.d((String)"SSLSocketFactory", (String)exception.toString());
            return null;
        }
        Certificate certificate = certificateFactory.generateCertificate((InputStream)bufferedInputStream);
        Log.d((String)"CA", (String)((X509Certificate)certificate).getSubjectDN().toString());
        {
            catch (Throwable throwable) {
                bufferedInputStream.close();
                throw throwable;
            }
        }
        bufferedInputStream.close();
        KeyStore keyStore = KeyStore.getInstance((String)KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", certificate);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        SSLContext sSLContext = SSLContext.getInstance((String)"TLS");
        sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        return sSLContext.getSocketFactory();
    }

    private String j() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.becandid.candid/1.6.1 ");
        stringBuilder.append("androidver/" + Build.VERSION.RELEASE + " ");
        stringBuilder.append("model/" + Build.MODEL + " ");
        stringBuilder.append("ver_code/136 ");
        stringBuilder.append("make/" + Build.MANUFACTURER);
        return stringBuilder.toString();
    }

    private void m(String string2) {
        SSLSocketFactory sSLSocketFactory;
        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        String string3 = super.j();
        a = PersistentCookieStore.getCookieStore(GossipApplication.a().getApplicationContext());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if ((AppState.config == null || AppState.config.getBoolean("use_limited_ca", true)) && (sSLSocketFactory = super.i()) != null) {
            builder.sslSocketFactory(sSLSocketFactory);
        }
        builder.cookieJar(new JavaNetCookieJar((CookieHandler)new CookieManager(a, CookiePolicy.ACCEPT_ALL)));
        builder.addInterceptor((ie)this.new c(string3));
        builder.addInterceptor((ie)this.new d());
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);
        this.c = new Retrofit.Builder().baseUrl(string2).addCallAdapterFactory((CallAdapter.Factory)RxJavaCallAdapterFactory.create()).addConverterFactory((Converter.Factory)ik.a()).client(builder.build()).build();
    }

    public apd<EmptyClass> a(int n2) {
        return this.e.b(n2);
    }

    public apd<EmptyClass> a(int n2, int n3) {
        return this.e.a(n2, n3).a(new id("unable to like comment"));
    }

    public apd<NetworkData> a(int n2, String string2) {
        return this.e.d(Integer.toString((int)n2), string2).a(new id("fetch group feed failed"));
    }

    public apd<Group> a(int n2, String string2, String string3, String string4, String string5) {
        return this.e.a(n2, string2, string3, string4, string5).b(new apu<NetworkData, apd<Group>>(){

            public apd<Group> a(NetworkData networkData) {
                if (networkData != null) {
                    return apd.a(networkData.group);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("update group failed"));
    }

    public apd<NetworkData> a(FacebookInfo facebookInfo) {
        if (facebookInfo.fbToken == null || facebookInfo.fbToken.b() == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"fb_token", (Object)facebookInfo.fbToken.b());
        if (facebookInfo.schoolIds != null && facebookInfo.schoolIds.size() > 0) {
            hashMap.put((Object)"fb_school_ids", (Object)DataUtil.join(facebookInfo.schoolIds));
        }
        if (facebookInfo.jobIds != null && facebookInfo.jobIds.size() > 0) {
            hashMap.put((Object)"fb_job_ids", (Object)DataUtil.join(facebookInfo.jobIds));
        }
        if (facebookInfo.age != null) {
            hashMap.put((Object)"age", (Object)facebookInfo.age);
        }
        return this.e.f((Map<String, String>)hashMap).a(new id("auto join facebook failed"));
    }

    /*
     * Enabled aggressive block sorting
     */
    public apd<NetworkData> a(FacebookInfo facebookInfo, boolean bl2) {
        HashMap hashMap = new HashMap();
        if (bl2) {
            hashMap.put((Object)"for_you", (Object)"1");
        }
        if (facebookInfo != null && facebookInfo.fbToken != null) {
            hashMap.put((Object)"fb_token", (Object)facebookInfo.fbToken.b());
            if (facebookInfo.jobIds != null && !facebookInfo.jobIds.isEmpty()) {
                hashMap.put((Object)"fb_job_ids", (Object)DataUtil.join(facebookInfo.jobIds));
            }
            if (facebookInfo.schoolIds != null && !facebookInfo.schoolIds.isEmpty()) {
                hashMap.put((Object)"fb_school_ids", (Object)DataUtil.join(facebookInfo.schoolIds));
            }
        }
        if (AppState.location != null) {
            StringBuilder stringBuilder = new StringBuilder().append(AppState.location.getLatitude()).append(",").append(AppState.location.getLongitude()).append("@");
            String string2 = AppState.location.hasAccuracy() ? Float.valueOf((float)AppState.location.getAccuracy()) : "50";
            hashMap.put((Object)"location", (Object)stringBuilder.append((Object)string2).toString());
        }
        return this.e.e((Map<String, String>)hashMap).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("unable to get suggested groups"));
    }

    public apd<EmptyClass> a(Group group) {
        return this.e.d(group.group_id).b(new apu<NetworkData, apd<EmptyClass>>(){

            public apd<EmptyClass> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apd.a(new EmptyClass());
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("skip group failed"));
    }

    public apd<EmptyClass> a(Post post, String string2) {
        if (string2 == null) {
            string2 = "owner";
        }
        return this.e.c(Integer.toString((int)post.post_id), string2).a(new id("delete post failed"));
    }

    public apd<NetworkData> a(String string2, String string3) {
        return this.e.e(string2, string3).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null) {
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("unable to verify phone number"));
    }

    public apd<EmptyClass> a(String string2, String string3, String string4) {
        String string5 = "-7";
        if (string3 == null || !string3.equals((Object)"0")) {
            string5 = string3;
        }
        if (string2 == null) {
            return null;
        }
        return this.e.c(string2, string5, string4).a(new id("invite contacts failed"));
    }

    public apd<Group> a(String string2, String string3, String string4, String string5) {
        return this.e.a(string2, string3, string4, string5).b(new apu<NetworkData, apd<Group>>(){

            public apd<Group> a(NetworkData networkData) {
                if (networkData != null) {
                    return apd.a(networkData.group);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("create group failed"));
    }

    public apd<String> a(String string2, Map<String, String> map, RequestBody requestBody) {
        return this.b(string2).a(map, requestBody).b(new apu<String, apd<String>>(){

            public apd<String> a(String string2) {
                if (string2 != null) {
                    return apd.a(string2);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((String)object);
            }
        }).a(new id("error uploading image to s3"));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public apd<GroupNameCheck> a(String string2, boolean bl2) {
        int n2;
        a a2 = this.e;
        if (bl2) {
            n2 = 1;
            do {
                return a2.a(string2, n2).a(new id("check group name failed"));
                break;
            } while (true);
        }
        n2 = 0;
        return a2.a(string2, n2).a(new id("check group name failed"));
    }

    public apd<EmptyClass> a(Map<String, String> map) {
        return this.e.o(map).a(new id("update user info failed"));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public apd<NetworkData> a(boolean bl2) {
        int n2;
        a a2 = this.e;
        if (bl2) {
            n2 = 1;
            do {
                return a2.a(n2).a(new id("Unable to logout"));
                break;
            } while (true);
        }
        n2 = 0;
        return a2.a(n2).a(new id("Unable to logout"));
    }

    public void a(String string2) {
        super.m(string2);
        this.e = (a)this.c.create((Class)a.class);
    }

    public apd<NetworkData> b() {
        return this.e.a().b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    AppState.config.setExperimentConfig(networkData.config);
                    AppState.account = networkData.my_info;
                    AppState.tabsOrder = networkData.feed_tab_order;
                    if (AppState.account.unread_activity_count >= 0) {
                        iq.a().a(new ih.an(3, AppState.account.unread_activity_count));
                    }
                    if (AppState.account.unread_feed_count >= 0) {
                        iq.a().a(new ih.an(0, AppState.account.unread_feed_count));
                    }
                    if (AppState.account.unread_groups_count >= 0) {
                        iq.a().a(new ih.an(1, AppState.account.unread_groups_count));
                    }
                    if (networkData.groups != null) {
                        AppState.groups = new ArrayList(networkData.groups);
                    }
                    if (networkData.activity_settings != null) {
                        AppState.notificationSettings = new ArrayList(networkData.activity_settings);
                    }
                    if (networkData.feed_colors != null) {
                        AppState.feedColors = networkData.feed_colors;
                    }
                    if (networkData.group_tags != null) {
                        AppState.groupTags = networkData.group_tags;
                    }
                    AppState.needAge = networkData.my_info.need_age;
                    AppState.needOnboarding = networkData.my_info.need_onboarding;
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("unable to get your info"));
    }

    public apd<NetworkData> b(int n2) {
        return this.e.c(n2).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    if (AppState.groups == null) {
                        AppState.groups = new ArrayList();
                    }
                    AppState.groups.add((Object)networkData.group);
                    iq.a().a(new ih.m(networkData.group));
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("join group failed"));
    }

    public apd<NetworkData> b(int n2, String string2) {
        return this.e.a(n2, string2).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("unable to report comment"));
    }

    public apd<EmptyClass> b(Post post, String string2) {
        return this.e.a(Integer.toString((int)post.post_id), string2).a(new id("report post failed"));
    }

    public apd<NetworkData> b(String string2, String string3) {
        return this.e.b(string2, string3).a(new id("Get activity failed"));
    }

    public apd<Post> b(String string2, String string3, String string4) {
        return this.e.b(string2, string3, string4).b(new apu<NetworkData, apd<Post>>(){

            public apd<Post> a(NetworkData networkData) {
                if (networkData != null) {
                    return apd.a(networkData.post);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("like post failed"));
    }

    public apd<aif> b(Map<String, String> map) {
        return this.e.c(map).a(new id("new user hash failed"));
    }

    public b b(String string2) {
        if (this.d == null || !this.d.baseUrl().host().equals((Object)"s3.amazonaws.com")) {
            this.d = new Retrofit.Builder().baseUrl("https://" + "s3.amazonaws.com" + "/").addConverterFactory((Converter.Factory)ScalarsConverterFactory.create()).addCallAdapterFactory((CallAdapter.Factory)RxJavaCallAdapterFactory.create()).build();
        }
        return (b)this.d.create((Class)b.class);
    }

    public apd<aif> c() {
        return this.e.b().a(new id("unable to get splash page"));
    }

    public apd<NetworkData> c(int n2) {
        return this.e.e(n2).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("leave group failed"));
    }

    public apd<EmptyClass> c(String string2) {
        return this.e.a(string2, "android", "production").a(new id("send GCM Token failed"));
    }

    public apd<NetworkData.UploadResponse> c(String string2, String string3) {
        final File file = new File(string3);
        return this.e.f("image/jpg", "edit_account").b(new apu<NetworkData.UploadResponse, apd<NetworkData.UploadResponse>>(){

            public apd<NetworkData.UploadResponse> a(final NetworkData.UploadResponse uploadResponse) {
                if (uploadResponse != null && uploadResponse.success) {
                    RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
                    ie.this.a((String)uploadResponse.s3_data.get((Object)"bucket"), uploadResponse.s3_data, requestBody).b(Schedulers.io()).a(apn.a()).b(new apj<String>(){

                        public void a(String string2) {
                            iq.a().a(new ih.ag(uploadResponse, true, null));
                        }

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            rb.a(throwable);
                            if (throwable instanceof CompositeException) {
                                Iterator iterator = ((CompositeException)throwable).a().iterator();
                                while (iterator.hasNext()) {
                                    Log.d((String)"ERRS", (String)((Throwable)iterator.next()).toString());
                                }
                            }
                            iq.a().a(new ih.ag(uploadResponse, false, null));
                        }

                        @Override
                        public /* synthetic */ void onNext(Object object) {
                            this.a((String)object);
                        }
                    });
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData.UploadResponse)object);
            }

        });
    }

    public apd<List<Post>> c(String string2, String string3, String string4) {
        String string5 = string2;
        if (string2 == null) {
            string5 = "home";
        }
        HashMap hashMap = new HashMap();
        if ("friends".equals((Object)string2)) {
            hashMap.put((Object)"include_fb", (Object)"1");
            hashMap.put((Object)"include_phone", (Object)"1");
        }
        if (string4 != null && !string4.isEmpty()) {
            hashMap.put((Object)"seen_posts", (Object)string4);
        }
        hashMap.put((Object)"include_comments", (Object)"1");
        return this.e.a(string5, string3, (Map<String, String>)hashMap).b(new apu<NetworkData, apd<List<Post>>>(){

            public apd<List<Post>> a(NetworkData networkData) {
                if (networkData != null) {
                    return apd.a(networkData.posts);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("fetch feed failed"));
    }

    public apd<aif> c(Map<String, String> map) {
        return this.e.d(map).a(new id("sync friends failed"));
    }

    public apd<NetworkData> createPost(Post post, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"group_id", (Object)String.valueOf((int)post.group_id));
        if (post.caption != null) {
            hashMap.put((Object)"caption", (Object)post.caption);
        }
        if (post.mentioned_groups_info != null) {
            hashMap.put((Object)"mentioned_group_ids", (Object)post.mentioned_groups_info);
        }
        if (post.source_url != null) {
            hashMap.put((Object)"source_url", (Object)post.source_url);
            hashMap.put((Object)"width", (Object)String.valueOf((int)post.width));
            hashMap.put((Object)"height", (Object)String.valueOf((int)post.height));
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        if (hashMap.containsKey((Object)"source_url") && hashMap.get((Object)"source_url") == null) {
            hashMap.put((Object)"source_url", (Object)"");
        }
        if (post.friends_disabled == 1) {
            hashMap.put((Object)"friends_disabled", (Object)"1");
        }
        return this.e.a((Map<String, String>)hashMap).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null) {
                    if (networkData.group != null) {
                        AppState.groups.add((Object)networkData.group);
                        iq.a().a(new ih.m(networkData.group));
                    }
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("create post failed"));
    }

    public apd<NetworkData> d() {
        HashMap hashMap = new HashMap();
        if (AppState.fbInfo != null && AppState.fbInfo.fbToken != null) {
            hashMap.put((Object)"fb_uid", (Object)AppState.fbInfo.fbToken.i());
            hashMap.put((Object)"fb_token", (Object)AppState.fbInfo.fbToken.b());
        }
        return this.e.u((Map<String, String>)hashMap).a(new id("unable to check for an existing facebook account"));
    }

    public apd<NetworkData> d(int n2) {
        return this.e.f(n2).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    if (networkData.debug) {
                        AppState.internal = networkData.debug;
                    }
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("unable to get user profile"));
    }

    public apd<Map<String, String>> d(String string2) {
        return this.e.a(string2).b(new apu<PostInfoResponse, apd<Map<String, String>>>(){

            public apd<Map<String, String>> a(PostInfoResponse postInfoResponse) {
                if (postInfoResponse != null) {
                    return apd.a(postInfoResponse.data);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((PostInfoResponse)object);
            }
        }).a(new id("Unable to get post info"));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public apd<Post> d(Map<String, String> map) {
        Context context = GossipApplication.a().getApplicationContext();
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.getPackageInfo((String)context.getPackageName(), (int)0).versionCode <= 68) return this.e.b(map).b(new apu<NetworkData, apd<Post>>(){

                public apd<Post> a(NetworkData networkData) {
                    if (networkData != null) {
                        return apd.a(networkData.post);
                    }
                    return null;
                }

                @Override
                public /* synthetic */ Object call(Object object) {
                    return this.a((NetworkData)object);
                }
            }).a(new id("Get post comments failed"));
            map.put((Object)"threaded", (Object)Integer.toString((int)1));
        }
        catch (PackageManager.NameNotFoundException var4_4) {
            rb.a((Throwable)var4_4);
            return this.e.b(map).b(new ).a(new id("Get post comments failed"));
        }
        return this.e.b(map).b(new ).a(new id("Get post comments failed"));
    }

    public apd<NetworkData> e() {
        HashMap hashMap = new HashMap();
        if (AppState.fbInfo != null && AppState.fbInfo.fbToken != null) {
            hashMap.put((Object)"fb_uid", (Object)AppState.fbInfo.fbToken.i());
            hashMap.put((Object)"fb_token", (Object)AppState.fbInfo.fbToken.b());
        }
        if (AppState.contactsInfo != null && AppState.contactsInfo.phone_number != null) {
            hashMap.put((Object)"phone_number", (Object)AppState.contactsInfo.phone_number);
            hashMap.put((Object)"otp_code", (Object)AppState.contactsInfo.otpCode);
            if (AppState.contactsInfo.contacts != null && !AppState.contactsInfo.contacts.isEmpty()) {
                hashMap.put((Object)"phone_contacts", (Object)DataUtil.join(AppState.contactsInfo.contacts));
            }
        }
        if (AppState.referralId != null) {
            hashMap.put((Object)"referral_id", (Object)AppState.referralId);
        }
        return this.e.v((Map<String, String>)hashMap).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    if (networkData.my_info != null) {
                        AppState.account = networkData.my_info;
                        AppState.needAge = networkData.my_info.need_age;
                        AppState.age = networkData.my_info.age;
                    }
                    if (networkData.group_tags != null) {
                        AppState.groupTags = networkData.group_tags;
                    }
                    if (networkData.activity_settings != null) {
                        AppState.notificationSettings = new ArrayList(networkData.activity_settings);
                    }
                    if (networkData.config != null) {
                        AppState.setConfig(networkData.config);
                    }
                    if (networkData.referral_post_id != 0) {
                        AppState.referralPostId = networkData.referral_post_id;
                    }
                }
                return apd.a(networkData);
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("unable to get or create a user"));
    }

    public apd<EmptyClass> e(int n2) {
        return this.e.g(n2).a(new id("unable to invite friends to group"));
    }

    public apd<EmptyClass> e(String string2) {
        return this.e.b(string2);
    }

    public apd<EmptyClass> e(Map<String, String> map) {
        return this.e.g(map).b(new apu<NetworkData, apd<EmptyClass>>(){

            public apd<EmptyClass> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apd.a(new EmptyClass());
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("update activity settings failed"));
    }

    /*
     * Enabled aggressive block sorting
     */
    public apd<NetworkData> f() {
        HashMap hashMap = new HashMap();
        if (AppState.location != null) {
            StringBuilder stringBuilder = new StringBuilder().append(AppState.location.getLatitude()).append(",").append(AppState.location.getLongitude()).append("@");
            String string2 = AppState.location.hasAccuracy() ? Float.valueOf((float)AppState.location.getAccuracy()) : "50";
            hashMap.put((Object)"location", (Object)stringBuilder.append((Object)string2).toString());
        }
        if (AppState.fbInfo != null && AppState.fbInfo.age != null) {
            hashMap.put((Object)"age", (Object)AppState.fbInfo.age);
        } else if (AppState.age != null) {
            hashMap.put((Object)"age", (Object)AppState.age);
        }
        if (AppState.activeTags != null && !AppState.activeTags.isEmpty()) {
            hashMap.put((Object)"tags", (Object)DataUtil.join(AppState.activeTags));
        }
        if (AppState.fbInfo != null) {
            if (AppState.fbInfo.jobIds != null && !AppState.fbInfo.jobIds.isEmpty()) {
                hashMap.put((Object)"fb_job_ids", (Object)DataUtil.join(AppState.fbInfo.jobIds));
            }
            if (AppState.fbInfo.schoolIds != null && !AppState.fbInfo.schoolIds.isEmpty()) {
                hashMap.put((Object)"fb_school_ids", (Object)DataUtil.join(AppState.fbInfo.schoolIds));
            }
            if (AppState.fbInfo.friendIds != null && !AppState.fbInfo.friendIds.isEmpty()) {
                hashMap.put((Object)"fb_friends", (Object)DataUtil.join(AppState.fbInfo.friendIds));
            }
        }
        return this.e.w((Map<String, String>)hashMap).a(new id("unable to get groups for user signup"));
    }

    public apd<NetworkData> f(int n2) {
        return this.e.h(n2).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("unable to delete group"));
    }

    public apd<EmptyClass> f(String string2) {
        return this.e.c(string2);
    }

    public apd<NetworkData> f(Map<String, String> map) {
        return this.e.h(map).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("unable to delete comment"));
    }

    public apd<NetworkData> g() {
        return this.e.d().a(new id("unable to mark messages visit"));
    }

    public apd<NetworkData> g(int n2) {
        return this.e.i(n2).a(new id("unable to get history page"));
    }

    public apd<EmptyClass> g(String string2) {
        return this.e.d(string2).a(new id("unable to skip upsell"));
    }

    public apd<NetworkData> g(Map<String, String> map) {
        return this.e.i(map).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("unable to report comment"));
    }

    public apd<NetworkData> h() {
        return this.e.c().a(new id("unable to get unread message count"));
    }

    public apd<NetworkData> h(int n2) {
        return this.e.j(n2).a(new id("unable to get posts page"));
    }

    public apd<NetworkData> h(String string2) {
        return this.e.e(string2).a(new id("unable to generate otp code"));
    }

    public apd<NetworkData> h(Map<String, String> map) {
        return this.e.j(map).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id("unable to add comment"));
    }

    public apd<NetworkData> i(int n2) {
        return this.e.k(n2).a(new id("unable to get groups page"));
    }

    public apd<aif> i(String string2) {
        return this.e.f(string2).a(new id("unable to search for images"));
    }

    public apd<NetworkData> i(Map<String, String> map) {
        return this.e.k(map).b(new apu<NetworkData, apd<NetworkData>>(){

            public apd<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apd.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new id(""));
    }

    public apd<EmptyClass> j(String string2) {
        return this.e.g(string2).a(new id("unable to mark notification as clicked"));
    }

    public apd<aif> j(Map<String, String> map) {
        return this.e.l(map).a(new id("unable to get search results"));
    }

    public apd<EmptyClass> k(String string2) {
        return this.e.h(string2).a(new id("unable to set server message_sent seen"));
    }

    public apd<NetworkData> k(Map<String, String> map) {
        return this.e.m(map).a(new id("unable to edit post"));
    }

    public apd<NetworkData> l(String string2) {
        return this.e.i(string2).a(new id("unable to search user threads"));
    }

    public apd<NetworkData> l(Map<String, String> map) {
        return this.e.n(map).a(new id("unable to edit comment"));
    }

    public apd<NetworkData> m(Map<String, String> map) {
        return this.e.s(map).a(new id("unable to read message_sent thread"));
    }

    public apd<NetworkData> n(Map<String, String> map) {
        return this.e.q(map).a(new id("unable to add message_sent"));
    }

    public apd<NetworkData> o(Map<String, String> map) {
        return this.e.r(map).a(new id("unable to get threads and requests"));
    }

    public apd<NetworkData> p(Map<String, String> map) {
        return this.e.x(map).a(new id("unable to report message"));
    }

    public apd<NetworkData> q(Map<String, String> map) {
        return this.e.y(map).a(new id("unable to set message settings"));
    }

    public apd<NetworkData> r(Map<String, String> map) {
        return this.e.z(map).a(new id("unable to block user"));
    }

    public apd<NetworkData> s(Map<String, String> map) {
        return this.e.A(map).a(new id("unable to unblock user"));
    }

    public apd<NetworkData> t(Map<String, String> map) {
        return this.e.B(map).a(new id("unable to delete thread"));
    }

    public apd<NetworkData> u(Map<String, String> map) {
        return this.e.p(map).a(new id("unable to handle message request"));
    }

    public apd<NetworkData> v(Map<String, String> map) {
        return this.e.t(map).a(new id("unable to mark thread read"));
    }

    static interface a {
        @FormUrlEncoded
        @POST(value="api/unblock_thread")
        public apd<NetworkData> A(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/delete_thread")
        public apd<NetworkData> B(@FieldMap Map<String, String> var1);

        @POST(value="api/get_my_info")
        public apd<NetworkData> a();

        @FormUrlEncoded
        @POST(value="api/logout")
        public apd<NetworkData> a(@Field(value="forever") int var1);

        @FormUrlEncoded
        @POST(value="api/like_comment")
        public apd<EmptyClass> a(@Field(value="comment_id") int var1, @Field(value="value") int var2);

        @FormUrlEncoded
        @POST(value="api/report_group")
        public apd<NetworkData> a(@Field(value="group_id") int var1, @Field(value="reason") String var2);

        @FormUrlEncoded
        @POST(value="api/update_group")
        public apd<NetworkData> a(@Field(value="group_id") int var1, @Field(value="group_name") String var2, @Field(value="about") String var3, @Field(value="tags") String var4, @Field(value="source_url") String var5);

        @FormUrlEncoded
        @POST(value="api/get_post_info")
        public apd<PostInfoResponse> a(@Field(value="url") String var1);

        @FormUrlEncoded
        @POST(value="api/check_group_name")
        public apd<GroupNameCheck> a(@Field(value="group_name") String var1, @Field(value="will_use_duplicate") int var2);

        @FormUrlEncoded
        @POST(value="api/report_post")
        public apd<EmptyClass> a(@Field(value="post_id") String var1, @Field(value="reason") String var2);

        @FormUrlEncoded
        @POST(value="api/update_device_token")
        public apd<EmptyClass> a(@Field(value="device_token") String var1, @Field(value="platform_type") String var2, @Field(value="version_type") String var3);

        @FormUrlEncoded
        @POST(value="api/create_group")
        public apd<NetworkData> a(@Field(value="group_name") String var1, @Field(value="about") String var2, @Field(value="tags") String var3, @Field(value="source_url") String var4);

        @FormUrlEncoded
        @POST(value="api/feed")
        public apd<NetworkData> a(@Field(value="feed_type") String var1, @Field(value="min_post_id") String var2, @FieldMap Map<String, String> var3);

        @FormUrlEncoded
        @POST(value="api/add_post")
        public apd<NetworkData> a(@FieldMap Map<String, String> var1);

        @POST(value="api/splash_page")
        public apd<aif> b();

        @FormUrlEncoded
        @POST(value="api/mark_read_activity")
        public apd<EmptyClass> b(@Field(value="activity_id") int var1);

        @FormUrlEncoded
        @POST(value="api/mute_post")
        public apd<EmptyClass> b(@Field(value="post_id") String var1);

        @FormUrlEncoded
        @POST(value="api/get_activity")
        public apd<NetworkData> b(@Field(value="mark_read") String var1, @Field(value="last_activity_id") String var2);

        @FormUrlEncoded
        @POST(value="api/like_post")
        public apd<NetworkData> b(@Field(value="post_id") String var1, @Field(value="value") String var2, @Field(value="is_rumor") String var3);

        @FormUrlEncoded
        @POST(value="api/post_comments")
        public apd<NetworkData> b(@FieldMap Map<String, String> var1);

        @POST(value="api/get_threads_requests_count")
        public apd<NetworkData> c();

        @FormUrlEncoded
        @POST(value="api/join_group")
        public apd<NetworkData> c(@Field(value="group_id") int var1);

        @FormUrlEncoded
        @POST(value="api/unmute_post")
        public apd<EmptyClass> c(@Field(value="post_id") String var1);

        @FormUrlEncoded
        @POST(value="api/delete_post")
        public apd<EmptyClass> c(@Field(value="post_id") String var1, @Field(value="reason") String var2);

        @FormUrlEncoded
        @POST(value="api/invite_contacts")
        public apd<EmptyClass> c(@Field(value="contacts_json") String var1, @Field(value="upsell_id") String var2, @Field(value="name") String var3);

        @FormUrlEncoded
        @POST(value="api/new_user_hash")
        public apd<aif> c(@FieldMap Map<String, String> var1);

        @POST(value="api/mark_messages_visit")
        public apd<NetworkData> d();

        @FormUrlEncoded
        @POST(value="api/skip_group")
        public apd<NetworkData> d(@Field(value="group_id") int var1);

        @FormUrlEncoded
        @POST(value="api/skip_upsell")
        public apd<EmptyClass> d(@Field(value="upsell_id") String var1);

        @FormUrlEncoded
        @POST(value="api/group_feed")
        public apd<NetworkData> d(@Field(value="group_id") String var1, @Field(value="min_post_id") String var2);

        @FormUrlEncoded
        @POST(value="api/sync_friends")
        public apd<aif> d(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/leave_group")
        public apd<NetworkData> e(@Field(value="group_id") int var1);

        @FormUrlEncoded
        @POST(value="api/generate_otp")
        public apd<NetworkData> e(@Field(value="phone_number") String var1);

        @FormUrlEncoded
        @POST(value="api/verify_phone_number")
        public apd<NetworkData> e(@Field(value="otp_code") String var1, @Field(value="phone_number") String var2);

        @FormUrlEncoded
        @POST(value="api/suggested_groups")
        public apd<NetworkData> e(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/profile")
        public apd<NetworkData> f(@Field(value="user_id") int var1);

        @FormUrlEncoded
        @POST(value="api/search_images")
        public apd<aif> f(@Field(value="query") String var1);

        @FormUrlEncoded
        @POST(value="api/start_upload")
        public apd<NetworkData.UploadResponse> f(@Field(value="content_type") String var1, @Field(value="form_id") String var2);

        @FormUrlEncoded
        @POST(value="api/auto_join_fb_groups")
        public apd<NetworkData> f(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/invite_group_friends")
        public apd<EmptyClass> g(@Field(value="group_id") int var1);

        @FormUrlEncoded
        @POST(value="api/click_notification")
        public apd<EmptyClass> g(@Field(value="notification_id") String var1);

        @FormUrlEncoded
        @POST(value="api/update_activity_settings")
        public apd<NetworkData> g(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/delete_group")
        public apd<NetworkData> h(@Field(value="group_id") int var1);

        @FormUrlEncoded
        @POST(value="api/server_message_seen")
        public apd<EmptyClass> h(@Field(value="message_type") String var1);

        @FormUrlEncoded
        @POST(value="api/delete_comment")
        public apd<NetworkData> h(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/all_interacted_posts")
        public apd<NetworkData> i(@Field(value="page") int var1);

        @FormUrlEncoded
        @POST(value="api/search_user_threads")
        public apd<NetworkData> i(@Field(value="search_string") String var1);

        @FormUrlEncoded
        @POST(value="api/report_comment")
        public apd<NetworkData> i(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/my_posts_on_scroll")
        public apd<NetworkData> j(@Field(value="page") int var1);

        @FormUrlEncoded
        @POST(value="api/add_comment")
        public apd<NetworkData> j(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/my_groups_on_scroll")
        public apd<NetworkData> k(@Field(value="page") int var1);

        @FormUrlEncoded
        @POST(value="api/update_user_tags")
        public apd<NetworkData> k(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/search_groups")
        public apd<aif> l(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/edit_post")
        public apd<NetworkData> m(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/edit_comment")
        public apd<NetworkData> n(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/update_user_info")
        public apd<EmptyClass> o(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/handle_message_request")
        public apd<NetworkData> p(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/add_message")
        public apd<NetworkData> q(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/get_threads_and_requests")
        public apd<NetworkData> r(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/get_thread")
        public apd<NetworkData> s(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/read_thread")
        public apd<NetworkData> t(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/login_fb_user")
        public apd<NetworkData> u(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/signupprocess")
        public apd<NetworkData> v(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/get_location_tags_groups")
        public apd<NetworkData> w(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/report_message")
        public apd<NetworkData> x(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/set_message_settings")
        public apd<NetworkData> y(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/block_thread")
        public apd<NetworkData> z(@FieldMap Map<String, String> var1);
    }

    static interface b {
        @Multipart
        @POST(value="/likes.images")
        public apd<String> a(@PartMap Map<String, String> var1, @Part(value="File") RequestBody var2);
    }

    class c
    implements Interceptor {
        private final String b;

        public c(String string2) {
            this.b = string2;
        }

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().header("User-Agent", this.b).build());
        }
    }

    class d
    implements Interceptor {
        private it b;

        public d() {
            this.b = new it();
        }

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            Buffer buffer = new Buffer();
            request.body().writeTo(buffer);
            byte[] arrby = this.b.a(buffer.buffer().readUtf8());
            buffer.close();
            RequestBody requestBody = RequestBody.create(request.body().contentType(), arrby);
            Response response = chain.proceed(request.newBuilder().header("Candid-Encoded", "1").method(request.method(), requestBody).build());
            byte[] arrby2 = this.b.b(response.body().string());
            ResponseBody responseBody = ResponseBody.create(response.body().contentType(), arrby2);
            return response.newBuilder().body(responseBody).build();
        }
    }

}

