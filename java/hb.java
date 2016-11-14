/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.text.SpannableString
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.StyleSpan
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.FullScreenImageActivity;
import com.becandid.candid.data.Notification;
import java.util.List;

public class hb
extends hd<Notification> {
    private ii d = ii.a();
    private Context e;

    public hb(Context context) {
        this.e = context;
    }

    public ja a(ViewGroup viewGroup, int n2) {
        return new ja(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968703, viewGroup, false));
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(iv iv2, int n2) {
        SpannableString spannableString;
        final ja ja2 = (ja)iv2;
        final Notification notification = (Notification)this.a.get(n2);
        int n3 = this.e.getResources().getIdentifier(notification.action_icon.toLowerCase() + "_activity", "drawable", this.e.getPackageName());
        Drawable drawable = this.e.getResources().getDrawable(n3);
        ja2.g.setImageDrawable(drawable);
        if (notification.user_name != null && !notification.title.startsWith("Someone") && notification.icon_color != null) {
            int n4 = Color.parseColor((String)notification.icon_color);
            String string2 = notification.user_name + " " + notification.title;
            spannableString = new SpannableString((CharSequence)string2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(n4);
            spannableString.setSpan((Object)foregroundColorSpan, 0, notification.user_name.length(), 33);
            spannableString.setSpan((Object)new StyleSpan(1), notification.user_name.length(), string2.length(), 33);
            ja2.h.setVisibility(0);
            TextView textView = ja2.h;
            textView.setTypeface(ii.b());
            ja2.h.setTextColor(n4);
            ja2.h.setText((CharSequence)ii.a(notification.icon_name));
            int n5 = ja2.h.getWidth();
            if (n5 == 0) {
                n5 = (int)(30.0f * ja2.h.getResources().getDisplayMetrics().density);
            }
            int n6 = 1073741824 | 16777215 & n4;
            ja2.j.setColor(n6);
            ja2.j.setCornerRadius((float)(n5 / 2));
            ja2.h.setBackground((Drawable)ja2.j);
        } else {
            ja2.h.setVisibility(8);
            String string3 = notification.title;
            spannableString = new SpannableString((CharSequence)string3);
            spannableString.setSpan((Object)new StyleSpan(1), 0, string3.length(), 33);
        }
        ja2.a.setText((CharSequence)spannableString);
        if (notification.sticker_name != null) {
            ja2.m.setVisibility(0);
            int n7 = this.e.getResources().getIdentifier(notification.sticker_name.toLowerCase(), "drawable", this.e.getPackageName());
            Drawable drawable2 = this.e.getResources().getDrawable(n7);
            ja2.i.setImageDrawable(drawable2);
            ja2.i.setVisibility(0);
            if ("".equals((Object)notification.body)) {
                ja2.b.setVisibility(8);
            } else {
                ja2.b.setText((CharSequence)notification.body);
                ja2.b.setVisibility(0);
            }
        } else {
            ja2.m.setVisibility(8);
            if (notification.body == null || "".equals((Object)notification.body)) {
                ja2.b.setVisibility(8);
            } else {
                ja2.b.setText((CharSequence)notification.body);
                ja2.b.setVisibility(0);
            }
        }
        if (notification.source_url != null) {
            ja2.c.setVisibility(0);
            float f2 = this.e.getResources().getDisplayMetrics().density;
            FrameLayout.LayoutParams layoutParams = notification.image_width > 250 || notification.image_height > 250 ? new FrameLayout.LayoutParams((int)(0.05f + 250.0f * f2), (int)(0.05f + 250.0f * f2)) : new FrameLayout.LayoutParams((int)(0.05f + f2 * (float)notification.image_width), (int)(0.05f + f2 * (float)notification.image_height));
            ja2.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            ja2.c.setBackgroundResource(17301613);
            jl<String> jl2 = GossipApplication.c.a(notification.source_url).d();
            px<String, nz> px2 = new px<String, nz>(){

                public boolean a(Exception exception, String string2, qq<nz> qq2, boolean bl2) {
                    return false;
                }

                public boolean a(nz nz2, String string2, qq<nz> qq2, boolean bl2, boolean bl3) {
                    ja2.c.setBackground(null);
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
            jl2.a(px2).a(ja2.c);
            ImageView imageView = ja2.c;
            View.OnClickListener onClickListener = new View.OnClickListener(){

                public void onClick(View view) {
                    Intent intent = new Intent(hb.this.e, (Class)FullScreenImageActivity.class);
                    intent.putExtra("source_url", notification.source_url);
                    if (notification.onclick.split("/")[0].equals((Object)"post")) {
                        hb.this.e.startActivity(intent);
                    }
                }
            };
            imageView.setOnClickListener(onClickListener);
        } else {
            ja2.c.setVisibility(8);
        }
        ja2.d.setText((CharSequence)ij.a(notification.t_create));
        View view = ((ja)iv2).itemView;
        view.measure(View.MeasureSpec.makeMeasureSpec((int)view.getContext().getResources().getDisplayMetrics().widthPixels, (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)0, (int)0));
        if (notification.unread == 1) {
            ja2.a.setTypeface(Typeface.DEFAULT_BOLD);
            ja2.k.setBackgroundColor(268435456 | 16777215 & this.e.getResources().getColor(2131558476));
            return;
        }
        ja2.k.setBackgroundColor(this.e.getResources().getColor(17170443));
    }

    @Override
    public /* synthetic */ iv b(ViewGroup viewGroup, int n2) {
        return this.a(viewGroup, n2);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        this.a((iv)viewHolder, n2);
    }

    @Override
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return this.a(viewGroup, n2);
    }

}

