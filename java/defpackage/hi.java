package defpackage;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.activities.MeSettingsActivity.ActivitySetting;
import com.becandid.candid.activities.MeSettingsActivity.Setting;
import com.becandid.candid.activities.MeSettingsActivity.WebViewSetting;
import java.util.List;

/* compiled from: MeSettingsAdapter */
public class hi extends hd<Setting> {
    private Context d;

    public /* synthetic */ iv b(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((iv) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public hi(List<Setting> settings, Context context) {
        this.a = settings;
        this.d = context;
    }

    public int getItemViewType(int position) {
        return ((Setting) this.a.get(position)).type;
    }

    public ix a(ViewGroup viewGroup, int viewType) {
        View entry;
        if (viewType == 0) {
            entry = LayoutInflater.from(viewGroup.getContext()).inflate(2130968686, viewGroup, false);
        } else {
            entry = LayoutInflater.from(viewGroup.getContext()).inflate(2130968687, viewGroup, false);
        }
        return new ix(entry);
    }

    public void a(iv holder, int position) {
        ix viewHolder = (ix) holder;
        Setting currSetting = (Setting) this.a.get(position);
        if (currSetting instanceof WebViewSetting) {
            viewHolder.c.setVisibility(0);
            viewHolder.a.setOnClickListener(new hi$1(this, currSetting));
        } else if (currSetting instanceof ActivitySetting) {
            viewHolder.c.setVisibility(0);
            viewHolder.a.setOnClickListener(new hi$2(this, currSetting));
        } else if (currSetting.name.equals("Disown Permanently")) {
            viewHolder.c.setVisibility(8);
            viewHolder.b.setTextColor(this.d.getResources().getColor(2131558513));
            viewHolder.a.setOnClickListener(new hi$3(this));
        }
        viewHolder.b.setText(currSetting.name);
    }
}
