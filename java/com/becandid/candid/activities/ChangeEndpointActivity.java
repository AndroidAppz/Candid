package com.becandid.candid.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import defpackage.ie;

public class ChangeEndpointActivity extends BaseActivity {
    public String PROD_ENDPOINT = "https://becandid.com/";
    public String STAGING_ENDPOINT = "https://dev.becandid.com/";
    private String b = this.PROD_ENDPOINT;
    @BindView(2131624083)
    EditText mEndpointText;
    @BindView(2131624084)
    RadioGroup mRadioGroup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968603);
        ButterKnife.bind(this);
        setSupportActionBar((Toolbar) findViewById(2131624081));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(2130837589);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case 2131624085:
                if (checked) {
                    this.b = this.PROD_ENDPOINT;
                    this.mEndpointText.setText(this.b);
                    this.mEndpointText.setEnabled(false);
                    return;
                }
                break;
            case 2131624086:
                break;
            case 2131624087:
                break;
            default:
                return;
        }
        if (checked) {
            this.b = this.STAGING_ENDPOINT;
            this.mEndpointText.setText(this.b);
            this.mEndpointText.setEnabled(false);
            return;
        }
        if (checked) {
            this.mEndpointText.setEnabled(true);
            this.mEndpointText.requestFocus();
            ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.mEndpointText, 1);
        }
    }

    public void onSaveEndpoint(View view) {
        ie.a().a(this.mEndpointText.getText().toString());
        finish();
    }
}
