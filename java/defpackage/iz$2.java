package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.User;

/* compiled from: MessageViewHolder */
class iz$2 implements OnMenuItemClickListener {
    final /* synthetic */ Message a;
    final /* synthetic */ Context b;
    final /* synthetic */ User c;

    iz$2(Message message, Context context, User user) {
        this.a = message;
        this.b = context;
        this.c = user;
    }

    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case 2131624782:
                ((ClipboardManager) this.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Candid Message", this.a.message));
                break;
            case 2131624783:
                GossipApplication.c.a(this.a.source_url).j().a(new iz$2$1(this));
                break;
            case 2131624784:
                int[] reasonPos = new int[]{-1};
                String[] chars = new String[]{this.b.getString(2131230889), this.b.getString(2131230922), this.b.getString(2131230854)};
                String[] reportString = new String[]{"nsfw", "spam", "hate"};
                Builder builder = new Builder(this.b);
                builder.setTitle(this.b.getString(2131230943)).setSingleChoiceItems(chars, -1, new iz$2$3(this, reasonPos)).setPositiveButton(2131230891, new iz$2$2(this, reasonPos, reportString)).setNegativeButton("Cancel", null);
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new iz$2$4(this, reasonPos));
                dialog.show();
                return true;
        }
        return false;
    }
}
