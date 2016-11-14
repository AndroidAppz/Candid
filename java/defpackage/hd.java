package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BaseAdapter */
public class hd<T> extends Adapter<iv> {
    List<T> a = new ArrayList();
    String b;
    public Map<String, String> c = new HashMap();

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((iv) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return b(viewGroup, i);
    }

    public iv b(ViewGroup parent, int viewType) {
        return null;
    }

    public void a(iv holder, int position) {
    }

    public int getItemCount() {
        return this.a.size();
    }

    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void a(String lastDataId) {
        if (lastDataId == null) {
            this.b = null;
        } else if (Integer.parseInt(lastDataId) <= 0) {
            this.b = null;
        } else {
            this.b = lastDataId;
        }
    }

    public void a(int lastDataId) {
        if (lastDataId <= 0) {
            this.b = null;
        } else {
            this.b = Integer.toString(lastDataId);
        }
    }

    public String a() {
        return this.b;
    }

    public void a(List<T> newData) {
        this.a.clear();
        if (newData != null) {
            this.a.addAll(newData);
        }
        notifyDataSetChanged();
        this.c.clear();
    }

    public void a(T row) {
        this.a.add(0, row);
        notifyItemRangeInserted(0, 1);
    }

    public void b(List<T> newData) {
        int currSize = this.a.size();
        this.a.addAll(newData);
        notifyItemRangeInserted(currSize, this.a.size() - 1);
        this.c.clear();
    }

    public int b(T data) {
        for (int i = 0; i < this.a.size(); i++) {
            if (data.equals(this.a.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public void a(T row, int pos) {
        this.a.set(pos, row);
        notifyItemChanged(pos);
    }

    public void b(T row, int pos) {
        this.a.add(pos, row);
        notifyItemRangeInserted(pos, 1);
    }

    public T b() {
        if (this.a.isEmpty()) {
            return null;
        }
        return this.a.get(0);
    }

    public void c() {
        this.a.clear();
        notifyDataSetChanged();
    }

    public boolean d() {
        return !this.a.isEmpty();
    }

    public List<T> e() {
        return this.a;
    }

    public String b(String feedType) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry<String, String> entry : this.c.entrySet()) {
            String impression = (String) entry.getValue();
            if (!((String) entry.getKey()).contains("oldest")) {
                stringBuilder.append(impression);
                stringBuilder.append(feedType);
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }
}
