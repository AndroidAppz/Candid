package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/* compiled from: MetadataManager */
class ajs {
    private static final Logger a = Logger.getLogger(ajs.class.getName());
    private static final Map<Integer, ajx$b> b = Collections.synchronizedMap(new HashMap());
    private static final Map<String, ajx$b> c = Collections.synchronizedMap(new HashMap());
    private static final Set<Integer> d = ajp.a();
    private static final Set<String> e = ajw.a();

    private ajs() {
    }

    static ajy a(ObjectInputStream in, int bufferSize) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] data = new byte[bufferSize];
        while (true) {
            int nRead = in.read(data, 0, bufferSize);
            if (nRead != -1) {
                outputStream.write(data, 0, nRead);
            } else {
                outputStream.flush();
                return ajy.a(outputStream.toByteArray());
            }
        }
    }
}
