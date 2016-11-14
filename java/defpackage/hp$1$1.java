package defpackage;

import com.becandid.candid.data.Post;
import java.util.List;

/* compiled from: FeedFragment */
class hp$1$1 extends apj<List<Post>> {
    final /* synthetic */ hp$1 a;

    hp$1$1(hp$1 this$1) {
        this.a = this$1;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((List) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
    }

    public void a(List<Post> posts) {
        if (posts == null || posts.isEmpty()) {
            this.a.a.b.a(null);
        } else if (posts.size() != 1 || (posts.get(0) instanceof Post)) {
            this.a.a.b.b((List) posts);
            this.a.a.b.a(Integer.toString(((Post) posts.get(posts.size() - 1)).post_id));
        }
    }
}
