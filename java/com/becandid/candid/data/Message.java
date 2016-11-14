package com.becandid.candid.data;

import java.lang.reflect.Field;
import java.util.Map;

public class Message {
    public boolean failedSend = false;
    public int image_height;
    public int image_width;
    public String message;
    public boolean messageHeader;
    public boolean messagePost;
    public long messageTempId;
    public int message_id;
    public Map<String, String> params;
    public Post post;
    public int post_id;
    public String sender = "self";
    public long sent_time;
    public String source_url;
    public String sticker_name;
    public String subject;
    public int uploaded;
    public User user_info;

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
