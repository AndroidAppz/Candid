package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;

/* compiled from: TutorialContinueFragment */
public class hx extends Fragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968677, container, false);
        view.findViewById(2131624458).setOnClickListener(new hx$1(this));
        return view;
    }

    public void a() {
        AppState.hasPosted = true;
        AppState.saveState(GossipApplication.a());
        getActivity().finish();
    }
}
