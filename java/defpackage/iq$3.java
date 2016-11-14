package defpackage;

/* compiled from: RxBus */
class iq$3 implements apu<Object, Boolean> {
    final /* synthetic */ Class a;
    final /* synthetic */ iq b;

    iq$3(iq this$0, Class cls) {
        this.b = this$0;
        this.a = cls;
    }

    public /* synthetic */ Object call(Object obj) {
        return a(obj);
    }

    public Boolean a(Object o) {
        return Boolean.valueOf(o.getClass().equals(this.a));
    }
}
