package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareMedia.Type;

public final class ShareVideo extends ShareMedia {
    public static final Creator<ShareVideo> CREATOR = new Creator<ShareVideo>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public ShareVideo a(Parcel source) {
            return new ShareVideo(source);
        }

        public ShareVideo[] a(int size) {
            return new ShareVideo[size];
        }
    };
    private final Uri a;

    public static final class a extends com.facebook.share.model.ShareMedia.a<ShareVideo, a> {
        private Uri a;

        public a a(Uri localUrl) {
            this.a = localUrl;
            return this;
        }

        public ShareVideo a() {
            return new ShareVideo();
        }

        public a a(ShareVideo model) {
            return model == null ? this : ((a) super.a((ShareMedia) model)).a(model.c());
        }

        a b(Parcel parcel) {
            return a((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }
    }

    private ShareVideo(a builder) {
        super((com.facebook.share.model.ShareMedia.a) builder);
        this.a = builder.a;
    }

    ShareVideo(Parcel in) {
        super(in);
        this.a = (Uri) in.readParcelable(Uri.class.getClassLoader());
    }

    public Uri c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeParcelable(this.a, 0);
    }

    public Type b() {
        return Type.VIDEO;
    }
}
