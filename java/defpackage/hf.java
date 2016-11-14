package defpackage;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Comment;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.UpdatePost.Updates;
import com.becandid.candid.views.viewholders.GroupHeaderHolder;
import com.becandid.candid.views.viewholders.ImagePostViewHolder;
import com.becandid.candid.views.viewholders.LinkPostViewHolder;
import com.becandid.candid.views.viewholders.TextPostViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: FeedAdapter */
public class hf extends hd<Post> {
    private static HashMap<Integer, String> d = new HashMap();
    private Activity e;

    public /* synthetic */ void a(Object obj, int i) {
        b((Post) obj, i);
    }

    public /* synthetic */ void b(Object obj, int i) {
        a((Post) obj, i);
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((iv) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return b(viewGroup, i);
    }

    public /* synthetic */ void onViewAttachedToWindow(ViewHolder viewHolder) {
        a((iv) viewHolder);
    }

    public /* synthetic */ void onViewDetachedFromWindow(ViewHolder viewHolder) {
        b((iv) viewHolder);
    }

    public hf(BaseActivity activity) {
        this.e = activity;
        activity.addToSubscriptionList(iq.a().a(ih$q.class, new hf$1(this, activity)));
        activity.addToSubscriptionList(iq.a().a(ih$am.class, new hf$2(this)));
        activity.addToSubscriptionList(iq.a().a(ih$r.class, new hf$3(this)));
        activity.addToSubscriptionList(iq.a().a(ih$ab.class, new hf$4(this)));
        activity.addToSubscriptionList(iq.a().a(ih$l.class, new hf$5(this)));
        activity.addToSubscriptionList(iq.a().a(ih$ad.class, new hf$6(this)));
        activity.addToSubscriptionList(iq.a().a(ih$ah.class, new hf$7(this)));
    }

    private void a(ih$l didDeleteComment) {
        int row = c(didDeleteComment.b);
        if (row >= 0) {
            Post post = (Post) this.a.get(row);
            post.num_comments--;
            post.comment_icon_name = null;
            notifyItemChanged(row);
        }
    }

    private void a(ih$ab newComment) {
        int row = c(newComment.a);
        Comment comment = newComment.d;
        if (row >= 0 && comment != null && (this.e instanceof MainTabsActivity)) {
            Post post = (Post) this.a.get(row);
            post.comment_icon_name = comment.icon_name;
            post.comment_text = comment.comment_text;
            post.comment_time_ago = comment.comment_time_ago;
            post.comment_source_url = comment.source_url;
            post.comment_image_width = comment.small_image_width;
            post.comment_image_height = comment.small_image_height;
            post.comment_sticker_name = comment.sticker_name;
            if (post.comment_sticker_name != null && (post.comment_image_height == 0 || post.comment_image_width == 0)) {
                post.comment_image_width = 25;
                post.comment_image_height = 25;
            }
            notifyItemChanged(row);
        }
    }

    public void b(int postId) {
        int row = c(postId);
        if (row >= 0) {
            this.a.remove(row);
            notifyItemRemoved(row);
        }
    }

    public int c(int postId) {
        int i = 0;
        for (Post post : this.a) {
            if (post.post_id == postId) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void a(int postId, ih$q update) {
        int row = c(postId);
        if (row >= 0) {
            Post post = (Post) this.a.get(row);
            post.num_likes = update.c;
            post.num_dislikes = update.d;
            post.like_value = update.b;
            post.num_true = update.e;
            post.num_false = update.f;
            post.opinion_value = update.g;
            notifyItemChanged(row);
        }
    }

    public void a(int postId, ih$am updatePost) {
        Log.d("FeedAdapter", "Got update with num_comments: " + updatePost.a.updates.num_comments);
        int row = c(postId);
        if (row >= 0) {
            Post post = (Post) this.a.get(row);
            Updates update = updatePost.a.updates;
            if (update.num_likes != null) {
                post.num_likes = update.num_likes.intValue();
            }
            if (update.num_dislikes != null) {
                post.num_dislikes = update.num_dislikes.intValue();
            }
            if (update.num_comments != null) {
                post.num_comments = update.num_comments.intValue();
            }
            notifyItemChanged(row);
        }
    }

    public void a(int postId, String postText, String mentionedGroupsInfo) {
        int row = c(postId);
        if (row >= 0) {
            Post post = (Post) this.a.get(row);
            post.caption = postText;
            post.mentioned_groups_info = mentionedGroupsInfo;
        }
        notifyItemChanged(row);
    }

    public iv b(ViewGroup parent, int viewType) {
        if (viewType == 5) {
            return new GroupHeaderHolder(LayoutInflater.from(parent.getContext()).inflate(2130968656, parent, false), this.e);
        }
        if (viewType == 4) {
            return new jb(this.e);
        }
        if (viewType == 2) {
            return new ImagePostViewHolder(LayoutInflater.from(parent.getContext()).inflate(2130968658, parent, false), this.e);
        }
        if (viewType == 3) {
            return new LinkPostViewHolder(LayoutInflater.from(parent.getContext()).inflate(2130968659, parent, false), this.e);
        }
        return new TextPostViewHolder(LayoutInflater.from(parent.getContext()).inflate(2130968660, parent, false), this.e);
    }

    public void a(iv holder, int position) {
        Post post = (Post) this.a.get(position);
        if (post != null) {
            if (holder instanceof GroupHeaderHolder) {
                GroupHeaderHolder groupHeaderHolder = (GroupHeaderHolder) holder;
                groupHeaderHolder.a(groupHeaderHolder, post);
            } else if (holder instanceof jb) {
                ((jb) holder).a(post.layout_xml);
            } else if (holder instanceof TextPostViewHolder) {
                TextPostViewHolder.a((TextPostViewHolder) holder, post);
            } else if (holder instanceof ImagePostViewHolder) {
                ImagePostViewHolder.a((ImagePostViewHolder) holder, post);
            } else if (holder instanceof LinkPostViewHolder) {
                LinkPostViewHolder.a((LinkPostViewHolder) holder, post);
            }
        }
    }

    public int getItemViewType(int position) {
        Post post = (Post) this.a.get(position);
        try {
            if (post.layout_xml != null) {
                return 4;
            }
            if (post.tags != null) {
                return 5;
            }
            String type = post.type;
            int i = -1;
            switch (type.hashCode()) {
                case 3321850:
                    if (type.equals("link")) {
                        i = 1;
                        break;
                    }
                    break;
                case 100313435:
                    if (type.equals("image")) {
                        i = 0;
                        break;
                    }
                    break;
                case 112202875:
                    if (type.equals("video")) {
                        i = 2;
                        break;
                    }
                    break;
            }
            switch (i) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    return 2;
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    return 3;
                default:
                    return 1;
            }
        } catch (NullPointerException e) {
            rb.a(new Exception("POST is NULL: " + post.toString()));
            return 1;
        }
    }

    public void a(List<Post> newData) {
        super.a((List) newData);
        a((List) newData, 0);
    }

    public void a(int pos, Post post) {
        this.a.set(pos, post);
        notifyItemChanged(pos);
        if (c(post, pos)) {
            notifyItemChanged(pos);
        }
    }

    private void a(List<Post> newData, int startIndex) {
        if (newData != null) {
            int i = startIndex;
            boolean changed = false;
            for (Post post : newData) {
                changed = c(post, i) || changed;
                i++;
            }
            if (changed) {
                notifyDataSetChanged();
            }
        }
    }

    public void b(List<Post> newData) {
        super.b((List) newData);
        a((List) newData, this.a.indexOf(newData.get(0)));
    }

    public void a(Post row) {
        super.a((Object) row);
        if (!(this.e instanceof PostDetailsActivity) && c(row, 0)) {
            notifyItemChanged(0);
        }
    }

    public void a(Post row, int pos) {
        super.b((Object) row, pos);
        if (!(this.e instanceof PostDetailsActivity) && c(row, pos)) {
            notifyItemChanged(pos);
        }
    }

    public void b(Post row, int pos) {
        super.a((Object) row, pos);
        if (!(this.e instanceof PostDetailsActivity) && c(row, pos)) {
            notifyItemChanged(pos);
        }
    }

    public boolean c(Post post, int position) {
        if (post == null) {
            rb.a(new Exception("post in fixupPost is NULL"));
            return false;
        } else if (post.layout_xml != null) {
            return false;
        } else {
            List<Post> neighboringPosts = a(position, 1);
            String color = post.icon_color;
            if (d.containsKey(Integer.valueOf(post.post_id))) {
                post.icon_color = (String) d.get(Integer.valueOf(post.post_id));
                return true;
            }
            for (Post neighbor : neighboringPosts) {
                if (neighbor.icon_color != null && neighbor.icon_color.equals(color)) {
                    a(post, (List) neighboringPosts);
                    return true;
                }
            }
            return false;
        }
    }

    public void a(Post post, List<Post> neighbors) {
        if (AppState.feedColors != null) {
            HashSet<String> colors = new HashSet(neighbors.size());
            for (Post neighbor : neighbors) {
                colors.add(neighbor.icon_color);
            }
            while (colors.contains(post.icon_color)) {
                post.icon_color = (String) AppState.feedColors.get((int) (Math.random() * ((double) AppState.feedColors.size())));
            }
            d.put(Integer.valueOf(post.post_id), post.icon_color);
        }
    }

    public List<Post> a(int position, int distance) {
        ArrayList<Post> neighbors = new ArrayList(distance * 2);
        for (int i = Math.max(0, position - distance); i < Math.min((position + distance) + 1, this.a.size()); i++) {
            if (i != position) {
                neighbors.add(this.a.get(i));
            }
        }
        return neighbors;
    }

    public int d(int rowPosition) {
        if (rowPosition >= this.a.size()) {
            return -1;
        }
        return ((Post) this.a.get(rowPosition)).post_id;
    }

    public void a(iv holder) {
        super.onViewAttachedToWindow(holder);
        try {
            int postId = ((Post) this.a.get(holder.getAdapterPosition())).post_id;
            long currTime = System.currentTimeMillis();
            if (!this.c.containsKey(Integer.toString(postId) + "_oldest")) {
                this.c.put(Integer.toString(postId) + "_oldest", Long.toString(currTime));
            }
        } catch (Exception e) {
            rb.a(e);
        }
    }

    public void b(iv holder) {
        super.onViewDetachedFromWindow(holder);
        try {
            Post post = (Post) this.a.get(holder.getAdapterPosition());
            int postId = post.post_id;
            long currTime = System.currentTimeMillis();
            long oldTime = Long.parseLong((String) this.c.get(Integer.toString(postId) + "_oldest"));
            StringBuilder impressionData = new StringBuilder();
            impressionData.append(post.post_id);
            impressionData.append("|");
            impressionData.append(System.currentTimeMillis());
            impressionData.append("|");
            impressionData.append((currTime - oldTime) / 1000);
            impressionData.append("|");
            this.c.put(Integer.toString(postId), impressionData.toString());
        } catch (Exception e) {
            rb.a(e);
        }
    }

    public Post e(int row) {
        return (Post) this.a.get(row);
    }
}
