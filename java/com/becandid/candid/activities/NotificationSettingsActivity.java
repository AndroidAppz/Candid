package com.becandid.candid.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AlertDialog.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData.NotificationSetting;
import defpackage.apn;
import defpackage.ie;
import defpackage.rb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class NotificationSettingsActivity extends BaseActivity {
    private ArrayList<NotificationSetting> b;
    private boolean c;

    class NotificationSettingsAdapter extends ArrayAdapter<NotificationSetting> {
        final /* synthetic */ NotificationSettingsActivity a;

        public NotificationSettingsAdapter(NotificationSettingsActivity this$0, Context context, List<NotificationSetting> settings) {
            this.a = this$0;
            super(context, -1, settings);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130968704, parent, false);
            }
            NotificationSetting item = (NotificationSetting) getItem(position);
            ((ImageView) convertView.findViewById(2131624554)).setImageResource(item.disabled.intValue() == 0 ? 2130837980 : 2130837709);
            ((TextView) convertView.findViewById(2131624555)).setText(item.display_name);
            return convertView;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968620);
        ListView settings = (ListView) findViewById(2131624244);
        this.b = new ArrayList(10);
        if (AppState.notificationSettings == null) {
            rb.a(new Throwable("AppState notificationSettings is NULL"));
            finish();
            return;
        }
        Iterator it = AppState.notificationSettings.iterator();
        while (it.hasNext()) {
            this.b.add(((NotificationSetting) it.next()).copy());
        }
        final NotificationSettingsAdapter adapter = new NotificationSettingsAdapter(this, this, this.b);
        settings.setAdapter(adapter);
        settings.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ NotificationSettingsActivity b;

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int i;
                NotificationSetting item = (NotificationSetting) adapter.getItem(position);
                if (item.disabled.intValue() == 1) {
                    i = 0;
                } else {
                    i = 1;
                }
                item.disabled = Integer.valueOf(i);
                this.b.c = true;
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void cancelClick(View v) {
        finish();
    }

    public void saveClick(View v) {
        AppState.notificationSettings = this.b;
        List<String> disabled = new ArrayList();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            NotificationSetting setting = (NotificationSetting) it.next();
            if (setting.disabled.intValue() == 1) {
                disabled.add(setting.type);
            }
        }
        Map params = new HashMap();
        params.put("disabled", DataUtil.join(disabled));
        ie.a().e(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
        finish();
    }

    public void onBackPressed() {
        if (this.c) {
            new Builder(this).setTitle("Unsaved changes").setMessage("Save the settings or reset them?").setNegativeButton("Reset", new OnClickListener(this) {
                final /* synthetic */ NotificationSettingsActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(DialogInterface dialog, int which) {
                    this.a.cancelClick(null);
                }
            }).setPositiveButton("Save", new OnClickListener(this) {
                final /* synthetic */ NotificationSettingsActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(DialogInterface dialog, int which) {
                    this.a.saveClick(null);
                }
            }).create().show();
        } else {
            super.onBackPressed();
        }
    }
}
