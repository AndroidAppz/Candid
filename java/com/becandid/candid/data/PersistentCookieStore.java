package com.becandid.candid.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import defpackage.ahz;
import defpackage.dh;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PersistentCookieStore implements CookieStore {
    private static PersistentCookieStore cookieStore;
    private static final ahz sGson = new ahz();
    private Map<URI, Set<HttpCookie>> allCookies;
    private SharedPreferences gsonSharedPreferences;

    public static PersistentCookieStore getCookieStore(Context context) {
        if (cookieStore == null) {
            cookieStore = new PersistentCookieStore(context.getApplicationContext());
        }
        return cookieStore;
    }

    private PersistentCookieStore(Context context) {
        loadAllFromPersistence(context);
    }

    private void loadAllFromPersistence(Context context) {
        this.allCookies = new dh();
        loadCookies(context, "com.becandid.likes.cookieStore");
    }

    private void loadCookies(Context context, String storeName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(storeName, 0);
        this.gsonSharedPreferences = sharedPreferences;
        for (Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            try {
                URI uri = new URI(((String) entry.getKey()).split("\\|", 2)[0]);
                HttpCookie cookie = (HttpCookie) sGson.a((String) entry.getValue(), HttpCookie.class);
                if (cookie != null) {
                    Set<HttpCookie> targetCookies = (Set) this.allCookies.get(uri);
                    if (targetCookies == null) {
                        targetCookies = new HashSet();
                        this.allCookies.put(uri, targetCookies);
                    }
                    targetCookies.remove(cookie);
                    targetCookies.add(cookie);
                }
            } catch (URISyntaxException e) {
                Log.w("PersistentCookieStore", e);
            }
        }
    }

    public synchronized void add(URI uri, HttpCookie cookie) {
        Log.d("PersistentCookieStore", "add: " + uri.toString());
        uri = cookieUri(uri, cookie);
        Set<HttpCookie> targetCookies = (Set) this.allCookies.get(uri);
        if (targetCookies == null) {
            targetCookies = new HashSet();
            this.allCookies.put(uri, targetCookies);
        }
        targetCookies.remove(cookie);
        targetCookies.add(cookie);
        saveToPersistence(uri, cookie);
    }

    private static URI cookieUri(URI uri, HttpCookie cookie) {
        URI cookieUri = uri;
        if (cookie.getDomain() == null) {
            return cookieUri;
        }
        try {
            String str;
            if (uri.getScheme() == null) {
                str = "http";
            } else {
                str = uri.getScheme();
            }
            return new URI(str, cookie.getDomain(), cookie.getPath() == null ? "/" : cookie.getPath(), null);
        } catch (URISyntaxException e) {
            Log.w("PersistentCookieStore", e);
            return cookieUri;
        }
    }

    private void saveToPersistence(URI uri, HttpCookie cookie) {
        Editor editorGSON = this.gsonSharedPreferences.edit();
        editorGSON.putString(getCookieKey(uri, cookie), getGsonSerializedCookie(cookie));
        editorGSON.apply();
    }

    public synchronized List<HttpCookie> get(URI uri) {
        return getValidCookies(uri);
    }

    public synchronized List<HttpCookie> getCookies() {
        List<HttpCookie> allValidCookies;
        allValidCookies = new ArrayList();
        for (URI storedUri : this.allCookies.keySet()) {
            allValidCookies.addAll(getValidCookies(storedUri));
        }
        return allValidCookies;
    }

    private List<HttpCookie> getValidCookies(URI uri) {
        Set<HttpCookie> targetCookies = new HashSet();
        for (Entry<URI, Set<HttpCookie>> entry : this.allCookies.entrySet()) {
            URI storedUri = (URI) entry.getKey();
            if (!TextUtils.isEmpty(storedUri.getHost())) {
                String storedHost = storedUri.getHost();
                String subDomainStoredHost = storedHost;
                if (!storedHost.startsWith(".")) {
                    subDomainStoredHost = "." + storedHost;
                }
                if (uri.getHost().equals(storedHost) || uri.getHost().endsWith(subDomainStoredHost) || (uri.getHost().contains(".dev.") && uri.getHost().endsWith(storedHost))) {
                    if (storedUri.getPath() == null || "/".equals(storedUri.getPath()) || storedUri.getPath().equals(uri.getPath())) {
                        targetCookies.addAll((Collection) entry.getValue());
                    }
                }
            }
        }
        List cookiesToRemoveFromPersistence = new ArrayList();
        Iterator<HttpCookie> it = targetCookies.iterator();
        while (it.hasNext()) {
            HttpCookie currentCookie = (HttpCookie) it.next();
            if (currentCookie.hasExpired() && !"u".equals(currentCookie.getName())) {
                cookiesToRemoveFromPersistence.add(currentCookie);
                it.remove();
            }
        }
        if (!cookiesToRemoveFromPersistence.isEmpty()) {
            removeFromPersistence(uri, cookiesToRemoveFromPersistence);
        }
        return new ArrayList(targetCookies);
    }

    private void removeFromPersistence(URI uri, List<HttpCookie> cookiesToRemove) {
        Editor editorGSON = this.gsonSharedPreferences.edit();
        for (HttpCookie cookieToRemove : cookiesToRemove) {
            editorGSON.remove(getCookieKey(uri, cookieToRemove));
        }
        editorGSON.apply();
    }

    public synchronized List<URI> getURIs() {
        return new ArrayList(this.allCookies.keySet());
    }

    public synchronized boolean remove(URI uri, HttpCookie cookie) {
        boolean cookieRemoved;
        Set<HttpCookie> targetCookies = (Set) this.allCookies.get(uri);
        cookieRemoved = targetCookies != null && targetCookies.remove(cookie);
        if (cookieRemoved) {
            removeFromPersistence(uri, cookie);
        }
        return cookieRemoved;
    }

    private void removeFromPersistence(URI uri, HttpCookie cookieToRemove) {
        Editor editorGSON = this.gsonSharedPreferences.edit();
        editorGSON.remove(getCookieKey(uri, cookieToRemove));
        editorGSON.apply();
    }

    public synchronized boolean removeAll() {
        this.allCookies.clear();
        removeAllFromPersistence();
        return true;
    }

    private void removeAllFromPersistence() {
        this.gsonSharedPreferences.edit().clear().apply();
    }

    private String getCookieKey(URI uri, HttpCookie cookie) {
        return uri.toString() + '|' + cookie.getName();
    }

    private String getGsonSerializedCookie(HttpCookie cookie) {
        return sGson.a((Object) cookie);
    }
}
