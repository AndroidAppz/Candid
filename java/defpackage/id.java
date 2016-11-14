package defpackage;

import android.content.Context;
import android.widget.Toast;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.networks.RetrofitException;
import java.io.IOException;

/* compiled from: ErrorAction1Handler */
public class id implements apr<Throwable> {
    String a;

    public /* synthetic */ void call(Object obj) {
        a((Throwable) obj);
    }

    public id(String methodName) {
        this.a = methodName;
    }

    public void a(Throwable throwable) {
        RetrofitException exception;
        Context context = GossipApplication.a().getApplicationContext();
        if (throwable instanceof IOException) {
            exception = RetrofitException.a((IOException) throwable);
            Toast.makeText(context, "There was a network error", 0).show();
        } else {
            exception = RetrofitException.a(throwable);
            Toast.makeText(context, "There was an unexpected error", 0).show();
        }
        rb.a(exception);
    }
}
