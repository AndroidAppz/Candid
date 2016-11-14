package defpackage;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.activities.FullScreenImageActivity;
import com.becandid.candid.data.Notification;

/* compiled from: ActivityAdapter */
class hb$2 implements OnClickListener {
    final /* synthetic */ Notification a;
    final /* synthetic */ hb b;

    hb$2(hb this$0, Notification notification) {
        this.b = this$0;
        this.a = notification;
    }

    public void onClick(View v) {
        Intent intent = new Intent(this.b.e, FullScreenImageActivity.class);
        intent.putExtra("source_url", this.a.source_url);
        if (this.a.onclick.split("/")[0].equals("post")) {
            this.b.e.startActivity(intent);
        }
    }
}
