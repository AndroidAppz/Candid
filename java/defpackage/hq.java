package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.data.AppState;
import rx.schedulers.Schedulers;

/* compiled from: MeActivityFragment */
public class hq extends Fragment {
    private View a;
    private RecyclerView b;
    private hb c;
    private SwipeRefreshLayout d;
    private View e;
    private apk f;
    private long g;

    private apk b(boolean markRead) {
        this.g = System.currentTimeMillis();
        return ie.a().b(Boolean.toString(markRead), null).b(Schedulers.io()).a(apn.a()).b(new hq$1(this));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.a = inflater.inflate(2130968670, container, false);
        this.e = this.a.findViewById(2131624280);
        this.d = (SwipeRefreshLayout) this.a.findViewById(2131624278);
        this.d.setOnRefreshListener(new hq$2(this));
        this.b = (RecyclerView) this.a.findViewById(2131624279);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        this.b.setLayoutManager(llm);
        this.c = new hb(getContext());
        this.b.setAdapter(this.c);
        this.b.addOnItemTouchListener(new hq$3(this, getContext()));
        this.b.addOnScrollListener(new hq$4(this, llm, this.c));
        this.f = b(true);
        return this.a;
    }

    public void onResume() {
        super.onResume();
        if (AppState.account != null && AppState.account.unread_activity_count > 0) {
            this.f = b(false);
        }
        aom.a(getContext());
    }

    public void a(boolean markRead) {
        if (this.c != null) {
            this.f = b(markRead);
        }
    }
}
