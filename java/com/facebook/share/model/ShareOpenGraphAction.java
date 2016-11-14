package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, a> {
    public static final Creator<ShareOpenGraphAction> CREATOR = new Creator<ShareOpenGraphAction>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public ShareOpenGraphAction a(Parcel in) {
            return new ShareOpenGraphAction(in);
        }

        public ShareOpenGraphAction[] a(int size) {
            return new ShareOpenGraphAction[size];
        }
    };

    public static final class a extends com.facebook.share.model.ShareOpenGraphValueContainer.a<ShareOpenGraphAction, a> {
        public a a(String actionType) {
            a("og:type", actionType);
            return this;
        }

        public ShareOpenGraphAction a() {
            return new ShareOpenGraphAction();
        }

        public a a(ShareOpenGraphAction model) {
            return model == null ? this : ((a) super.a((ShareOpenGraphValueContainer) model)).a(model.a());
        }

        a a(Parcel parcel) {
            return a((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
        }
    }

    private ShareOpenGraphAction(a builder) {
        super((com.facebook.share.model.ShareOpenGraphValueContainer.a) builder);
    }

    ShareOpenGraphAction(Parcel in) {
        super(in);
    }

    public String a() {
        return b("og:type");
    }
}
