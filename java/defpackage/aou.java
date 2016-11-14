package defpackage;

import java.util.Comparator;

/* compiled from: CompareToBuilder */
public class aou {
    private int a = 0;

    public aou a(Object lhs, Object rhs) {
        return a(lhs, rhs, null);
    }

    public aou a(Object lhs, Object rhs, Comparator<?> comparator) {
        if (this.a == 0 && lhs != rhs) {
            if (lhs == null) {
                this.a = -1;
            } else if (rhs == null) {
                this.a = 1;
            } else if (lhs.getClass().isArray()) {
                if (lhs instanceof long[]) {
                    a((long[]) lhs, (long[]) rhs);
                } else if (lhs instanceof int[]) {
                    a((int[]) lhs, (int[]) rhs);
                } else if (lhs instanceof short[]) {
                    a((short[]) lhs, (short[]) rhs);
                } else if (lhs instanceof char[]) {
                    a((char[]) lhs, (char[]) rhs);
                } else if (lhs instanceof byte[]) {
                    a((byte[]) lhs, (byte[]) rhs);
                } else if (lhs instanceof double[]) {
                    a((double[]) lhs, (double[]) rhs);
                } else if (lhs instanceof float[]) {
                    a((float[]) lhs, (float[]) rhs);
                } else if (lhs instanceof boolean[]) {
                    a((boolean[]) lhs, (boolean[]) rhs);
                } else {
                    a((Object[]) lhs, (Object[]) rhs, (Comparator) comparator);
                }
            } else if (comparator == null) {
                this.a = ((Comparable) lhs).compareTo(rhs);
            } else {
                this.a = comparator.compare(lhs, rhs);
            }
        }
        return this;
    }

    public aou a(long lhs, long rhs) {
        if (this.a == 0) {
            int i = lhs < rhs ? -1 : lhs > rhs ? 1 : 0;
            this.a = i;
        }
        return this;
    }

    public aou a(int lhs, int rhs) {
        if (this.a == 0) {
            int i = lhs < rhs ? -1 : lhs > rhs ? 1 : 0;
            this.a = i;
        }
        return this;
    }

    public aou a(short lhs, short rhs) {
        if (this.a == 0) {
            int i = lhs < rhs ? -1 : lhs > rhs ? 1 : 0;
            this.a = i;
        }
        return this;
    }

    public aou a(char lhs, char rhs) {
        if (this.a == 0) {
            int i = lhs < rhs ? -1 : lhs > rhs ? 1 : 0;
            this.a = i;
        }
        return this;
    }

    public aou a(byte lhs, byte rhs) {
        if (this.a == 0) {
            int i = lhs < rhs ? -1 : lhs > rhs ? 1 : 0;
            this.a = i;
        }
        return this;
    }

    public aou a(double lhs, double rhs) {
        if (this.a == 0) {
            this.a = Double.compare(lhs, rhs);
        }
        return this;
    }

    public aou a(float lhs, float rhs) {
        if (this.a == 0) {
            this.a = Float.compare(lhs, rhs);
        }
        return this;
    }

    public aou a(boolean lhs, boolean rhs) {
        if (this.a == 0 && lhs != rhs) {
            if (lhs) {
                this.a = 1;
            } else {
                this.a = -1;
            }
        }
        return this;
    }

    public aou a(Object[] lhs, Object[] rhs, Comparator<?> comparator) {
        int i = -1;
        if (this.a == 0 && lhs != rhs) {
            if (lhs == null) {
                this.a = -1;
            } else if (rhs == null) {
                this.a = 1;
            } else if (lhs.length != rhs.length) {
                if (lhs.length >= rhs.length) {
                    i = 1;
                }
                this.a = i;
            } else {
                for (int i2 = 0; i2 < lhs.length && this.a == 0; i2++) {
                    a(lhs[i2], rhs[i2], (Comparator) comparator);
                }
            }
        }
        return this;
    }

    public aou a(long[] lhs, long[] rhs) {
        int i = -1;
        if (this.a == 0 && lhs != rhs) {
            if (lhs == null) {
                this.a = -1;
            } else if (rhs == null) {
                this.a = 1;
            } else if (lhs.length != rhs.length) {
                if (lhs.length >= rhs.length) {
                    i = 1;
                }
                this.a = i;
            } else {
                for (int i2 = 0; i2 < lhs.length && this.a == 0; i2++) {
                    a(lhs[i2], rhs[i2]);
                }
            }
        }
        return this;
    }

