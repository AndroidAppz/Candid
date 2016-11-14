package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import defpackage.vp;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEvent implements Serializable {
    private static final HashSet<String> c = new HashSet();
    private JSONObject a;
    private boolean b;
    private String d;

    public static class SerializationProxyV1 implements Serializable {
        private final String a;
        private final boolean b;

        private SerializationProxyV1(String jsonString, boolean isImplicit) {
            this.a = jsonString;
            this.b = isImplicit;
        }

        private Object readResolve() throws JSONException {
            return new AppEvent(this.a, this.b);
        }
    }

    public AppEvent(String contextName, String eventName, Double valueToSum, Bundle parameters, boolean isImplicitlyLogged, UUID currentSessionId) {
        try {
            a(eventName);
            this.d = eventName;
            this.b = isImplicitlyLogged;
            this.a = new JSONObject();
            this.a.put("_eventName", eventName);
            this.a.put("_logTime", System.currentTimeMillis() / 1000);
            this.a.put("_ui", contextName);
            if (currentSessionId != null) {
                this.a.put("_session_id", currentSessionId);
            }
            if (valueToSum != null) {
                this.a.put("_valueToSum", valueToSum.doubleValue());
            }
            if (this.b) {
                this.a.put("_implicitlyLogged", "1");
            }
            if (parameters != null) {
                for (String key : parameters.keySet()) {
                    a(key);
                    Object value = parameters.get(key);
                    if ((value instanceof String) || (value instanceof Number)) {
                        this.a.put(key, value.toString());
                    } else {
                        throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[]{value, key}));
                    }
                }
            }
            if (!this.b) {
                vp.a(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", this.a.toString());
            }
        } catch (JSONException jsonException) {
            vp.a(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", jsonException.toString());
            this.a = null;
        } catch (FacebookException e) {
            vp.a(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event name or parameter:", e.toString());
            this.a = null;
        }
    }

    public String a() {
        return this.d;
    }

    private AppEvent(String jsonString, boolean isImplicit) throws JSONException {
        this.a = new JSONObject(jsonString);
        this.b = isImplicit;
    }

    public boolean b() {
        return this.b;
    }

    public JSONObject c() {
        return this.a;
    }

    private void a(String identifier) throws FacebookException {
        String regex = "^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$";
        if (identifier == null || identifier.length() == 0 || identifier.length() > 40) {
            if (identifier == null) {
                identifier = "<None Provided>";
            }
            throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[]{identifier, Integer.valueOf(40)}));
        }
        synchronized (c) {
            boolean alreadyValidated = c.contains(identifier);
        }
        if (!alreadyValidated) {
            if (identifier.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
                synchronized (c) {
                    c.add(identifier);
                }
                return;
            }
            throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[]{identifier}));
        }
    }

    private Object writeReplace() {
        return new SerializationProxyV1(this.a.toString(), this.b);
    }

    public String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", new Object[]{this.a.optString("_eventName"), Boolean.valueOf(this.b), this.a.toString()});
    }
}
