/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 */
public abstract class arz {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final String a(Object object) {
        try {
            return this.b(object);
        }
        catch (InterruptedException var3_3) {
            Thread.currentThread().interrupt();
            do {
                return object.getClass().getName() + ".errorRendering";
                break;
            } while (true);
        }
        catch (Throwable var2_4) {
            app.a(var2_4);
            return object.getClass().getName() + ".errorRendering";
        }
    }

    public void a(Throwable throwable) {
    }

    protected String b(Object object) throws InterruptedException {
        return null;
    }
}

