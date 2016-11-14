package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SharePhotoContent extends ShareContent<SharePhotoContent, a> {
    public static final Creator<SharePhotoContent> CREATOR = new Creator<SharePhotoContent>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public SharePhotoContent a(Parcel in) {
            return new SharePhotoContent(in);
        }

        public SharePhotoContent[] a(int size) {
            return new SharePhotoContent[size];
        }
    };
    private final List<SharePhoto> a;

    public static class a extends com.facebook.share.model.ShareContent.a<SharePhotoContent, a> {
        private final List<SharePhoto> a = new ArrayList();

        public a a(SharePhoto photo) {
            if (photo != null) {
                this.a.add(new com.facebook.share.model.SharePhoto.a().a(photo).c());
            }
            return this;
        }

        public SharePhotoContent a() {
            return new SharePhotoContent();
        }
    }

    private SharePhotoContent(a builder) {
        super((com.facebook.share.model.ShareContent.a) builder);
        this.a = Collections.unmodifiableList(builder.a);
    }

    SharePhotoContent(Parcel in) {
        super(in);
        this.a = Collections.unmodifiableList(com.facebook.share.model.SharePhoto.a.c(in));
    }

    public List<SharePhoto> a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        com.facebook.share.model.SharePhoto.a.a(out, flags, this.a);
    }
}
