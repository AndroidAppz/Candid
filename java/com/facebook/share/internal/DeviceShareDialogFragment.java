package com.facebook.share.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.b;
import com.facebook.HttpMethod;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import defpackage.ug;
import defpackage.um$d;
import defpackage.um$e;
import defpackage.um$f;
import defpackage.um$g;
import defpackage.vx;
import defpackage.ws;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceShareDialogFragment extends DialogFragment {
    private static ScheduledThreadPoolExecutor f;
    private ProgressBar a;
    private TextView b;
    private Dialog c;
    private volatile RequestState d;
    private volatile ScheduledFuture e;
    private ShareContent g;

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
        private long b;

        RequestState() {
        }

        public String a() {
            return this.a;
        }

        public void a(String userCode) {
            this.a = userCode;
        }

        public long b() {
            return this.b;
        }

        public void a(long expiresIn) {
            this.b = expiresIn;
        }

        protected RequestState(Parcel in) {
            this.a = in.readString();
            this.b = in.readLong();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.a);
            dest.writeLong(this.b);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (savedInstanceState != null) {
            RequestState requestState = (RequestState) savedInstanceState.getParcelable("request_state");
            if (requestState != null) {
                a(requestState);
            }
        }
        return view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this.c = new Dialog(getActivity(), um$g.com_facebook_auth_dialog);
        View view = getActivity().getLayoutInflater().inflate(um$e.com_facebook_device_auth_dialog_fragment, null);
        this.a = (ProgressBar) view.findViewById(um$d.progress_bar);
        this.b = (TextView) view.findViewById(um$d.confirmation_code);
        ((Button) view.findViewById(um$d.cancel_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DeviceShareDialogFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.c.dismiss();
            }
        });
        ((TextView) view.findViewById(um$d.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(um$f.com_facebook_device_auth_instructions)));
        ((TextView) view.findViewById(um$d.com_facebook_device_dialog_title)).setText(getString(um$f.com_facebook_share_button_text));
        this.c.setContentView(view);
        c();
        return this.c;
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (this.e != null) {
            this.e.cancel(true);
        }
        a(-1, new Intent());
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.d != null) {
            outState.putParcelable("request_state", this.d);
        }
    }

    private void a(int resultCode, Intent data) {
        if (isAdded()) {
            Activity activity = getActivity();
            activity.setResult(resultCode, data);
            activity.finish();
        }
    }

    private void a() {
        if (isAdded()) {
            getFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    public void a(ShareContent shareContent) {
        this.g = shareContent;
    }

    private Bundle b() {
        ShareContent content = this.g;
        if (content == null) {
            return null;
        }
        if (content instanceof ShareLinkContent) {
            return ws.a((ShareLinkContent) content);
        }
        if (content instanceof ShareOpenGraphContent) {
            return ws.a((ShareOpenGraphContent) content);
        }
        return null;
    }

    private void c() {
        Bundle parameters = b();
        if (parameters == null || parameters.size() == 0) {
            a(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        parameters.putString("access_token", vx.b() + "|" + vx.c());
        new GraphRequest(null, "device/share", parameters, HttpMethod.POST, new b(this) {
            final /* synthetic */ DeviceShareDialogFragment a;

            {
                this.a = this$0;
            }

            public void onCompleted(ug response) {
                FacebookRequestError error = response.a();
                if (error != null) {
                    this.a.a(error);
                    return;
                }
                JSONObject jsonObject = response.b();
                RequestState requestState = new RequestState();
                try {
                    requestState.a(jsonObject.getString("user_code"));
                    requestState.a(jsonObject.getLong("expires_in"));
                    this.a.a(requestState);
                } catch (JSONException e) {
                    this.a.a(new FacebookRequestError(0, "", "Malformed server response"));
                }
            }
        }).j();
    }

    private void a(FacebookRequestError error) {
        a();
        Intent intent = new Intent();
        intent.putExtra("error", error);
        a(-1, intent);
    }

    private static synchronized ScheduledThreadPoolExecutor d() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceShareDialogFragment.class) {
            if (f == null) {
                f = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = f;
        }
        return scheduledThreadPoolExecutor;
    }

    private void a(RequestState currentRequestState) {
        this.d = currentRequestState;
        this.b.setText(currentRequestState.a());
        this.b.setVisibility(0);
        this.a.setVisibility(8);
        this.e = d().schedule(new Runnable(this) {
            final /* synthetic */ DeviceShareDialogFragment a;

            {
                this.a = this$0;
            }

            public void run() {
                this.a.c.dismiss();
            }
        }, currentRequestState.b(), TimeUnit.SECONDS);
    }
}
