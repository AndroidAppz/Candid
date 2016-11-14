package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.Post;
import rx.schedulers.Schedulers;

/* compiled from: MePostsFragment */
public class ht extends Fragment {
    private View a;
    private RecyclerView b;
    private hf c;
    private View d;
    private SwipeRefreshLayout e;
    private apk f;

    public apk a() {
        return ie.a().h(0).b(Schedulers.io()).a(apn.a()).b(new ht$1(this));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.a = inflater.inflate(2130968673, container, false);
        this.d = this.a.findViewById(2131624179);
        this.b = (RecyclerView) this.a.findViewById(2131624445);
        LayoutManager layoutManager = new LinearLayoutManager(getContext());
        this.b.setLayoutManager(layoutManager);
        this.c = new hf((BaseActivity) getActivity());
        this.b.setAdapter(this.c);
        this.b.addOnScrollListener(new ht$2(this, (LinearLayoutManager) layoutManager, this.c));
        ItemAnimator animator = this.b.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        this.e = (SwipeRefreshLayout) this.a.findViewById(2131624163);
        this.e.setOnRefreshListener(new ht$3(this));
        this.f = a();
        return this.a;
    }

    public void b() {
        if (this.c != null) {
            this.f = a();
        }
    }

    public void a(Post post) {
        if (this.c != null) {
            this.c.a(post);
            this.d.setVisibility(8);
        }
    }

    public void a(int postId) {
        if (this.c != null) {
            this.c.b(postId);
            if (this.c.getItemCount() <= 0) {
                this.d.setVisibility(0);
            }
        }
    }
}
