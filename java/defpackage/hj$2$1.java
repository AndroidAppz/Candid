package defpackage;

import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import com.becandid.candid.models.EmptySubscriber;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

/* compiled from: MessageThreadsAdapter */
class hj$2$1 implements OnMenuItemClickListener {
    final /* synthetic */ hj$2 a;

    hj$2$1(hj$2 this$1) {
        this.a = this$1;
    }

    public boolean onMenuItemClick(MenuItem item) {
        Map<String, String> params = new HashMap();
        int postId = this.a.a.post_id;
        String userName = this.a.a.target_user_info.post_name;
        params.put("post_id", Integer.toString(postId));
        params.put("post_name", userName);
        switch (item.getItemId()) {
            case 2131624785:
                if (this.a.a.is_request == 1) {
                    ie.a().r(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                } else {
                    ie.a().t(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                }
                iq.a().a(new ih$j(postId, userName));
                return true;
            default:
                return false;
        }
    }
}
