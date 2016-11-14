package defpackage;

import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.becandid.candid.data.MessageThread;

/* compiled from: MessageThreadsAdapter */
class hj$2 implements OnLongClickListener {
    final /* synthetic */ MessageThread a;
    final /* synthetic */ hj b;

    hj$2(hj this$0, MessageThread messageThread) {
        this.b = this$0;
        this.a = messageThread;
    }

    public boolean onLongClick(View v) {
        PopupMenu popupMenu = new PopupMenu(this.b.d, v);
        popupMenu.getMenuInflater().inflate(2131689478, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new hj$2$1(this));
        return true;
    }
}
