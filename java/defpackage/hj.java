package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.util.RoundedCornersTransformation;

/* compiled from: MessageThreadsAdapter */
public class hj extends hd<MessageThread> {
    private Context d;
    private ii e = ii.a();

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((iv) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return b(viewGroup, i);
    }

    public hj(Context context) {
        this.d = context;
    }

    public iv b(ViewGroup parent, int viewType) {
        return new iy(LayoutInflater.from(parent.getContext()).inflate(2130968690, parent, false));
    }

    public void a(iv holder, int position) {
        iy threadHolder = (iy) holder;
        MessageThread thread = (MessageThread) this.a.get(position);
        threadHolder.a.setOnClickListener(new hj$1(this, thread, holder));
        threadHolder.a.setOnLongClickListener(new hj$2(this, thread));
        int color = this.d.getResources().getColor(2131558476);
        try {
            color = Color.parseColor(thread.target_user_info.icon_color);
        } catch (NullPointerException e) {
            rc.c().a((rm) new rm("Display Messaging Thread").a("Thread", thread.toString()));
        }
        TextView textView = threadHolder.b;
        ii iiVar = this.e;
        textView.setText(ii.a(thread.target_user_info.icon_name));
        textView = threadHolder.b;
        iiVar = this.e;
        textView.setTypeface(ii.b());
        threadHolder.b.setTextColor(color);
        int iconWidth = threadHolder.c.getWidth();
        if (iconWidth == 0) {
            iconWidth = iu.a(60, this.d);
        }
        int gradColor = (16777215 & color) | 1073741824;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(gradColor);
        gradientDrawable.setCornerRadius((float) (iconWidth / 2));
        threadHolder.c.setBackground(gradientDrawable);
        if (thread.online == 1) {
            threadHolder.d.setVisibility(0);
        } else {
            threadHolder.d.setVisibility(8);
        }
        threadHolder.g.setText(thread.target_user_info.post_name);
        threadHolder.g.setTextColor(color);
        threadHolder.h.setText(((Message) thread.messages.get(0)).subject);
        threadHolder.i.setText(ij.a(thread.sent_time));
        if (thread.post == null) {
            threadHolder.l.setVisibility(8);
            threadHolder.k.setVisibility(8);
            threadHolder.m.setVisibility(0);
            threadHolder.j.setBackground(this.d.getResources().getDrawable(2130838051));
            ((GradientDrawable) threadHolder.j.getBackground()).setColor(Color.parseColor("#DDDDDD"));
        } else if (thread.post.thumb_url != null) {
            threadHolder.j.setBackground(null);
            threadHolder.k.setVisibility(8);
            threadHolder.m.setVisibility(8);
            threadHolder.l.setVisibility(0);
            GossipApplication.c.a(thread.post.thumb_url).d().a(new RoundedCornersTransformation(this.d, iu.a(4, this.d), 0)).a(threadHolder.l);
        } else {
            threadHolder.l.setVisibility(8);
            threadHolder.m.setVisibility(8);
            threadHolder.k.setVisibility(0);
            threadHolder.k.setTypeface(ic.a(this.d).a("JosefinSans-SemiBold.ttf"));
            threadHolder.j.setBackground(this.d.getResources().getDrawable(2130838051));
            ((GradientDrawable) threadHolder.j.getBackground()).setColor(Color.parseColor(thread.post.icon_color));
            if (thread.post.caption != null) {
                threadHolder.k.setText(thread.post.caption);
            } else if (thread.post.og_title != null) {
                threadHolder.k.setText(thread.post.og_title);
            }
        }
        if (thread.unread_messages > 0) {
            threadHolder.a.setBackgroundColor((this.d.getResources().getColor(2131558476) & 16777215) | 268435456);
        } else {
            threadHolder.a.setBackground(this.d.getResources().getDrawable(2130838052));
        }
        ((BaseActivity) this.d).addToSubscriptionList(iq.a().a(ih$j.class, new hj$3(this)));
    }

    public MessageThread b(int position) {
        return (MessageThread) this.a.get(position);
    }

    public void a(MessageThread thread) {
        if (this.a != null) {
            this.a.add(0, thread);
            notifyItemInserted(0);
        }
    }

    public boolean a(ih$ac message) {
        if (this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                MessageThread thread = (MessageThread) this.a.get(i);
                if (thread.post_id == message.b && thread.target_user_info.post_name.equals(message.d)) {
                    ((Message) thread.messages.get(0)).message = message.c;
                    ((Message) thread.messages.get(0)).subject = message.c;
                    ((Message) thread.messages.get(0)).sent_time = System.currentTimeMillis();
                    thread.unread_messages++;
                    notifyItemChanged(i);
                    return true;
                }
            }
        }
        return false;
    }
}
