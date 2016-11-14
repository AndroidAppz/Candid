package defpackage;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.User;
import com.becandid.candid.views.viewholders.MessagePostViewHolder;
import com.becandid.candid.views.viewholders.MessagesHeaderViewHolder;
import java.util.List;

/* compiled from: MessagesAdapter */
public class hk extends hd<Message> {
    private Context d;
    private User e;
    private User f;

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((iv) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return b(viewGroup, i);
    }

    public hk(Context context) {
        this.d = context;
        ((BaseActivity) context).addToSubscriptionList(iq.a().a(ih$af.class, new hk$1(this)));
    }

    public void a(User targetUserInfo) {
        this.e = targetUserInfo;
    }

    public void b(User userInfo) {
        this.f = userInfo;
    }

    public iv b(ViewGroup parent, int viewType) {
        switch (viewType) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return new iz(LayoutInflater.from(parent.getContext()).inflate(2130968689, parent, false), 0);
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return new iz(LayoutInflater.from(parent.getContext()).inflate(2130968688, parent, false), 1);
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return new MessagePostViewHolder(LayoutInflater.from(parent.getContext()).inflate(2130968657, parent, false), (MessageActivity) this.d);
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return new MessagesHeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(2130968691, parent, false));
            default:
                return null;
        }
    }

    public void a(iv holder, int position) {
        Message message = (Message) this.a.get(position);
        if (holder instanceof iz) {
            iz messageHolder = (iz) holder;
            Message prevMessage = null;
            if (position >= 1) {
                prevMessage = (Message) this.a.get(position - 1);
            }
            if (this.e != null) {
                if (message.sent_time == 0 || (prevMessage != null && message.sent_time - prevMessage.sent_time < 6000)) {
                    iz.a(messageHolder, message, prevMessage, this.f, this.e, false, this.d, this);
                } else {
                    iz.a(messageHolder, message, prevMessage, this.f, this.e, true, this.d, this);
                }
            }
        } else if (holder instanceof MessagePostViewHolder) {
            MessagePostViewHolder.a((MessagePostViewHolder) holder, message);
        } else if (holder instanceof MessagesHeaderViewHolder) {
            MessagesHeaderViewHolder.a((MessagesHeaderViewHolder) holder, this.f);
        }
    }

    public int getItemViewType(int position) {
        Message message = (Message) this.a.get(position);
        if (message.messagePost) {
            return 2;
        }
        if (message.messageHeader) {
            return 3;
        }
        if (message.sender.equals("self")) {
            return 0;
        }
        if (message.sender.equals("other")) {
            return 1;
        }
        return -1;
    }

    public void a(Message message) {
        this.a.add(message);
        notifyItemInserted(this.a.size() - 1);
    }

    public void c(List<Message> data) {
        this.a.addAll(0, data);
        notifyItemRangeInserted(0, data.size());
    }

    public void a(long tempMessageId, boolean success, boolean delete, Message newMessage) {
        for (int i = 0; i < this.a.size(); i++) {
            Message message = (Message) this.a.get(i);
            if (message.messageTempId == tempMessageId) {
                if (success && newMessage != null) {
                    this.a.set(i, newMessage);
                } else if (delete) {
                    this.a.remove(i);
                    notifyItemRemoved(i);
                    return;
                } else {
                    message.failedSend = true;
                    this.a.set(i, message);
                }
                notifyItemChanged(i);
            }
        }
    }

    public boolean b(int messageId) {
        for (Message message : this.a) {
            if (messageId == message.message_id) {
                return true;
            }
        }
        return false;
    }

    public void a(int position, List<Message> data) {
        this.a.addAll(position, data);
    }
}
