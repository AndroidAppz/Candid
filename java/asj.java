/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  rx.internal.operators.NotificationLite
 *  rx.subjects.SubjectSubscriptionManager
 *  rx.subjects.SubjectSubscriptionManager$b
 */
import java.util.ArrayList;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;

public final class asj<T>
extends asl<T, T> {
    final SubjectSubscriptionManager<T> c;
    private final NotificationLite<T> d = NotificationLite.a();

    protected asj(apd.a<T> a2, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(a2);
        this.c = subjectSubscriptionManager;
    }

    public static <T> asj<T> b() {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        subjectSubscriptionManager.e = new apr<SubjectSubscriptionManager.b<T>>(){

            public void a(SubjectSubscriptionManager.b<T> b2) {
                b2.b(subjectSubscriptionManager.a(), subjectSubscriptionManager.f);
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((SubjectSubscriptionManager.b)object);
            }
        };
        return new asj<T>((apd.a<T>)subjectSubscriptionManager, (SubjectSubscriptionManager<T>)subjectSubscriptionManager);
    }

    @Override
    public void onCompleted() {
        if (this.c.b) {
            Object object = this.d.b();
            SubjectSubscriptionManager.b[] arrb = this.c.b(object);
            int n2 = arrb.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                arrb[i2].a(object, this.c.f);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onError(Throwable throwable) {
        if (this.c.b) {
            Object object = this.d.a(throwable);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b b2 : this.c.b(object)) {
                try {
                    b2.a(object, this.c.f);
                    continue;
                }
                catch (Throwable var8_7) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((Object)var8_7);
                }
            }
            app.a(arrayList);
        }
    }

    @Override
    public void onNext(T t2) {
        SubjectSubscriptionManager.b[] arrb = this.c.b();
        int n2 = arrb.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrb[i2].onNext(t2);
        }
    }

}

