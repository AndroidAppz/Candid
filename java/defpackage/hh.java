package defpackage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.GroupSearchActivity.GroupSearchResult;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.becandid.candid.util.RoundedCornersTransformation.CornerType;
import java.util.List;

/* compiled from: GroupSearchAdapter */
public class hh extends Adapter<hh$a> {
    private List<GroupSearchResult> a;
    private Context b;
    private RoundedCornersTransformation c;

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((hh$a) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public hh(List<GroupSearchResult> searchResults, Context context) {
        this.a = searchResults;
        this.b = context;
        this.c = new RoundedCornersTransformation(context, (int) (10.0f * context.getResources().getDisplayMetrics().density), 0, CornerType.ALL);
    }

    public int getItemCount() {
        return this.a.size();
    }

    public hh$a a(ViewGroup viewGroup, int i) {
        return new hh$a(LayoutInflater.from(viewGroup.getContext()).inflate(2130968683, viewGroup, false));
    }

    public void a(hh$a groupHolder, int i) {
        GroupSearchResult currItem = (GroupSearchResult) this.a.get(i);
        groupHolder.c.setText(currItem.firstTag);
        groupHolder.a.setText(currItem.groupName);
        GossipApplication.c.a(currItem.thumbUrl).a().a(17301613).a(this.c).a(groupHolder.b);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
