package com.facebook.appevents;

import java.util.HashMap;
import java.util.List;

public class PersistedEvents extends HashMap<AccessTokenAppIdPair, List<AppEvent>> {
    public PersistedEvents(HashMap<AccessTokenAppIdPair, List<AppEvent>> appEventMap) {
        super(appEventMap);
    }
}
