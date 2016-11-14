/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ArrayAdapter
 *  android.widget.Filter
 *  android.widget.Filter$FilterResults
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import com.becandid.candid.data.Group;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class hg
extends ArrayAdapter<Group> {
    ArrayList<Group> a;
    a b;
    private final Object c = new Object();

    public hg(Context context, int n2, List<Group> list) {
        super(context, n2, list);
        this.a = new ArrayList(list);
        Collections.sort(this.a, (Comparator)new Comparator<Group>(){

            /*
             * Enabled aggressive block sorting
             */
            public int a(Group group, Group group2) {
                Integer n2;
                Integer n3 = group2.t_last_post;
                Integer n4 = n3 == null ? Integer.valueOf((int)group2.t_joined) : Integer.valueOf((int)(2592000 + n3));
                Integer n5 = group.t_last_post;
                if (n5 == null) {
                    n2 = group.t_joined;
                    return n4.compareTo(n2);
                }
                n2 = 2592000 + n5;
                return n4.compareTo(n2);
            }

            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((Group)object, (Group)object2);
            }
        });
    }

    public a a() {
        if (this.b == null) {
            this.b = new a();
        }
        return this.b;
    }

    public ArrayList<Group> a(String string2) {
        String string3 = string2.toLowerCase();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        block0 : for (Group group : this.a) {
            String string4 = group.group_name.toLowerCase();
            if (string4.startsWith(string3)) {
                arrayList.add((Object)group);
                continue;
            }
            String[] arrstring = string4.split(" ");
            int n2 = arrstring.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!arrstring[i2].startsWith(string3)) continue;
                arrayList2.add((Object)group);
                continue block0;
            }
        }
        arrayList.addAll((Collection)arrayList2);
        return arrayList;
    }

    public Group b(String string2) {
        ArrayList<Group> arrayList = this.a(string2);
        if (arrayList.size() > 0) {
            return (Group)arrayList.get(0);
        }
        return null;
    }

    public /* synthetic */ Filter getFilter() {
        return this.a();
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        View view2 = view;
        if (view2 == null) {
            view2 = ((Activity)this.getContext()).getLayoutInflater().inflate(2130968683, viewGroup, false);
            view2.findViewById(2131624470).setVisibility(8);
            view2.findViewById(2131624472).setVisibility(8);
        }
        Group group = (Group)this.getItem(n2);
        ((TextView)view2.findViewById(2131624471)).setText((CharSequence)group.group_name);
        view2.findViewById(2131624469).setVisibility(8);
        return view2;
    }

    public class a
    extends Filter {
        public String a(Object object) {
            return ((Group)object).group_name;
        }

        public /* synthetic */ CharSequence convertResultToString(Object object) {
            return this.a(object);
        }

        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence != null && charSequence.length() > 0) {
                ArrayList<Group> arrayList;
                filterResults.values = arrayList = hg.this.a(charSequence.toString());
                filterResults.count = arrayList.size();
                return filterResults;
            }
            return null;
        }

        /*
         * Enabled aggressive block sorting
         */
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            hg.this.clear();
            if (filterResults != null) {
                hg.this.addAll((Collection)((ArrayList)filterResults.values));
            } else {
                hg.this.addAll(hg.this.a);
            }
            hg.this.notifyDataSetChanged();
        }
    }

}

