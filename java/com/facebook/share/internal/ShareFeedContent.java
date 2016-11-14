package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareContent;

public class ShareFeedContent extends ShareContent<ShareFeedContent, Object> {
    public static final Creator<ShareFeedContent> CREATOR = new Creator<ShareFeedContent>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public ShareFeedContent a(Parcel in) {
            return new ShareFeedContent(in);
        }

        public ShareFeedContent[] a(int size) {
            return new ShareFeedContent[size];
        }
    };
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;

    ShareFeedContent(Parcel in) {
        super(in);
        this.a = in.readString();
        this.b = in.readString();
        this.c = in.readString();
        this.d = in.readString();
        this.e = in.readString();
        this.f = in.readString();
        this.g = in.readString();
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeString(this.a);
        out.writeString(this.b);
        out.writeString(this.c);
        out.writeString(this.d);
        out.writeString(this.e);
        out.writeString(this.f);
        out.writeString(this.g);
    }
}
