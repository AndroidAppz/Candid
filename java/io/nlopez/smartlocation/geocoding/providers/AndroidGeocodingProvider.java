package io.nlopez.smartlocation.geocoding.providers;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import defpackage.aob;
import defpackage.aod;
import defpackage.aok;
import io.nlopez.smartlocation.geocoding.utils.LocationAddress;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class AndroidGeocodingProvider {
    private static final String a = (AndroidGeocodingProvider.class.getCanonicalName() + ".DIRECT_GEOCODE_ACTION");
    private static final String b = (AndroidGeocodingProvider.class.getCanonicalName() + ".REVERSE_GEOCODE_ACTION");
    private Locale c;
    private aob d;
    private aod e;
    private HashMap<String, Integer> f;
    private HashMap<Location, Integer> g;
    private aok h;
    private BroadcastReceiver i;
    private BroadcastReceiver j;

    public static class AndroidGeocodingService extends IntentService {
        private Geocoder a;

        public AndroidGeocodingService() {
            super(AndroidGeocodingService.class.getSimpleName());
        }

        protected void onHandleIntent(Intent intent) {
            Locale locale = (Locale) intent.getSerializableExtra("locale");
            if (locale == null) {
                this.a = new Geocoder(this);
            } else {
                this.a = new Geocoder(this, locale);
            }
            if (intent.hasExtra("direct")) {
                HashMap<String, Integer> nameList = (HashMap) intent.getSerializableExtra("direct");
                for (String name : nameList.keySet()) {
                    a(name, a(name, ((Integer) nameList.get(name)).intValue()));
                }
            }
            if (intent.hasExtra("reverse")) {
                HashMap<Location, Integer> locationList = (HashMap) intent.getSerializableExtra("reverse");
                for (Location location : locationList.keySet()) {
                    a(location, a(location, ((Integer) locationList.get(location)).intValue()));
                }
            }
        }

        private void a(String name, ArrayList<LocationAddress> results) {
            Intent directIntent = new Intent(AndroidGeocodingProvider.a);
            directIntent.putExtra("name", name);
            directIntent.putExtra("result", results);
            sendBroadcast(directIntent);
        }

        private void a(Location location, ArrayList<Address> results) {
            Intent reverseIntent = new Intent(AndroidGeocodingProvider.b);
            reverseIntent.putExtra("location", location);
            reverseIntent.putExtra("result", results);
            sendBroadcast(reverseIntent);
        }

        private ArrayList<Address> a(Location location, int maxResults) {
            try {
                return new ArrayList(this.a.getFromLocation(location.getLatitude(), location.getLongitude(), maxResults));
            } catch (IOException e) {
                return new ArrayList();
            }
        }

        private ArrayList<LocationAddress> a(String name, int maxResults) {
            try {
                List<Address> addresses = this.a.getFromLocationName(name, maxResults);
                ArrayList<LocationAddress> arrayList = new ArrayList();
                for (Address address : addresses) {
                    arrayList.add(new LocationAddress(address));
                }
                return arrayList;
            } catch (IOException e) {
                return new ArrayList();
            }
        }
    }

    public AndroidGeocodingProvider() {
        this(Locale.getDefault());
    }

    public AndroidGeocodingProvider(Locale locale) {
        this.i = new BroadcastReceiver(this) {
            final /* synthetic */ AndroidGeocodingProvider a;

            {
                this.a = r1;
            }

            public void onReceive(Context context, Intent intent) {
                if (AndroidGeocodingProvider.a.equals(intent.getAction())) {
                    this.a.h.a("sending new direct geocoding response", new Object[0]);
                    if (this.a.d != null) {
                        this.a.d.a(intent.getStringExtra("name"), intent.getParcelableArrayListExtra("result"));
                    }
                }
            }
        };
        this.j = new BroadcastReceiver(this) {
            final /* synthetic */ AndroidGeocodingProvider a;

            {
                this.a = r1;
            }

            public void onReceive(Context context, Intent intent) {
                if (AndroidGeocodingProvider.b.equals(intent.getAction())) {
                    this.a.h.a("sending new reverse geocoding response", new Object[0]);
                    if (this.a.e != null) {
                        this.a.e.a((Location) intent.getParcelableExtra("location"), (ArrayList) intent.getSerializableExtra("result"));
                    }
                }
            }
        };
        if (locale == null) {
            throw new RuntimeException("Locale is null");
        }
        this.c = locale;
        this.f = new HashMap();
        this.g = new HashMap();
        if (!Geocoder.isPresent()) {
            throw new RuntimeException("Android Geocoder not present. Please check if Geocoder.isPresent() before invoking the search");
        }
    }
}
