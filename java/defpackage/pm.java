package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import java.util.HashSet;

/* compiled from: SupportRequestManagerFragment */
public class pm extends Fragment {
    private jr a;
    private final pa b;
    private final pk c;
    private final HashSet<pm> d;
    private pm e;

    public pm() {
        this(new pa());
    }

    @SuppressLint({"ValidFragment"})
    public pm(pa lifecycle) {
        this.c = new pm$a(this, null);
        this.d = new HashSet();
        this.b = lifecycle;
    }

    public void a(jr requestManager) {
        this.a = requestManager;
    }

    pa a() {
        return this.b;
    }

    public jr b() {
        return this.a;
    }

    public pk c() {
        return this.c;
    }

    private void a(pm child) {
        this.d.add(child);
    }

    private void b(pm child) {
        this.d.remove(child);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.e = pj.a().a(getActivity().getSupportFragmentManager());
        if (this.e != this) {
            this.e.a(this);
        }
    }

    public void onDetach() {
        super.onDetach();
        if (this.e != null) {
            this.e.b(this);
            this.e = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.b.a();
    }

    public void onStop() {
        super.onStop();
        this.b.b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.b.c();
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.a != null) {
            this.a.a();
        }
    }
}
