package defpackage;

/* compiled from: MultipleAssignmentSubscription */
final class aso$a {
    final boolean a;
    final apk b;

    aso$a(boolean u, apk s) {
        this.a = u;
        this.b = s;
    }

    aso$a a() {
        return new aso$a(true, this.b);
    }

    aso$a a(apk s) {
        return new aso$a(this.a, s);
    }
}
