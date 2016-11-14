package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.Locale;

/* compiled from: CountryListAdapter */
public class ake extends BaseAdapter {
    List<akh> a;
    LayoutInflater b = ((LayoutInflater) this.c.getSystemService("layout_inflater"));
    private Context c;

    private int a(String drawableName) {
        try {
            return akd$b.class.getField(drawableName).getInt(null);
        } catch (Exception e) {
            Log.e("CountryCodePicker", "Failure to get drawable id.", e);
            return -1;
        }
    }

    public ake(Context context, List<akh> countries) {
        this.c = context;
        this.a = countries;
    }

    public int getCount() {
        return this.a.size();
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ake$a cell;
        View cellView = convertView;
        akh country = (akh) this.a.get(position);
        if (convertView == null) {
            cell = new ake$a();
            cellView = this.b.inflate(akd$d.row, null);
            cell.a = (TextView) cellView.findViewById(akd$c.row_title);
            cell.b = (ImageView) cellView.findViewById(akd$c.row_icon);
            cellView.setTag(cell);
        } else {
            cell = (ake$a) cellView.getTag();
        }
        cell.a.setText(country.c());
        int drawableId = a("flag_" + country.b().toLowerCase(Locale.ENGLISH));
        country.a(drawableId);
        cell.b.setImageResource(drawableId);
        return cellView;
    }
}
