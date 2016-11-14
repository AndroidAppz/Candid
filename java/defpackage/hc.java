package defpackage;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: AllBadgesAdapter */
public class hc extends Adapter<ViewHolder> {
    private List<ib$a> a = ib.a().b();
    private Activity b;

    public hc(Activity context) {
        this.b = context;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new hc$a(this, LayoutInflater.from(parent.getContext()).inflate(2130968736, null));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position >= 0) {
            ib$a badge = (ib$a) this.a.get(position);
            if (holder instanceof hc$a) {
                ((hc$a) holder).b.setText(badge.b);
                ((hc$a) holder).b.setTextColor(Color.parseColor(badge.e));
                ((hc$a) holder).a.setImageResource(badge.c);
                holder.itemView.setOnClickListener(new hc$1(this, badge));
            }
        }
    }

    public int getItemCount() {
        return this.a.size();
    }
}
