package io.nlopez.smartlocation.geocoding.utils;

import android.location.Address;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LocationAddress implements Parcelable {
    public static final Creator CREATOR = new Creator() {
        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return a(x0);
        }

        public LocationAddress a(Parcel in) {
            return new LocationAddress(in);
        }

        public LocationAddress[] a(int size) {
            return new LocationAddress[size];
        }
    };
    private Location a;
    private Address b;

    public LocationAddress(Address address) {
        this.b = address;
        this.a = new Location(LocationAddress.class.getCanonicalName());
        this.a.setLatitude(address.getLatitude());
        this.a.setLongitude(address.getLongitude());
    }

    public LocationAddress(Parcel in) {
        this.a = (Location) in.readParcelable(Location.class.getClassLoader());
        this.b = (Address) in.readParcelable(Address.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.a, flags);
        dest.writeParcelable(this.b, flags);
    }
}
