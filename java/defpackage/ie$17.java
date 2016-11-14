package defpackage;

import com.becandid.candid.data.AppState;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;

/* compiled from: ApiService */
class ie$17 implements apu<NetworkData, apd<NetworkData>> {
    final /* synthetic */ ie a;

    ie$17(ie this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apd<NetworkData> a(NetworkData networkData) {
        if (networkData != null && networkData.success) {
            if (networkData.my_info != null) {
                AppState.account = networkData.my_info;
                AppState.needAge = networkData.my_info.need_age;
                AppState.age = networkData.my_info.age;
            }
            if (networkData.group_tags != null) {
                AppState.groupTags = networkData.group_tags;
            }
            if (networkData.activity_settings != null) {
                AppState.notificationSettings = new ArrayList(networkData.activity_settings);
            }
            if (networkData.config != null) {
                AppState.setConfig(networkData.config);
            }
            if (networkData.referral_post_id != 0) {
                AppState.referralPostId = networkData.referral_post_id;
            }
        }
        return apd.a((Object) networkData);
    }
}
