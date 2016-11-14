package defpackage;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.FacebookException;

/* compiled from: FacebookDialogFragment */
public class ve extends DialogFragment {
    private Dialog a;

    public void a(Dialog dialog) {
        this.a = dialog;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.a == null) {
            vy webDialog;
            FragmentActivity activity = getActivity();
            Bundle params = vr.d(activity.getIntent());
            if (params.getBoolean("is_fallback", false)) {
                String url = params.getString("url");
                if (vw.a(url)) {
                    vw.b("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                }
                webDialog = new vg(activity, url, String.format("fb%s://bridge/", new Object[]{ud.i()}));
                webDialog.a(new ve$2(this));
            } else {
                String actionName = params.getString("action");
                Bundle webParams = params.getBundle("params");
                if (vw.a(actionName)) {
                    vw.b("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                }
                webDialog = new vy$a(activity, actionName, webParams).a(new ve$1(this)).a();
            }
            this.a = webDialog;
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (this.a == null) {
            a(null, null);
            setShowsDialog(false);
        }
        return this.a;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.a instanceof vy) {
            ((vy) this.a).d();
        }
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    private void a(Bundle values, FacebookException error) {
        FragmentActivity fragmentActivity = getActivity();
        fragmentActivity.setResult(error == null ? -1 : 0, vr.a(fragmentActivity.getIntent(), values, error));
        fragmentActivity.finish();
    }

    private void a(Bundle values) {
        FragmentActivity fragmentActivity = getActivity();
        Intent resultIntent = new Intent();
        if (values == null) {
            values = new Bundle();
        }
        resultIntent.putExtras(values);
        fragmentActivity.setResult(-1, resultIntent);
        fragmentActivity.finish();
    }
}
