package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import java.util.List;

public interface ags extends IInterface {
    List<UserAttributeParcel> a(AppMetadata appMetadata, boolean z) throws RemoteException;

    void a(AppMetadata appMetadata) throws RemoteException;

    void a(EventParcel eventParcel, AppMetadata appMetadata) throws RemoteException;

    void a(EventParcel eventParcel, String str, String str2) throws RemoteException;

    void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) throws RemoteException;

    byte[] a(EventParcel eventParcel, String str) throws RemoteException;

    void b(AppMetadata appMetadata) throws RemoteException;
}
