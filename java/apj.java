/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
public abstract class apj<T>
implements ape<T>,
apk {
    private static final Long NOT_SET = Long.MIN_VALUE;
    private apf producer;
    private long requested;
    private final apj<?> subscriber;
    private final aqr subscriptions;

    public apj() {
        this(null, false);
    }

    protected apj(apj<?> apj2) {
        super(apj2, true);
    }

    /*
     * Enabled aggressive block sorting
     */
    protected apj(apj<?> apj2, boolean bl2) {
        this.requested = NOT_SET;
        this.subscriber = apj2;
        aqr aqr2 = bl2 && apj2 != null ? apj2.subscriptions : new aqr();
        this.subscriptions = aqr2;
    }

    private void addToRequested(long l2) {
        if (this.requested == NOT_SET) {
            this.requested = l2;
            return;
        }
        long l3 = l2 + this.requested;
        if (l3 < 0) {
            this.requested = Long.MAX_VALUE;
            return;
        }
        this.requested = l3;
    }

    public final void add(apk apk2) {
        this.subscriptions.a(apk2);
    }

    @Override
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void request(long l2) {
        if (l2 < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + l2);
        }
        void var5_2 = this;
        synchronized (var5_2) {
            if (this.producer != null) {
                apf apf2 = this.producer;
                // MONITOREXIT [3, 2] lbl7 : MonitorExitStatement: MONITOREXIT : var5_2
                apf2.a(l2);
                return;
            }
            super.addToRequested(l2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setProducer(apf apf2) {
        void var8_2 = this;
        synchronized (var8_2) {
            long l2 = this.requested;
            this.producer = apf2;
            apj apj2 = this.subscriber;
            boolean bl2 = false;
            if (apj2 != null) {
                long l3 = l2 LCMP NOT_SET;
                bl2 = false;
                if (l3 == false) {
                    bl2 = true;
                    // MONITOREXIT [5, 6, 2] lbl12 : MonitorExitStatement: MONITOREXIT : var8_2
                    if (bl2) {
                        this.subscriber.setProducer(this.producer);
                        return;
                    }
                }
            }
            if (l2 == NOT_SET) {
                this.producer.a(Long.MAX_VALUE);
                return;
            }
            this.producer.a(l2);
            return;
        }
    }

    @Override
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }
}

