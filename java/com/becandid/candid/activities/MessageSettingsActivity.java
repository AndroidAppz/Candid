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
import com.becandid.candid.models.EmptySubscriber;
import defpackage.apn;
import defpackage.ie;
import defpackage.ih$z;
import defpackage.iq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rx.schedulers.Schedulers;

public class MessageSettingsActivity extends BaseActivity {
    private ArrayList<String> b;
    private ArrayList<String> c;
    private ToggleSettingsAdapter d;
    private ToggleSettingsAdapter e;
    private boolean f;

    class ToggleSettingsAdapter extends ArrayAdapter<String> {
        final /* synthetic */ MessageSettingsActivity a;
        private int b;

        public ToggleSettingsAdapter(MessageSettingsActivity this$0, Context context, List<String> settings, int selected) {
            this.a = this$0;
            super(context, -1, settings);
            this.b = selected;
        }

        public boolean selectOption(int position) {
            if (this.b == position) {
                return false;
            }
            this.b = position;
            notifyDataSetChanged();
            return true;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130968704, parent, false);
            }
            ((ImageView) convertView.findViewById(2131624554)).setImageResource(position == this.b ? 2130837980 : 2130837709);
            ((TextView) convertView.findViewById(2131624555)).setText((CharSequence) getItem(position));
            return convertView;
        }

        public int getSetting() {
            return this.b;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968619);
        ListView messagingSettings = (ListView) findViewById(2131624239);
        ListView deletionSettings = (ListView) findViewById(2131624241);
        this.b = new ArrayList(2);
        this.b.add(AppState.config.getString("enable_messaging_prompt", "Messaging enabled"));
        this.b.add(AppState.config.getString("disable_messaging_prompt", "Messaging disabled"));
        this.c = new ArrayList(2);
        this.c.add(AppState.config.getString("self_delete_messages_prompt", "Messages manually deleted"));
        this.c.add(AppState.config.getString("auto_delete_messages_prompt", "Messages deleted automatically after 2 days"));
        this.d = new ToggleSettingsAdapter(this, this, this.b, AppState.account.messaging_disabled);
        messagingSettings.setAdapter(this.d);
        messagingSettings.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MessageSettingsActivity a;

            {
                this.a = this$0;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                this.a.f = this.a.d.selectOption(position);
            }
        });
        this.e = new ToggleSettingsAdapter(this, this, this.c, AppState.account.message_auto_deletion);
        deletionSettings.setAdapter(this.e);
        deletionSettings.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MessageSettingsActivity a;

            {
                this.a = this$0;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                this.a.f = this.a.e.selectOption(position);
            }
        });
    }

    public void saveClick(View v) {
        if (this.f) {
            HashMap<String, String> params = new HashMap();
            params.put("messaging_disabled", Integer.toString(this.d.getSetting()));
            params.put("message_auto_deletion", Integer.toString(this.e.getSetting()));
            AppState.account.messaging_disabled = this.d.getSetting();
            AppState.account.message_auto_deletion = this.e.getSetting();
            ie.a().q(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
            iq.a().a(new ih$z(AppState.account.messaging_disabled));
        }
        finish();
    }

    public void cancelClick(View v) {
        finish();
    }

    public void onBackPressed() {
        if (this.f) {
            new Builder(this).setTitle("Unsaved changes").setMessage("Save the settings or reset them?").setNegativeButton("Reset", new OnClickListener(this) {
                final /* synthetic */ MessageSettingsActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(DialogInterface dialog, int which) {
                    this.a.cancelClick(null);
                }
            }).setPositiveButton("Save", new OnClickListener(this) {
                final /* synthetic */ MessageSettingsActivity a;

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
