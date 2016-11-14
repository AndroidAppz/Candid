/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.view.ViewGroup
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class hd<T>
extends RecyclerView.Adapter<iv> {
    List<T> a = new ArrayList();
    String b;
    public Map<String, String> c = new HashMap();

    public String a() {
        return this.b;
    }

    public void a(int n2) {
        if (n2 <= 0) {
            this.b = null;
            return;
        }
        this.b = Integer.toString((int)n2);
    }

    public void a(iv iv2, int n2) {
    }

    public void a(T t2) {
        this.a.add(0, t2);
        this.notifyItemRangeInserted(0, 1);
    }

    public void a(T t2, int n2) {
        this.a.set(n2, t2);
        this.notifyItemChanged(n2);
    }

    public void a(String string2) {
        if (string2 == null) {
            this.b = null;
            return;
        }
        if (Integer.parseInt((String)string2) <= 0) {
            this.b = null;
            return;
        }
        this.b = string2;
    }

    public void a(List<T> list) {
        this.a.clear();
        if (list != null) {
            this.a.addAll(list);
        }
        this.notifyDataSetChanged();
        this.c.clear();
    }

    public int b(T t2) {
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            if (!t2.equals(this.a.get(i2))) continue;
            return i2;
        }
        return -1;
    }

    public iv b(ViewGroup viewGroup, int n2) {
        return null;
    }

    public T b() {
        if (!this.a.isEmpty()) {
            return (T)this.a.get(0);
        }
        return null;
    }

    public String b(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : this.c.entrySet()) {
            String string3 = (String)entry.getKey();
            String string4 = (String)entry.getValue();
            if (string3.contains((CharSequence)"oldest")) continue;
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    public void b(T t2, int n2) {
        this.a.add(n2, t2);
        this.notifyItemRangeInserted(n2, 1);
    }

    public void b(List<T> list) {
        int n2 = this.a.size();
        this.a.addAll(list);
        this.notifyItemRangeInserted(n2, -1 + this.a.size());
        this.c.clear();
    }

    public void c() {
        this.a.clear();
        this.notifyDataSetChanged();
    }

    public boolean d() {
        if (!this.a.isEmpty()) {
            return true;
        }
        return false;
    }

    public List<T> e() {
        return this.a;
    }

    public int getItemCount() {
        return this.a.size();
    }

    public int getItemViewType(int n2) {
        return super.getItemViewType(n2);
    }

    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        this.a((iv)viewHolder, n2);
    }

    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return this.b(viewGroup, n2);
    }
}

