package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;

/* compiled from: WebDialog */
class vy$b extends WebViewClient {
    final /* synthetic */ vy a;

    private vy$b(vy vyVar) {
        this.a = vyVar;
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        vw.b("FacebookSDK.WebDialog", "Redirect URL: " + url);
        if (url.startsWith(this.a.b)) {
            Bundle values = this.a.a(url);
            String error = values.getString("error");
            if (error == null) {
                error = values.getString("error_type");
            }
            String errorMessage = values.getString("error_msg");
            if (errorMessage == null) {
                errorMessage = values.getString("error_message");
            }
            if (errorMessage == null) {
                errorMessage = values.getString("error_description");
            }
            String errorCodeString = values.getString("error_code");
            int errorCode = -1;
            if (!vw.a(errorCodeString)) {
                try {
                    errorCode = Integer.parseInt(errorCodeString);
                } catch (NumberFormatException e) {
                    errorCode = -1;
                }
            }
            if (vw.a(error) && vw.a(errorMessage) && errorCode == -1) {
                this.a.a(values);
            } else if (error != null && (error.equals("access_denied") || error.equals("OAuthAccessDeniedException"))) {
                this.a.cancel();
            } else if (errorCode == 4201) {
                this.a.cancel();
            } else {
                this.a.a(new FacebookServiceException(new FacebookRequestError(errorCode, error, errorMessage), errorMessage));
            }
            return true;
        } else if (url.startsWith("fbconnect://cancel")) {
            this.a.cancel();
            return true;
        } else if (url.contains("touch")) {
            return false;
        } else {
            try {
                this.a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                return true;
            } catch (ActivityNotFoundException e2) {
                return false;
            }
        }
    }

    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        this.a.a(new FacebookDialogException(description, errorCode, failingUrl));
    }

    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        super.onReceivedSslError(view, handler, error);
        handler.cancel();
        this.a.a(new FacebookDialogException(null, -11, null));
    }

    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        vw.b("FacebookSDK.WebDialog", "Webview loading URL: " + url);
        super.onPageStarted(view, url, favicon);
        if (!this.a.i) {
            this.a.e.show();
        }
    }

    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (!this.a.i) {
            this.a.e.dismiss();
        }
        this.a.g.setBackgroundColor(0);
        this.a.d.setVisibility(0);
        this.a.f.setVisibility(0);
        this.a.j = true;
    }
}
