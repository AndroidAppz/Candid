package defpackage;

/* compiled from: LikeActionController */
class wk$o implements Runnable {
    private String a;
    private String b;

    wk$o(String cacheKey, String controllerJson) {
        this.a = cacheKey;
        this.b = controllerJson;
    }

    public void run() {
        wk.b(this.a, this.b);
    }
}
