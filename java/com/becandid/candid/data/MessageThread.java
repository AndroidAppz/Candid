package com.becandid.candid.data;

import java.lang.reflect.Field;
import java.util.List;

public class MessageThread {
    public int is_request;
    public List<Message> messages;
    public int online;
    public String other_user_post_name;
    public Post post;
    public int post_id;
    public long sent_time;
    public User target_user_info;
    public String thread_comment_id;
    public int unread_messages;
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
