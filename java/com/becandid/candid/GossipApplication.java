package com.becandid.candid;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.multidex.MultiDexApplication;
import android.util.Log;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.ContactsInfo;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import defpackage.akp;
import defpackage.bb;
import defpackage.ih$w;
import defpackage.iq;
import defpackage.jp;
import defpackage.jr;
import defpackage.rb;
import defpackage.ud;
import java.util.HashSet;

public class GossipApplication extends MultiDexApplication {
    public static volatile Context a;
    public static volatile Handler b;
    public static jr c;
    public static String d = "https://becandid.com/";
    private static volatile GossipApplication e;
    private a f;

    class a implements ActivityLifecycleCallbacks {
        public int a;
        public int b;
        public boolean c;
        final /* synthetic */ GossipApplication d;

        a(GossipApplication this$0) {
            this.d = this$0;
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            this.a++;
            if (this.c) {
                AppState.loadState(this.d);
            }
            this.c = false;
        }

        public void onActivityPaused(Activity activity) {
            this.b++;
            if (this.a == this.b) {
                AppState.saveState(this.d);
            }
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }
    }

    public void onCreate() {
        super.onCreate();
        a = getApplicationContext();
        b = new Handler(Looper.getMainLooper());
        e = this;
        this.f = new a(this);
        AppState.expandedPostIds = new HashSet();
        registerActivityLifecycleCallbacks(this.f);
        b();
        AppState.loadState(this);
    }

    public static GossipApplication a() {
        return e;
    }

    protected void b() {
        ud.a(getApplicationContext());
        akp.a((Context) this, new rb());
        c = jp.b(a);
    }

    public void c() {
        if (bb.checkSelfPermission(a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            LocationManager locationManager = (LocationManager) getSystemService("location");
            if (locationManager.getAllProviders().contains("passive") && locationManager.isProviderEnabled("passive")) {
                a("passive");
            }
            if (locationManager.getAllProviders().contains("network") && locationManager.isProviderEnabled("network")) {
                a("network");
            }
        }
    }

    public void a(final String provider) {
        try {
            ((LocationManager) getSystemService("location")).requestSingleUpdate(provider, new LocationListener(this) {
                final /* synthetic */ GossipApplication b;

                public void onLocationChanged(Location location) {
                    if (provider.equals("network") && AppState.locationProvider != null && AppState.locationProvider.equals("passive")) {
                        AppState.location = location;
                        AppState.locationProvider = provider;
                    } else if (provider.equals("passive") && AppState.locationProvider == null) {
                        AppState.location = location;
                        AppState.locationProvider = provider;
                    }
                    iq.a().a(new ih$w());
                }

                public void onStatusChanged(String provider, int status, Bundle extras) {
                }

                public void onProviderEnabled(String provider) {
                }

                public void onProviderDisabled(String provider) {
                }
            }, null);
        } catch (SecurityException e) {
            Log.e("Location", e.toString());
        }
    }

    public void d() {
        if (AppState.contactsInfo == null) {
            AppState.contactsInfo = new ContactsInfo();
        }
        Cursor phones = getContentResolver().query(Phone.CONTENT_URI, null, null, null, null);
        while (phones != null && phones.moveToNext()) {
            String number = phones.getString(phones.getColumnIndex("data1"));
            try {
                PhoneNumberUtil phoneUtil = PhoneNumberUtil.a();
                AppState.contactsInfo.contacts.add(phoneUtil.a(phoneUtil.a(number, "US"), PhoneNumberFormat.E164));
            } catch (NumberParseException e) {
                e.printStackTrace();
            }
        }
    }
}
