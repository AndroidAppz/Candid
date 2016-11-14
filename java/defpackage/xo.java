package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class xo {
    public static int a(Parcel parcel) {
        return xo.b(parcel, 20293);
    }

    public static void a(Parcel parcel, int i) {
        xo.c(parcel, i);
    }

    public static void a(Parcel parcel, int i, byte b) {
        xo.b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void a(Parcel parcel, int i, double d) {
        xo.b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void a(Parcel parcel, int i, float f) {
        xo.b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void a(Parcel parcel, int i, int i2) {
        xo.b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void a(Parcel parcel, int i, long j) {
        xo.b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = xo.b(parcel, i);
            parcel.writeBundle(bundle);
            xo.c(parcel, b);
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = xo.b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            xo.c(parcel, b);
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = xo.b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            xo.c(parcel, b);
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Double d, boolean z) {
        if (d != null) {
            xo.b(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            xo.b(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            xo.b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            xo.b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = xo.b(parcel, i);
            parcel.writeString(str);
            xo.c(parcel, b);
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list != null) {
            int b = xo.b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            xo.c(parcel, b);
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, short s) {
        xo.b(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void a(Parcel parcel, int i, boolean z) {
        xo.b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int b = xo.b(parcel, i);
            parcel.writeByteArray(bArr);
            xo.c(parcel, b);
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b = xo.b(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    xo.a(parcel, parcelable, i2);
                }
            }
            xo.c(parcel, b);
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int b = xo.b(parcel, i);
            parcel.writeStringArray(strArr);
            xo.c(parcel, b);
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int b(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static void b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int b = xo.b(parcel, i);
            parcel.writeStringList(list);
            xo.c(parcel, b);
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    private static void c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static <T extends Parcelable> void c(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int b = xo.b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    xo.a(parcel, parcelable, 0);
                }
            }
            xo.c(parcel, b);
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }

    public static void d(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int b = xo.b(parcel, i);
            parcel.writeList(list);
            xo.c(parcel, b);
        } else if (z) {
            xo.b(parcel, i, 0);
        }
    }
}
