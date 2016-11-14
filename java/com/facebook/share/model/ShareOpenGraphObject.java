package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Object> {
    public static final Creator<ShareOpenGraphObject> CREATOR = new Creator<ShareOpenGraphObject>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public ShareOpenGraphObject a(Parcel in) {
            return new ShareOpenGraphObject(in);
        }

        public ShareOpenGraphObject[] a(int size) {
            return new ShareOpenGraphObject[size];
        }
    };

    ShareOpenGraphObject(Parcel in) {
        super(in);
    }
}
