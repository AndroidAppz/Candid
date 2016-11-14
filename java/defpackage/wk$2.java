package defpackage;

import android.os.Bundle;

/* compiled from: LikeActionController */
class wk$2 implements vs$a {
    final /* synthetic */ wk a;

    wk$2(wk this$0) {
        this.a = this$0;
    }

    public void a(Bundle result) {
        if (result != null && result.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED")) {
            String likeCountWithLike;
            String likeCountWithoutLike;
            String socialSentenceWithLike;
            String socialSentenceWithoutLike;
            String unlikeToken;
            boolean objectIsLiked = result.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
            if (result.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE")) {
                likeCountWithLike = result.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
            } else {
                likeCountWithLike = this.a.n;
            }
            if (result.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
                likeCountWithoutLike = result.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
            } else {
                likeCountWithoutLike = this.a.o;
            }
            if (result.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
                socialSentenceWithLike = result.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
            } else {
                socialSentenceWithLike = this.a.p;
            }
            if (result.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
                socialSentenceWithoutLike = result.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
            } else {
                socialSentenceWithoutLike = this.a.q;
            }
            if (result.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
                unlikeToken = result.getString("com.facebook.platform.extra.UNLIKE_TOKEN");
            } else {
                unlikeToken = this.a.r;
            }
            this.a.a(objectIsLiked, likeCountWithLike, likeCountWithoutLike, socialSentenceWithLike, socialSentenceWithoutLike, unlikeToken);
        }
    }
}
