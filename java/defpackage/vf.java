package defpackage;

import com.facebook.FacebookRequestError.Category;
import com.facebook.internal.FacebookRequestErrorClassification$1;
import com.facebook.internal.FacebookRequestErrorClassification$2;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FacebookRequestErrorClassification */
public final class vf {
    private static vf g;
    private final Map<Integer, Set<Integer>> a;
    private final Map<Integer, Set<Integer>> b;
    private final Map<Integer, Set<Integer>> c;
    private final String d;
    private final String e;
    private final String f;

    vf(Map<Integer, Set<Integer>> otherErrors, Map<Integer, Set<Integer>> transientErrors, Map<Integer, Set<Integer>> loginRecoverableErrors, String otherRecoveryMessage, String transientRecoveryMessage, String loginRecoverableRecoveryMessage) {
        this.a = otherErrors;
        this.b = transientErrors;
        this.c = loginRecoverableErrors;
        this.d = otherRecoveryMessage;
        this.e = transientRecoveryMessage;
        this.f = loginRecoverableRecoveryMessage;
    }

    public String a(Category category) {
        switch (vf$1.a[category.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return this.d;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return this.f;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return this.e;
            default:
                return null;
        }
    }

    public Category a(int errorCode, int errorSubCode, boolean isTransient) {
        if (isTransient) {
            return Category.TRANSIENT;
        }
        Set<Integer> subCodes;
        if (this.a != null && this.a.containsKey(Integer.valueOf(errorCode))) {
            subCodes = (Set) this.a.get(Integer.valueOf(errorCode));
            if (subCodes == null || subCodes.contains(Integer.valueOf(errorSubCode))) {
                return Category.OTHER;
            }
        }
        if (this.c != null && this.c.containsKey(Integer.valueOf(errorCode))) {
            subCodes = (Set) this.c.get(Integer.valueOf(errorCode));
            if (subCodes == null || subCodes.contains(Integer.valueOf(errorSubCode))) {
                return Category.LOGIN_RECOVERABLE;
            }
        }
        if (this.b != null && this.b.containsKey(Integer.valueOf(errorCode))) {
            subCodes = (Set) this.b.get(Integer.valueOf(errorCode));
            if (subCodes == null || subCodes.contains(Integer.valueOf(errorSubCode))) {
                return Category.TRANSIENT;
            }
        }
        return Category.OTHER;
    }

    public static synchronized vf a() {
        vf vfVar;
        synchronized (vf.class) {
            if (g == null) {
                g = vf.b();
            }
            vfVar = g;
        }
        return vfVar;
    }

    private static vf b() {
        return new vf(null, new FacebookRequestErrorClassification$1(), new FacebookRequestErrorClassification$2(), null, null, null);
    }

    private static Map<Integer, Set<Integer>> a(JSONObject definition) {
        JSONArray itemsArray = definition.optJSONArray("items");
        if (itemsArray.length() == 0) {
            return null;
        }
        Map<Integer, Set<Integer>> items = new HashMap();
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject item = itemsArray.optJSONObject(i);
            if (item != null) {
                int code = item.optInt("code");
                if (code != 0) {
                    Set<Integer> subcodes = null;
                    JSONArray subcodesArray = item.optJSONArray("subcodes");
                    if (subcodesArray != null && subcodesArray.length() > 0) {
                        subcodes = new HashSet();
                        for (int j = 0; j < subcodesArray.length(); j++) {
                            int subCode = subcodesArray.optInt(j);
                            if (subCode != 0) {
                                subcodes.add(Integer.valueOf(subCode));
                            }
                        }
                    }
                    items.put(Integer.valueOf(code), subcodes);
                }
            }
        }
        return items;
    }

    public static vf a(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        Map<Integer, Set<Integer>> otherErrors = null;
        Map<Integer, Set<Integer>> transientErrors = null;
        Map<Integer, Set<Integer>> loginRecoverableErrors = null;
        String otherRecoveryMessage = null;
        String transientRecoveryMessage = null;
        String loginRecoverableRecoveryMessage = null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject definition = jsonArray.optJSONObject(i);
            if (definition != null) {
                String name = definition.optString("name");
                if (name != null) {
                    if (name.equalsIgnoreCase("other")) {
                        otherRecoveryMessage = definition.optString("recovery_message", null);
                        otherErrors = vf.a(definition);
                    } else if (name.equalsIgnoreCase("transient")) {
                        transientRecoveryMessage = definition.optString("recovery_message", null);
                        transientErrors = vf.a(definition);
                    } else if (name.equalsIgnoreCase("login_recoverable")) {
                        loginRecoverableRecoveryMessage = definition.optString("recovery_message", null);
                        loginRecoverableErrors = vf.a(definition);
                    }
                }
            }
        }
        return new vf(otherErrors, transientErrors, loginRecoverableErrors, otherRecoveryMessage, transientRecoveryMessage, loginRecoverableRecoveryMessage);
    }
}
