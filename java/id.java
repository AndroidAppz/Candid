/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.Toast
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.content.Context;
import android.widget.Toast;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.networks.RetrofitException;
import java.io.IOException;

public class id
implements apr<Throwable> {
    String a;

    public id(String string2) {
        this.a = string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(Throwable throwable) {
        RetrofitException retrofitException;
        Context context = GossipApplication.a().getApplicationContext();
        if (throwable instanceof IOException) {
            retrofitException = RetrofitException.a((IOException)throwable);
            Toast.makeText((Context)context, (CharSequence)"There was a network error", (int)0).show();
        } else {
            retrofitException = RetrofitException.a(throwable);
            Toast.makeText((Context)context, (CharSequence)"There was an unexpected error", (int)0).show();
        }
        rb.a((Throwable)retrofitException);
    }

    @Override
    public /* synthetic */ void call(Object object) {
        this.a((Throwable)object);
    }
}

