package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import java.util.Set;

public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends a> implements ShareModel {
    private final Bundle a;

    public static abstract class a<P extends ShareOpenGraphValueContainer, E extends a> {
        private Bundle a = new Bundle();

        public E a(String key, String value) {
            this.a.putString(key, value);
            return this;
        }

        public E a(P model) {
            if (model != null) {
                this.a.putAll(model.b());
            }
            return this;
        }
    }

    protected ShareOpenGraphValueContainer(a<P, E> builder) {
        this.a = (Bundle) builder.a.clone();
    }

    ShareOpenGraphValueContainer(Parcel in) {
        this.a = in.readBundle(a.class.getClassLoader());
    }

    public Object a(String key) {
        return this.a.get(key);
    }

    public String b(String key) {
        return this.a.getString(key);
    }

    public Bundle b() {
        return (Bundle) this.a.clone();
    }

    public Set<String> c() {
        return this.a.keySet();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeBundle(this.a);
    }
}
