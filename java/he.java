/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnShowListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.support.v7.widget.PopupMenu
 *  android.support.v7.widget.PopupMenu$OnMenuItemClickListener
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.text.SpannableString
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.ContentEditActivity;
import com.becandid.candid.activities.FullScreenImageActivity;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Comment;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import com.becandid.candid.views.viewholders.ImagePostViewHolder;
import com.becandid.candid.views.viewholders.LinkPostViewHolder;
import com.becandid.candid.views.viewholders.TextPostViewHolder;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import rx.schedulers.Schedulers;

public class he
extends hd<Comment> {
    private ii d;
    private Post e;
    private Context f;
    private Handler g;
    private int h = 10;
    private int i = 16;
    private int j = 30;

    public he(List<Comment> list, Post post, Context context) {
        this.a = list;
        this.e = post;
        this.d = ii.a();
        this.f = context;
        this.g = new Handler(context.getMainLooper());
        apk apk2 = iq.a().a(ih.al.class, new apj<ih.al>(){

            public void a(ih.al al2) {
                he.this.a(al2.a, al2);
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
                this.a((ih.al)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(apk2);
        apk apk3 = iq.a().a(ih.l.class, new apj<ih.l>(){

            public void a(ih.l l2) {
                he.this.c(l2.a);
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
                this.a((ih.l)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(apk3);
        apk apk4 = iq.a().a(ih.s.class, new apj<ih.s>(){

            public void a(ih.s s2) {
                he.this.c(s2.a);
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
                this.a((ih.s)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(apk4);
        apk apk5 = iq.a().a(ih.g.class, new apj<ih.g>(){

            public void a(ih.g g2) {
                he.this.a(g2.a, g2.b, g2.c);
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
                this.a((ih.g)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(apk5);
        apk apk6 = iq.a().a(ih.ae.class, new apj<ih.ae>(){

            public void a(ih.ae ae2) {
                iu.a(ae2.a, ae2.d, ae2.b);
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
                this.a((ih.ae)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(apk6);
        apk apk7 = iq.a().a(ih.h.class, new apj<ih.h>(){

            public void a(ih.h h2) {
                iu.b(h2.a, h2.b, h2.c);
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
                this.a((ih.h)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(apk7);
        apk apk8 = iq.a().a(ih.i.class, new apj<ih.i>(){

            public void a(ih.i i2) {
                iu.a(i2.a, i2.d, i2.b, i2.c);
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
                this.a((ih.i)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(apk8);
    }

    private void a(int n2, ih.al al2) {
        int n3 = this.b(n2);
        if (n3 != -1) {
            Comment comment = (Comment)this.a.get(n3);
            comment.like_value = al2.b;
            comment.num_likes = al2.c;
            comment.num_dislikes = al2.d;
            this.notifyItemChanged(n3 + 1);
        }
    }

    private void a(int n2, String string2, String string3) {
        int n3 = this.b(n2);
        if (n3 != -1) {
            Comment comment = (Comment)this.a.get(n3);
            comment.comment_text = string2;
            comment.mentioned_groups_info = string3;
            this.notifyItemChanged(n3 + 1);
        }
    }

    static /* synthetic */ Post b(he he2) {
        return he2.e;
    }

    private void c(int n2) {
        int n3 = this.b(n2);
        if (n3 != -1) {
            this.a.remove(n3);
            this.notifyItemRemoved(n3 + 1);
        }
    }

    @Override
    public void a(Comment comment) {
        this.a.add((Object)comment);
        this.notifyItemInserted(this.a.size());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void a(iv var1, final int var2_2) {
        if (var1 == null) {
            return;
        }
        if (var2_2 == 0) {
            if (var1 instanceof TextPostViewHolder) {
                TextPostViewHolder.a((TextPostViewHolder)var1, this.e);
                return;
            }
            if (var1 instanceof ImagePostViewHolder) {
                ImagePostViewHolder.a((ImagePostViewHolder)var1, this.e);
                return;
            }
            if (var1 instanceof LinkPostViewHolder == false) return;
            LinkPostViewHolder.a((LinkPostViewHolder)var1, this.e);
            return;
        }
        var3_3 = (iw)var1;
        var4_4 = (Comment)this.a.get(var2_2 - 1);
        if (var4_4 == null) return;
        if (var4_4.is_master_comment) {
            var53_5 = (RelativeLayout.LayoutParams)var3_3.w.getLayoutParams();
            var53_5.setMargins(0, iu.a(this.h, this.f), 0, 0);
            var3_3.w.setLayoutParams((ViewGroup.LayoutParams)var53_5);
            this.i = 16;
            this.j = 30;
        } else {
            var5_6 = (RelativeLayout.LayoutParams)var3_3.w.getLayoutParams();
            var5_6.setMargins(iu.a(35, this.f), 0, 0, 0);
            var3_3.w.setLayoutParams((ViewGroup.LayoutParams)var5_6);
            this.i = 15;
            this.j = 24;
        }
        var6_7 = var4_4.user != null ? var4_4.user.user_name : (var4_4.user_name != null ? var4_4.user_name : "");
        var3_3.s = var4_4.comment_id;
        var3_3.t = var4_4.like_value;
        var3_3.a.setText((CharSequence)var6_7);
        var7_8 = Color.parseColor((String)var4_4.icon_color);
        var3_3.a.setTextColor(var7_8);
        var3_3.a.setTextSize((float)this.i);
        var8_9 = new jh();
        var9_10 = iu.a(10, this.f);
        var10_11 = iu.a(6, this.f);
        var8_9.setBounds(0, iu.a(1, this.f), var9_10, var10_11);
        var8_9.a(var7_8);
        var3_3.a.setCompoundDrawables(null, null, (Drawable)var8_9, null);
        var11_12 = var3_3.a;
        var12_13 = new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    /*
                     * Unable to fully structure code
                     * Enabled aggressive block sorting
                     * Lifted jumps to return sites
                     */
                    public boolean onMenuItemClick(MenuItem var1) {
                        switch (var1.getItemId()) {
                            case 2131624762: {
                                var12_2 = new Intent(he.a(15.this.he.this), (Class)ContentEditActivity.class);
                                var12_2.putExtra("comment_text", 15.this.var4_4.comment_text);
                                var12_2.putExtra("comment_id", 15.this.var4_4.comment_id);
                                if (15.this.var4_4.mentioned_groups_info != null) {
                                    var12_2.putExtra("group_tags", 15.this.var4_4.mentioned_groups_info);
                                }
                                ((PostDetailsActivity)he.a(15.this.he.this)).startActivityForResult(var12_2, 203);
                                ** break;
                            }
                            case 2131624763: {
                                iu.a(he.a(15.this.he.this), "Delete this comment?", "Once you delete this comment you can never see it again.", "Yes", "No", 16843605, false, new ih.h(he.a(15.this.he.this), 15.this.var4_4.comment_id, 15.this.var4_4.post_id)).show();
                                ** break;
                            }
                            case 2131624765: {
                                var10_3 = iu.a(he.a(15.this.he.this), "Report This Comment?", null, "Report Comment", "Cancel", -1, true, new ih.ae(he.a(15.this.he.this), 15.this.var4_4.comment_id)).create();
                                var10_3.setOnShowListener(new DialogInterface.OnShowListener(){

                                    public void onShow(DialogInterface dialogInterface) {
                                        ((AlertDialog)dialogInterface).getButton(-1).setEnabled(false);
                                    }
                                });
                                var10_3.show();
                                ** break;
                            }
                            case 2131624766: {
                                var9_4 = iu.a(he.a(15.this.he.this), "Delete this comment?", null, "Delete Comment", "Cancel", 16843605, true, new ih.i(he.a(15.this.he.this), 15.this.var4_4.comment_id, 15.this.var4_4.post_id)).create();
                                var9_4.setOnShowListener(new DialogInterface.OnShowListener(){

                                    public void onShow(DialogInterface dialogInterface) {
                                        ((AlertDialog)dialogInterface).getButton(-1).setEnabled(false);
                                    }
                                });
                                var9_4.show();
                            }
lbl22: // 5 sources:
                            default: {
                                return true;
                            }
                            case 2131624764: 
                        }
                        if (15.this.var4_4.messaging_blocked != null) {
                            new AlertDialog.Builder(he.a(15.this.he.this)).setMessage((CharSequence)15.this.var4_4.messaging_blocked).setPositiveButton(2131230891, null).show();
                            return true;
                        }
                        if (15.this.var4_4.messaging_disabled != null) {
                            new AlertDialog.Builder(he.a(15.this.he.this)).setMessage((CharSequence)15.this.var4_4.messaging_disabled).setPositiveButton(2131230891, null).show();
                            return true;
                        }
                        var2_5 = new Intent(he.a(15.this.he.this), (Class)MessageActivity.class);
                        var2_5.putExtra("post_id", Integer.toString((int)he.b((he)15.this.he.this).post_id));
                        if (15.this.var4_4.user != null) {
                            var2_5.putExtra("user_name", 15.this.var4_4.user.user_name);
                        } else {
                            var2_5.putExtra("user_name", 15.this.var4_4.user_name);
                        }
                        var2_5.putExtra("comment_id", Integer.toString((int)15.this.var4_4.comment_id));
                        he.a(15.this.he.this).startActivity(var2_5);
                        return true;
                    }

                });
                if (var4_4.thats_me == 1) {
                    if (!var4_4.comment_text.equals((Object)"")) {
                        popupMenu.getMenu().add(1, 2131624762, 0, 2131230832);
                    }
                    popupMenu.getMenu().add(1, 2131624763, 0, 2131230825);
                } else if (he.b((he)he.this).group_id != 0 && AppState.isGroupModerator(he.b((he)he.this).group_id)) {
                    popupMenu.getMenu().add(1, 2131624766, 0, 2131230825);
                } else {
                    if (AppState.config.getBoolean("messaging_turned_on", true) && var4_4.thats_me != 1) {
                        popupMenu.getMenu().add(1, 2131624764, 0, 2131230875);
                    }
                    if (he.b((he)he.this).group_id != 0 && AppState.isGroupModerator(he.b((he)he.this).group_id)) {
                        popupMenu.getMenu().add(1, 2131624766, 0, 2131230825);
                    } else {
                        popupMenu.getMenu().add(1, 2131624765, 0, 2131230906);
                    }
                }
                popupMenu.show();
            }

        };
        var11_12.setOnClickListener(var12_13);
        if (var4_4.is_candid_mod == 1) {
            var3_3.c.setVisibility(0);
            var50_14 = (RelativeLayout.LayoutParams)var3_3.c.getLayoutParams();
            var50_14.width = iu.a(this.j, this.f);
            var50_14.height = iu.a(this.j, this.f);
            var3_3.c.setLayoutParams((ViewGroup.LayoutParams)var50_14);
            var51_15 = var3_3.c;
            var52_16 = new View.OnClickListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onClick(View view) {
                    if (var4_4.messaging_blocked != null) {
                        new AlertDialog.Builder(he.this.f).setMessage((CharSequence)var4_4.messaging_blocked).setPositiveButton(2131230891, null).show();
                        return;
                    }
                    if (var4_4.messaging_disabled != null) {
                        new AlertDialog.Builder(he.this.f).setMessage((CharSequence)var4_4.messaging_disabled).setPositiveButton(2131230891, null).show();
                        return;
                    }
                    if (!AppState.hasMessagedFromAlert) {
                        new AlertDialog.Builder(he.this.f).setTitle((CharSequence)"Message User?").setMessage((CharSequence)"Would you like to send this user a message?").setNegativeButton((CharSequence)he.this.f.getResources().getString(2131230887), null).setPositiveButton((CharSequence)he.this.f.getResources().getString(2131230945), new DialogInterface.OnClickListener(){

                            /*
                             * Enabled aggressive block sorting
                             */
                            public void onClick(DialogInterface dialogInterface, int n2) {
                                Intent intent = new Intent(he.this.f, (Class)MessageActivity.class);
                                intent.putExtra("post_id", Integer.toString((int)he.b((he)he.this).post_id));
                                if (var4_4.user != null) {
                                    intent.putExtra("user_name", var4_4.user.user_name);
                                } else {
                                    intent.putExtra("user_name", var4_4.user_name);
                                }
                                intent.putExtra("comment_id", Integer.toString((int)var4_4.comment_id));
                                he.this.f.startActivity(intent);
                            }
                        }).create().show();
                        AppState.hasMessagedFromAlert = true;
                        AppState.saveState((ContextWrapper)GossipApplication.a());
                        return;
                    }
                    Intent intent = new Intent(he.this.f, (Class)MessageActivity.class);
                    intent.putExtra("post_id", Integer.toString((int)he.b((he)he.this).post_id));
                    if (var4_4.user != null) {
                        intent.putExtra("user_name", var4_4.user.user_name);
                    } else {
                        intent.putExtra("user_name", var4_4.user_name);
                    }
                    intent.putExtra("comment_id", Integer.toString((int)var4_4.comment_id));
                    he.this.f.startActivity(intent);
                }

            };
            var51_15.setOnClickListener(var52_16);
            var3_3.b.setVisibility(8);
        } else {
            var3_3.b.setVisibility(0);
            var3_3.b.setTextColor(var7_8);
            var13_18 = var3_3.b;
            var13_18.setTypeface(ii.b());
            var3_3.b.setText((CharSequence)ii.a(var4_4.icon_name));
            var15_20 = (RelativeLayout.LayoutParams)var3_3.b.getLayoutParams();
            var15_20.width = iu.a(this.j, this.f);
            var15_20.height = iu.a(this.j, this.f);
            var3_3.b.setLayoutParams((ViewGroup.LayoutParams)var15_20);
            var3_3.b.setTextSize((float)this.j);
            var16_22 = var3_3.b.getWidth();
            if (var16_22 == 0) {
                var16_22 = (int)(var3_3.b.getResources().getDisplayMetrics().density * (float)this.j);
            }
            var17_21 = 1073741824 | 16777215 & var7_8;
            var3_3.d.setColor(var17_21);
            var3_3.d.setCornerRadius((float)(var16_22 / 2));
            var3_3.b.setBackground((Drawable)var3_3.d);
            if (AppState.config.getBoolean("messaging_turned_on", true) && var4_4.thats_me != 1) {
                var48_19 = var3_3.b;
                var49_17 = new View.OnClickListener(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public void onClick(View view) {
                        if (var4_4.messaging_blocked != null) {
                            new AlertDialog.Builder(he.this.f).setMessage((CharSequence)var4_4.messaging_blocked).setPositiveButton(2131230891, null).show();
                            return;
                        }
                        if (var4_4.messaging_disabled != null) {
                            new AlertDialog.Builder(he.this.f).setMessage((CharSequence)var4_4.messaging_disabled).setPositiveButton(2131230891, null).show();
                            return;
                        }
                        if (!AppState.hasMessagedFromAlert) {
                            new AlertDialog.Builder(he.this.f).setTitle((CharSequence)"Message User?").setMessage((CharSequence)"Would you like to send this user a message?").setNegativeButton((CharSequence)he.this.f.getResources().getString(2131230887), null).setPositiveButton((CharSequence)he.this.f.getResources().getString(2131230945), new DialogInterface.OnClickListener(){

                                /*
                                 * Enabled aggressive block sorting
                                 */
                                public void onClick(DialogInterface dialogInterface, int n2) {
                                    Intent intent = new Intent(he.this.f, (Class)MessageActivity.class);
                                    intent.putExtra("post_id", Integer.toString((int)he.b((he)he.this).post_id));
                                    if (var4_4.user != null) {
                                        intent.putExtra("user_name", var4_4.user.user_name);
                                    } else {
                                        intent.putExtra("user_name", var4_4.user_name);
                                    }
                                    intent.putExtra("comment_id", Integer.toString((int)var4_4.comment_id));
                                    he.this.f.startActivity(intent);
                                }
                            }).create().show();
                            AppState.hasMessagedFromAlert = true;
                            AppState.saveState((ContextWrapper)GossipApplication.a());
                            return;
                        }
                        Intent intent = new Intent(he.this.f, (Class)MessageActivity.class);
                        intent.putExtra("post_id", Integer.toString((int)he.b((he)he.this).post_id));
                        if (var4_4.user != null) {
                            intent.putExtra("user_name", var4_4.user.user_name);
                        } else {
                            intent.putExtra("user_name", var4_4.user_name);
                        }
                        intent.putExtra("comment_id", Integer.toString((int)var4_4.comment_id));
                        he.this.f.startActivity(intent);
                    }

                };
                var48_19.setOnClickListener(var49_17);
            }
            var3_3.c.setVisibility(8);
        }
        if (var4_4.is_op == 1 || var4_4.is_friend == 1 || var4_4.thats_me == 1 || var4_4.is_candid_mod == 1) {
            var3_3.g.setVisibility(0);
            var3_3.g.setTextColor(Color.parseColor((String)var4_4.icon_color));
            var3_3.g.setBackground(null);
            if (var4_4.is_candid_mod == 1) {
                var3_3.g.setText((CharSequence)"MOD");
                var3_3.g.setTextColor(this.f.getResources().getColor(2131558476));
            } else if (var4_4.thats_me == 1) {
                var3_3.g.setText((CharSequence)"YOU");
                var3_3.g.setTextColor(this.f.getResources().getColor(17170443));
                var3_3.g.setBackground(this.f.getResources().getDrawable(2130838146));
            } else if (var4_4.is_op == 1) {
                var3_3.g.setText((CharSequence)"OP");
            } else if (var4_4.is_friend == 1) {
                var3_3.g.setText((CharSequence)"FRIEND");
            }
        } else {
            var3_3.g.setVisibility(8);
        }
        var3_3.h.setOnFocusChangeListener(null);
        if (PostDetailsActivity.clipped != null && !PostDetailsActivity.clipped.contains((Object)var4_4.comment_id)) {
            var18_23 = iu.a(var4_4.comment_text, 2131558478);
            if (var18_23.toString().endsWith("See More")) {
                var46_24 = var3_3.h;
                var47_25 = new View.OnFocusChangeListener(){

                    public void onFocusChange(View view, boolean bl2) {
                        if (bl2) {
                            new Handler().post(new Runnable(){

                                public void run() {
                                    var3_3.h.setOnFocusChangeListener(null);
                                    PostDetailsActivity.clipped.add((Object)var4_4.comment_id);
                                    he.this.notifyItemChanged(var2_2);
                                }
                            });
                        }
                    }

                };
                var46_24.setOnFocusChangeListener(var47_25);
            } else {
                PostDetailsActivity.clipped.add((Object)var4_4.comment_id);
            }
        } else {
            var18_23 = new SpannableString((CharSequence)var4_4.comment_text);
        }
        if (var4_4.sticker_name != null) {
            var44_26 = GossipApplication.a.getResources().getIdentifier(var4_4.sticker_name.toLowerCase(), "drawable", GossipApplication.a.getPackageName());
            var3_3.i.setImageDrawable(GossipApplication.a.getResources().getDrawable(var44_26));
            var3_3.i.setVisibility(0);
        } else {
            var3_3.i.setVisibility(8);
        }
        if (!var4_4.comment_text.equals((Object)"")) ** GOTO lbl117
        var3_3.h.setVisibility(8);
        ** GOTO lbl121
lbl117: // 1 sources:
        if (AppState.config.getInt("disable_group_tagging", 0) != 0 || var4_4.mentioned_groups_info == null) ** GOTO lbl191
        var36_41 = var4_4.mentioned_groups_info.split(";");
        var37_42 = var36_41.length;
        ** GOTO lbl180
lbl121: // 2 sources:
        do {
            if (var4_4.source_url != null) {
                var3_3.j.setVisibility(0);
                var25_27 = this.f.getResources().getDisplayMetrics().density;
                if (var4_4.image_width > 250 || var4_4.image_height > 250) {
                    var26_28 = (int)(0.05f + 250.0f * var25_27);
                    var27_29 = (int)(0.05f + 250.0f * var25_27);
                    var28_30 = new FrameLayout.LayoutParams(var26_28, var27_29);
                } else {
                    var34_49 = (int)(0.05f + var25_27 * (float)var4_4.image_width);
                    var35_50 = (int)(0.05f + var25_27 * (float)var4_4.image_height);
                    var28_30 = new FrameLayout.LayoutParams(var34_49, var35_50);
                }
                var3_3.j.setLayoutParams((ViewGroup.LayoutParams)var28_30);
                var3_3.j.setBackgroundResource(17301613);
                var29_31 = GossipApplication.c.a(var4_4.source_url).d();
                var30_32 = new px<String, nz>(){

                    public boolean a(Exception exception, String string2, qq<nz> qq2, boolean bl2) {
                        return false;
                    }

                    public boolean a(nz nz2, String string2, qq<nz> qq2, boolean bl2, boolean bl3) {
                        var3_3.j.setBackground(null);
                        return false;
                    }

                    @Override
                    public /* synthetic */ boolean onException(Exception exception, Object object, qq qq2, boolean bl2) {
                        return this.a(exception, (String)object, qq2, bl2);
                    }

                    @Override
                    public /* synthetic */ boolean onResourceReady(Object object, Object object2, qq qq2, boolean bl2, boolean bl3) {
                        return this.a((nz)((Object)object), (String)object2, qq2, bl2, bl3);
                    }
                };
                var29_31.a(var30_32).a(var3_3.j);
                var32_33 = var3_3.j;
                var33_34 = new View.OnClickListener(){

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(he.this.f, (Class)FullScreenImageActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putInt("comment_id", var4_4.comment_id);
                            bundle.putString("source_url", var4_4.source_url);
                            bundle.putInt("num_likes", var4_4.num_likes);
                            bundle.putInt("num_dislikes", var4_4.num_dislikes);
                            bundle.putString("icon_name", var4_4.icon_name);
                            bundle.putString("icon_color", var4_4.icon_color);
                            if (var4_4.user != null) {
                                bundle.putString("user_name", var4_4.user.user_name);
                            } else {
                                bundle.putString("user_name", var4_4.user_name);
                            }
                            bundle.putInt("like_value", var4_4.like_value);
                            bundle.putBoolean("fromDetails", true);
                            bundle.putInt("thats_me", var4_4.thats_me);
                            intent.putExtras(bundle);
                            ((Activity)he.this.f).startActivityForResult(intent, 198);
                            return;
                        }
                        catch (NullPointerException var4_42) {
                            Toast.makeText((Context)he.this.f, (CharSequence)"This image is currently unavailable, please try again later", (int)1).show();
                            rb.a((Throwable)var4_42);
                            return;
                        }
                    }
                };
                var32_33.setOnClickListener(var33_34);
            } else {
                var3_3.j.setVisibility(8);
            }
            var3_3.k.setText((CharSequence)var4_4.comment_time_ago);
            if (var4_4.like_value == -1) {
                var3_3.o.setSelected(true);
                var3_3.l.setSelected(false);
            } else if (var4_4.like_value == 1) {
                var3_3.l.setSelected(true);
                var3_3.o.setSelected(false);
            } else {
                var3_3.l.setSelected(false);
                var3_3.o.setSelected(false);
            }
            var3_3.n.setText((CharSequence)Integer.toString((int)var4_4.num_likes));
            var3_3.q.setText((CharSequence)Integer.toString((int)var4_4.num_dislikes));
            var19_35 = var3_3.m;
            var20_36 = new View.OnClickListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onClick(View view) {
                    int n2;
                    ih.al al2;
                    if (var3_3.l.isSelected()) {
                        n2 = 0;
                        al2 = new ih.al(var4_4.comment_id, 0, -1 + var4_4.num_likes, var4_4.num_dislikes);
                    } else {
                        n2 = 1;
                        al2 = var3_3.o.isSelected() ? new ih.al(var4_4.comment_id, n2, 1 + var4_4.num_likes, -1 + var4_4.num_dislikes) : new ih.al(var4_4.comment_id, n2, 1 + var4_4.num_likes, var4_4.num_dislikes);
                    }
                    iq.a().a(al2);
                    ie.a().a(var4_4.comment_id, n2).b(Schedulers.io()).a(apn.a()).b(new apj<EmptyClass>(){

                        public void a(EmptyClass emptyClass) {
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
                            this.a((EmptyClass)object);
                        }
                    });
                }

            };
            var19_35.setOnClickListener(var20_36);
            var21_37 = var3_3.p;
            var22_38 = new View.OnClickListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onClick(View view) {
                    int n2;
                    ih.al al2;
                    if (var3_3.o.isSelected()) {
                        n2 = 0;
                        al2 = new ih.al(var4_4.comment_id, 0, var4_4.num_likes, -1 + var4_4.num_dislikes);
                    } else {
                        n2 = -1;
                        al2 = var3_3.l.isSelected() ? new ih.al(var4_4.comment_id, n2, -1 + var4_4.num_likes, 1 + var4_4.num_dislikes) : new ih.al(var4_4.comment_id, n2, var4_4.num_likes, 1 + var4_4.num_dislikes);
                    }
                    iq.a().a(al2);
                    ie.a().a(var4_4.comment_id, n2).b(Schedulers.io()).a(apn.a()).b(new apj<EmptyClass>(){

                        public void a(EmptyClass emptyClass) {
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
                            this.a((EmptyClass)object);
                        }
                    });
                }

            };
            var21_37.setOnClickListener(var22_38);
            if (var4_4.like_value == 1) {
                var3_3.l.setSelected(true);
                var3_3.o.setSelected(false);
            } else if (var4_4.like_value == -1) {
                var3_3.l.setSelected(false);
                var3_3.o.setSelected(true);
            } else {
                var3_3.l.setSelected(false);
                var3_3.o.setSelected(false);
            }
            if (var4_4.thats_me == 1) {
                var3_3.r.setVisibility(8);
            } else {
                var3_3.r.setVisibility(0);
            }
            var23_39 = var3_3.r;
            var24_40 = new View.OnClickListener(){

                public void onClick(View view) {
                    ((PostDetailsActivity)he.this.f).replyTo(var6_7, Integer.toString((int)var4_4.comment_id), var2_2);
                    new Handler().postDelayed(new Runnable(){

                        public void run() {
                            ((PostDetailsActivity)he.this.f).scrollToComment(var4_4.comment_id);
                        }
                    }, 500);
                }

            };
            var23_39.setOnClickListener(var24_40);
            return;
            break;
        } while (true);
lbl180: // 2 sources:
        for (var38_43 = 0; var38_43 < var37_42; ++var38_43) {
            var39_46 = var36_41[var38_43].split(",");
            var40_47 = Integer.parseInt((String)var39_46[0]);
            var41_44 = Integer.parseInt((String)var39_46[1]);
            var42_45 = Integer.parseInt((String)var39_46[2]);
            if (var18_23.toString().endsWith("See More") && var42_45 >= var18_23.length() || var41_44 >= var18_23.length() || var42_45 > var18_23.length() || var41_44 < 0 || var42_45 <= 0) break;
            try {
                var18_23.setSpan((Object)iu.b("#000000", var40_47, this.f), var41_44, var42_45, 33);
                continue;
            }
            catch (IndexOutOfBoundsException var43_48) {}
            break;
        }
lbl191: // 4 sources:
        var3_3.h.setText((CharSequence)var18_23);
        var3_3.h.setVisibility(0);
        var3_3.h.setTextSize((float)this.i);
        ** while (true)
    }

    public void a(List<Comment> list, Post post) {
        this.e = post;
        this.a.clear();
        this.a.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public int b(int n2) {
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            if (((Comment)this.a.get((int)i2)).comment_id != n2) continue;
            return i2;
        }
        return -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public iv b(ViewGroup viewGroup, int n2) {
        if (n2 == 2) {
            return new ImagePostViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968658, viewGroup, false), (Activity)this.f);
        }
        if (n2 == 3) {
            return new LinkPostViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968659, viewGroup, false), (Activity)this.f);
        }
        if (n2 == 1) {
            return new TextPostViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968660, viewGroup, false), (Activity)this.f);
        }
        ImagePostViewHolder imagePostViewHolder = null;
        if (n2 != 6) return imagePostViewHolder;
        return new iw(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968638, viewGroup, false));
    }

    public void c(List<Comment> list) {
        int n2 = this.a.size();
        this.a.addAll(list);
        this.notifyItemRangeChanged(n2 + 1, 20);
    }

    @Override
    public int getItemCount() {
        return 1 + this.a.size();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public int getItemViewType(int var1) {
        if (var1 != 0) return 6;
        if (this.e == null) {
            return 6;
        }
        var2_2 = this.e.type;
        var3_3 = -1;
        switch (var2_2.hashCode()) {
            case 100313435: {
                if (var2_2.equals((Object)"image")) {
                    var3_3 = 0;
                    ** break;
                }
                ** GOTO lbl15
            }
            case 3321850: {
                if (var2_2.equals((Object)"link")) {
                    var3_3 = 1;
                }
            }
lbl15: // 6 sources:
            default: {
                ** GOTO lbl20
            }
            case 112202875: 
        }
        if (var2_2.equals((Object)"video")) {
            var3_3 = 2;
        }
lbl20: // 4 sources:
        switch (var3_3) {
            default: {
                return 1;
            }
            case 0: {
                return 2;
            }
            case 1: 
            case 2: 
        }
        return 3;
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

