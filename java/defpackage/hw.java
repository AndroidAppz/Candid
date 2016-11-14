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
import com.becandid.candid.data.MessageThread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

/* compiled from: MessagesThreadsFragment */
public class hw extends Fragment {
    private View a;
    private View b;
    private RecyclerView c;
    private hj d;
    private SwipeRefreshLayout e;

    public void a(String page) {
        Map<String, String> params = new HashMap();
        params.put("thread_page", page);
        params.put("include_messages", "1");
        ie.a().o(params).b(Schedulers.io()).a(apn.a()).b(new hw$1(this, page));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.a = inflater.inflate(2130968676, container, false);
        this.b = this.a.findViewById(2131624457);
        this.c = (RecyclerView) this.a.findViewById(2131624456);
        LayoutManager layoutManager = new LinearLayoutManager(getContext());
        this.c.setLayoutManager(layoutManager);
        this.d = new hj(getActivity());
        this.c.setAdapter(this.d);
        this.c.addOnScrollListener(new hw$2(this, (LinearLayoutManager) layoutManager, this.d));
        ItemAnimator animator = this.c.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        this.e = (SwipeRefreshLayout) this.a.findViewById(2131624455);
        this.e.setOnRefreshListener(new hw$3(this));
        this.e.post(new hw$4(this));
        return this.a;
    }

    public void a(List<MessageThread> threads) {
        if (this.d != null) {
            this.d.a((List) threads);
        }
        this.e.setRefreshing(false);
    }

    public void a() {
        if (this.d.d()) {
            this.c.setVisibility(0);
            this.b.setVisibility(8);
            return;
        }
        this.c.setVisibility(8);
        this.b.setVisibility(0);
    }

    public void b(String page) {
        if (this.d != null) {
            this.d.a(page);
        }
    }

    public void a(MessageThread thread) {
        if (this.d != null) {
            this.d.a(thread);
            a();
        }
    }

    public boolean a(ih$ac message) {
        if (this.d != null) {
            return this.d.a(message);
        }
        return false;
    }

    public MessageThread b() {
        if (this.d != null) {
            return (MessageThread) this.d.b();
        }
        return null;
    }
}
