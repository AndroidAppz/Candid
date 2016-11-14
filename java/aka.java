/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.CloneNotSupportedException
 *  java.lang.Object
 *  java.lang.String
 */
import java.io.IOException;

public abstract class aka {
    protected volatile int F = -1;

    public abstract aka b(ajy var1) throws IOException;

    public aka c() throws CloneNotSupportedException {
        return (aka)super.clone();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.c();
    }

    public String toString() {
        return akb.a(this);
    }
}

