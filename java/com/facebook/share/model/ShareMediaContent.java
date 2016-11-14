package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

public final class ShareMediaContent extends ShareContent<ShareMediaContent, Object> {
    public static final Creator<ShareMediaContent> CREATOR = new Creator<ShareMediaContent>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public ShareMediaContent a(Parcel in) {
            return new ShareMediaContent(in);
        }

        public ShareMediaContent[] a(int size) {
            return new ShareMediaContent[size];
        }
    };
    private final List<ShareMedia> a;

    ShareMediaContent(Parcel in) {
        super(in);
        this.a = Arrays.asList((ShareMedia[]) in.readParcelableArray(ShareMedia.class.getClassLoader()));
    }

    public List<ShareMedia> a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeParcelableArray((ShareMedia[]) this.a.toArray(), flags);
    }
}
