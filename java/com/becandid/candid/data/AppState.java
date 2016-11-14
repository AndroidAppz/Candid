package com.becandid.candid.data;

import android.app.NotificationManager;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.util.Log;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.data.FacebookInfo.LoadCallback;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData.NotificationSetting;
import com.facebook.AccessToken;
import defpackage.ahz;
import defpackage.ajm;
import defpackage.apn;
import defpackage.ie;
import defpackage.we;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class AppState {
    public static User account;
    public static ArrayList<String> activeTags;
    private static List<String> adultTags;
    public static String age;
    public static boolean blurTaskCalledOnFlight = false;
    public static Config config;
    public static ContactsInfo contactsInfo;
    public static HashSet<Integer> expandedPostIds;
    public static FacebookInfo fbInfo;
    public static List<String> feedColors;
    public static List<String> groupTags;
    public static List<Group> groups;
    public static boolean hasMessagedFromAlert;
    public static boolean hasMessagingShown;
    public static boolean hasMuted;
    public static boolean hasPosted;
    public static boolean hasShownMutePopup;
    public static boolean hasShownUnmutePopup;
    public static boolean internal;
    public static Location location;
    public static String locationProvider;
    public static MainTabsActivity mainTabsActivity;
    public static int needAge;
    public static int needOnboarding;
    public static ArrayList<NotificationSetting> notificationSettings;
    public static String referralId;
    public static int referralPostId;
    public static List<String> tabsOrder;
    public static List<String> tags;
    private static List<String> teenTags;

    public static void setConfig(Map<String, Object> confMap) {
        config = new Config();
        config.setExperimentConfig(confMap);
    }

    public static void setOnboardingTags(Map<String, Object> onboardingMap) {
        tags = (ArrayList) onboardingMap.get("tags");
    }

    public static void setOnboardingTeenTags(List<String> tags) {
        teenTags = tags;
    }

    public static void setOnboardingAdultTags(List<String> tags) {
        adultTags = tags;
    }

    public static void loadState(ContextWrapper context) {
        SharedPreferences sharedPref = context.getSharedPreferences("com.becandid.candid", 0);
        Log.d("APP", "Checking shared prefs for app state");
        if (sharedPref.contains("config")) {
            setConfig(DataUtil.toMap(sharedPref.getString("config", "{}")));
        }
        if (sharedPref.contains("account")) {
            String accountJson = sharedPref.getString("account", null);
            if (accountJson != null) {
                account = (User) DataUtil.gson.a(accountJson, User.class);
            }
            if (account != null) {
                ie.a().b().b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
            }
        }
        if (sharedPref.contains("tags")) {
            try {
                Type type = new ajm<List<String>>() {
                }.getType();
                tags = (List) new ahz().a(sharedPref.getString("tags", "{}"), type);
            } catch (ClassCastException e) {
            }
        }
        if (sharedPref.contains("teenTags")) {
            try {
                type = new ajm<List<String>>() {
                }.getType();
                teenTags = (List) new ahz().a(sharedPref.getString("teenTags", "{}"), type);
            } catch (ClassCastException e2) {
            }
        }
        if (sharedPref.contains("adultTags")) {
            try {
                type = new ajm<List<String>>() {
                }.getType();
                adultTags = (List) new ahz().a(sharedPref.getString("adultTags", "{}"), type);
            } catch (ClassCastException e3) {
            }
        }
        if (feedColors == null) {
            if (sharedPref.contains("colors")) {
                feedColors = new ArrayList(sharedPref.getStringSet("colors", null));
            } else {
                feedColors = Arrays.asList(new String[]{"#3b6c9e", "#23cbba", "#5cc396", "#e3c02a", "#603785", "#1daff1", "#fd9231", "#94bb65", "#d2822c", "#945319", "#9ccb46", "#147b40", "#e6ad38", "#a837aa", "#e3515d", "#cc333e", "#465163", "#d46342"});
            }
        }
        if (sharedPref.contains("hasPosted")) {
            hasPosted = sharedPref.getBoolean("hasPosted", false);
        }
        if (sharedPref.contains("hasMuted")) {
            hasMuted = sharedPref.getBoolean("hasMuted", false);
        }
        if (sharedPref.contains("hasShownMutePopup")) {
            hasShownMutePopup = sharedPref.getBoolean("hasShownMutePopup", false);
        }
        if (sharedPref.contains("hasShownUnmutePopup")) {
            hasShownUnmutePopup = sharedPref.getBoolean("hasShownUnmutePopup", false);
        }
        if (sharedPref.contains("hasMessagingShown")) {
            hasMessagingShown = sharedPref.getBoolean("hasMessagingShown", false);
        }
        if (sharedPref.contains("hasMessagedFromAlert")) {
            hasMessagedFromAlert = sharedPref.getBoolean("hasMessagedFromAlert", false);
        }
        if (AccessToken.a() != null) {
            fbInfo = new FacebookInfo();
            fbInfo.fbToken = AccessToken.a();
        }
        if (sharedPref.contains("tabsOrder")) {
            type = new ajm<List<String>>() {
            }.getType();
            tabsOrder = (List) new ahz().a(sharedPref.getString("tabsOrder", "{}"), type);
        }
        if (sharedPref.contains("age")) {
            age = sharedPref.getString("age", null);
        }
    }

    public static void saveState(ContextWrapper context) {
        Log.d("APP", "Save app state");
        Editor editor = context.getSharedPreferences("com.becandid.candid", 0).edit();
        if (!(config == null || config.experimentConfig == null)) {
            editor.putString("config", DataUtil.toJson(config.experimentConfig));
        }
        if (account != null) {
            editor.putString("account", DataUtil.toJson(account));
        }
        if (tags != null) {
            editor.putString("tags", DataUtil.toJson(tags));
        }
        if (teenTags != null) {
            editor.putString("teenTags", DataUtil.toJson(teenTags));
        }
        if (adultTags != null) {
            editor.putString("adultTags", DataUtil.toJson(adultTags));
        }
        if (feedColors != null) {
            editor.putStringSet("colors", new LinkedHashSet(feedColors));
        }
        if (tabsOrder != null) {
            editor.putString("tabsOrder", DataUtil.toJson(tabsOrder));
        }
        editor.putBoolean("hasPosted", hasPosted);
        editor.putBoolean("hasMuted", hasMuted);
        editor.putBoolean("hasMessagingShown", hasMessagingShown);
        editor.putBoolean("hasShownMutePopup", hasShownMutePopup);
        editor.putBoolean("hasShownUnmutePopup", hasShownUnmutePopup);
        editor.putBoolean("hasMessagedFromAlert", hasMessagedFromAlert);
        if (age != null) {
            editor.putString("age", age);
            if ("under_18".equals(age) && teenTags != null && !teenTags.isEmpty()) {
                tags = teenTags;
                editor.putString("tags", DataUtil.toJson(tags));
            } else if (!(age == null || adultTags == null || adultTags.isEmpty())) {
                tags = adultTags;
                editor.putString("tags", DataUtil.toJson(tags));
            }
        }
        editor.commit();
    }

    public static void clearState(ContextWrapper context) {
        Log.d("APP", "Clear app state");
        Editor editor = context.getSharedPreferences("com.becandid.candid", 0).edit();
        editor.remove("account");
        editor.remove("tags");
        editor.remove("colors");
        editor.remove("contactsInfo");
        editor.remove("hasPosted");
        editor.remove("hasMuted");
        editor.clear();
        editor.commit();
    }

    public static boolean loggedin() {
        return account != null;
    }

    public static boolean isGroupMember(int groupId) {
        if (groups == null) {
            return false;
        }
        for (Group group : groups) {
            if (group.group_id == groupId) {
                return true;
            }
        }
        return false;
    }

    public static boolean isGroupModerator(int groupId) {
        if (groups == null) {
            return false;
        }
        for (Group group : groups) {
            if (group.group_id == groupId && group.moderator == 1) {
                return true;
            }
        }
        return false;
    }

    public static void disownAccount() {
        tags = null;
        activeTags = null;
        location = null;
        locationProvider = null;
        fbInfo = null;
        contactsInfo = null;
        account = null;
        groups = null;
        hasPosted = false;
        hasMuted = false;
        hasShownMutePopup = false;
        hasShownUnmutePopup = false;
        hasMessagingShown = false;
        age = null;
        teenTags = null;
        adultTags = null;
        if (AccessToken.a() != null) {
            we.c().d();
        }
        ((NotificationManager) GossipApplication.a.getSystemService("notification")).cancelAll();
        ie.a.removeAll();
        clearState(GossipApplication.a());
    }

    public static void setFBInfo(AccessToken token) {
        if (account != null) {
            account.have_fb = true;
        }
        fbInfo = new FacebookInfo();
        fbInfo.fbToken = token;
        fbInfo.load();
    }

    public static void setFBInfo(AccessToken token, LoadCallback cb) {
        if (account != null) {
            account.have_fb = true;
        }
        fbInfo = new FacebookInfo();
        fbInfo.fbToken = token;
        fbInfo.load(cb);
    }
}
