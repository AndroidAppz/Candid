package com.becandid.candid.services;

import android.content.Intent;
import android.os.Bundle;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.User;
import com.google.android.gms.gcm.GcmListenerService;
import defpackage.aom;
import defpackage.ih$ac;
import defpackage.ih$an;
import defpackage.iq;

public class GcmMessageHandler extends GcmListenerService {
    public void a(String from, Bundle data) {
        if (AppState.account != null) {
            Intent gcmIntent = new Intent("com.becandid.candid.GOT_PUSH");
            gcmIntent.putExtras(data);
            if (data.containsKey("unread_activity_count")) {
                if ("like_post".equals(data.getString("notification_type"))) {
                    if ("0".equals(data.getString("unread_activity_count"))) {
                        if (AppState.account.unread_activity_count == 0) {
                            AppState.account.unread_activity_count = 1;
                        } else {
                            User user = AppState.account;
                            user.unread_activity_count++;
                        }
                        iq.a().a(new ih$an(3, AppState.account.unread_activity_count));
                    }
                }
                AppState.account.unread_activity_count = Integer.parseInt(data.getString("unread_activity_count"));
                iq.a().a(new ih$an(3, AppState.account.unread_activity_count));
            }
            if (data.containsKey("unread_feed_count")) {
                AppState.account.unread_feed_count = Integer.parseInt(data.getString("unread_feed_count"));
                iq.a().a(new ih$an(0, AppState.account.unread_feed_count));
            }
            if (data.containsKey("unread_groups_count")) {
                AppState.account.unread_groups_count = Integer.parseInt(data.getString("unread_groups_count"));
                iq.a().a(new ih$an(1, AppState.account.unread_groups_count));
            }
            aom.a(this, AppState.account.unread_activity_count + AppState.account.unread_feed_count);
            if (data.getString("message_id") != null) {
                if (data.getString("post_id") != null && AppState.config.getBoolean("messaging_turned_on", true)) {
                    int count;
                    int messageId = Integer.parseInt(data.getString("message_id"));
                    String senderName = (String) DataUtil.toMap(data.getString("user_info")).get("post_name");
                    ih$ac newMessage = new ih$ac(messageId, Integer.parseInt(data.getString("post_id")), data.getString("message"), senderName, data.getString("subject"));
                    if (data.containsKey("image_width")) {
                        if (data.containsKey("image_height")) {
                            if (data.containsKey("source_url")) {
                                newMessage.f = Integer.parseInt(data.getString("image_width"));
                                newMessage.g = Integer.parseInt(data.getString("image_height"));
                                newMessage.h = data.getString("source_url");
                                iq.a().a(newMessage);
                                if (data.containsKey("unread_message_count")) {
                                    count = Integer.parseInt(data.getString("unread_message_count"));
                                    AppState.account.unread_message_count = count;
                                    iq.a().a(new ih$an(2, count, true));
                                    aom.a(this, (AppState.account.unread_activity_count + AppState.account.unread_feed_count) + count);
                                }
                                gcmIntent = new Intent("com.becandid.candid.MESSAGING");
                                gcmIntent.putExtras(data);
                            }
                        }
                    }
                    if (data.containsKey("sticker_name")) {
                        newMessage.i = data.getString("sticker_name");
                    }
                    iq.a().a(newMessage);
                    if (data.containsKey("unread_message_count")) {
                        count = Integer.parseInt(data.getString("unread_message_count"));
                        AppState.account.unread_message_count = count;
                        iq.a().a(new ih$an(2, count, true));
                        aom.a(this, (AppState.account.unread_activity_count + AppState.account.unread_feed_count) + count);
                    }
                    gcmIntent = new Intent("com.becandid.candid.MESSAGING");
                    gcmIntent.putExtras(data);
                }
            }
            sendOrderedBroadcast(gcmIntent, null);
        }
    }
}
