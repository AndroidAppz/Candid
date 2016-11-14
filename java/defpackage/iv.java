package defpackage;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import butterknife.ButterKnife;

/* compiled from: BaseViewHolder */
public class iv extends ViewHolder {
    protected View e;
    public Context f;

    public iv(View itemView) {
        super(itemView);
        this.e = itemView;
        ButterKnife.bind(this, itemView);
        this.f = itemView.getContext();
    }

    public iv(View itemView, Activity activity) {
        super(itemView);
        this.e = itemView;
        ButterKnife.bind(this, itemView);
        this.f = activity;
    }
}
