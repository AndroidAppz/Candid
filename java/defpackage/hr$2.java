package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.Group;

/* compiled from: MeGroupsFragment */
class hr$2 extends io {
    final /* synthetic */ hr a;

    hr$2(hr this$0, Context context) {
        this.a = this$0;
        super(context);
    }

    public void onItemClick(View v, int position) {
        Intent intent = new Intent(this.a.getContext(), GroupDetailsActivity.class);
        Group group = this.a.c.b(position);
        if (group != null) {
            intent.putExtra("group_id", group.group_id);
            intent.putExtra("group_name", group.group_name);
            intent.putExtra("group_image", group.imageUrl());
            intent.putExtra("group_json", DataUtil.toJson(group));
            this.a.getContext().startActivity(intent);
        }
    }
}
