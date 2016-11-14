package defpackage;

/* compiled from: SerialSubscription */
final class asp$a {
    final boolean a;
    final apk b;

    asp$a(boolean u, apk s) {
        this.a = u;
        this.b = s;
    }

    asp$a a() {
        return new asp$a(true, this.b);
    }

    asp$a a(apk s) {
        return new asp$a(this.a, s);
    }
}
