/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Color
 *  android.os.AsyncTask
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.util.List
 */
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.becandid.candid.data.AppState;
import com.becandid.thirdparty.BlurTask;
import java.util.List;

public class hc
extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ib.a> a;
    private Activity b;

    public hc(Activity activity) {
        this.b = activity;
        this.a = ib.a().b();
    }

    public int getItemCount() {
        return this.a.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        if (n2 >= 0) {
            final ib.a a2 = (ib.a)this.a.get(n2);
            if (viewHolder instanceof a) {
                ((a)viewHolder).b.setText((CharSequence)a2.b);
                ((a)viewHolder).b.setTextColor(Color.parseColor((String)a2.e));
                ((a)viewHolder).a.setImageResource(a2.c);
                viewHolder.itemView.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {
                        if (!AppState.blurTaskCalledOnFlight) {
                            AppState.blurTaskCalledOnFlight = true;
                            new BlurTask(hc.this.b, 2131624267, a2.a).execute((Object[])new Void[0]);
                        }
                    }
                });
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return (hc)this.new a(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968736, null));
    }

    class a
    extends RecyclerView.ViewHolder {
        public ImageView a;
        public TextView b;

        public a(View view) {
            super(view);
            this.a = (ImageView)view.findViewById(2131624079);
            this.b = (TextView)view.findViewById(2131624759);
        }
    }

}

