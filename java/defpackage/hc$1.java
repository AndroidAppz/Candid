package defpackage;

import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.data.AppState;
import com.becandid.thirdparty.BlurTask;

/* compiled from: AllBadgesAdapter */
class hc$1 implements OnClickListener {
    final /* synthetic */ ib$a a;
    final /* synthetic */ hc b;

    hc$1(hc this$0, ib$a ib_a) {
        this.b = this$0;
        this.a = ib_a;
    }

    public void onClick(View v) {
        if (!AppState.blurTaskCalledOnFlight) {
            AppState.blurTaskCalledOnFlight = true;
            new BlurTask(this.b.b, 2131624267, this.a.a).execute(new Void[0]);
        }
    }
}
