package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ShareHashtag implements ShareModel {
    public static final Creator<ShareHashtag> CREATOR = new Creator<ShareHashtag>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public ShareHashtag a(Parcel in) {
            return new ShareHashtag(in);
        }

        public ShareHashtag[] a(int size) {
            return new ShareHashtag[size];
        }
    };
    private final String a;

    public static class a {
        private String a;

        public a a(String hashtag) {
            this.a = hashtag;
            return this;
        }

        public a a(ShareHashtag model) {
            return model == null ? this : a(model.a());
        }

        a a(Parcel parcel) {
            return a((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
        }

        public ShareHashtag a() {
            return new ShareHashtag();
        }
    }

    private ShareHashtag(a builder) {
        this.a = builder.a;
    }

    ShareHashtag(Parcel in) {
        this.a = in.readString();
    }

    public String a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.a);
    }
}
