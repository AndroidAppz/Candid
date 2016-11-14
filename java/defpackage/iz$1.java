package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.activities.FullScreenImageActivity;
import com.becandid.candid.data.Message;

/* compiled from: MessageViewHolder */
class iz$1 implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ Message b;

    iz$1(Context context, Message message) {
        this.a = context;
        this.b = message;
    }

    public void onClick(View v) {
        Intent intent = new Intent(this.a, FullScreenImageActivity.class);
        intent.putExtra("source_url", this.b.source_url);
        this.a.startActivity(intent);
    }
}
