package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareLinkContent extends ShareContent<ShareLinkContent, a> {
    public static final Creator<ShareLinkContent> CREATOR = new Creator<ShareLinkContent>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public ShareLinkContent a(Parcel in) {
            return new ShareLinkContent(in);
        }

        public ShareLinkContent[] a(int size) {
            return new ShareLinkContent[size];
        }
    };
    private final String a;
    private final String b;
    private final Uri c;
    private final String d;

    public static final class a extends com.facebook.share.model.ShareContent.a<ShareLinkContent, a> {
        private String a;
        private String b;
        private Uri c;
        private String d;

        public ShareLinkContent a() {
            return new ShareLinkContent();
        }
    }

    private ShareLinkContent(a builder) {
        super((com.facebook.share.model.ShareContent.a) builder);
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
    }

    ShareLinkContent(Parcel in) {
        super(in);
        this.a = in.readString();
        this.b = in.readString();
        this.c = (Uri) in.readParcelable(Uri.class.getClassLoader());
        this.d = in.readString();
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public Uri c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeString(this.a);
        out.writeString(this.b);
        out.writeParcelable(this.c, 0);
        out.writeString(this.d);
    }
}
