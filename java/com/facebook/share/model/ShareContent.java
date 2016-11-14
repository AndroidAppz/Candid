package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ShareContent<P extends ShareContent, E extends a> implements ShareModel {
    private final Uri a;
    private final List<String> b;
    private final String c;
    private final String d;
    private final ShareHashtag e;

    public static abstract class a<P extends ShareContent, E extends a> {
        private Uri a;
        private List<String> b;
        private String c;
        private String d;
        private ShareHashtag e;

        public E a(Uri contentUrl) {
            this.a = contentUrl;
            return this;
        }
    }

    protected ShareContent(a builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    public ShareContent(Parcel in) {
        this.a = (Uri) in.readParcelable(Uri.class.getClassLoader());
        this.b = a(in);
        this.c = in.readString();
        this.d = in.readString();
        this.e = new com.facebook.share.model.ShareHashtag.a().a(in).a();
    }

    public Uri h() {
        return this.a;
    }

    public List<String> i() {
        return this.b;
    }

    public String j() {
        return this.c;
    }

    public String k() {
        return this.d;
    }

    public ShareHashtag l() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(this.a, 0);
        out.writeStringList(this.b);
        out.writeString(this.c);
        out.writeString(this.d);
        out.writeParcelable(this.e, 0);
    }

    private List<String> a(Parcel in) {
        List<String> list = new ArrayList();
        in.readStringList(list);
        return list.size() == 0 ? null : Collections.unmodifiableList(list);
    }
}
