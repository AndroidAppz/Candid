package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareModel;

public class LikeContent implements ShareModel {
    public static final Creator<LikeContent> CREATOR = new Creator<LikeContent>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public LikeContent a(Parcel in) {
            return new LikeContent(in);
        }

        public LikeContent[] a(int size) {
            return new LikeContent[size];
        }
    };
    private final String a;
    private final String b;

    public static class a {
        private String a;
        private String b;

        public a a(String objectId) {
            this.a = objectId;
            return this;
        }

        public a b(String objectType) {
            this.b = objectType;
            return this;
        }

        public LikeContent a() {
            return new LikeContent();
        }
    }

    private LikeContent(a builder) {
        this.a = builder.a;
        this.b = builder.b;
    }

    LikeContent(Parcel in) {
        this.a = in.readString();
        this.b = in.readString();
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.a);
        out.writeString(this.b);
    }
}
