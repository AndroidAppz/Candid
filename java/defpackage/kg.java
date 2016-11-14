package defpackage;

import java.util.Arrays;
import java.util.Collection;

/* compiled from: MultiTransformation */
public class kg<T> implements kj<T> {
    private final Collection<? extends kj<T>> a;
    private String b;

    @SafeVarargs
    public kg(kj<T>... transformations) {
        if (transformations.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.a = Arrays.asList(transformations);
    }

    public lb<T> a(lb<T> resource, int outWidth, int outHeight) {
        lb<T> previous = resource;
        for (kj<T> transformation : this.a) {
            lb<T> transformed = transformation.a(previous, outWidth, outHeight);
            if (!(previous == null || previous.equals(resource) || previous.equals(transformed))) {
                previous.d();
            }
            previous = transformed;
        }
        return previous;
    }

    public String a() {
        if (this.b == null) {
            StringBuilder sb = new StringBuilder();
            for (kj<T> transformation : this.a) {
                sb.append(transformation.a());
            }
            this.b = sb.toString();
        }
        return this.b;
    }
}
