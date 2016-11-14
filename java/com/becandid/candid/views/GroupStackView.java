package com.becandid.candid.views;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.NetworkData;
import defpackage.apj;
import defpackage.apn;
import defpackage.ie;
import defpackage.ip;
import defpackage.rb;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import rx.schedulers.Schedulers;

public class GroupStackView extends RelativeLayout implements OnClickListener, OnTouchListener {
    RelativeLayout a;
    RelativeLayout b;
    ImageView c;
    private int d;
    private int e;
    private long f;
    private float g;
    private float h;
    private ConcurrentLinkedQueue<View> i;
    private ConcurrentLinkedQueue<View> j;
    private View k;
    private ArrayList<Group> l;
    private int m;
    private int n;
    private boolean o;
    private float p;
    private float q;
    private b[] r;
    private Button s;
    private Button t;
    private c u;
    private boolean v;
    private boolean w;

    public interface c {
        void onEmptyGroups();

        void onJoinGroup(Group group);

        void onSkipGroup(Group group);

        void onTouchEvent(Group group);
    }

    public class a {
        TextView a;
        TextView b;
        TextView c;
        TextView[] d;
        ImageView e;
        TextView f;
        ImageView g;
        ImageView h;
        final /* synthetic */ GroupStackView i;

        public a(GroupStackView this$0, View card) {
            this.i = this$0;
            this.a = (TextView) card.findViewById(2131624110);
            this.b = (TextView) card.findViewById(2131624462);
            this.c = (TextView) card.findViewById(2131624361);
            this.d = new TextView[]{(TextView) card.findViewById(2131624357), (TextView) card.findViewById(2131624358), (TextView) card.findViewById(2131624359)};
            this.e = (ImageView) card.findViewById(2131624353);
            this.f = (TextView) card.findViewById(2131624461);
            this.g = (ImageView) card.findViewById(2131624463);
            this.h = (ImageView) card.findViewById(2131624464);
        }

        public void a(List<String> tagStrings) {
            for (int i = 0; i < this.d.length; i++) {
                if (i < tagStrings.size()) {
                    this.d[i].setText((CharSequence) tagStrings.get(i));
                    this.d[i].setVisibility(0);
                } else {
                    this.d[i].setVisibility(8);
                }
            }
        }

        public void a(Group group) {
            StringBuilder sb = new StringBuilder(50);
            if (group.num_friends > 1) {
                sb.append(group.num_friends + " friends   ");
            }
            sb.append(group.num_members + " member");
            if (group.num_members != 1) {
                sb.append("s");
            }
            sb.append("   " + group.num_posts + " post");
            if (group.num_posts != 1) {
                sb.append("s");
            }
            this.c.setText(sb.toString());
        }
    }

    class b {
        float a;
        float b;
        float c;
        final /* synthetic */ GroupStackView d;

        public b(GroupStackView this$0, float x, float y, float rotation) {
            this.d = this$0;
            this.a = x;
            this.b = y;
            this.c = (60.0f * rotation) / 3.1415927f;
        }
    }

    public GroupStackView(Context context) {
        super(context);
        this.h = 0.0f;
        this.m = 0;
        this.n = 0;
        this.r = new b[]{new b(this, -13.0f, 5.0f, -0.12f), new b(this, 15.0f, -10.0f, 0.11f), new b(this, 12.0f, 9.0f, -0.16f), new b(this, -12.0f, -8.0f, 0.17f), new b(this, -4.0f, -1.0f, -0.19f), new b(this, 9.0f, 3.0f, 0.14f)};
        this.v = true;
        d();
    }

