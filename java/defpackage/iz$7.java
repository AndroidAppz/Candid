package defpackage;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.User;

/* compiled from: MessageViewHolder */
class iz$7 implements OnLongClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ Message b;
    final /* synthetic */ User c;

    iz$7(Context context, Message message, User user) {
        this.a = context;
        this.b = message;
        this.c = user;
    }

    public boolean onLongClick(View v) {
        PopupMenu messageMenu = new PopupMenu(this.a, v);
        messageMenu.setOnMenuItemClickListener(iz.b(this.b, this.a, this.c));
        messageMenu.getMenu().add(1, 2131624782, 0, 2131230871);
        messageMenu.show();
        return false;
    }
}
