package defpackage;

import java.util.regex.Pattern;

/* compiled from: RegexCache */
public class ajv {
    private ajv$a<String, Pattern> a;

    public ajv(int size) {
        this.a = new ajv$a(size);
    }

    public Pattern a(String regex) {
        Pattern pattern = (Pattern) this.a.a((Object) regex);
        if (pattern != null) {
            return pattern;
        }
        pattern = Pattern.compile(regex);
        this.a.a(regex, pattern);
        return pattern;
    }
}
