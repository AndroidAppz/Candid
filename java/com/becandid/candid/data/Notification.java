package com.becandid.candid.data;

import java.lang.reflect.Field;

public class Notification {
    public String action_icon;
    public int activity_id;
    public String body;
    public int comment_id;
    public String icon_color;
    public String icon_name;
    public int image_height;
    public int image_width;
    public String onclick;
    public String source_url;
    public String sticker_name;
    public long t_create;
    public String title;
    public int unread;
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
