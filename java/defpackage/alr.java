package defpackage;

/* compiled from: ResponseParser */
public class alr {
    public static int a(int statusCode) {
        if (statusCode >= 200 && statusCode <= 299) {
            return 0;
        }
        if (statusCode >= 300 && statusCode <= 399) {
            return 1;
        }
        if (statusCode >= 400 && statusCode <= 499) {
            return 0;
        }
        if (statusCode >= 500) {
            return 1;
        }
        return 1;
    }
}
