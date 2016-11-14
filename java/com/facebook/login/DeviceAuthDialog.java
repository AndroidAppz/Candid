package com.facebook.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.b;
import com.facebook.HttpMethod;
import com.facebook.login.LoginClient.Request;
import defpackage.ud;
import defpackage.ue;
import defpackage.ug;
import defpackage.um$d;
import defpackage.um$e;
import defpackage.um$f;
import defpackage.um$g;
import defpackage.vw;
import defpackage.vw$e;
import defpackage.vx;
import defpackage.wc;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class DeviceAuthDialog extends DialogFragment {
    private ProgressBar a;
    private TextView b;
    private DeviceAuthMethodHandler c;
    private AtomicBoolean d = new AtomicBoolean();
    private volatile ue e;
    private volatile ScheduledFuture f;
    private volatile RequestState g;
    private Dialog h;
    private boolean i = false;

    static class RequestState implements Parcelable {
        public static final Creator<RequestState> CREATOR = new Creator<RequestState>() {
            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return a(i);
            }

            public RequestState a(Parcel in) {
                return new RequestState(in);
            }

            public RequestState[] a(int size) {
                return new RequestState[size];
            }
        };
        private String a;
        private String b;
        private long c;
        private long d;

        RequestState() {
        }

        public String a() {
            return this.a;
        }

        public void a(String userCode) {
            this.a = userCode;
        }

        public String b() {
            return this.b;
        }

        public void b(String requestCode) {
            this.b = requestCode;
        }

        public long c() {
            return this.c;
        }

        public void a(long interval) {
            this.c = interval;
        }

        public void b(long lastPoll) {
            this.d = lastPoll;
        }

        protected RequestState(Parcel in) {
            this.a = in.readString();
            this.b = in.readString();
            this.c = in.readLong();
            this.d = in.readLong();
        }

        public boolean d() {
            if (this.d != 0 && (new Date().getTime() - this.d) - (this.c * 1000) < 0) {
                return true;
            }
            return false;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.a);
            dest.writeString(this.b);
            dest.writeLong(this.c);
            dest.writeLong(this.d);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.c = (DeviceAuthMethodHandler) ((wc) ((FacebookActivity) getActivity()).a()).b().g();
        if (savedInstanceState != null) {
            RequestState requestState = (RequestState) savedInstanceState.getParcelable("request_state");
            if (requestState != null) {
                a(requestState);
            }
        }
        return view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this.h = new Dialog(getActivity(), um$g.com_facebook_auth_dialog);
        View view = getActivity().getLayoutInflater().inflate(um$e.com_facebook_device_auth_dialog_fragment, null);
        this.a = (ProgressBar) view.findViewById(um$d.progress_bar);
        this.b = (TextView) view.findViewById(um$d.confirmation_code);
        ((Button) view.findViewById(um$d.cancel_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DeviceAuthDialog a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.d();
            }
        });
        ((TextView) view.findViewById(um$d.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(um$f.com_facebook_device_auth_instructions)));
        this.h.setContentView(view);
        return this.h;
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (!this.i) {
            d();
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.g != null) {
            outState.putParcelable("request_state", this.g);
        }
    }

    public void onDestroy() {
        this.i = true;
        this.d.set(true);
        super.onDestroy();
        if (this.e != null) {
            this.e.cancel(true);
        }
        if (this.f != null) {
            this.f.cancel(true);
        }
    }

    public void a(Request request) {
        Bundle parameters = new Bundle();
        parameters.putString("scope", TextUtils.join(",", request.a()));
        String redirectUriString = request.g();
        if (redirectUriString != null) {
            parameters.putString("redirect_uri", redirectUriString);
        }
        parameters.putString("access_token", vx.b() + "|" + vx.c());
        new GraphRequest(null, "device/login", parameters, HttpMethod.POST, new b(this) {
            final /* synthetic */ DeviceAuthDialog a;

            {
                this.a = this$0;
            }

            public void onCompleted(ug response) {
                if (response.a() != null) {
                    this.a.a(response.a().g());
                    return;
                }
                JSONObject jsonObject = response.b();
                RequestState requestState = new RequestState();
                try {
                    requestState.a(jsonObject.getString("user_code"));
                    requestState.b(jsonObject.getString("code"));
                    requestState.a(jsonObject.getLong("interval"));
                    this.a.a(requestState);
                } catch (Throwable ex) {
                    this.a.a(new FacebookException(ex));
                }
            }
        }).j();
    }

    private void a(RequestState currentRequestState) {
        this.g = currentRequestState;
        this.b.setText(currentRequestState.a());
        this.b.setVisibility(0);
        this.a.setVisibility(8);
        if (currentRequestState.d()) {
            b();
        } else {
            a();
        }
    }

    private void a() {
        this.g.b(new Date().getTime());
        this.e = c().j();
    }

    private void b() {
        this.f = DeviceAuthMethodHandler.c().schedule(new Runnable(this) {
            final /* synthetic */ DeviceAuthDialog a;

            {
                this.a = this$0;
            }

            public void run() {
                this.a.a();
            }
        }, this.g.c(), TimeUnit.SECONDS);
    }

    private GraphRequest c() {
        Bundle parameters = new Bundle();
        parameters.putString("code", this.g.b());
        return new GraphRequest(null, "device/login_status", parameters, HttpMethod.POST, new b(this) {
            final /* synthetic */ DeviceAuthDialog a;

            {
                this.a = this$0;
            }

            public void onCompleted(ug response) {
                if (!this.a.d.get()) {
                    FacebookRequestError error = response.a();
                    if (error != null) {
                        switch (error.c()) {
                            case 1349152:
                            case 1349173:
                                this.a.d();
                                return;
                            case 1349172:
                            case 1349174:
                                this.a.b();
                                return;
                            default:
                                this.a.a(response.a().g());
                                return;
                        }
                    }
                    try {
                        this.a.a(response.b().getString("access_token"));
                    } catch (Throwable ex) {
                        this.a.a(new FacebookException(ex));
                    }
                }
            }
        });
    }

    private void a(final String accessToken) {
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,permissions");
        new GraphRequest(new AccessToken(accessToken, ud.i(), "0", null, null, null, null, null), "me", parameters, HttpMethod.GET, new b(this) {
            final /* synthetic */ DeviceAuthDialog b;

            public void onCompleted(ug response) {
                if (!this.b.d.get()) {
                    if (response.a() != null) {
                        this.b.a(response.a().g());
                        return;
                    }
                    try {
                        JSONObject jsonObject = response.b();
                        String userId = jsonObject.getString("id");
                        vw$e permissions = vw.a(jsonObject);
                        this.b.c.a(accessToken, ud.i(), userId, permissions.a(), permissions.b(), AccessTokenSource.DEVICE_AUTH, null, null);
                        this.b.h.dismiss();
                    } catch (Throwable ex) {
                        this.b.a(new FacebookException(ex));
                    }
                }
            }
        }).j();
    }

    private void a(FacebookException ex) {
        if (this.d.compareAndSet(false, true)) {
            this.c.a((Exception) ex);
            this.h.dismiss();
        }
    }

    private void d() {
        if (this.d.compareAndSet(false, true)) {
            if (this.c != null) {
                this.c.d_();
            }
            this.h.dismiss();
        }
    }
}
