/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
public class amh {
    private final int a;
    private final amd b;
    private final amg c;

    public amh(int n2, amd amd2, amg amg2) {
        this.a = n2;
        this.b = amd2;
        this.c = amg2;
    }

    public amh(amd amd2, amg amg2) {
        super(0, amd2, amg2);
    }

    public long a() {
        return this.b.a(this.a);
    }

    public amh b() {
        return new amh(1 + this.a, this.b, this.c);
    }

    public amh c() {
        return new amh(this.b, this.c);
    }
}

