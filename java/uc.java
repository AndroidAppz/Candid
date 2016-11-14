/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
import com.facebook.FacebookException;

public interface uc<RESULT> {
    public void onCancel();

    public void onError(FacebookException var1);

    public void onSuccess(RESULT var1);
}

