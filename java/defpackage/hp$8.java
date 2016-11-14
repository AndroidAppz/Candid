package defpackage;

import com.becandid.candid.data.Post;
import java.util.List;

/* compiled from: FeedFragment */
class hp$8 extends apj<List<Post>> {
    final /* synthetic */ hp a;

    hp$8(hp this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((List) obj);
    }

    public void onCompleted() {
        this.a.e.scrollToPosition(0);
        this.a.e.setVisibility(0);
        this.a.g.setVisibility(8);
        this.a.f.setRefreshing(false);
    }

    public void onError(Throwable e) {
        this.a.g.setVisibility(8);
        this.a.f.setRefreshing(false);
    }

    public void a(List<Post> posts) {
        if (posts != null && !posts.isEmpty()) {
            if (posts.size() != 1 || (posts.get(0) instanceof Post)) {
                this.a.b.a((List) posts);
                this.a.b.a(Integer.toString(((Post) posts.get(posts.size() - 1)).post_id));
            }
        }
    }
}
