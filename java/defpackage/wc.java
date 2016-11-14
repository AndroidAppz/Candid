package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.FacebookActivity;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.login.CustomTabLoginMethodHandler;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.Result.Code;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LoginFragment */
public class wc extends Fragment {
    private String a;
    private LoginClient b;
    private Request c;
    private boolean d;
    private String e;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.d = savedInstanceState != null;
        if (savedInstanceState != null) {
            this.b = (LoginClient) savedInstanceState.getParcelable("loginClient");
            this.b.a((Fragment) this);
            this.e = savedInstanceState.getString("challenge");
        } else {
            this.b = new LoginClient((Fragment) this);
            this.e = vw.a(20);
        }
        this.b.a(new wc$1(this));
        Activity activity = getActivity();
        if (activity != null) {
            a(activity);
            if (activity.getIntent() != null) {
                Intent intent = activity.getIntent();
                intent.setExtrasClassLoader(Request.class.getClassLoader());
                this.c = (Request) intent.getParcelableExtra("request");
            }
        }
    }

    public void onDestroy() {
        this.b.f();
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(um$e.com_facebook_login_fragment, container, false);
        this.b.a(new wc$2(this, view));
        return view;
    }

    private void a(Result outcome) {
        this.c = null;
        int resultCode = outcome.a == Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", outcome);
        Intent resultIntent = new Intent();
        resultIntent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(resultCode, resultIntent);
            getActivity().finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.a == null) {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            getActivity().finish();
            return;
        }
        if (this.d) {
            Activity activity = getActivity();
            if ((activity instanceof FacebookActivity) && (this.b.g() instanceof CustomTabLoginMethodHandler)) {
                ((FacebookActivity) activity).a(null, new FacebookOperationCanceledException());
            }
        }
        this.d = true;
        this.b.a(this.c);
    }

    public void onPause() {
        super.onPause();
        getActivity().findViewById(um$d.com_facebook_login_activity_progress_bar).setVisibility(8);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.b.a(requestCode, resultCode, data);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("loginClient", this.b);
        outState.putString("challenge", this.e);
    }

    private void a(Activity activity) {
        ComponentName componentName = activity.getCallingActivity();
        if (componentName != null) {
            this.a = componentName.getPackageName();
        }
    }

    public boolean a(Bundle values) {
        boolean z = false;
        try {
            String stateString = values.getString("state");
            if (stateString != null) {
                z = new JSONObject(stateString).getString("7_challenge").equals(this.e);
            }
        } catch (JSONException e) {
        }
        return z;
    }

    public String a() {
        return this.e;
    }

    public LoginClient b() {
        return this.b;
    }
}
