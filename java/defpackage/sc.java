package defpackage;

/* compiled from: SignUpEvent */
public class sc extends rr<sc> {
    public sc a(String signUpMethod) {
        this.c.a("method", signUpMethod);
        return this;
    }

    public sc a(boolean signUpSucceeded) {
        this.c.a("success", Boolean.toString(signUpSucceeded));
        return this;
    }

    String b() {
        return "signUp";
    }
}
