package com.becandid.candid.services;

import android.content.Intent;
import com.google.android.gms.iid.InstanceIDListenerService;

public class CustomInstanceIDListenerService extends InstanceIDListenerService {
    public void a() {
        startService(new Intent(this, RegistrationIntentService.class));
    }
}