    public aou a(int[] lhs, int[] rhs) {
        int i = -1;
        if (this.a == 0 && lhs != rhs) {
            if (lhs == null) {
                this.a = -1;
            } else if (rhs == null) {
                this.a = 1;
            } else if (lhs.length != rhs.length) {
                if (lhs.length >= rhs.length) {
                    i = 1;
                }
                this.a = i;
            } else {
                for (int i2 = 0; i2 < lhs.length && this.a == 0; i2++) {
                    a(lhs[i2], rhs[i2]);
                }
            }
        }
        return this;
    }

    public aou a(short[] lhs, short[] rhs) {
        int i = -1;
        if (this.a == 0 && lhs != rhs) {
            if (lhs == null) {
                this.a = -1;
            } else if (rhs == null) {
                this.a = 1;
            } else if (lhs.length != rhs.length) {
                if (lhs.length >= rhs.length) {
                    i = 1;
                }
                this.a = i;
            } else {
                for (int i2 = 0; i2 < lhs.length && this.a == 0; i2++) {
                    a(lhs[i2], rhs[i2]);
                }
            }
        }
        return this;
    }

    public aou a(char[] lhs, char[] rhs) {
        int i = -1;
        if (this.a == 0 && lhs != rhs) {
            if (lhs == null) {
                this.a = -1;
            } else if (rhs == null) {
                this.a = 1;
            } else if (lhs.length != rhs.length) {
                if (lhs.length >= rhs.length) {
                    i = 1;
                }
                this.a = i;
            } else {
                for (int i2 = 0; i2 < lhs.length && this.a == 0; i2++) {
                    a(lhs[i2], rhs[i2]);
                }
            }
        }
        return this;
    }

    public aou a(byte[] lhs, byte[] rhs) {
        int i = -1;
        if (this.a == 0 && lhs != rhs) {
            if (lhs == null) {
                this.a = -1;
            } else if (rhs == null) {
                this.a = 1;
            } else if (lhs.length != rhs.length) {
                if (lhs.length >= rhs.length) {
                    i = 1;
                }
                this.a = i;
            } else {
                for (int i2 = 0; i2 < lhs.length && this.a == 0; i2++) {
                    a(lhs[i2], rhs[i2]);
                }
            }
        }
        return this;
    }

    public aou a(double[] lhs, double[] rhs) {
        int i = -1;
        if (this.a == 0 && lhs != rhs) {
            if (lhs == null) {
                this.a = -1;
            } else if (rhs == null) {
                this.a = 1;
            } else if (lhs.length != rhs.length) {
                if (lhs.length >= rhs.length) {
                    i = 1;
                }
                this.a = i;
            } else {
                for (int i2 = 0; i2 < lhs.length && this.a == 0; i2++) {
                    a(lhs[i2], rhs[i2]);
                }
            }
        }
        return this;
    }

    public aou a(float[] lhs, float[] rhs) {
        int i = -1;
        if (this.a == 0 && lhs != rhs) {
            if (lhs == null) {
                this.a = -1;
            } else if (rhs == null) {
                this.a = 1;
            } else if (lhs.length != rhs.length) {
                if (lhs.length >= rhs.length) {
                    i = 1;
                }
                this.a = i;
            } else {
                for (int i2 = 0; i2 < lhs.length && this.a == 0; i2++) {
                    a(lhs[i2], rhs[i2]);
                }
            }
        }
        return this;
    }

    public aou a(boolean[] lhs, boolean[] rhs) {
        int i = -1;
        if (this.a == 0 && lhs != rhs) {
            if (lhs == null) {
                this.a = -1;
            } else if (rhs == null) {
                this.a = 1;
            } else if (lhs.length != rhs.length) {
                if (lhs.length >= rhs.length) {
                    i = 1;
                }
                this.a = i;
            } else {
                for (int i2 = 0; i2 < lhs.length && this.a == 0; i2++) {
                    a(lhs[i2], rhs[i2]);
                }
            }
        }
        return this;
    }

    public int a() {
        return this.a;
    }
}
