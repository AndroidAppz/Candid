/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
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

