package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.models.EmptySubscriber;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

/* compiled from: MessageViewHolder */
class iz$2$2 implements OnClickListener {
    final /* synthetic */ int[] a;
    final /* synthetic */ String[] b;
    final /* synthetic */ iz$2 c;

    iz$2$2(iz$2 this$0, int[] iArr, String[] strArr) {
        this.c = this$0;
        this.a = iArr;
        this.b = strArr;
    }

    public void onClick(DialogInterface dialog, int which) {
        if (this.a[0] >= 0) {
            Map<String, String> params = new HashMap();
            params.put("message_id", Integer.toString(this.c.a.message_id));
            params.put("reason", this.b[this.a[0]]);
            ie.a().p(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
            params = new HashMap();
            params.put("post_id", Integer.toString(this.c.a.post_id));
            params.put("post_name", this.c.c.post_name);
            ie.a().r(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
            iq.a().a(new ih$j(this.c.a.post_id, this.c.c.post_name));
            ((BaseActivity) this.c.b).finish();
        }
    }
}
