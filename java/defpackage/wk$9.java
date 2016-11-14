package defpackage;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.LoggingBehavior;

/* compiled from: LikeActionController */
class wk$9 extends wp {
    final /* synthetic */ Bundle a;
    final /* synthetic */ wk b;

    wk$9(wk this$0, uc callback, Bundle bundle) {
        this.b = this$0;
        this.a = bundle;
        super(callback);
    }

    public void a(ux appCall, Bundle data) {
        if (data != null && data.containsKey("object_is_liked")) {
            String unlikeToken;
            boolean isObjectLiked = data.getBoolean("object_is_liked");
            String likeCountStringWithLike = this.b.n;
            String likeCountStringWithoutLike = this.b.o;
            if (data.containsKey("like_count_string")) {
                likeCountStringWithLike = data.getString("like_count_string");
                likeCountStringWithoutLike = likeCountStringWithLike;
            }
            String socialSentenceWithLike = this.b.p;
            String socialSentenceWithoutWithoutLike = this.b.q;
            if (data.containsKey("social_sentence")) {
                socialSentenceWithLike = data.getString("social_sentence");
                socialSentenceWithoutWithoutLike = socialSentenceWithLike;
            }
            if (data.containsKey("object_is_liked")) {
                unlikeToken = data.getString("unlike_token");
            } else {
                unlikeToken = this.b.r;
            }
            Bundle logParams = this.a == null ? new Bundle() : this.a;
            logParams.putString("call_id", appCall.c().toString());
            this.b.l().a("fb_like_control_dialog_did_succeed", null, logParams);
            this.b.a(isObjectLiked, likeCountStringWithLike, likeCountStringWithoutLike, socialSentenceWithLike, socialSentenceWithoutWithoutLike, unlikeToken);
        }
    }

    public void a(ux appCall, FacebookException error) {
        vp.a(LoggingBehavior.REQUESTS, wk.a, "Like Dialog failed with error : %s", error);
        Bundle logParams = this.a == null ? new Bundle() : this.a;
        logParams.putString("call_id", appCall.c().toString());
        this.b.a("present_dialog", logParams);
        wk.c(this.b, "com.facebook.sdk.LikeActionController.DID_ERROR", vr.a(error));
    }

    public void a(ux appCall) {
        a(appCall, new FacebookOperationCanceledException());
    }
}
