package com.becandid.candid.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.becandid.candid.activities.InviteContactsActivity;
import com.becandid.candid.data.Post;
import com.becandid.candid.views.viewholders.ImagePostViewHolder;
import com.becandid.candid.views.viewholders.LinkPostViewHolder;
import com.becandid.candid.views.viewholders.TextPostViewHolder;
import defpackage.ahz;
import defpackage.rb;
import defpackage.um$h;
import defpackage.zu;

public class InviteContactPeopleFragment extends Fragment {
    int a = -1;
    int b = -1;
    int c = -1;
    int d = -1;
    Runnable e = new Runnable(this) {
        final /* synthetic */ InviteContactPeopleFragment a;

        {
            this.a = this$0;
        }

        public void run() {
            this.a.a();
        }
    };
    private Unbinder f;
    private Bundle g;
    private Handler h;
    @BindView(2131624433)
    FrameLayout mEntirePostSnippet;
    @BindView(2131624430)
    ImageView mPostPlaceholder;
    @BindView(2131624429)
    ImageView mPostPreview;
    @BindView(2131624428)
    FrameLayout mPostSnippet;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r8, android.view.ViewGroup r9, android.os.Bundle r10) {
        /*
        r7 = this;
        r3 = 0;
        r4 = -1;
        r5 = 2130968668; // 0x7f04005c float:1.7545996E38 double:1.052838411E-314;
        r2 = r8.inflate(r5, r9, r3);
        r5 = butterknife.ButterKnife.bind(r7, r2);
        r7.f = r5;
        r5 = r7.getArguments();
        r7.g = r5;
        r5 = new android.os.Handler;
        r6 = r7.getActivity();
        r6 = r6.getMainLooper();
        r5.<init>(r6);
        r7.h = r5;
        r5 = r7.g;
        r6 = "post";
        r0 = r5.getString(r6);
        if (r0 == 0) goto L_0x0050;
    L_0x002e:
        r7.a(r0);
    L_0x0031:
        r3 = 2131624431; // 0x7f0e01ef float:1.8876042E38 double:1.053162401E-314;
        r3 = r2.findViewById(r3);
        r4 = new com.becandid.candid.fragments.InviteContactPeopleFragment$2;
        r4.<init>(r7);
        r3.setOnClickListener(r4);
        r3 = 2131624432; // 0x7f0e01f0 float:1.8876044E38 double:1.0531624017E-314;
        r3 = r2.findViewById(r3);
        r4 = new com.becandid.candid.fragments.InviteContactPeopleFragment$3;
        r4.<init>(r7);
        r3.setOnClickListener(r4);
        return r2;
    L_0x0050:
        r5 = r7.mPostPlaceholder;
        r5.setVisibility(r3);
        r5 = r7.g;
        r6 = "invite_type";
        r1 = r5.getString(r6);
        if (r1 == 0) goto L_0x0072;
    L_0x005f:
        r5 = r1.hashCode();
        switch(r5) {
            case 2493632: goto L_0x00ad;
            case 69076575: goto L_0x00b6;
            default: goto L_0x0066;
        };
    L_0x0066:
        r3 = r4;
    L_0x0067:
        switch(r3) {
            case 0: goto L_0x00c0;
            case 1: goto L_0x00c9;
            default: goto L_0x006a;
        };
    L_0x006a:
        r3 = r7.mPostPlaceholder;
        r5 = 2130838026; // 0x7f02020a float:1.7281023E38 double:1.0527738655E-314;
        r3.setImageResource(r5);
    L_0x0072:
        r3 = r7.g;
        r5 = "groupId";
        r3 = r3.getInt(r5, r4);
        r7.c = r3;
        r3 = r7.getActivity();
        r3 = r3 instanceof com.becandid.candid.activities.InviteContactsActivity;
        if (r3 == 0) goto L_0x008f;
    L_0x0084:
        r3 = r7.getActivity();
        r3 = (com.becandid.candid.activities.InviteContactsActivity) r3;
        r5 = r7.c;
        r3.setGroupId(r5);
    L_0x008f:
        r3 = r7.g;
        r5 = "upsellId";
        r3 = r3.getInt(r5, r4);
        r7.d = r3;
        r3 = r7.getActivity();
        r3 = r3 instanceof com.becandid.candid.activities.InviteContactsActivity;
        if (r3 == 0) goto L_0x0031;
    L_0x00a1:
        r3 = r7.getActivity();
        r3 = (com.becandid.candid.activities.InviteContactsActivity) r3;
        r4 = r7.d;
        r3.setUpsellId(r4);
        goto L_0x0031;
    L_0x00ad:
        r5 = "Post";
        r5 = r1.equals(r5);
        if (r5 == 0) goto L_0x0066;
    L_0x00b5:
        goto L_0x0067;
    L_0x00b6:
        r3 = "Group";
        r3 = r1.equals(r3);
        if (r3 == 0) goto L_0x0066;
    L_0x00be:
        r3 = 1;
        goto L_0x0067;
    L_0x00c0:
        r3 = r7.mPostPlaceholder;
        r5 = 2130838025; // 0x7f020209 float:1.728102E38 double:1.052773865E-314;
        r3.setImageResource(r5);
        goto L_0x0072;
    L_0x00c9:
        r3 = r7.mPostPlaceholder;
        r5 = 2130838027; // 0x7f02020b float:1.7281025E38 double:1.052773866E-314;
        r3.setImageResource(r5);
        goto L_0x0072;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.becandid.candid.fragments.InviteContactPeopleFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    private void a() {
        this.mEntirePostSnippet.setDrawingCacheEnabled(true);
        this.mEntirePostSnippet.buildDrawingCache();
        Bitmap bitmap = this.mEntirePostSnippet.getDrawingCache();
        if (this.a == -1 && this.b == -1) {
            int totalHeight = this.mEntirePostSnippet.getHeight();
            int totalWidth = this.mEntirePostSnippet.getWidth();
            this.a = this.mPostSnippet.getHeight();
            this.b = (this.a * totalWidth) / totalHeight;
        }
        Drawable drawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, this.b, this.a, true));
        LayoutParams layoutParams = new LayoutParams(this.b, this.a);
        layoutParams.addRule(3, 2131624410);
        layoutParams.addRule(2, 2131624415);
        layoutParams.addRule(14);
        this.mPostSnippet.setLayoutParams(layoutParams);
        this.mPostPreview.setImageDrawable(drawable);
        this.mEntirePostSnippet.setVisibility(8);
    }

    @OnClick({2131624431})
    public void inviteAll(View v) {
        ((InviteContactsActivity) getActivity()).inviteAll(v);
    }

    @OnClick({2131624432})
    public void chooseContacts(View v) {
        ((InviteContactsActivity) getActivity()).chooseContacts(v);
    }

    private void a(String data) {
        Post post = (Post) new ahz().a(data, Post.class);
        if (post == null) {
            rb.a(new Throwable("post object is null in setup post preview"));
            getActivity().finish();
            return;
        }
        this.c = post.group_id;
        if (getActivity() instanceof InviteContactsActivity) {
            ((InviteContactsActivity) getActivity()).setGroupId(this.c);
        }
        String type = post.type;
        Context context = getContext();
        boolean z = true;
        switch (type.hashCode()) {
            case 3321850:
                if (type.equals("link")) {
                    z = true;
                    break;
                }
                break;
            case 100313435:
                if (type.equals("image")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                ImagePostViewHolder imageHolder = new ImagePostViewHolder(LayoutInflater.from(context).inflate(2130968658, null, false), getActivity());
                ImagePostViewHolder.a(imageHolder, post);
                this.mEntirePostSnippet.addView(imageHolder.itemView);
                break;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                LinkPostViewHolder linkHolder = new LinkPostViewHolder(LayoutInflater.from(context).inflate(2130968659, null, false), getActivity());
                LinkPostViewHolder.a(linkHolder, post);
                this.mEntirePostSnippet.addView(linkHolder.itemView);
                break;
            default:
                TextPostViewHolder textHolder = new TextPostViewHolder(LayoutInflater.from(context).inflate(2130968660, null, false), getActivity());
                TextPostViewHolder.a(textHolder, post);
                this.mEntirePostSnippet.addView(textHolder.itemView);
                break;
        }
        this.mEntirePostSnippet.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ InviteContactPeopleFragment a;

            {
                this.a = this$0;
            }

            public void onGlobalLayout() {
                this.a.mEntirePostSnippet.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.a.mEntirePostSnippet.requestLayout();
                this.a.h.post(this.a.e);
            }
        });
    }

    @OnClick({2131624411})
    public void onContactClose() {
        getActivity().finish();
    }

    public void onResume() {
        super.onResume();
        if (this.mPostPlaceholder.getVisibility() != 0) {
            ViewTreeObserver entirePostSnippetVTO = this.mEntirePostSnippet.getViewTreeObserver();
            if (entirePostSnippetVTO.isAlive()) {
                entirePostSnippetVTO.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                    final /* synthetic */ InviteContactPeopleFragment a;

                    {
                        this.a = this$0;
                    }

                    public void onGlobalLayout() {
                        if (this.a.mEntirePostSnippet != null) {
                            this.a.mEntirePostSnippet.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            this.a.h.postDelayed(this.a.e, 3000);
                        }
                    }
                });
            }
        }
    }

    public void onPause() {
        super.onPause();
        this.h.removeCallbacks(this.e);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f.unbind();
    }
}
