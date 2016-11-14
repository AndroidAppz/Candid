package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.util.StateSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.User;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/* compiled from: MessageViewHolder */
public class iz extends iv {
    public static ii m;
    public RelativeLayout a;
    public TextView b;
    public TextView c;
    public LinearLayout d;
    public TextView g;
    public ImageView h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public int l;

    public iz(View itemView, int messageType) {
        super(itemView);
        m = ii.a();
        this.l = messageType;
        this.c = (TextView) itemView.findViewById(2131624489);
        this.g = (TextView) itemView.findViewById(2131624496);
        this.h = (ImageView) itemView.findViewById(2131624493);
        this.i = (ImageView) itemView.findViewById(2131624494);
        this.j = (TextView) itemView.findViewById(2131624495);
        this.d = (LinearLayout) itemView.findViewById(2131624492);
        if (messageType == 0) {
            this.k = (TextView) itemView.findViewById(2131624497);
            return;
        }
        this.a = (RelativeLayout) itemView.findViewById(2131624490);
        this.b = (TextView) itemView.findViewById(2131624491);
    }

    public static void a(iz messageHolder, Message message, Message prevMessage, User userInfo, User targetUserInfo, boolean showTimeHeader, Context context, hk messagesAdapter) {
        if (showTimeHeader) {
            messageHolder.c.setVisibility(0);
            messageHolder.c.setText(ij.a(message.sent_time));
        } else {
            messageHolder.c.setVisibility(8);
        }
        messageHolder.i.setOnClickListener(new iz$1(context, message));
        GradientDrawable messageBackground;
        GradientDrawable messagePressed;
        Drawable states;
        switch (messageHolder.l) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                messageBackground = (GradientDrawable) context.getResources().getDrawable(2130838049).mutate();
                messageBackground.setColor(context.getResources().getColor(2131558476));
                messagePressed = (GradientDrawable) context.getResources().getDrawable(2130838049).mutate();
                messagePressed.setColor(context.getResources().getColor(2131558477));
                states = new StateListDrawable();
                states.addState(new int[]{16842919}, messagePressed);
                states.addState(StateSet.WILD_CARD, messageBackground);
                messageHolder.g.setBackground(states);
                if (message.failedSend) {
                    messageHolder.k.setVisibility(0);
                    messageHolder.i.setOnClickListener(new iz$3(messageHolder, message, context, messagesAdapter));
                    messageHolder.g.setOnClickListener(new iz$4(messageHolder, message, context, messagesAdapter));
                    messageHolder.h.setOnClickListener(new iz$5(messageHolder, message, context, messagesAdapter));
                } else {
                    messageHolder.k.setVisibility(8);
                }
                messageHolder.i.setOnLongClickListener(new iz$6(context, message, targetUserInfo));
                messageHolder.g.setOnLongClickListener(new iz$7(context, message, targetUserInfo));
                break;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                messageBackground = (GradientDrawable) context.getResources().getDrawable(2130838049).mutate();
                int color = Color.parseColor("#DDDDDD");
                messageBackground.setColor(color);
                messagePressed = (GradientDrawable) context.getResources().getDrawable(2130838049).mutate();
                messagePressed.setColor(-7829368 & color);
                states = new StateListDrawable();
                states.addState(new int[]{16842919}, messagePressed);
                states.addState(StateSet.WILD_CARD, messageBackground);
                messageHolder.g.setBackground(states);
                if (prevMessage == null || prevMessage.sender.equals("self") || showTimeHeader) {
                    messageHolder.b.setVisibility(0);
                    color = Color.parseColor(targetUserInfo.icon_color);
                    messageHolder.b.setTextColor(color);
                    TextView textView = messageHolder.b;
                    ii iiVar = m;
                    textView.setTypeface(ii.b());
                    textView = messageHolder.b;
                    iiVar = m;
                    textView.setText(ii.a(targetUserInfo.icon_name));
                    int iconWidth = messageHolder.a.getWidth();
                    if (iconWidth == 0) {
                        iconWidth = (int) (context.getResources().getDisplayMetrics().density * 30.0f);
                    }
                    int gradColor = (16777215 & color) | 1073741824;
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(gradColor);
                    gradientDrawable.setCornerRadius((float) (iconWidth / 2));
                    messageHolder.a.setBackground(gradientDrawable);
                } else {
                    messageHolder.b.setVisibility(8);
                    messageHolder.a.setBackground(null);
                }
                messageHolder.i.setOnLongClickListener(new iz$8(context, message, targetUserInfo));
                messageHolder.g.setOnLongClickListener(new iz$9(context, message, targetUserInfo));
                break;
        }
        if (message.message == null || message.message.equals("")) {
            messageHolder.g.setVisibility(8);
        } else {
            messageHolder.g.setVisibility(0);
            messageHolder.g.setText(message.message);
        }
        if (message.source_url != null) {
            messageHolder.i.setVisibility(0);
            if (message.uploaded == 0 && AppState.config.getInt("android_msg_image_upload", 1) == 1) {
                messageHolder.j.setVisibility(0);
            } else {
                messageHolder.j.setVisibility(8);
            }
            Display display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            LayoutParams imageLayout = new LayoutParams(width / 2, (int) ((((float) message.image_height) * context.getResources().getDisplayMetrics().density) + 0.05f));
            imageLayout.setMargins(0, iu.a(3, context), 0, iu.a(3, context));
            messageHolder.i.setLayoutParams(imageLayout);
            messageHolder.i.setBackgroundResource(17301613);
            jl d = GossipApplication.c.a(message.source_url).d();
            kj[] kjVarArr = new kj[1];
            kjVarArr[0] = new RoundedCornersTransformation(context, iu.a(10, context), 0);
            d.a(kjVarArr).a(new iz$10(messageHolder)).a(DiskCacheStrategy.c).a(messageHolder.i);
        } else {
            messageHolder.i.setVisibility(8);
            messageHolder.j.setVisibility(8);
        }
        if (message.sticker_name != null) {
            messageHolder.h.setImageDrawable(GossipApplication.a.getResources().getDrawable(GossipApplication.a.getResources().getIdentifier(message.sticker_name.toLowerCase(), "drawable", GossipApplication.a.getPackageName())));
            messageHolder.h.setVisibility(0);
            return;
        }
        messageHolder.h.setVisibility(8);
    }

    private static OnMenuItemClickListener b(Message message, Context context, User targerUserInfo) {
        return new iz$2(message, context, targerUserInfo);
    }
}
