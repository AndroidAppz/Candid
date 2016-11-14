package defpackage;

/* compiled from: AdvertisingInfo */
public class ale {
    public final String a;
    public final boolean b;

    ale(String advertisingId, boolean limitAdTrackingEnabled) {
        this.a = advertisingId;
        this.b = limitAdTrackingEnabled;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ale infoToCompare = (ale) o;
        if (this.b != infoToCompare.b) {
            return false;
        }
        if (this.a != null) {
            if (this.a.equals(infoToCompare.a)) {
                return true;
            }
        } else if (infoToCompare.a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result;
        int i = 0;
        if (this.a != null) {
            result = this.a.hashCode();
        } else {
            result = 0;
        }
        int i2 = result * 31;
        if (this.b) {
            i = 1;
        }
        return i2 + i;
    }
}
