package com.becandid.candid.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.becandid.candid.activities.CreateGroupActivity;
import com.becandid.candid.activities.GroupSearchActivity;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.SplashActivity;

public class GroupHeaderView extends RelativeLayout {
    public GroupHeaderView(Context context) {
        super(context);
        a(context);
    }

    public GroupHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context);
    }

    public GroupHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a(context);
    }

    public void a(Context context) {
        LayoutInflater.from(context).inflate(2130968682, this, true);
        ButterKnife.bind(this);
    }

    @OnClick({2131624465})
    public void onGroupSearchClick(View v) {
        getContext().startActivity(new Intent(getContext(), GroupSearchActivity.class));
    }

    @OnClick({2131624466})
    public void onCreateGroupClick(View v) {
        Activity activity = (Activity) v.getContext();
        if (activity instanceof MainTabsActivity) {
            activity.startActivityForResult(new Intent(activity, CreateGroupActivity.class), SplashActivity.CHANGE_ENDPOINT_CODE);
        }
    }
}
