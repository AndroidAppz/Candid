package defpackage;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.Map;
import java.util.UUID;

/* compiled from: SessionMetadataCollector */
class sb {
    private final Context a;
    private final IdManager b;
    private final String c;
    private final String d;

    public sb(Context context, IdManager idManager, String versionCode, String versionName) {
        this.a = context;
        this.b = idManager;
        this.c = versionCode;
        this.d = versionName;
    }

    public rz a() {
        Map<DeviceIdentifierType, String> deviceIdentifiers = this.b.i();
        return new rz(this.b.c(), UUID.randomUUID().toString(), this.b.b(), (String) deviceIdentifiers.get(DeviceIdentifierType.d), (String) deviceIdentifiers.get(DeviceIdentifierType.g), this.b.l(), (String) deviceIdentifiers.get(DeviceIdentifierType.c), CommonUtils.m(this.a), this.b.d(), this.b.g(), this.c, this.d);
    }
}
