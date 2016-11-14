package com.becandid.candid.data;

import java.lang.reflect.Field;
import java.util.List;

public class User {
    public String age;
    public String badge_status;
    public boolean have_fb;
    public boolean have_phone_number;
    public String icon_color;
    public String icon_name;
    public boolean is_blocked;
    public int message_auto_deletion;
    public int messaging_disabled;
    public int need_age;
    public int need_onboarding;
    public int num_fb_friends;
    public int num_groups;
    public int num_phone_friends;
    public int num_posts;
    public int online;
    public String post_name;
    public float quality_score;
    public List<String> tags;
    public int unread_activity_count = -1;
    public int unread_feed_count = -1;
    public int unread_groups_count = -1;
    public int unread_message_count = -1;
    public int user_id;
    public String user_name;

    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        result.append(getClass().getName());
        result.append(" Object {");
        result.append(newLine);
        for (Field field : getClass().getDeclaredFields()) {
            result.append("  ");
            try {
                result.append(field.getName());
                result.append(": ");
                result.append(field.get(this));
            } catch (IllegalAccessException ex) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("}");
        return result.toString();
    }
}
