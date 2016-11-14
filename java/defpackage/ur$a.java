package defpackage;

import com.facebook.appevents.AccessTokenAppIdPair.SerializationProxyV1;
import com.facebook.appevents.AppEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* compiled from: AppEventStore */
class ur$a extends ObjectInputStream {
    public ur$a(InputStream in) throws IOException {
        super(in);
    }

    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
        if (resultClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
            return ObjectStreamClass.lookup(SerializationProxyV1.class);
        }
        if (resultClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1")) {
            return ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class);
        }
        return resultClassDescriptor;
    }
}
