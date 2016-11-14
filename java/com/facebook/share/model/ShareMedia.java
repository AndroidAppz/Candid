package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public abstract class ShareMedia implements ShareModel {
    private final Bundle a;

    public enum Type {
        PHOTO,
        VIDEO
    }

    public static abstract class a<M extends ShareMedia, B extends a> {
        private Bundle a = new Bundle();

        @Deprecated
        public B a(Bundle parameters) {
            this.a.putAll(parameters);
            return this;
        }

        public B a(M model) {
            return model == null ? this : a(model.a());
        }

        static List<ShareMedia> a(Parcel in) {
            Parcelable[] parcelables = in.readParcelableArray(ShareMedia.class.getClassLoader());
            List<ShareMedia> shareMedia = new ArrayList(parcelables.length);
            for (Parcelable parcelable : parcelables) {
                shareMedia.add((ShareMedia) parcelable);
            }
            return shareMedia;
        }
    }

    public abstract Type b();

    protected ShareMedia(a builder) {
        this.a = new Bundle(builder.a);
    }

    ShareMedia(Parcel in) {
        this.a = in.readBundle();
    }

    @Deprecated
    public Bundle a() {
        return new Bundle(this.a);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBundle(this.a);
    }
}
