package defpackage;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.becandid.candid.data.Group;
import java.util.ArrayList;

/* compiled from: GroupAutocompleteAdapter */
public class hg$a extends Filter {
    final /* synthetic */ hg a;

    public hg$a(hg this$0) {
        this.a = this$0;
    }

    public /* synthetic */ CharSequence convertResultToString(Object obj) {
        return a(obj);
    }

    public String a(Object resultValue) {
        return ((Group) resultValue).group_name;
    }

    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        if (constraint == null || constraint.length() <= 0) {
            return null;
        }
        ArrayList<Group> bestSuggestions = this.a.a(constraint.toString());
        results.values = bestSuggestions;
        results.count = bestSuggestions.size();
        return results;
    }

    protected void publishResults(CharSequence constraint, FilterResults results) {
        this.a.clear();
        if (results != null) {
            this.a.addAll((ArrayList) results.values);
        } else {
            this.a.addAll(this.a.a);
        }
        this.a.notifyDataSetChanged();
    }
}
