package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* compiled from: BuildProperties */
class sg {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    sg(String versionCode, String versionName, String buildId, String packageName) {
        this.a = versionCode;
        this.b = versionName;
        this.c = buildId;
        this.d = packageName;
    }

    public static sg a(Properties props) {
        return new sg(props.getProperty("version_code"), props.getProperty("version_name"), props.getProperty("build_id"), props.getProperty("package_name"));
    }

    public static sg a(InputStream is) throws IOException {
        Properties props = new Properties();
        props.load(is);
        return sg.a(props);
    }
}
