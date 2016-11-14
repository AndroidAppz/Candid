package com.becandid.candid.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import defpackage.aif;
import defpackage.aig;
import defpackage.rb;
import defpackage.um$h;
import defpackage.zu;

public class PushNotificationReceiver extends BroadcastReceiver {
    private Context a;

    public void a(Bundle payload) {
        if (payload != null) {
            for (String key : payload.keySet()) {
                if (payload.get(key) != null) {
                    Log.d("PushNotificationPayload", String.format("%s %s (%s)", new Object[]{(String) r2.next(), payload.get(key).toString(), payload.get(key).getClass().getName()}));
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.a = context;
        Bundle data = intent.getExtras();
        a(data);
        if (!data.containsKey("push_notification_disabled") || !data.getString("push_notification_disabled", "0").equals("1")) {
            try {
                String message;
                String title = data.getString("title");
                if (!data.containsKey("message_id")) {
                    message = data.getString("message");
                } else if (!AppState.config.getBoolean("messaging_turned_on", true)) {
                    return;
                } else {
                    if (data.containsKey("is_request") && data.getString("is_request", "false").equals("true")) {
                        message = ((String) DataUtil.toMap(data.getString("user_info")).get("post_name")) + " sent you a message request!";
                    } else {
                        message = data.getString("subject");
                    }
                }
                a(data.getString("notification_id"), title, message, data.getString("url"), data);
            } catch (NullPointerException e) {
                rb.a(e);
            }
        }
    }

    private void a(String notificationId, String title, String message, String url, Bundle data) {
        try {
            Integer.parseInt(notificationId);
            PendingIntent pendingIntent = url != null ? a(data, notificationId) : null;
            Builder mBuilder = new Builder(this.a).setSmallIcon(2130838017).setContentTitle(title).setPriority(1).setStyle(new BigTextStyle().bigText(message)).setAutoCancel(true).setContentText(message);
            String notificationSoundOn = data.getString("notification_sound_on");
            String notificationLightOn = data.getString("notification_light_on");
            String notificationVibrationOn = data.getString("notification_vibration_on");
            int notificationSettings = -1;
            if (notificationSoundOn != null && Integer.parseInt(notificationSoundOn) == 1) {
                notificationSettings = 1;
            }
            if (notificationLightOn != null && Integer.parseInt(notificationLightOn) == 1) {
                if (notificationSettings == -1) {
                    notificationSettings = 4;
                } else {
                    notificationSettings |= 4;
                }
            }
            if (notificationVibrationOn != null && Integer.parseInt(notificationVibrationOn) == 1) {
                if (notificationSettings == -1) {
                    notificationSettings = 2;
                } else {
                    notificationSettings |= 2;
                }
            }
            if (notificationSettings != -1) {
                mBuilder.setDefaults(notificationSettings);
            }
            if (pendingIntent != null) {
                mBuilder.setContentIntent(pendingIntent);
            }
            NotificationManager mNotificationManager = (NotificationManager) this.a.getSystemService("notification");
            Notification notification = mBuilder.build();
            if (VERSION.SDK_INT >= 21) {
                mBuilder.setColor(this.a.getResources().getColor(2131558476));
            }
            mNotificationManager.notify(Integer.parseInt(notificationId), mBuilder.build());
        } catch (NumberFormatException e) {
            rb.a(e);
        }
    }

    private PendingIntent a(Bundle payload, String notificationId) {
        if (!payload.containsKey("notification_type")) {
            return null;
        }
        Intent intent;
        String notificationType = payload.getString("notification_type", "");
        boolean z = true;
        switch (notificationType.hashCode()) {
            case -2059463938:
                if (notificationType.equals("new_post_friend")) {
                    z = false;
                    break;
                }
                break;
            case -1659251239:
                if (notificationType.equals("friend_signup")) {
                    z = true;
                    break;
                }
                break;
            case -1348026953:
                if (notificationType.equals("like_comment")) {
                    z = true;
                    break;
                }
                break;
            case -877257620:
                if (notificationType.equals("new_post_small_groups")) {
                    z = true;
                    break;
                }
                break;
            case -641874555:
                if (notificationType.equals("new_post_trending")) {
                    z = true;
                    break;
                }
                break;
            case -242382124:
                if (notificationType.equals("group_invite_friend")) {
                    z = true;
                    break;
                }
                break;
            case -163723192:
                if (notificationType.equals("like_post")) {
                    z = true;
                    break;
                }
                break;
            case -72322863:
                if (notificationType.equals("new_comment_other")) {
                    z = true;
                    break;
                }
                break;
            case 205758144:
                if (notificationType.equals("new_comment")) {
                    z = true;
                    break;
                }
                break;
            case 954925063:
                if (notificationType.equals("message")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                intent = new Intent(this.a, PostDetailsActivity.class);
                intent.putExtra("post_id", Integer.valueOf(payload.getString("post_id")));
                break;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                intent = new Intent(this.a, PostDetailsActivity.class);
                intent.putExtra("post_id", Integer.valueOf(payload.getString("post_id")));
                break;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                intent = new Intent(this.a, PostDetailsActivity.class);
                intent.putExtra("post_id", Integer.valueOf(payload.getString("post_id")));
                intent.putExtra("scrollToBottom", true);
                intent.putExtra("comment_id", Integer.valueOf(payload.getString("comment_id")));
                break;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                intent = new Intent(this.a, PostDetailsActivity.class);
                intent.putExtra("post_id", Integer.valueOf(payload.getString("post_id")));
                intent.putExtra("scrollToBottom", true);
                intent.putExtra("comment_id", Integer.valueOf(payload.getString("comment_id")));
                break;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                intent = new Intent(this.a, PostDetailsActivity.class);
                intent.putExtra("post_id", Integer.valueOf(payload.getString("post_id")));
                break;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                intent = new Intent(this.a, PostDetailsActivity.class);
                intent.putExtra("post_id", Integer.valueOf(payload.getString("post_id")));
                intent.putExtra("scrollToBottom", true);
                intent.putExtra("comment_id", Integer.valueOf(payload.getString("comment_id")));
                break;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                intent = new Intent(this.a, GroupDetailsActivity.class);
                aif groupDetails = new aig().a(payload.getString("group")).m();
                intent.putExtra("group_id", groupDetails.b("group_id").g());
                intent.putExtra("group_name", groupDetails.b("group_name").c());
                break;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                intent = new Intent(this.a, MainTabsActivity.class);
                intent.putExtra("selected_tab", "me");
                break;
            case um$h.CardView_contentPadding /*8*/:
                intent = new Intent(this.a, PostDetailsActivity.class);
                intent.putExtra("post_id", Integer.valueOf(payload.getString("post_id")));
                break;
            case um$h.CardView_contentPaddingLeft /*9*/:
                intent = new Intent(this.a, MessageActivity.class);
                intent.putExtra("post_id", payload.getString("post_id"));
                if (payload.getString("user_info") != null) {
                    intent.putExtra("user_name", (String) DataUtil.toMap(payload.getString("user_info")).get("post_name"));
                    break;
                }
                break;
            default:
                if (!payload.containsKey("post_id")) {
                    intent = new Intent(this.a, MainTabsActivity.class);
                    intent.putExtra("selected_tab", "feed");
                    break;
                }
                intent = new Intent(this.a, PostDetailsActivity.class);
                intent.putExtra("post_id", Integer.valueOf(payload.getString("post_id")));
                break;
        }
        if (payload.containsKey("orig_notification_id")) {
            intent.putExtra("click_notification", payload.getString("orig_notification_id"));
        }
        return PendingIntent.getActivity(this.a, Integer.parseInt(notificationId), intent, 134217728);
    }
}
