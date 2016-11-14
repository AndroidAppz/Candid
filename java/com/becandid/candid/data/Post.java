package com.becandid.candid.data;

import java.lang.reflect.Field;
import java.util.List;

public class Post {
    public String about;
    public int actual_height = -1;
    public int actual_width = -1;
    public int can_mute;
    public String caption;
    public String comment_icon_name;
    public int comment_image_height = -1;
    public int comment_image_width = -1;
    public int comment_is_candid_mod;
    public String comment_source_url;
    public String comment_sticker_name;
    public String comment_text;
    public String comment_time_ago;
    public List<Comment> comments;
    public Integer friend_created = Integer.valueOf(0);
    public int friends_disabled;
    public int group_id;
    public String group_name;
    public int height;
    public String icon_color;
    public String icon_name;
    public String image_hash;
    public int is_candid_mod;
    public int is_friend;
    public String layout_xml;
    public int like_value;
    public String link_domain;
    public String link_url;
    public String localBitmapPath;
    public String mentioned_groups_info;
    public String messaging_blocked;
    public String messaging_disabled;
    public Integer moderator;
    public int muted_post;
    public int num_comments;
    public int num_dislikes;
    public int num_false;
    public Integer num_friends = Integer.valueOf(0);
    public int num_likes;
    public Integer num_members = Integer.valueOf(0);
    public Integer num_posts = Integer.valueOf(0);
    public int num_true;
    public String og_desc;
    public String og_title;
    public int opinion_value;
    public Integer owner_user_id;
    public int post_id;
    public String post_time_ago;
    public float quality_score;
    public int rumor;
    public ShareInfo share_info;
    public String source_url;
    public Integer t_joined;
    public Integer t_last_post;
    public List<String> tags;
    public int thats_me;
    public String thumb_url;
    public int trending;
    public String type;
    public String user_name;
    public int width;

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

    public boolean equals(Object o) {
        if (!(o instanceof Post)) {
            return false;
        }
        if (this.post_id == ((Post) o).post_id) {
            return true;
        }
        return false;
    }

    public String imageUrl() {
        return (this.thumb_url == null || this.thumb_url.length() <= 0) ? this.source_url : this.thumb_url;
    }

    public boolean isMember() {
        return AppState.isGroupMember(this.group_id);
    }
}
