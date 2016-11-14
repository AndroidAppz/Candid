package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.data.Group;
import rx.schedulers.Schedulers;

/* compiled from: MeGroupsFragment */
public class hr extends Fragment {
    private View a;
    private RecyclerView b;
    private hm c;
    private apk d;

    public apk a() {
        return ie.a().i(0).b(Schedulers.io()).a(apn.a()).b(new hr$1(this));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.a = inflater.inflate(2130968671, container, false);
        this.b = (RecyclerView) this.a.findViewById(2131624439);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, 1);
        this.b.setLayoutManager(sglm);
        this.c = new hm(getContext());
        this.b.setAdapter(this.c);
        this.b.addOnItemTouchListener(new hr$2(this, getContext()));
        this.b.addOnScrollListener(new hr$3(this, sglm, this.c));
        this.a.findViewById(2131624465).setOnClickListener(new hr$4(this));
        this.d = a();
        return this.a;
    }

    public void b() {
        if (this.c != null) {
            this.d = a();
        }
    }

    public void a(Group group) {
        if (this.c != null) {
            this.c.a(group);
        }
    }

    public void a(int groupId) {
        if (this.c != null) {
            this.c.c(groupId);
        }
    }
}
