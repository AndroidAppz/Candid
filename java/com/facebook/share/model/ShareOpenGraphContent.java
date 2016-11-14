package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareOpenGraphAction.a;

public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Object> {
    public static final Creator<ShareOpenGraphContent> CREATOR = new Creator<ShareOpenGraphContent>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public ShareOpenGraphContent a(Parcel in) {
            return new ShareOpenGraphContent(in);
        }

        public ShareOpenGraphContent[] a(int size) {
            return new ShareOpenGraphContent[size];
        }
    };
    private final ShareOpenGraphAction a;
    private final String b;

    ShareOpenGraphContent(Parcel in) {
        super(in);
        this.a = new a().a(in).a();
        this.b = in.readString();
    }

    public ShareOpenGraphAction a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeParcelable(this.a, 0);
        out.writeString(this.b);
    }
}
