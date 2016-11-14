package defpackage;

/* compiled from: TextDirectionHeuristicsCompat */
class de$b implements de$c {
    public static final de$b a = new de$b();

    public int a(CharSequence cs, int start, int count) {
        int result = 2;
        int e = start + count;
        for (int i = start; i < e && result == 2; i++) {
            result = de.d(Character.getDirectionality(cs.charAt(i)));
        }
        return result;
    }

    private de$b() {
    }
}
