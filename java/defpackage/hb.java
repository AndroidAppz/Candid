package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.Notification;

/* compiled from: ActivityAdapter */
public class hb extends hd<Notification> {
    private ii d = ii.a();
    private Context e;

    public /* synthetic */ iv b(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((iv) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public hb(Context context) {
        this.e = context;
    }

    public ja a(ViewGroup viewGroup, int i) {
        return new ja(LayoutInflater.from(viewGroup.getContext()).inflate(2130968703, viewGroup, false));
    }

    public void a(iv holder, int i) {
        Spannable spannable;
        ja notyHolder = (ja) holder;
        Notification currItem = (Notification) this.a.get(i);
        notyHolder.g.setImageDrawable(this.e.getResources().getDrawable(this.e.getResources().getIdentifier(currItem.action_icon.toLowerCase() + "_activity", "drawable", this.e.getPackageName())));
        String caption;
        if (currItem.user_name == null || currItem.title.startsWith("Someone") || currItem.icon_color == null) {
            notyHolder.h.setVisibility(8);
            caption = currItem.title;
            spannable = new SpannableString(caption);
            spannable.setSpan(new StyleSpan(1), 0, caption.length(), 33);
        } else {
            int userIconColor = Color.parseColor(currItem.icon_color);
            caption = currItem.user_name + " " + currItem.title;
            spannable = new SpannableString(caption);
            spannable.setSpan(new ForegroundColorSpan(userIconColor), 0, currItem.user_name.length(), 33);
            spannable.setSpan(new StyleSpan(1), currItem.user_name.length(), caption.length(), 33);
            notyHolder.h.setVisibility(0);
            TextView textView = notyHolder.h;
            ii iiVar = this.d;
            textView.setTypeface(ii.b());
            notyHolder.h.setTextColor(userIconColor);
            notyHolder.h.setText(ii.a(currItem.icon_name));
            int iconWidth = notyHolder.h.getWidth();
            if (iconWidth == 0) {
                iconWidth = (int) (notyHolder.h.getResources().getDisplayMetrics().density * 30.0f);
            }
            notyHolder.j.setColor((16777215 & userIconColor) | 1073741824);
            notyHolder.j.setCornerRadius((float) (iconWidth / 2));
            notyHolder.h.setBackground(notyHolder.j);
        }
        notyHolder.a.setText(spannable);
        if (currItem.sticker_name != null) {
            notyHolder.m.setVisibility(0);
            notyHolder.i.setImageDrawable(this.e.getResources().getDrawable(this.e.getResources().getIdentifier(currItem.sticker_name.toLowerCase(), "drawable", this.e.getPackageName())));
            notyHolder.i.setVisibility(0);
            if ("".equals(currItem.body)) {
                notyHolder.b.setVisibility(8);
            } else {
                notyHolder.b.setText(currItem.body);
                notyHolder.b.setVisibility(0);
            }
        } else {
            notyHolder.m.setVisibility(8);
            if (currItem.body == null || "".equals(currItem.body)) {
                notyHolder.b.setVisibility(8);
            } else {
                notyHolder.b.setText(currItem.body);
                notyHolder.b.setVisibility(0);
            }
        }
        if (currItem.source_url != null) {
            LayoutParams imageLayout;
            notyHolder.c.setVisibility(0);
            float scale = this.e.getResources().getDisplayMetrics().density;
            if (currItem.image_width > 250 || currItem.image_height > 250) {
                imageLayout = new LayoutParams((int) ((250.0f * scale) + 0.05f), (int) ((250.0f * scale) + 0.05f));
            } else {
                imageLayout = new LayoutParams((int) ((((float) currItem.image_width) * scale) + 0.05f), (int) ((((float) currItem.image_height) * scale) + 0.05f));
            }
            notyHolder.c.setLayoutParams(imageLayout);
            notyHolder.c.setBackgroundResource(17301613);
            GossipApplication.c.a(currItem.source_url).d().a(new hb$1(this, notyHolder)).a(notyHolder.c);
            notyHolder.c.setOnClickListener(new hb$2(this, currItem));
        } else {
            notyHolder.c.setVisibility(8);
        }
        notyHolder.d.setText(ij.a(currItem.t_create));
        View itemView = ((ja) holder).itemView;
        itemView.measure(MeasureSpec.makeMeasureSpec(itemView.getContext().getResources().getDisplayMetrics().widthPixels, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        if (currItem.unread == 1) {
            notyHolder.a.setTypeface(Typeface.DEFAULT_BOLD);
            notyHolder.k.setBackgroundColor((this.e.getResources().getColor(2131558476) & 16777215) | 268435456);
            return;
        }
        notyHolder.k.setBackgroundColor(this.e.getResources().getColor(17170443));
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
