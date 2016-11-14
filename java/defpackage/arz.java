package defpackage;

/* compiled from: RxJavaErrorHandler */
public abstract class arz {
    public void a(Throwable e) {
    }

    public final String a(Object item) {
        try {
            return b(item);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return item.getClass().getName() + ".errorRendering";
        } catch (Throwable t) {
            app.a(t);
            return item.getClass().getName() + ".errorRendering";
        }
    }

    protected String b(Object item) throws InterruptedException {
        return null;
    }
}
