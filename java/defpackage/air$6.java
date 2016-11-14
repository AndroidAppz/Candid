package defpackage;

import java.lang.reflect.Type;

/* compiled from: ConstructorConstructor */
class air$6 implements aiu<T> {
    final /* synthetic */ Class a;
    final /* synthetic */ Type b;
    final /* synthetic */ air c;
    private final aix d = aix.a();

    air$6(air this$0, Class cls, Type type) {
        this.c = this$0;
        this.a = cls;
        this.b = type;
    }

    public T a() {
        try {
            return this.d.a(this.a);
        } catch (Exception e) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + this.b + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
        }
    }
}
