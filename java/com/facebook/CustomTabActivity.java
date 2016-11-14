package com.facebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class CustomTabActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, FacebookActivity.class);
        intent.putExtra("url", getIntent().getDataString());
        intent.addFlags(603979776);
        startActivity(intent);
    }
}
