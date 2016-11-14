package com.becandid.candid.fragments.onboarding;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog.Builder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.models.NetworkData;
import defpackage.aif;
import defpackage.apj;
import defpackage.apn;
import defpackage.bb;
import defpackage.ie;
import defpackage.ih$ai;
import defpackage.ih$aj;
import defpackage.ih$ap;
import defpackage.iq;
import defpackage.rb;
import defpackage.rc;
import defpackage.rm;
import defpackage.um$h;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

public class OnboardingContactsFragment extends Fragment {
    final int a = 1;
    String b;
    private Unbinder c;
    @BindView(2131624583)
    Button contactsButton;
    @BindView(2131624089)
    TextView contactsHeader;
    @BindView(2131624581)
    TextView contactsSubheader;
    @BindView(2131624582)
    TextView contactsSubheader2;
    @BindView(2131624580)
    TextView skip;
    @BindView(2131624093)
    FrameLayout spinny;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.b = bundle.getString("second_fragment");
        }
        ((BaseActivity) getActivity()).addToSubscriptionList(iq.a().a(ih$ai.class, new apj<ih$ai>(this) {
            final /* synthetic */ OnboardingContactsFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((ih$ai) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void a(ih$ai sendContactsToServer) {
                this.a.d();
            }
        }));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968712, container, false);
        this.c = ButterKnife.bind(this, view);
        c();
        if (AppState.config.getInt("show_contacts_skip_android", 0) == 1) {
            this.skip.setVisibility(0);
            this.skip.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ OnboardingContactsFragment a;

                {
                    this.a = this$0;
                }

                public void onClick(View v) {
                    if (AppState.account != null) {
                        rc.c().a((rm) new rm("Skip Phone Contacts").a("logged_in", "true"));
                    } else {
                        rc.c().a((rm) new rm("Skip Phone Contacts").a("logged_in", "false"));
                    }
                    if (this.a.b == null) {
                        this.a.e();
                    } else if (this.a.b.equals("fb")) {
                        Bundle bundle = new Bundle();
                        bundle.putString("second_fragment", this.a.b);
                        ((OnboardingActivity) this.a.getActivity()).switchFragment("contacts", this.a.b, bundle);
                    } else {
                        this.a.getActivity().setResult(-1);
                        ((OnboardingActivity) this.a.getActivity()).finish();
                    }
                }
            });
        }
        this.contactsButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingContactsFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.a();
            }
        });
        return view;
    }

    private void c() {
        this.contactsHeader.setText(AppState.config.getString("contacts_header", getString(2131230819)));
        this.contactsSubheader.setText(AppState.config.getString("contacts_subheader", getString(2131230820)));
        this.contactsSubheader2.setText(AppState.config.getString("contacts_subheader_2", ""));
        if (this.contactsSubheader2.getText().equals("")) {
            this.contactsSubheader2.setVisibility(8);
        }
        this.contactsButton.setText(AppState.config.getString("contacts_button", getString(2131230818)));
    }

    public void a() {
        Log.d("Onboarding", "asking for contacts permission");
        if (bb.checkSelfPermission(getActivity(), "android.permission.READ_CONTACTS") != 0) {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 1);
            return;
        }
        d();
    }

    private void d() {
        GossipApplication.a().d();
        if (this.b != null) {
            b();
            if (this.b.equals("fb")) {
                Bundle bundle = new Bundle();
                bundle.putString("second_fragment", this.b);
                ((OnboardingActivity) getActivity()).switchFragment("contacts", this.b, bundle);
                return;
            }
            getActivity().setResult(-1);
            ((OnboardingActivity) getActivity()).finish();
            return;
        }
        e();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                if (grantResults.length <= 0 || grantResults[0] != 0) {
                    Log.d("Permissions", "Unable to get contacts permission");
                    if (AppState.config == null || AppState.config.getBoolean("android_contacts_required", true)) {
                        Builder builder = new Builder(getActivity());
                        String contactsMessage = "Contacts can be added later, but only to let you know which posts are from your friends.";
                        if (AppState.config != null && AppState.config.has("android_contacts_required_message")) {
                            contactsMessage = AppState.config.getString("android_contacts_required_message");
                        }
                        builder.setMessage(contactsMessage);
                        builder.setNeutralButton(2131230891, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ OnboardingContactsFragment a;

                            {
                                this.a = this$0;
                            }

                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                if (this.a.b == null) {
                                    this.a.e();
                                } else if (this.a.b.equals("fb")) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("second_fragment", this.a.b);
                                    iq.a().a(new ih$aj("contacts", this.a.b, bundle));
                                } else {
                                    this.a.getActivity().setResult(-1);
                                    ((OnboardingActivity) this.a.getActivity()).finish();
                                }
                            }
                        });
                        builder.create().show();
                        return;
                    } else if (this.b == null) {
                        e();
                        return;
                    } else if (this.b.equals("fb")) {
                        Bundle bundle = new Bundle();
                        bundle.putString("second_fragment", this.b);
                        iq.a().a(new ih$aj("contacts", this.b, bundle));
                        return;
                    } else {
                        getActivity().setResult(-1);
                        ((OnboardingActivity) getActivity()).finish();
                        return;
                    }
                }
                iq.a().a(new ih$ai());
                return;
            default:
                return;
        }
    }

    private void e() {
        this.spinny.setVisibility(0);
        ie.a().e().b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
            final /* synthetic */ OnboardingContactsFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                this.a.spinny.setVisibility(8);
                rb.a(e);
                Toast.makeText(this.a.getActivity(), 2131230920, 0).show();
            }

            public void a(NetworkData networkData) {
                AppState.saveState(GossipApplication.a());
                this.a.spinny.setVisibility(8);
                if (!networkData.success) {
                    return;
                }
                if (networkData.is_new_user) {
                    iq.a().a(new ih$aj("contacts", "location"));
                } else {
                    ((OnboardingActivity) this.a.getActivity()).finishSyncAccount();
                }
            }
        });
    }

    public void b() {
        Map syncParams = new HashMap();
        syncParams.put("type", "phone");
        syncParams.put("id_list", DataUtil.join(AppState.contactsInfo.contacts));
        ie.a().c(syncParams).b(Schedulers.io()).a(apn.a()).b(new apj<aif>(this) {
            final /* synthetic */ OnboardingContactsFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((aif) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                Log.d("ContactsSync", e.toString());
                if (AppState.account != null) {
                    rc.c().a((rm) ((rm) new rm("Connect Phone Contacts").a("success", "false")).a("logged_in", "true"));
                } else {
                    rc.c().a((rm) ((rm) new rm("Connect Phone Contacts").a("success", "false")).a("logged_in", "false"));
                }
            }

            public void a(aif result) {
                try {
                    AppState.account.num_phone_friends = result.b("num_phone_friends").g();
                    if (AppState.account != null) {
                        rc.c().a((rm) ((rm) new rm("Connect Phone Contacts").a("success", "true")).a("logged_in", "true"));
                    } else {
                        rc.c().a((rm) ((rm) new rm("Connect Phone Contacts").a("success", "true")).a("logged_in", "false"));
                    }
                    AppState.saveState(GossipApplication.a());
                    iq.a().a(new ih$ap());
                } catch (UnsupportedOperationException e) {
                    AppState.account.num_phone_friends = 0;
                }
            }
        });
    }
}
