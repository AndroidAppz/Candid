package com.becandid.candid.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.InviteContactsActivity.InviteFlowTypes;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.JoinedFacebookData;
import com.becandid.candid.models.NetworkData;
import com.facebook.AccessToken;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import defpackage.aif;
import defpackage.apd;
import defpackage.apj;
import defpackage.apk;
import defpackage.apn;
import defpackage.apv;
import defpackage.ie;
import defpackage.ih$ak;
import defpackage.ih$ap;
import defpackage.ih$m;
import defpackage.ih$v;
import defpackage.im;
import defpackage.iq;
import defpackage.ir;
import defpackage.rb;
import defpackage.ub;
import defpackage.ub$a;
import defpackage.uc;
import defpackage.we;
import defpackage.wf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import rx.schedulers.Schedulers;

public class BaseActivity extends AppCompatActivity {
    public static final int PERMISSION_WRITE_EXTERNAL_STORAGE = 1104;
    public static final int UPSELL_FEED = 1104;
    public static final int UPSELL_GROUP = 929;
    View a;
    public ub callbackManager;
    protected ArrayList<apk> eventSubscriptions = new ArrayList();
    public boolean isStopped;
    public boolean keyboardOpen;
    protected apk mSubscription;
    protected im photoHelper;

    public void enableKeyboardEvents(final View root) {
        this.a = root;
        Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);
        root.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ BaseActivity c;

