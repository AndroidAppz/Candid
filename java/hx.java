/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ContextWrapper
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  java.lang.Object
 */
import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;

public class hx
extends Fragment {
    public void a() {
        AppState.hasPosted = true;
        AppState.saveState((ContextWrapper)GossipApplication.a());
        this.getActivity().finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968677, viewGroup, false);
        view.findViewById(2131624458).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                hx.this.a();
            }
        });
        return view;
    }

}

