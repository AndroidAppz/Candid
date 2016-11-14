package com.facebook.appevents;

import com.facebook.AccessToken;
import defpackage.ud;
import defpackage.vw;
import java.io.Serializable;

public class AccessTokenAppIdPair implements Serializable {
    private final String a;
    private final String b;

    public static class SerializationProxyV1 implements Serializable {
        private final String a;
        private final String b;

        private SerializationProxyV1(String accessTokenString, String appId) {
            this.a = accessTokenString;
            this.b = appId;
        }

        private Object readResolve() {
            return new AccessTokenAppIdPair(this.a, this.b);
        }
    }

    public AccessTokenAppIdPair(AccessToken accessToken) {
        this(accessToken.b(), ud.i());
    }

    public AccessTokenAppIdPair(String accessTokenString, String applicationId) {
        if (vw.a(accessTokenString)) {
            accessTokenString = null;
        }
        this.a = accessTokenString;
        this.b = applicationId;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.a == null ? 0 : this.a.hashCode();
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return hashCode ^ i;
    }

    public boolean equals(Object o) {
        if (!(o instanceof AccessTokenAppIdPair)) {
            return false;
        }
        AccessTokenAppIdPair p = (AccessTokenAppIdPair) o;
        if (vw.a(p.a, this.a) && vw.a(p.b, this.b)) {
            return true;
        }
        return false;
    }

    private Object writeReplace() {
        return new SerializationProxyV1(this.a, this.b);
    }
}