            public void onGlobalLayout() {
                int height = root.getHeight();
                if (height < size.y - 100 && !this.c.keyboardOpen) {
                    this.c.keyboardOpen = true;
                    this.c.keyboardOpened();
                } else if (height >= size.y - 100 && this.c.keyboardOpen) {
                    this.c.keyboardOpen = false;
                    this.c.keyboardClosed();
                }
            }
        });
    }

    protected void keyboardOpened() {
    }

    protected void keyboardClosed() {
    }

    public void closeKeyboard() {
        closeKeyboard(this.a);
    }

    public void closeKeyboard(View view) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void openKeyboard() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(1, 1);
    }

    public void backNavClick(View backNav) {
        onBackPressed();
    }

    protected void busSubscribe(apk subscription) {
        this.eventSubscriptions.add(subscription);
    }

    protected <T> void busSubscribe(Class<T> eventClass, apj<T> subscriber) {
        this.eventSubscriptions.add(iq.a().a((Class) eventClass, (apj) subscriber));
    }

    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        this.isStopped = false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GossipApplication application = (GossipApplication) getApplication();
        Bundle args = getIntent().getExtras();
        if (args != null && args.containsKey("click_notification")) {
            ie.a().j(args.getString("click_notification")).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
        }
        busSubscribe(ih$ak.class, new apj<ih$ak>(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void onNext(ih$ak twitterReady) {
                ir.a().b();
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle args = intent.getExtras();
        if (args != null && args.containsKey("click_notification")) {
            ie.a().j(args.getString("click_notification")).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onStart() {
        super.onStart();
        this.isStopped = false;
    }

    protected void onStop() {
        super.onStop();
        this.isStopped = true;
    }

    protected void onDestroy() {
        super.onDestroy();
        Iterator it = this.eventSubscriptions.iterator();
        while (it.hasNext()) {
            ((apk) it.next()).unsubscribe();
        }
    }

    public void addToSubscriptionList(apk subscription) {
        this.eventSubscriptions.add(subscription);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.photoHelper != null) {
            this.photoHelper.a(requestCode, resultCode, data);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (this.photoHelper != null) {
            this.photoHelper.a(requestCode, permissions, grantResults);
        }
        if (requestCode == 1989 && grantResults.length > 0 && grantResults[0] == 0) {
            iq.a().a(new ih$ak());
        }
    }

    public im getPhotoHelper() {
        if (this.photoHelper == null) {
            this.photoHelper = new im(this);
        }
        return this.photoHelper;
    }

    public void setPhotoHelper(im photoHelper) {
        this.photoHelper = photoHelper;
    }

    public void onPhotoChosen(String url, int width, int height) {
    }

    protected void getRxSubscription() {
        this.mSubscription = null;
    }

    public void skipUpsell(int upsellId, int groupId) {
        ie.a().g(Integer.toString(upsellId) + "," + Integer.toString(groupId)).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
        upsellChange(upsellId);
    }

    public void skipUpsell(int upsellId) {
        ie.a().g(Integer.toString(upsellId)).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
        upsellChange(upsellId);
    }

    public void inviteFriends(final int upsellId, final int groupId) {
        new Builder(this).setTitle("Invite Candid Friends").setMessage("Do you want to anonymously recommend this group to your friends on Candid?").setCancelable(true).setNegativeButton(getResources().getString(2131230887), new OnClickListener(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = this$0;
            }

            public void onClick(DialogInterface dialog, int which) {
            }
        }).setPositiveButton(getResources().getString(2131230945), new OnClickListener(this) {
            final /* synthetic */ BaseActivity c;

            public void onClick(DialogInterface dialog, int which) {
                ie.a().e(groupId).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                this.c.upsellChange(upsellId);
                Toast.makeText(this.c.getBaseContext(), "Your friends have been notified. Thanks!", 1).show();
            }
        }).create().show();
    }

    public void showContactsDialog(int upsellId, int groupId) {
        Intent intent = new Intent(this, InviteContactsActivity.class);
        intent.putExtra("invite_type", InviteFlowTypes.GROUP.toString());
        intent.putExtra("groupId", groupId);
        intent.putExtra("upsellId", upsellId);
        startActivityForResult(intent, UPSELL_GROUP);
    }

    public void upsellChange(int upsellId) {
    }

    public void showConnectAccount(int upsellId) {
        Intent intent = new Intent(this, OnboardingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_facebook_last_fragment", true);
        bundle.putString("first_fragment", "phone");
        bundle.putString("second_fragment", "fb");
        intent.putExtras(bundle);
        startActivityForResult(intent, UPSELL_FEED);
    }

    public void showPhoneConnect(int upsellId) {
        Intent intent = new Intent(this, OnboardingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("first_fragment", "phone");
        bundle.putString("second_fragment", "phone");
        intent.putExtras(bundle);
        startActivityForResult(intent, UPSELL_FEED);
    }

    public void showContactsDialog(int upsellId) {
        Intent intent = new Intent(this, InviteContactsActivity.class);
        intent.putExtra("invite_type", InviteFlowTypes.DOWNLOAD.toString());
        intent.putExtra("upsellId", upsellId);
        startActivityForResult(intent, UPSELL_GROUP);
    }

    public void connectFacebook(int upsellId) {
        if (this.callbackManager == null) {
            this.callbackManager = ub$a.a();
            we.c().a(this.callbackManager, new uc<wf>(this) {
                final /* synthetic */ BaseActivity a;

                {
                    this.a = this$0;
                }

                public void onSuccess(wf loginResult) {
                    Log.d("FBConnect", "success");
                    AppState.setFBInfo(loginResult.a());
                    apk sub = iq.a().a(ih$v.class, new apj<ih$v>(this) {
                        final /* synthetic */ AnonymousClass5 a;

                        {
                            this.a = this$1;
                        }

                        public void onCompleted() {
                        }

                        public void onError(Throwable e) {
                            rb.a(e);
                        }

                        public void onNext(ih$v fbInfoReceived) {
                            this.a.a.sendFbDataToServer();
                        }
                    });
                }

                public void onCancel() {
                    Log.d("FBConnect", "cancel");
                }

                public void onError(FacebookException error) {
                    Log.e("FBConnect", error.toString());
                    if (!(error instanceof FacebookAuthorizationException) || AccessToken.a() == null) {
                        Toast.makeText(GossipApplication.a(), "Unable to connect to Facebook", 1).show();
                        return;
                    }
                    we.c().d();
                    we.c().a(this.a.getParent(), Arrays.asList("public_profile,user_friends,user_work_history,user_education_history".split(",")));
                }
            });
        }
        we.c().a((Activity) this, Arrays.asList("public_profile,user_friends,user_work_history,user_education_history".split(",")));
    }

    public void sendFbDataToServer() {
        Map hashParams = new HashMap();
        hashParams.put("fb_token", AppState.fbInfo.fbToken.b());
        hashParams.put("fb_uid", AppState.fbInfo.fbToken.i());
        Map<String, String> syncParams = new HashMap();
        syncParams.put("type", "fb");
        syncParams.put("fb_uid", AppState.fbInfo.fbToken.i());
        syncParams.put("id_list", DataUtil.join(AppState.fbInfo.friendIds));
        apd.a(ie.a().b(hashParams).b(Schedulers.io()).a(apn.a()), ie.a().a(AppState.fbInfo).b(Schedulers.io()).a(apn.a()), new apv<aif, NetworkData, JoinedFacebookData>(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = this$0;
            }

            public JoinedFacebookData call(aif hash, NetworkData autoJoin) {
                return new JoinedFacebookData(hash, autoJoin);
            }
        }).b(new apj<JoinedFacebookData>(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
                iq.a().a(new ih$ap());
            }

            public void onError(Throwable e) {
            }

            public void onNext(JoinedFacebookData joinedFacebookData) {
                NetworkData autoJoin = joinedFacebookData.autoJoin;
                if (!(autoJoin == null || autoJoin.groups == null)) {
                    for (Group group : autoJoin.groups) {
                        iq.a().a(new ih$m(group));
                    }
                }
                if (autoJoin != null && autoJoin.my_info != null) {
                    AppState.account.num_groups = autoJoin.my_info.num_groups;
                }
            }
        });
    }

    protected void clearPhoto() {
        if (this.photoHelper != null) {
            this.photoHelper.clearPhoto();
        }
    }
}
