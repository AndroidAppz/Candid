package defpackage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import com.becandid.candid.data.Group;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: GroupAutocompleteAdapter */
public class hg extends ArrayAdapter<Group> {
    ArrayList<Group> a;
    hg$a b;
    private final Object c = new Object();

    public /* synthetic */ Filter getFilter() {
        return a();
    }

    public hg(Context context, int resource, List<Group> objects) {
        super(context, resource, objects);
        this.a = new ArrayList(objects);
        Collections.sort(this.a, new hg$1(this));
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = ((Activity) getContext()).getLayoutInflater().inflate(2130968683, parent, false);
            row.findViewById(2131624470).setVisibility(8);
            row.findViewById(2131624472).setVisibility(8);
        }
        ((TextView) row.findViewById(2131624471)).setText(((Group) getItem(position)).group_name);
        row.findViewById(2131624469).setVisibility(8);
        return row;
    }

    public hg$a a() {
        if (this.b == null) {
            this.b = new hg$a(this);
        }
        return this.b;
    }

    public ArrayList<Group> a(String prefix) {
        prefix = prefix.toLowerCase();
        ArrayList<Group> bestSuggestions = new ArrayList();
        ArrayList<Group> moreSuggestions = new ArrayList();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            Group group = (Group) it.next();
            String lowerName = group.group_name.toLowerCase();
            if (lowerName.startsWith(prefix)) {
                bestSuggestions.add(group);
            } else {
                for (String word : lowerName.split(" ")) {
                    if (word.startsWith(prefix)) {
                        moreSuggestions.add(group);
                        break;
                    }
                }
            }
        }
        bestSuggestions.addAll(moreSuggestions);
        return bestSuggestions;
    }

    public Group b(String prefix) {
        List<Group> matching = a(prefix);
        if (matching.size() > 0) {
            return (Group) matching.get(0);
        }
        return null;
    }
}
