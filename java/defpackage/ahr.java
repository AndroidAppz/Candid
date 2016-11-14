package defpackage;

import com.google.firebase.iid.FirebaseInstanceId;

public class ahr {
    private final FirebaseInstanceId a;

    private ahr(FirebaseInstanceId firebaseInstanceId) {
        this.a = firebaseInstanceId;
    }

    public static ahr a() {
        return new ahr(FirebaseInstanceId.a());
    }

    public String b() {
        return this.a.c();
    }
}
