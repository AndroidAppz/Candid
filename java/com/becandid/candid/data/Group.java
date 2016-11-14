package com.becandid.candid.data;

import java.io.Serializable;
import java.util.List;

public class Group implements Serializable {
    public String about;
    public int friend_created = 0;
    public int group_id;
    public String group_name;
    public int moderator;
    public int num_friends = 0;
    public int num_members = 0;
    public int num_posts = 0;
    public int owner_user_id;
    public String source_url;
    public int t_joined;
    public int t_last_post;
    public List<String> tags;
    public String thumb_url;

    public String imageUrl() {
        return (this.thumb_url == null || this.thumb_url.length() <= 0) ? this.source_url : this.thumb_url;
    }

    public boolean isFriendCreated() {
        return this.friend_created != 0;
    }

    public Post convertToPost() {
        Post post = new Post();
        post.group_id = this.group_id;
        post.group_name = this.group_name;
        post.source_url = this.source_url;
        post.thumb_url = this.thumb_url;
        post.num_posts = Integer.valueOf(this.num_posts);
        post.num_members = Integer.valueOf(this.num_members);
        post.num_friends = Integer.valueOf(this.num_friends);
        post.owner_user_id = Integer.valueOf(this.owner_user_id);
        post.moderator = Integer.valueOf(this.moderator);
        post.about = this.about;
        post.friend_created = Integer.valueOf(this.friend_created);
        post.t_joined = Integer.valueOf(this.t_joined);
        post.t_last_post = Integer.valueOf(this.t_last_post);
        post.tags = this.tags;
        return post;
    }
}
