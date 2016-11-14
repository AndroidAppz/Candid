package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import defpackage.uj;
import defpackage.vw;
import defpackage.vw$c;
import defpackage.vx;
import org.json.JSONException;
import org.json.JSONObject;

public final class Profile implements Parcelable {
    public static final Creator<Profile> CREATOR = new Creator() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public Profile a(Parcel source) {
            return new Profile(source);
        }

        public Profile[] a(int size) {
            return new Profile[size];
        }
    };
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final Uri f;

    public static Profile a() {
        return uj.a().b();
    }

    public static void a(Profile profile) {
        uj.a().a(profile);
    }

    public static void b() {
        AccessToken accessToken = AccessToken.a();
        if (accessToken == null) {
            a(null);
        } else {
            vw.a(accessToken.b(), new vw$c() {
                public void a(JSONObject userInfo) {
                    String id = userInfo.optString("id");
                    if (id != null) {
                        String link = userInfo.optString("link");
                        Profile.a(new Profile(id, userInfo.optString("first_name"), userInfo.optString("middle_name"), userInfo.optString("last_name"), userInfo.optString("name"), link != null ? Uri.parse(link) : null));
                    }
                }

                public void a(FacebookException error) {
                }
            });
        }
    }

    public Profile(String id, String firstName, String middleName, String lastName, String name, Uri linkUri) {
        vx.a(id, "id");
        this.a = id;
        this.b = firstName;
        this.c = middleName;
        this.d = lastName;
        this.e = name;
        this.f = linkUri;
    }

    public String c() {
        return this.e;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Profile)) {
            return false;
        }
        Profile o = (Profile) other;
        if (this.a.equals(o.a) && this.b == null) {
            if (o.b != null) {
                return false;
            }
            return true;
        } else if (this.b.equals(o.b) && this.c == null) {
            if (o.c != null) {
                return false;
            }
            return true;
        } else if (this.c.equals(o.c) && this.d == null) {
            if (o.d != null) {
                return false;
            }
            return true;
        } else if (this.d.equals(o.d) && this.e == null) {
            if (o.e != null) {
                return false;
            }
            return true;
        } else if (!this.e.equals(o.e) || this.f != null) {
            return this.f.equals(o.f);
        } else {
            if (o.f != null) {
                return false;
            }
            return true;
        }
    }

    public int hashCode() {
        int result = this.a.hashCode() + 527;
        if (this.b != null) {
            result = (result * 31) + this.b.hashCode();
        }
        if (this.c != null) {
            result = (result * 31) + this.c.hashCode();
        }
        if (this.d != null) {
            result = (result * 31) + this.d.hashCode();
        }
        if (this.e != null) {
            result = (result * 31) + this.e.hashCode();
        }
        if (this.f != null) {
            return (result * 31) + this.f.hashCode();
        }
        return result;
    }

    public JSONObject d() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", this.a);
            jsonObject.put("first_name", this.b);
            jsonObject.put("middle_name", this.c);
            jsonObject.put("last_name", this.d);
            jsonObject.put("name", this.e);
            if (this.f == null) {
                return jsonObject;
            }
            jsonObject.put("link_uri", this.f.toString());
            return jsonObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public Profile(JSONObject jsonObject) {
        Uri uri = null;
        this.a = jsonObject.optString("id", null);
        this.b = jsonObject.optString("first_name", null);
        this.c = jsonObject.optString("middle_name", null);
        this.d = jsonObject.optString("last_name", null);
        this.e = jsonObject.optString("name", null);
        String linkUriString = jsonObject.optString("link_uri", null);
        if (linkUriString != null) {
            uri = Uri.parse(linkUriString);
        }
        this.f = uri;
    }

    private Profile(Parcel source) {
        this.a = source.readString();
        this.b = source.readString();
        this.c = source.readString();
        this.d = source.readString();
        this.e = source.readString();
        String linkUriString = source.readString();
        this.f = linkUriString == null ? null : Uri.parse(linkUriString);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.a);
        dest.writeString(this.b);
        dest.writeString(this.c);
        dest.writeString(this.d);
        dest.writeString(this.e);
        dest.writeString(this.f == null ? null : this.f.toString());
    }
}
