package com.becandid.candid.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.becandid.candid.fragments.onboarding.OnboardingAgeFragment;

public class VerifyAgeActivity extends BaseActivity {
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(2131427522);
        super.onCreate(savedInstanceState);
        setContentView(2130968630);
        FragmentManager fragmentManager = getSupportFragmentManager();
        OnboardingAgeFragment onboardingAgeFragment = new OnboardingAgeFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("existing_user", true);
        onboardingAgeFragment.setArguments(bundle);
        fragmentManager.beginTransaction().add(2131624291, onboardingAgeFragment, "age").commit();
    }

    public void onBackPressed() {
    }

    public void onActivityResult() {
        setResult(-1);
        finish();
    }
}
