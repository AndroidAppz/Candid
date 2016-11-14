/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
public final class agr {
    public static a<Long> A;
    public static a<Boolean> a;
    public static a<Boolean> b;
    public static a<String> c;
    public static a<Long> d;
    public static a<Long> e;
    public static a<Long> f;
    public static a<String> g;
    public static a<String> h;
    public static a<Integer> i;
    public static a<Integer> j;
    public static a<Integer> k;
    public static a<Integer> l;
    public static a<Integer> m;
    public static a<Integer> n;
    public static a<Integer> o;
    public static a<Integer> p;
    public static a<String> q;
    public static a<Long> r;
    public static a<Long> s;
    public static a<Long> t;
    public static a<Long> u;
    public static a<Long> v;
    public static a<Long> w;
    public static a<Integer> x;
    public static a<Long> y;
    public static a<Integer> z;

    static {
        a = a.a("measurement.service_enabled", true);
        b = a.a("measurement.service_client_enabled", true);
        c = a.a("measurement.log_tag", "FA", "FA-SVC");
        d = a.a("measurement.ad_id_cache_time", 10000);
        e = a.a("measurement.monitoring.sample_period_millis", 86400000);
        f = a.a("measurement.config.cache_time", 86400000, 3600000);
        g = a.a("measurement.config.url_scheme", "https");
        h = a.a("measurement.config.url_authority", "app-measurement.com");
        i = a.a("measurement.upload.max_bundles", 100);
        j = a.a("measurement.upload.max_batch_size", 65536);
        k = a.a("measurement.upload.max_bundle_size", 65536);
        l = a.a("measurement.upload.max_events_per_bundle", 1000);
        m = a.a("measurement.upload.max_events_per_day", 100000);
        n = a.a("measurement.upload.max_public_events_per_day", 50000);
        o = a.a("measurement.upload.max_conversions_per_day", 500);
        p = a.a("measurement.store.max_stored_events_per_app", 100000);
        q = a.a("measurement.upload.url", "https://app-measurement.com/a");
        r = a.a("measurement.upload.backoff_period", 43200000);
        s = a.a("measurement.upload.window_interval", 3600000);
        t = a.a("measurement.upload.interval", 3600000);
        u = a.a("measurement.upload.stale_data_deletion_interval", 86400000);
        v = a.a("measurement.upload.initial_upload_delay_time", 15000);
        w = a.a("measurement.upload.retry_time", 1800000);
        x = a.a("measurement.upload.retry_count", 6);
        y = a.a("measurement.upload.max_queue_time", 2419200000L);
        z = a.a("measurement.lifetimevalue.max_currency_tracked", 4);
        A = a.a("measurement.service_client.idle_disconnect_millis", 5000);
    }

    public static final class a<V> {
        private final V a;
        private final abj<V> b;
        private final String c;

        private a(String string2, abj<V> abj2, V v2) {
            xr.a(abj2);
            this.b = abj2;
            this.a = v2;
            this.c = string2;
        }

        static a<Integer> a(String string2, int n2) {
            return a.a(string2, n2, n2);
        }

        static a<Integer> a(String string2, int n2, int n3) {
            return new a<Integer>(string2, abj.a(string2, n3), n2);
        }

        static a<Long> a(String string2, long l2) {
            return a.a(string2, l2, l2);
        }

        static a<Long> a(String string2, long l2, long l3) {
            return new a<Long>(string2, abj.a(string2, l3), l2);
        }

        static a<String> a(String string2, String string3) {
            return a.a(string2, string3, string3);
        }

        static a<String> a(String string2, String string3, String string4) {
            return new a<String>(string2, abj.a(string2, string4), string3);
        }

        static a<Boolean> a(String string2, boolean bl2) {
            return a.a(string2, bl2, bl2);
        }

        static a<Boolean> a(String string2, boolean bl2, boolean bl3) {
            return new a<Boolean>(string2, abj.a(string2, bl3), bl2);
        }

        public V a(V v2) {
            if (v2 != null) {
                return v2;
            }
            return this.a;
        }

        public String a() {
            return this.c;
        }

        public V b() {
            return this.a;
        }
    }

}

