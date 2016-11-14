package com.becandid.candid.data;

import java.lang.reflect.Field;
import java.util.List;

public class Comment {
    public int clipped = 1;
    public int comment_id;
    public String comment_text;
    public String comment_time_ago;
    public String icon_color;
    public String icon_name;
    public int image_height;
    public int image_width;
    public int is_candid_mod;
    public int is_friend;
    public boolean is_master_comment;
    public int is_op;
    public int like_value;
    public String mentioned_groups_info;
    public String messaging_blocked;
    public String messaging_disabled;
    public int num_dislikes;
    public int num_likes;
    public int post_id;
    public List<Comment> reply_comments;
    public int small_image_height;
    public int small_image_width;
    public String source_url;
    public String sticker_name;
    public int thats_me;
    public User user;
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
