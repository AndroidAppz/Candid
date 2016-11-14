package com.becandid.candid.models;

import com.becandid.candid.data.Comment;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.data.Notification;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.UpdatePost;
import com.becandid.candid.data.User;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class NetworkData {
    public List<Notification> activity;
    public List<NotificationSetting> activity_settings;
    public Comment comment;
    public Map<String, Object> config;
    public boolean debug;
    public String error;
    public List<String> feed_colors;
    public List<String> feed_tab_order;
    public Group group;
    public List<String> group_tags;
    public List<Group> groups;
    public boolean is_new_user;
    public int last_activity_id;
    public Message message;
    public User my_info;
    public int new_requests;
    public int new_threads;
    public int next_page;
    public Post post;
    public List<Post> posts;
    public User profile;
    public int referral_post_id;
    public int request_next_page;
    public List<MessageThread> requests;
    public List<MessageThread> results;
    public ServerMessage server_message;
    public boolean success;
    public MessageThread thread;
    public int thread_next_page;
    public List<MessageThread> threads;
    public int unread_count = -1;
    public int unread_groups_count = -1;
    public UpdatePost update_post;

    public class NotificationSetting {
        public Integer disabled;
        public String display_name;
        public String type;

        public NotificationSetting copy() {
            NotificationSetting copy = new NotificationSetting();
            copy.display_name = this.display_name;
            copy.type = this.type;
            copy.disabled = this.disabled;
            return copy;
        }
    }

    public static class UploadResponse {
        public String full_url;
        public Map<String, String> s3_data;
        public boolean success;
    }

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
