package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Comment;
import com.becandid.candid.data.Post;
import com.becandid.candid.views.viewholders.ImagePostViewHolder;
import com.becandid.candid.views.viewholders.LinkPostViewHolder;
import com.becandid.candid.views.viewholders.TextPostViewHolder;
import java.util.List;

/* compiled from: CommentsAdapter */
public class he extends hd<Comment> {
    private ii d;
    private Post e;
    private Context f;
    private Handler g;
    private int h = 10;
    private int i = 16;
    private int j = 30;

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((iv) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return b(viewGroup, i);
    }

    public he(List<Comment> comments, Post post, Context context) {
        this.a = comments;
        this.e = post;
        this.d = ii.a();
        this.f = context;
        this.g = new Handler(context.getMainLooper());
        ((BaseActivity) context).addToSubscriptionList(iq.a().a(ih$al.class, new he$1(this)));
        ((BaseActivity) context).addToSubscriptionList(iq.a().a(ih$l.class, new he$9(this)));
        ((BaseActivity) context).addToSubscriptionList(iq.a().a(ih$s.class, new he$10(this)));
        ((BaseActivity) context).addToSubscriptionList(iq.a().a(ih$g.class, new he$11(this)));
        ((BaseActivity) context).addToSubscriptionList(iq.a().a(ih$ae.class, new he$12(this)));
        ((BaseActivity) context).addToSubscriptionList(iq.a().a(ih$h.class, new he$13(this)));
        ((BaseActivity) context).addToSubscriptionList(iq.a().a(ih$i.class, new he$14(this)));
    }

    public int b(int commentId) {
        for (int i = 0; i < this.a.size(); i++) {
            if (((Comment) this.a.get(i)).comment_id == commentId) {
                return i;
            }
        }
        return -1;
    }

    private void a(int commentId, ih$al updateComment) {
        int entry = b(commentId);
        if (entry != -1) {
            Comment comment = (Comment) this.a.get(entry);
            comment.like_value = updateComment.b;
            comment.num_likes = updateComment.c;
            comment.num_dislikes = updateComment.d;
            notifyItemChanged(entry + 1);
        }
    }

    private void c(int commentId) {
        int entry = b(commentId);
        if (entry != -1) {
            this.a.remove(entry);
            notifyItemRemoved(entry + 1);
        }
    }

    private void a(int commentId, String commentText, String mentionedGroupsInfo) {
        int entry = b(commentId);
        if (entry != -1) {
            Comment comment = (Comment) this.a.get(entry);
            comment.comment_text = commentText;
            comment.mentioned_groups_info = mentionedGroupsInfo;
            notifyItemChanged(entry + 1);
        }
    }

    public iv b(ViewGroup parent, int viewType) {
        if (viewType == 2) {
            return new ImagePostViewHolder(LayoutInflater.from(parent.getContext()).inflate(2130968658, parent, false), (Activity) this.f);
        }
        if (viewType == 3) {
            return new LinkPostViewHolder(LayoutInflater.from(parent.getContext()).inflate(2130968659, parent, false), (Activity) this.f);
        }
        if (viewType == 1) {
            return new TextPostViewHolder(LayoutInflater.from(parent.getContext()).inflate(2130968660, parent, false), (Activity) this.f);
        }
        if (viewType == 6) {
            return new iw(LayoutInflater.from(parent.getContext()).inflate(2130968638, parent, false));
        }
        return null;
    }

