package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.SharePhoto.a;

public final class ShareVideoContent extends ShareContent<ShareVideoContent, Object> implements ShareModel {
    public static final Creator<ShareVideoContent> CREATOR = new Creator<ShareVideoContent>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public ShareVideoContent a(Parcel in) {
            return new ShareVideoContent(in);
        }

        public ShareVideoContent[] a(int size) {
            return new ShareVideoContent[size];
        }
    };
    private final String a;
    private final String b;
    private final SharePhoto c;
    private final ShareVideo d;

    ShareVideoContent(Parcel in) {
        super(in);
        this.a = in.readString();
        this.b = in.readString();
        a previewPhotoBuilder = new a().b(in);
        if (previewPhotoBuilder.a() == null && previewPhotoBuilder.b() == null) {
            this.c = null;
        } else {
            this.c = previewPhotoBuilder.c();
        }
        this.d = new ShareVideo.a().b(in).a();
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public SharePhoto c() {
        return this.c;
    }

    public ShareVideo d() {
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
        out.writeParcelable(this.d, 0);
    }
}
