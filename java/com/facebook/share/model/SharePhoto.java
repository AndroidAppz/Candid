package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareMedia.Type;
import java.util.ArrayList;
import java.util.List;

public final class SharePhoto extends ShareMedia {
    public static final Creator<SharePhoto> CREATOR = new Creator<SharePhoto>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public SharePhoto a(Parcel source) {
            return new SharePhoto(source);
        }

        public SharePhoto[] a(int size) {
            return new SharePhoto[size];
        }
    };
    private final Bitmap a;
    private final Uri b;
    private final boolean c;
    private final String d;

    public static final class a extends com.facebook.share.model.ShareMedia.a<SharePhoto, a> {
        private Bitmap a;
        private Uri b;
        private boolean c;
        private String d;

        public a a(Bitmap bitmap) {
            this.a = bitmap;
            return this;
        }

        public a a(Uri imageUrl) {
            this.b = imageUrl;
            return this;
        }

        public a a(boolean userGenerated) {
            this.c = userGenerated;
            return this;
        }

        public a a(String caption) {
            this.d = caption;
            return this;
        }

        Uri a() {
            return this.b;
        }

        Bitmap b() {
            return this.a;
        }

        public SharePhoto c() {
            return new SharePhoto();
        }

        public a a(SharePhoto model) {
            return model == null ? this : ((a) super.a((ShareMedia) model)).a(model.c()).a(model.d()).a(model.e()).a(model.f());
        }

        a b(Parcel parcel) {
            return a((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        static void a(Parcel out, int parcelFlags, List<SharePhoto> photos) {
            ShareMedia[] array = new ShareMedia[photos.size()];
            for (int i = 0; i < photos.size(); i++) {
                array[i] = (ShareMedia) photos.get(i);
            }
            out.writeParcelableArray(array, parcelFlags);
        }

        static List<SharePhoto> c(Parcel in) {
            List<ShareMedia> media = com.facebook.share.model.ShareMedia.a.a(in);
            List<SharePhoto> photos = new ArrayList();
            for (ShareMedia medium : media) {
                if (medium instanceof SharePhoto) {
                    photos.add((SharePhoto) medium);
                }
            }
            return photos;
        }
    }

    private SharePhoto(a builder) {
        super((com.facebook.share.model.ShareMedia.a) builder);
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
    }

    SharePhoto(Parcel in) {
        super(in);
        this.a = (Bitmap) in.readParcelable(Bitmap.class.getClassLoader());
        this.b = (Uri) in.readParcelable(Uri.class.getClassLoader());
        this.c = in.readByte() != (byte) 0;
        this.d = in.readString();
    }

    public Bitmap c() {
        return this.a;
    }

    public Uri d() {
        return this.b;
    }

    public boolean e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        int i = 0;
        super.writeToParcel(out, flags);
        out.writeParcelable(this.a, 0);
        out.writeParcelable(this.b, 0);
        if (this.c) {
            i = 1;
        }
        out.writeByte((byte) i);
        out.writeString(this.d);
    }

    public Type b() {
        return Type.PHOTO;
    }
}