    public void a(iv holder, int position) {
        if (holder != null) {
            if (position != 0) {
                iw commentHolder = (iw) holder;
                Comment currComment = (Comment) this.a.get(position - 1);
                if (currComment != null) {
                    String username;
                    Spannable caption;
                    LayoutParams layoutParams;
                    if (currComment.is_master_comment) {
                        layoutParams = (RelativeLayout.LayoutParams) commentHolder.w.getLayoutParams();
                        layoutParams.setMargins(0, iu.a(this.h, this.f), 0, 0);
                        commentHolder.w.setLayoutParams(layoutParams);
                        this.i = 16;
                        this.j = 30;
                    } else {
                        layoutParams = (RelativeLayout.LayoutParams) commentHolder.w.getLayoutParams();
                        layoutParams.setMargins(iu.a(35, this.f), 0, 0, 0);
                        commentHolder.w.setLayoutParams(layoutParams);
                        this.i = 15;
                        this.j = 24;
                    }
                    if (currComment.user != null) {
                        username = currComment.user.user_name;
                    } else if (currComment.user_name != null) {
                        username = currComment.user_name;
                    } else {
                        username = "";
                    }
                    commentHolder.s = currComment.comment_id;
                    commentHolder.t = currComment.like_value;
                    commentHolder.a.setText(username);
                    int postColor = Color.parseColor(currComment.icon_color);
                    commentHolder.a.setTextColor(postColor);
                    commentHolder.a.setTextSize((float) this.i);
                    Drawable triangle = new jh();
                    triangle.setBounds(0, iu.a(1, this.f), iu.a(10, this.f), iu.a(6, this.f));
                    triangle.a(postColor);
                    commentHolder.a.setCompoundDrawables(null, null, triangle, null);
                    commentHolder.a.setOnClickListener(new he$15(this, currComment));
                    LayoutParams params;
                    if (currComment.is_candid_mod == 1) {
                        commentHolder.c.setVisibility(0);
                        params = (RelativeLayout.LayoutParams) commentHolder.c.getLayoutParams();
                        params.width = iu.a(this.j, this.f);
                        params.height = iu.a(this.j, this.f);
                        commentHolder.c.setLayoutParams(params);
                        commentHolder.c.setOnClickListener(new he$16(this, currComment));
                        commentHolder.b.setVisibility(8);
                    } else {
                        commentHolder.b.setVisibility(0);
                        commentHolder.b.setTextColor(postColor);
                        TextView textView = commentHolder.b;
                        ii iiVar = this.d;
                        textView.setTypeface(ii.b());
                        commentHolder.b.setText(ii.a(currComment.icon_name));
                        params = (RelativeLayout.LayoutParams) commentHolder.b.getLayoutParams();
                        params.width = iu.a(this.j, this.f);
                        params.height = iu.a(this.j, this.f);
                        commentHolder.b.setLayoutParams(params);
                        commentHolder.b.setTextSize((float) this.j);
                        int iconWidth = commentHolder.b.getWidth();
                        if (iconWidth == 0) {
                            iconWidth = (int) (commentHolder.b.getResources().getDisplayMetrics().density * ((float) this.j));
                        }
                        commentHolder.d.setColor((16777215 & postColor) | 1073741824);
                        commentHolder.d.setCornerRadius((float) (iconWidth / 2));
                        commentHolder.b.setBackground(commentHolder.d);
                        if (AppState.config.getBoolean("messaging_turned_on", true) && currComment.thats_me != 1) {
                            commentHolder.b.setOnClickListener(new he$2(this, currComment));
                        }
                        commentHolder.c.setVisibility(8);
                    }
                    if (currComment.is_op == 1 || currComment.is_friend == 1 || currComment.thats_me == 1 || currComment.is_candid_mod == 1) {
                        commentHolder.g.setVisibility(0);
                        commentHolder.g.setTextColor(Color.parseColor(currComment.icon_color));
                        commentHolder.g.setBackground(null);
                        if (currComment.is_candid_mod == 1) {
                            commentHolder.g.setText("MOD");
                            commentHolder.g.setTextColor(this.f.getResources().getColor(2131558476));
                        } else if (currComment.thats_me == 1) {
                            commentHolder.g.setText("YOU");
                            commentHolder.g.setTextColor(this.f.getResources().getColor(17170443));
                            commentHolder.g.setBackground(this.f.getResources().getDrawable(2130838146));
                        } else if (currComment.is_op == 1) {
                            commentHolder.g.setText("OP");
                        } else if (currComment.is_friend == 1) {
                            commentHolder.g.setText("FRIEND");
                        }
                    } else {
                        commentHolder.g.setVisibility(8);
                    }
                    commentHolder.h.setOnFocusChangeListener(null);
                    if (PostDetailsActivity.clipped == null || PostDetailsActivity.clipped.contains(Integer.valueOf(currComment.comment_id))) {
                        caption = new SpannableString(currComment.comment_text);
                    } else {
                        caption = iu.a(currComment.comment_text, 2131558478);
                        if (caption.toString().endsWith("See More")) {
                            commentHolder.h.setOnFocusChangeListener(new he$3(this, commentHolder, currComment, position));
                        } else {
                            PostDetailsActivity.clipped.add(Integer.valueOf(currComment.comment_id));
                        }
                    }
                    if (currComment.sticker_name != null) {
                        commentHolder.i.setImageDrawable(GossipApplication.a.getResources().getDrawable(GossipApplication.a.getResources().getIdentifier(currComment.sticker_name.toLowerCase(), "drawable", GossipApplication.a.getPackageName())));
                        commentHolder.i.setVisibility(0);
                    } else {
                        commentHolder.i.setVisibility(8);
                    }
                    if (currComment.comment_text.equals("")) {
                        commentHolder.h.setVisibility(8);
                    } else {
                        if (AppState.config.getInt("disable_group_tagging", 0) == 0 && currComment.mentioned_groups_info != null) {
                            String[] groups = currComment.mentioned_groups_info.split(";");
                            int length = groups.length;
                            int i = 0;
                            while (i < length) {
                                String[] indices = groups[i].split(",");
                                int groupId = Integer.parseInt(indices[0]);
                                int startIndex = Integer.parseInt(indices[1]);
                                int endIndex = Integer.parseInt(indices[2]);
                                if ((caption.toString().endsWith("See More") && endIndex >= caption.length()) || startIndex >= caption.length() || endIndex > caption.length() || startIndex < 0 || endIndex <= 0) {
                                    break;
                                }
                                try {
                                    caption.setSpan(iu.b("#000000", groupId, this.f), startIndex, endIndex, 33);
                                    i++;
                                } catch (IndexOutOfBoundsException e) {
                                }
                            }
                        }
                        commentHolder.h.setText(caption);
                        commentHolder.h.setVisibility(0);
                        commentHolder.h.setTextSize((float) this.i);
                    }
                    if (currComment.source_url != null) {
                        commentHolder.j.setVisibility(0);
                        float scale = this.f.getResources().getDisplayMetrics().density;
                        LayoutParams layoutParams2;
                        if (currComment.image_width > 250 || currComment.image_height > 250) {
                            layoutParams2 = new FrameLayout.LayoutParams((int) ((250.0f * scale) + 0.05f), (int) ((250.0f * scale) + 0.05f));
                        } else {
                            layoutParams2 = new FrameLayout.LayoutParams((int) ((((float) currComment.image_width) * scale) + 0.05f), (int) ((((float) currComment.image_height) * scale) + 0.05f));
                        }
                        commentHolder.j.setLayoutParams(imageLayout);
                        commentHolder.j.setBackgroundResource(17301613);
                        GossipApplication.c.a(currComment.source_url).d().a(new he$4(this, commentHolder)).a(commentHolder.j);
                        commentHolder.j.setOnClickListener(new he$5(this, currComment));
                    } else {
                        commentHolder.j.setVisibility(8);
                    }
                    commentHolder.k.setText(currComment.comment_time_ago);
                    if (currComment.like_value == -1) {
                        commentHolder.o.setSelected(true);
                        commentHolder.l.setSelected(false);
                    } else if (currComment.like_value == 1) {
                        commentHolder.l.setSelected(true);
                        commentHolder.o.setSelected(false);
                    } else {
                        commentHolder.l.setSelected(false);
                        commentHolder.o.setSelected(false);
                    }
                    commentHolder.n.setText(Integer.toString(currComment.num_likes));
                    commentHolder.q.setText(Integer.toString(currComment.num_dislikes));
                    commentHolder.m.setOnClickListener(new he$6(this, commentHolder, currComment));
                    commentHolder.p.setOnClickListener(new he$7(this, commentHolder, currComment));
                    if (currComment.like_value == 1) {
                        commentHolder.l.setSelected(true);
                        commentHolder.o.setSelected(false);
                    } else if (currComment.like_value == -1) {
                        commentHolder.l.setSelected(false);
                        commentHolder.o.setSelected(true);
                    } else {
                        commentHolder.l.setSelected(false);
                        commentHolder.o.setSelected(false);
                    }
                    if (currComment.thats_me == 1) {
                        commentHolder.r.setVisibility(8);
                    } else {
                        commentHolder.r.setVisibility(0);
                    }
                    commentHolder.r.setOnClickListener(new he$8(this, username, currComment, position));
                }
            } else if (holder instanceof TextPostViewHolder) {
                TextPostViewHolder.a((TextPostViewHolder) holder, this.e);
            } else if (holder instanceof ImagePostViewHolder) {
                ImagePostViewHolder.a((ImagePostViewHolder) holder, this.e);
            } else if (holder instanceof LinkPostViewHolder) {
                LinkPostViewHolder.a((LinkPostViewHolder) holder, this.e);
            }
        }
    }

    public int getItemViewType(int position) {
        if (position != 0 || this.e == null) {
            return 6;
        }
        String type = this.e.type;
        Object obj = -1;
        int i;
        switch (type.hashCode()) {
            case 3321850:
                if (type.equals("link")) {
                    i = 1;
                    break;
                }
                break;
            case 100313435:
                if (type.equals("image")) {
                    obj = null;
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
        switch (obj) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return 2;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return 3;
            default:
                return 1;
        }
    }

    public int getItemCount() {
        return this.a.size() + 1;
    }

    public void a(List<Comment> comments, Post post) {
        this.e = post;
        this.a.clear();
        this.a.addAll(comments);
        notifyDataSetChanged();
    }

    public void c(List<Comment> comments) {
        int currPos = this.a.size();
        this.a.addAll(comments);
        notifyItemRangeChanged(currPos + 1, 20);
    }

    public void a(Comment comment) {
        this.a.add(comment);
        notifyItemInserted(this.a.size());
    }
}
