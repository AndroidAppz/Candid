package com.becandid.candid.data;

import android.os.Bundle;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.b;
import com.facebook.GraphRequest.c;
import defpackage.apd;
import defpackage.apn;
import defpackage.apr;
import defpackage.ih$v;
import defpackage.iq;
import defpackage.is;
import defpackage.ug;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookInfo {
    public String age;
    public AccessToken fbToken;
    public List<String> friendIds;
    public List<String> jobIds;
    public List<String> schoolIds;

    public interface LoadCallback {
        void onNext(int i);
    }

    public void load() {
        load(null);
    }

    public void load(final LoadCallback cb) {
        loadUserInfo(new LoadCallback() {
            public void onNext(int ignored) {
                apd.a(100, TimeUnit.MILLISECONDS).a(apn.a()).b(new apr<Long>() {
                    public void call(Long aLong) {
                        FacebookInfo.this.loadFriends(cb);
                    }
                });
            }
        });
    }

    public void loadFriends(LoadCallback cb) {
        this.friendIds = null;
        loadFriends("me/friends", cb);
    }

    public void loadFriends(String url, final LoadCallback cb) {
        if (this.fbToken != null) {
            Log.d("FBINFO", "Loading url: " + url);
            Bundle parameters = new Bundle();
            if (url.contains("?")) {
                try {
                    for (Entry<String, String> entry : is.b(url.substring(url.indexOf("?") + 1)).entrySet()) {
                        parameters.putString((String) entry.getKey(), (String) entry.getValue());
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                url = url.substring(0, url.indexOf("?"));
            }
            GraphRequest request = new GraphRequest(this.fbToken, url, null, null, new b() {
                public void onCompleted(ug response) {
                    JSONObject result = response.b();
                    if (result != null) {
                        try {
                            String next = FacebookInfo.this.parseFriends(result);
                            if (next != null) {
                                FacebookInfo.this.loadFriends(next, cb);
                            } else if (cb != null) {
                                cb.onNext(FacebookInfo.this.friendIds.size());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        iq.a().a(new ih$v());
                    }
                }
            });
            parameters.putString("limit", "100");
            parameters.putString("fields", "data,paging");
            request.a(parameters);
            request.j();
        }
    }

    private String parseFriends(JSONObject result) throws JSONException {
        JSONArray friends = result.getJSONArray("data");
        if (this.friendIds == null) {
            this.friendIds = new ArrayList(friends.length());
        }
        for (int i = 0; i < friends.length(); i++) {
            this.friendIds.add(friends.getJSONObject(i).getString("id"));
        }
        if (result.has("paging") && friends.length() > 20) {
            JSONObject paging = result.getJSONObject("paging");
            if (paging.has("next")) {
                String next = paging.getString("next");
                if (next.contains("/friends")) {
                    return next.substring(next.lastIndexOf("/", next.indexOf("/friends") - 1) + 1);
                }
            }
        }
        Log.d("FBINFO", "Friend ids: " + this.friendIds);
        return null;
    }

    public void loadUserInfo(final LoadCallback cb) {
        if (this.fbToken != null) {
            GraphRequest request = GraphRequest.a(this.fbToken, new c() {
                public void onCompleted(JSONObject object, ug response) {
                    if (object != null) {
                        Log.d("FBINFO", "Me response: " + object);
                        try {
                            FacebookInfo.this.parseJobs(object);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            FacebookInfo.this.parseSchools(object);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            FacebookInfo.this.age = object.getString("age_range");
                        } catch (JSONException e22) {
                            e22.printStackTrace();
                        }
                    } else {
                        Log.d("FBINFO", "Error getting /me: " + response.a());
                    }
                    if (cb != null) {
                        cb.onNext(0);
                    }
                }
            });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "work,education,age_range,gender,hometown");
            request.a(parameters);
            request.j();
        }
    }

    private void parseSchools(JSONObject object) throws JSONException {
        JSONArray schools = object.getJSONArray("education");
        this.schoolIds = new ArrayList(schools.length());
        for (int i = 0; i < schools.length(); i++) {
            this.schoolIds.add(schools.getJSONObject(i).getJSONObject("school").getString("id"));
        }
        Log.d("FBINFO", "School ids: " + this.schoolIds);
    }

    private void parseJobs(JSONObject object) throws JSONException {
        JSONArray jobs = object.getJSONArray("work");
        this.jobIds = new ArrayList(jobs.length());
        for (int i = 0; i < jobs.length(); i++) {
            this.jobIds.add(jobs.getJSONObject(i).getJSONObject("employer").getString("id"));
        }
        Log.d("FBINFO", "Jobs ids: " + this.jobIds);
    }
}
