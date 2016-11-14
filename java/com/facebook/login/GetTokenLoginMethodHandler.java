package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import defpackage.vs$a;
import defpackage.vw;
import defpackage.vw$c;
import defpackage.wb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Creator<GetTokenLoginMethodHandler> CREATOR = new Creator() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public GetTokenLoginMethodHandler a(Parcel source) {
            return new GetTokenLoginMethodHandler(source);
        }

        public GetTokenLoginMethodHandler[] a(int size) {
            return new GetTokenLoginMethodHandler[size];
        }
    };
    private wb c;

    GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    String a() {
        return "get_token";
    }

    void b() {
        if (this.c != null) {
            this.c.b();
            this.c.a(null);
            this.c = null;
        }
    }

    boolean a(final Request request) {
        this.c = new wb(this.b.b(), request.d());
        if (!this.c.a()) {
            return false;
        }
        this.b.k();
        this.c.a(new vs$a(this) {
            final /* synthetic */ GetTokenLoginMethodHandler b;

            public void a(Bundle result) {
                this.b.a(request, result);
            }
        });
        return true;
    }

    void a(Request request, Bundle result) {
        if (this.c != null) {
            this.c.a(null);
        }
        this.c = null;
        this.b.l();
        if (result != null) {
            ArrayList<String> currentPermissions = result.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            Set<String> permissions = request.a();
            if (currentPermissions == null || !(permissions == null || currentPermissions.containsAll(permissions))) {
                Set newPermissions = new HashSet();
                for (String permission : permissions) {
                    if (!currentPermissions.contains(permission)) {
                        newPermissions.add(permission);
                    }
                }
                if (!newPermissions.isEmpty()) {
                    a("new_permissions", TextUtils.join(",", newPermissions));
                }
                request.a(newPermissions);
            } else {
                c(request, result);
                return;
            }
        }
        this.b.i();
    }

    void b(Request request, Bundle result) {
        this.b.a(Result.a(this.b.c(), LoginMethodHandler.a(result, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.d())));
    }

    void c(final Request request, final Bundle result) {
        String userId = result.getString("com.facebook.platform.extra.USER_ID");
        if (userId == null || userId.isEmpty()) {
            this.b.k();
            vw.a(result.getString("com.facebook.platform.extra.ACCESS_TOKEN"), new vw$c(this) {
                final /* synthetic */ GetTokenLoginMethodHandler c;

                public void a(JSONObject userInfo) {
                    try {
                        result.putString("com.facebook.platform.extra.USER_ID", userInfo.getString("id"));
                        this.c.b(request, result);
                    } catch (JSONException ex) {
                        this.c.b.b(Result.a(this.c.b.c(), "Caught exception", ex.getMessage()));
                    }
                }

                public void a(FacebookException error) {
                    this.c.b.b(Result.a(this.c.b.c(), "Caught exception", error.getMessage()));
                }
            });
            return;
        }
        b(request, result);
    }

    GetTokenLoginMethodHandler(Parcel source) {
        super(source);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }
}
