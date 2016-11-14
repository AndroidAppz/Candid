package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.becandid.candid.data.AppState;
import rx.schedulers.Schedulers;

/* compiled from: FeedFragment */
public class hp extends Fragment {
    private View a;
    private hf b;
    private String c;
    private apk d;
    private RecyclerView e;
    private SwipeRefreshLayout f;
    private View g;
    private Handler h;
    private final int i = 60000;
    private long j;
    private Runnable k = new hp$7(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args.containsKey("feed_type")) {
            this.c = args.getString("feed_type");
        }
        this.h = new Handler(Looper.getMainLooper());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.a = inflater.inflate(2130968662, container, false);
        this.g = this.a.findViewById(um$d.progress_bar);
        this.e = (RecyclerView) this.a.findViewById(2131624391);
        LayoutManager layoutManager = new LinearLayoutManager(getContext());
        this.e.setLayoutManager(layoutManager);
        this.b = new hf((BaseActivity) getContext());
        this.e.setAdapter(this.b);
        ItemAnimator animator = this.e.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        this.e.addOnScrollListener(new hp$1(this, (LinearLayoutManager) layoutManager, this.b));
        this.f = (SwipeRefreshLayout) this.a.findViewById(2131624163);
        this.f.setOnRefreshListener(new hp$2(this));
        this.d = a(this.c);
        ((BaseActivity) getActivity()).addToSubscriptionList(this.d);
        ((BaseActivity) getActivity()).addToSubscriptionList(iq.a().a(ih$k.class, new hp$3(this)));
        ((BaseActivity) getActivity()).addToSubscriptionList(iq.a().a(ih$p.class, new hp$4(this)));
        ((BaseActivity) getActivity()).addToSubscriptionList(iq.a().a(ih$n.class, new hp$5(this)));
        ((BaseActivity) getActivity()).addToSubscriptionList(iq.a().a(ih$o.class, new hp$6(this)));
        return this.a;
    }

    public void a() {
        this.h.postDelayed(this.k, 60000);
        if (AppState.account != null && AppState.account.unread_feed_count > 0) {
            this.d = a(this.c);
        }
    }

    private apj c() {
        return new hp$8(this);
    }

    private apk a(String feedType) {
        if (this.b != null) {
            return ie.a().c(feedType, null, this.b.b(feedType)).b(Schedulers.io()).a(apn.a()).b(c());
        }
        rb.a(new Exception("Feed Adapter is NULL"));
        return null;
    }

    public void b() {
        AppState.expandedPostIds.clear();
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        if (this.g != null) {
            this.g.setVisibility(0);
        }
        if (this.d != null) {
            this.d.unsubscribe();
        }
        this.d = a(this.c);
    }

    private void a(ih$k didCreatePost) {
        try {
            this.b.a(didCreatePost.a);
            this.e.smoothScrollToPosition(0);
        } catch (Exception e) {
            rb.a(e);
        }
    }

    public void a(int upsellId) {
        this.b.b(upsellId);
    }

    public void onResume() {
        super.onResume();
        if (this.j == 0 || (System.currentTimeMillis() - this.j) / 60000 <= ((long) AppState.config.getInt("refresh_timeout", 5))) {
            a();
        } else {
            b();
        }
    }

    public void onPause() {
        super.onPause();
        this.h.removeCallbacks(this.k);
        this.j = System.currentTimeMillis();
    }
}