    public GroupStackView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.h = 0.0f;
        this.m = 0;
        this.n = 0;
        this.r = new b[]{new b(this, -13.0f, 5.0f, -0.12f), new b(this, 15.0f, -10.0f, 0.11f), new b(this, 12.0f, 9.0f, -0.16f), new b(this, -12.0f, -8.0f, 0.17f), new b(this, -4.0f, -1.0f, -0.19f), new b(this, 9.0f, 3.0f, 0.14f)};
        this.v = true;
        d();
    }

    public GroupStackView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.h = 0.0f;
        this.m = 0;
        this.n = 0;
        this.r = new b[]{new b(this, -13.0f, 5.0f, -0.12f), new b(this, 15.0f, -10.0f, 0.11f), new b(this, 12.0f, 9.0f, -0.16f), new b(this, -12.0f, -8.0f, 0.17f), new b(this, -4.0f, -1.0f, -0.19f), new b(this, 9.0f, 3.0f, 0.14f)};
        this.v = true;
        d();
    }

    @TargetApi(21)
    public GroupStackView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.h = 0.0f;
        this.m = 0;
        this.n = 0;
        this.r = new b[]{new b(this, -13.0f, 5.0f, -0.12f), new b(this, 15.0f, -10.0f, 0.11f), new b(this, 12.0f, 9.0f, -0.16f), new b(this, -12.0f, -8.0f, 0.17f), new b(this, -4.0f, -1.0f, -0.19f), new b(this, 9.0f, 3.0f, 0.14f)};
        this.v = true;
        d();
    }

    public void setListener(c listener) {
        this.u = listener;
    }

    private void d() {
        if (getChildCount() <= 0) {
            this.w = true;
            this.q = getResources().getDisplayMetrics().density;
            this.j = new ConcurrentLinkedQueue();
            this.i = new ConcurrentLinkedQueue();
            this.l = new ArrayList();
            this.a = new RelativeLayout(getContext());
            LayoutParams bottomParams = new LayoutParams(-1, -1);
            bottomParams.setMargins(0, 0, 0, (int) (100.0f * this.q));
            this.a.setLayoutParams(bottomParams);
            addView(this.a);
            this.c = new ImageView(getContext());
            setLayoutParams(bottomParams);
            addView(this.c);
            this.b = new RelativeLayout(getContext());
            LayoutParams tapCardParams = new LayoutParams(-1, -1);
            tapCardParams.setMargins(0, 0, 0, (int) (100.0f * this.q));
            this.b.setLayoutParams(tapCardParams);
            addView(this.b);
            RelativeLayout cardCover = new RelativeLayout(getContext());
            cardCover.setLayoutParams(new LayoutParams(-1, -1));
            addView(cardCover);
            cardCover.setOnTouchListener(this);
            LinearLayout buttons = new LinearLayout(getContext());
            LayoutParams params = new LayoutParams(-1, (int) (40.0f * this.q));
            params.addRule(12);
            params.setMargins((int) (15.0f * this.q), 0, (int) (15.0f * this.q), (int) (65.0f * this.q));
            buttons.setLayoutParams(params);
            addView(buttons);
            this.t = new Button(getContext());
            this.t.setText("Skip");
            LinearLayout.LayoutParams skipLayout = new LinearLayout.LayoutParams(0, -1);
            skipLayout.weight = 1.0f;
            this.t.setLayoutParams(skipLayout);
            this.t.setBackground(getResources().getDrawable(2130837985));
            buttons.addView(this.t);
            this.t.setOnClickListener(this);
            this.s = new Button(getContext());
            this.s.setText("Join");
            LinearLayout.LayoutParams joinLayout = new LinearLayout.LayoutParams(0, -1);
            joinLayout.weight = 1.0f;
            joinLayout.setMargins((int) (20.0f * this.q), 0, 0, 0);
            this.s.setLayoutParams(joinLayout);
            this.s.setBackground(getResources().getDrawable(2130838145));
            this.s.setTextColor(Color.parseColor("#ffffff"));
            buttons.addView(this.s);
            this.s.setOnClickListener(this);
            for (int i = 0; i < 6; i++) {
                View card = e();
                card.setAlpha(0.0f);
                this.a.addView(card, 0);
            }
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        this.d = getMeasuredWidth();
        this.e = getMeasuredHeight();
    }

    public int a() {
        return this.l.size() - this.n;
    }

    public void setGroups(List<Group> groups) {
        this.l.clear();
        this.m = 0;
        this.n = 0;
        for (int i = 0; i < this.a.getChildCount(); i++) {
            this.j.add(this.a.getChildAt(i));
        }
        this.a.removeAllViews();
        if (this.k != null) {
            this.b.removeView(this.k);
        }
        this.k = null;
        a((List) groups);
    }

    public void a(List<Group> groups) {
        this.l.addAll(groups);
        b();
        this.a.requestLayout();
        for (int i = 0; i < this.a.getChildCount(); i++) {
            this.a.getChildAt(i).requestLayout();
        }
        this.b.requestLayout();
    }

    public void b() {
        while (this.a.getChildCount() < 3 && this.m < this.l.size()) {
            View card = a((Group) this.l.get(this.m), this.m);
            b transform = this.r[this.m % this.r.length];
            card.setTranslationX(transform.a);
            card.setTranslationY(transform.b);
            card.setRotation(transform.c);
            this.m++;
        }
        c();
    }

    public View a(Group group, int index) {
        View card;
        if (this.j.isEmpty()) {
            card = e();
        } else {
            card = (View) this.j.poll();
        }
        if (card.getAlpha() == 0.0f) {
            card.setAlpha(1.0f);
        }
        card.setTag(Integer.valueOf(index));
        card.setTag(2131624361, group);
        a holder = (a) card.getTag(2131624110);
        holder.g.setAlpha(0.0f);
        holder.h.setAlpha(0.0f);
        holder.g.setVisibility(8);
        holder.h.setVisibility(8);
        ip tinter = new ip(getContext());
        if (this.w) {
            GossipApplication.c.a(group.imageUrl()).d().a(17301613).a(tinter).a(holder.e);
        }
        holder.a.setText(group.group_name);
        holder.b.setText(group.about);
        holder.a(group.tags);
        holder.a(group);
        if (group.isFriendCreated()) {
            holder.f.setVisibility(0);
            holder.f.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            holder.f.setVisibility(8);
        }
        this.a.addView(card, 0);
        return card;
    }

    private View e() {
        View card = LayoutInflater.from(getContext()).inflate(2130968681, this.a, false);
        card.setTag(2131624110, new a(this, card));
        return card;
    }

    public void a(View card) {
        if (card.getParent() != null) {
            ((ViewGroup) card.getParent()).removeView(card);
        }
        this.j.add(card);
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (this.k == null) {
            return false;
        }
        float touchX = event.getX();
        if (event.getAction() == 0) {
            if (this.u != null) {
                this.u.onTouchEvent((Group) this.k.getTag(2131624361));
            }
            this.o = true;
            this.p = touchX;
            this.f = System.currentTimeMillis();
            this.g = this.p;
            this.h = 0.0f;
            this.k.findViewById(2131624463).setVisibility(0);
            this.k.findViewById(2131624464).setVisibility(0);
            return true;
        }
        float xOffset = touchX - this.p;
        if (event.getAction() == 2 && this.o) {
            this.k.setX(xOffset);
            this.k.setRotation((25.0f * xOffset) / ((float) this.d));
            a(this.k, xOffset, 0);
            long now = System.currentTimeMillis();
            if (this.f > 0) {
                this.h = (0.5f * this.h) + ((0.5f * (touchX - this.g)) / ((float) (now - this.f)));
                if (this.h > 0.0f) {
                    this.h = Math.max(this.h, 1.0f);
                } else {
                    this.h = Math.min(this.h, -1.0f);
                }
            }
            this.g = touchX;
            this.f = now;
            return true;
        } else if (event.getAction() != 1) {
            return false;
        } else {
            Log.d("GSV", "drag end at " + xOffset + " vel: " + this.h + " (sw: " + this.d);
            int target = 0;
            int duration = 0;
            int destination = ((int) xOffset) + ((int) (this.h * 200.0f));
            if (destination > this.d / 2) {
                Log.d("GSV", "fling right");
                duration = Math.abs((int) (((((float) this.d) - touchX) + this.p) / Math.abs(this.h)));
                target = this.d;
            } else if (destination < (-this.d) / 2) {
                Log.d("GSV", "fling left");
                duration = Math.abs((int) ((((float) this.d) + xOffset) / Math.abs(this.h)));
                target = -this.d;
            }
            if (target != 0) {
                View card = this.k;
                this.k = null;
                a(card, target, duration);
            } else {
                this.k.animate().x(0.0f).rotation(0.0f).setDuration(250).start();
                a(this.k, 0.0f, 150);
            }
            return true;
        }
    }

    private void a(View card, float offset, int duration) {
        float joinAlpha = Math.max(0.0f, Math.min(1.0f, ((3.0f * offset) / ((float) this.d)) - 0.2f));
        float skipAlpha = Math.max(0.0f, Math.min(1.0f, (((-offset) * 3.0f) / ((float) this.d)) - 0.2f));
        a holder = (a) card.getTag(2131624110);
        if (duration == 0) {
            holder.g.setAlpha(joinAlpha);
            holder.h.setAlpha(skipAlpha);
            return;
        }
        holder.g.animate().alpha(joinAlpha).setDuration((long) duration).start();
        holder.h.animate().alpha(skipAlpha).setDuration((long) duration).start();
    }

    private void a(final View card, int target, int duration) {
        if (target > 0) {
            a((Group) card.getTag(2131624361));
        } else {
            b((Group) card.getTag(2131624361));
        }
        a(card, (float) target, duration / 4);
        target += target / 5;
        final ViewPropertyAnimator animator = card.animate().x((float) target).rotation(target > 0 ? 25.0f : -25.0f);
        if (duration >= 250 || duration < 0) {
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else {
            animator.setInterpolator(new LinearInterpolator());
        }
        animator.setDuration((long) duration);
        animator.setListener(new AnimatorListener(this) {
            final /* synthetic */ GroupStackView c;

            public void onAnimationStart(Animator animation) {
                Log.d("GSV", "animation start");
                this.c.c();
                this.c.v = false;
            }

            public void onAnimationEnd(Animator animation) {
                Log.d("GSV", "animation end");
                card.setX(0.0f);
                this.c.b.removeView(card);
                this.c.a(card);
                this.c.b();
                animator.setListener(null);
                if (this.c.a.getChildCount() <= 0 && this.c.k == null) {
                    this.c.u.onEmptyGroups();
                }
                this.c.v = true;
            }

            public void onAnimationCancel(Animator animation) {
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
        animator.start();
    }

    public void c() {
        int numCards = this.a.getChildCount();
        if (numCards > 0 && this.k == null) {
            View card = this.a.getChildAt(numCards - 1);
            Log.d("GSV", "promoteNextCard: " + ((TextView) card.findViewById(2131624110)).getText());
            this.a.removeView(card);
            this.b.addView(card, 0);
            card.animate().rotation(0.0f).translationX(0.0f).translationY(0.0f).setDuration(100).start();
            this.k = card;
            this.n = this.m - numCards;
            a holder = (a) card.getTag(2131624110);
            holder.g.setVisibility(0);
            holder.h.setVisibility(0);
        }
    }

    public void onClick(View v) {
        if (this.k != null && this.v) {
            View card;
            if (v == this.s) {
                card = this.k;
                this.k = null;
                a(card, (float) this.d, 0);
                a(card, this.d, 750);
            } else if (v == this.t) {
                card = this.k;
                this.k = null;
                a(card, (float) (-this.d), 0);
                a(card, -this.d, 750);
            }
        }
    }

    public void a(Group group) {
        ie.a().b(group.group_id).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
            final /* synthetic */ GroupStackView a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
                Log.d("GroupStackView", e.toString());
            }

            public void a(NetworkData networkData) {
                if (networkData.success && this.a.u != null) {
                    this.a.u.onJoinGroup(networkData.group);
                }
            }
        });
    }

    public void b(final Group group) {
        ie.a().a(group).b(Schedulers.io()).a(apn.a()).b(new apj<EmptyClass>(this) {
            final /* synthetic */ GroupStackView b;

            public /* synthetic */ void onNext(Object obj) {
                a((EmptyClass) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
                Log.d("GroupStackView", e.toString());
            }

            public void a(EmptyClass emptyClass) {
                if (this.b.u != null) {
                    this.b.u.onSkipGroup(group);
                }
            }
        });
    }

    public boolean isAttachedToWindow() {
        this.w = true;
        return super.isAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        this.w = false;
        super.onDetachedFromWindow();
    }
}
