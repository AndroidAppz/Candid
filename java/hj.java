/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.support.v7.widget.PopupMenu
 *  android.support.v7.widget.PopupMenu$OnMenuItemClickListener
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.util.RoundedCornersTransformation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class hj
extends hd<MessageThread> {
    private Context d;
    private ii e;

    public hj(Context context) {
        this.d = context;
        this.e = ii.a();
    }

    @Override
    public void a(MessageThread messageThread) {
        if (this.a != null) {
            this.a.add(0, (Object)messageThread);
            this.notifyItemInserted(0);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(final iv iv2, int n2) {
        iy iy2 = (iy)iv2;
        final MessageThread messageThread = (MessageThread)this.a.get(n2);
        iy2.a.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(hj.this.d, (Class)MessageActivity.class);
                intent.putExtra("post_id", Integer.toString((int)messageThread.post_id));
                if (messageThread.target_user_info.post_name != null) {
                    intent.putExtra("user_name", messageThread.target_user_info.post_name);
                }
                hj.this.d.startActivity(intent);
                HashMap hashMap = new HashMap();
                hashMap.put((Object)"post_id", (Object)Integer.toString((int)messageThread.post_id));
                if (messageThread.target_user_info.post_name != null) {
                    hashMap.put((Object)"post_name", (Object)messageThread.target_user_info.post_name);
                }
                ie.a().v((Map<String, String>)hashMap).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                int n2 = iv2.getAdapterPosition();
                if (n2 != -1) {
                    ((MessageThread)hj.this.a.get((int)n2)).unread_messages = 0;
                    hj.this.notifyItemChanged(n2);
                }
            }
        });
        iy2.a.setOnLongClickListener(new View.OnLongClickListener(){

            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(hj.this.d, view);
                popupMenu.getMenuInflater().inflate(2131689478, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        HashMap hashMap = new HashMap();
                        int n2 = messageThread.post_id;
                        String string2 = messageThread.target_user_info.post_name;
                        hashMap.put((Object)"post_id", (Object)Integer.toString((int)n2));
                        hashMap.put((Object)"post_name", (Object)string2);
                        switch (menuItem.getItemId()) {
                            default: {
                                return false;
                            }
                            case 2131624785: 
                        }
                        if (messageThread.is_request == 1) {
                            ie.a().r((Map<String, String>)hashMap).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                        } else {
                            ie.a().t((Map<String, String>)hashMap).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                        }
                        iq.a().a(new ih.j(n2, string2));
                        return true;
                    }
                });
                return true;
            }

        });
        int n3 = this.d.getResources().getColor(2131558476);
        try {
            int n4;
            n3 = n4 = Color.parseColor((String)messageThread.target_user_info.icon_color);
        }
        catch (NullPointerException var6_15) {
            rc.c().a((rm)new rm("Display Messaging Thread").a("Thread", messageThread.toString()));
        }
        TextView textView = iy2.b;
        textView.setText((CharSequence)ii.a(messageThread.target_user_info.icon_name));
        TextView textView2 = iy2.b;
        textView2.setTypeface(ii.b());
        iy2.b.setTextColor(n3);
        int n5 = iy2.c.getWidth();
        if (n5 == 0) {
            n5 = iu.a(60, this.d);
        }
        int n6 = 1073741824 | 16777215 & n3;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(n6);
        gradientDrawable.setCornerRadius((float)(n5 / 2));
        iy2.c.setBackground((Drawable)gradientDrawable);
        if (messageThread.online == 1) {
            iy2.d.setVisibility(0);
        } else {
            iy2.d.setVisibility(8);
        }
        iy2.g.setText((CharSequence)messageThread.target_user_info.post_name);
        iy2.g.setTextColor(n3);
        iy2.h.setText((CharSequence)((Message)messageThread.messages.get((int)0)).subject);
        iy2.i.setText((CharSequence)ij.a(messageThread.sent_time));
        if (messageThread.post != null) {
            if (messageThread.post.thumb_url != null) {
                iy2.j.setBackground(null);
                iy2.k.setVisibility(8);
                iy2.m.setVisibility(8);
                iy2.l.setVisibility(0);
                jl<String> jl2 = GossipApplication.c.a(messageThread.post.thumb_url).d();
                kj[] arrkj = new kj[]{new RoundedCornersTransformation(this.d, iu.a(4, this.d), 0)};
                jl2.a(arrkj).a(iy2.l);
            } else {
                iy2.l.setVisibility(8);
                iy2.m.setVisibility(8);
                iy2.k.setVisibility(0);
                iy2.k.setTypeface(ic.a(this.d).a("JosefinSans-SemiBold.ttf"));
                iy2.j.setBackground(this.d.getResources().getDrawable(2130838051));
                ((GradientDrawable)iy2.j.getBackground()).setColor(Color.parseColor((String)messageThread.post.icon_color));
                if (messageThread.post.caption != null) {
                    iy2.k.setText((CharSequence)messageThread.post.caption);
                } else if (messageThread.post.og_title != null) {
                    iy2.k.setText((CharSequence)messageThread.post.og_title);
                }
            }
        } else {
            iy2.l.setVisibility(8);
            iy2.k.setVisibility(8);
            iy2.m.setVisibility(0);
            iy2.j.setBackground(this.d.getResources().getDrawable(2130838051));
            ((GradientDrawable)iy2.j.getBackground()).setColor(Color.parseColor((String)"#DDDDDD"));
        }
        if (messageThread.unread_messages > 0) {
            iy2.a.setBackgroundColor(268435456 | 16777215 & this.d.getResources().getColor(2131558476));
        } else {
            iy2.a.setBackground(this.d.getResources().getDrawable(2130838052));
        }
        apk apk2 = iq.a().a(ih.j.class, new apj<ih.j>(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void a(ih.j j2) {
                if (hj.this.a.isEmpty()) {
                    return;
                }
                int n2 = 0;
                while (n2 < hj.this.a.size()) {
                    MessageThread messageThread = (MessageThread)hj.this.a.get(n2);
                    if (messageThread != null && j2 != null) {
                        try {
                            if (messageThread.post_id == j2.a && messageThread.other_user_post_name.equals((Object)j2.b)) {
                                hj.this.a.remove(n2);
                                hj.this.notifyItemRemoved(n2);
                                return;
                            }
                        }
                        catch (NullPointerException var4_3) {
                            rc.c().a((rm)new rm("Display Messaging Thread").a("Thread", messageThread.toString()));
                        }
                    }
                    ++n2;
                }
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ih.j)object);
            }
        });
        ((BaseActivity)this.d).addToSubscriptionList(apk2);
    }

    public boolean a(ih.ac ac2) {
        if (this.a != null) {
            for (int i2 = 0; i2 < this.a.size(); ++i2) {
                MessageThread messageThread = (MessageThread)this.a.get(i2);
                if (messageThread.post_id != ac2.b || !messageThread.target_user_info.post_name.equals((Object)ac2.d)) continue;
                ((Message)messageThread.messages.get((int)0)).message = ac2.c;
                ((Message)messageThread.messages.get((int)0)).subject = ac2.c;
                ((Message)messageThread.messages.get((int)0)).sent_time = System.currentTimeMillis();
                messageThread.unread_messages = 1 + messageThread.unread_messages;
                this.notifyItemChanged(i2);
                return true;
            }
        }
        return false;
    }

    public MessageThread b(int n2) {
        return (MessageThread)this.a.get(n2);
    }

    @Override
    public iv b(ViewGroup viewGroup, int n2) {
        return new iy(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968690, viewGroup, false));
    }

    @Override
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        this.a((iv)viewHolder, n2);
    }

    @Override
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return this.b(viewGroup, n2);
    }

}

