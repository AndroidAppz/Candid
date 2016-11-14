package defpackage;

import com.becandid.candid.data.AppState;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;

/* compiled from: ApiService */
class ie$6 implements apu<NetworkData, apd<NetworkData>> {
    final /* synthetic */ ie a;

    ie$6(ie this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apd<NetworkData> a(NetworkData networkData) {
        if (networkData == null || !networkData.success) {
            return null;
        }
        AppState.config.setExperimentConfig(networkData.config);
        AppState.account = networkData.my_info;
        AppState.tabsOrder = networkData.feed_tab_order;
        if (AppState.account.unread_activity_count >= 0) {
            iq.a().a(new ih$an(3, AppState.account.unread_activity_count));
        }
        if (AppState.account.unread_feed_count >= 0) {
            iq.a().a(new ih$an(0, AppState.account.unread_feed_count));
        }
        if (AppState.account.unread_groups_count >= 0) {
            iq.a().a(new ih$an(1, AppState.account.unread_groups_count));
        }
        if (networkData.groups != null) {
            AppState.groups = new ArrayList(networkData.groups);
        }
        if (networkData.activity_settings != null) {
            AppState.notificationSettings = new ArrayList(networkData.activity_settings);
        }
        if (networkData.feed_colors != null) {
            AppState.feedColors = networkData.feed_colors;
        }
        if (networkData.group_tags != null) {
            AppState.groupTags = networkData.group_tags;
        }
        AppState.needAge = networkData.my_info.need_age;
        AppState.needOnboarding = networkData.my_info.need_onboarding;
        return apd.a((Object) networkData);
    }
}
