package defpackage;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.Group;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.becandid.candid.util.RoundedCornersTransformation.CornerType;

/* compiled from: ProfileGroupsAdapter */
public class hm extends hd<Group> {
    private Context d;
    private RoundedCornersTransformation e = new RoundedCornersTransformation(this.d, (int) (10.0f * this.d.getResources().getDisplayMetrics().density), 0, CornerType.TOP);

    public /* synthetic */ iv b(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((iv) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public hm(Context activity) {
        this.d = activity;
    }

    public void a(Group group) {
        for (Group g : this.a) {
            if (g.group_id == group.group_id) {
                return;
            }
        }
        this.a.add(0, group);
        notifyDataSetChanged();
    }

    public Group b(int index) {
        if (index >= this.a.size() || index < 0) {
            return null;
        }
        return (Group) this.a.get(index);
    }

    public void c(int groupId) {
        for (int i = 0; i < this.a.size(); i++) {
            if (((Group) this.a.get(i)).group_id == groupId) {
                this.a.remove(i);
                notifyDataSetChanged();
                return;
            }
        }
    }

    public hm$a a(ViewGroup parent, int viewType) {
        return new hm$a(LayoutInflater.from(parent.getContext()).inflate(2130968729, parent, false));
    }

    public void a(iv holder, int position) {
        Group group = (Group) this.a.get(position);
        hm$a gHolder = (hm$a) holder;
        gHolder.b.setText(group.group_name);
        gHolder.c.setText(group.num_members + " members");
        gHolder.d.setVisibility(group.moderator == 1 ? 0 : 8);
        GossipApplication.c.a(group.imageUrl()).a().a(17301613).a(this.e).a(gHolder.a);
    }

    public int getItemCount() {
        return this.a.size();
    }
}
