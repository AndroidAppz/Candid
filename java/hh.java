/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.GroupSearchActivity;
import com.becandid.candid.util.RoundedCornersTransformation;
import java.util.List;

public class hh
extends RecyclerView.Adapter<a> {
    private List<GroupSearchActivity.GroupSearchResult> a;
    private Context b;
    private RoundedCornersTransformation c;

    public hh(List<GroupSearchActivity.GroupSearchResult> list, Context context) {
        this.a = list;
        this.b = context;
        this.c = new RoundedCornersTransformation(context, (int)(10.0f * context.getResources().getDisplayMetrics().density), 0, RoundedCornersTransformation.CornerType.a);
    }

    public a a(ViewGroup viewGroup, int n2) {
        return new a(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968683, viewGroup, false));
    }

    public void a(a a2, int n2) {
        GroupSearchActivity.GroupSearchResult groupSearchResult = (GroupSearchActivity.GroupSearchResult)this.a.get(n2);
        a2.c.setText((CharSequence)groupSearchResult.firstTag);
        a2.a.setText((CharSequence)groupSearchResult.groupName);
        jl<int> jl2 = GossipApplication.c.a(groupSearchResult.thumbUrl).a().a((String)((int)17301613));
        kj[] arrkj = new kj[]{this.c};
        jl2.a(arrkj).a(a2.b);
    }

    public int getItemCount() {
        return this.a.size();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        this.a((a)viewHolder, n2);
    }

    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return this.a(viewGroup, n2);
    }

    public static class a
    extends RecyclerView.ViewHolder {
        TextView a;
        ImageView b;
        TextView c;

        a(View view) {
            super(view);
            this.a = (TextView)view.findViewById(2131624471);
            this.b = (ImageView)view.findViewById(2131624469);
            this.c = (TextView)view.findViewById(2131624470);
        }
    }

}

