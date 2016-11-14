package defpackage;

import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Post;
import java.util.List;

/* compiled from: FeedFragment */
class hp$7$1 extends apj<List<Post>> {
    final /* synthetic */ hp$7 a;

    hp$7$1(hp$7 this$1) {
        this.a = this$1;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((List) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(List<Post> posts) {
        for (Post post : posts) {
            int hasData = this.a.a.b.b((Object) post);
            if (!(hasData == -1 || AppState.expandedPostIds.contains(Integer.valueOf(post.post_id)))) {
                this.a.a.b.a(hasData, post);
            }
        }
    }
}
