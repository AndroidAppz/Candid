package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.activities.GroupMeSearchActivity;
import com.becandid.candid.data.AppState;
import java.io.Serializable;

/* compiled from: MeGroupsFragment */
class hr$4 implements OnClickListener {
    final /* synthetic */ hr a;

    hr$4(hr this$0) {
        this.a = this$0;
    }

    public void onClick(View v) {
        Intent intent = new Intent(this.a.getContext(), GroupMeSearchActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("groups", (Serializable) AppState.groups);
        intent.putExtras(bundle);
        this.a.getContext().startActivity(intent);
    }
}
