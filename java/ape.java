/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
public interface ape<T> {
    public void onCompleted();

    public void onError(Throwable var1);

    public void onNext(T var1);
}

