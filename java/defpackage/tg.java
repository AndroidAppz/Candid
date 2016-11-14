package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: NativeCrashWriter */
class tg {
    private static final tw a = new tw("", "", 0);
    private static final tg$j[] b = new tg$j[0];
    private static final tg$m[] c = new tg$m[0];
    private static final tg$g[] d = new tg$g[0];
    private static final tg$b[] e = new tg$b[0];
    private static final tg$c[] f = new tg$c[0];

    private static tg$e a(tv crashEvent, td logFileManager, Map<String, String> attributes) throws IOException {
        tg$a applicationMessage = new tg$a(new tg$f(new tg$l(crashEvent.b != null ? crashEvent.b : a), tg.a(crashEvent.c), tg.a(crashEvent.d)), tg.a(tg.a(crashEvent.e, attributes)));
        tg$d deviceMessage = tg.a(crashEvent.f);
        so logByteString = logFileManager.a();
        if (logByteString == null) {
            akp.h().a("CrashlyticsCore", "No log data to include with this event.");
        }
        logFileManager.b();
        tg$j logMessage = logByteString != null ? new tg$h(logByteString) : new tg$i();
        return new tg$e(crashEvent.a, "ndk-crash", new tg$j[]{applicationMessage, deviceMessage, logMessage});
    }

    private static tt[] a(tt[] ndkAttributes, Map<String, String> javaAttributes) {
        Map<String, String> sorted = new TreeMap(javaAttributes);
        if (ndkAttributes != null) {
            for (tt attr : ndkAttributes) {
                sorted.put(attr.a, attr.b);
            }
        }
        Entry[] entryArray = (Entry[]) sorted.entrySet().toArray(new Entry[sorted.size()]);
        tt[] merged = new tt[entryArray.length];
        for (int i = 0; i < merged.length; i++) {
            merged[i] = new tt((String) entryArray[i].getKey(), (String) entryArray[i].getValue());
        }
        return merged;
    }

    private static tg$d a(tu deviceData) {
        return new tg$d(((float) deviceData.f) / 100.0f, deviceData.g, deviceData.h, deviceData.a, deviceData.b - deviceData.d, deviceData.c - deviceData.e);
    }

    private static tg$k a(tx[] threads) {
        tg$m[] threadMessages = threads != null ? new tg$m[threads.length] : c;
        for (int threadIdx = 0; threadIdx < threadMessages.length; threadIdx++) {
            tx threadData = threads[threadIdx];
            threadMessages[threadIdx] = new tg$m(threadData, tg.a(threadData.c));
        }
        return new tg$k(threadMessages);
    }

    private static tg$k a(tx$a[] frames) {
        tg$g[] frameMessages = frames != null ? new tg$g[frames.length] : d;
        for (int frameIdx = 0; frameIdx < frameMessages.length; frameIdx++) {
            frameMessages[frameIdx] = new tg$g(frames[frameIdx]);
        }
        return new tg$k(frameMessages);
    }

    private static tg$k a(ts[] binaryImages) {
        tg$b[] binaryImageMessages = binaryImages != null ? new tg$b[binaryImages.length] : e;
        for (int i = 0; i < binaryImageMessages.length; i++) {
            binaryImageMessages[i] = new tg$b(binaryImages[i]);
        }
        return new tg$k(binaryImageMessages);
    }

    private static tg$k a(tt[] customAttributes) {
        tg$c[] customAttributeMessages = customAttributes != null ? new tg$c[customAttributes.length] : f;
        for (int i = 0; i < customAttributeMessages.length; i++) {
            customAttributeMessages[i] = new tg$c(customAttributes[i]);
        }
        return new tg$k(customAttributeMessages);
    }

    public static void a(tv crashEventData, td logFileManager, Map<String, String> customAttributes, CodedOutputStream cos) throws IOException {
        tg.a(crashEventData, logFileManager, customAttributes).b(cos);
    }
}
