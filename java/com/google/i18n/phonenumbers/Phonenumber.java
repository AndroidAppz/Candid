package com.google.i18n.phonenumbers;

import java.io.Serializable;

public final class Phonenumber {

    public static class PhoneNumber implements Serializable {
        private boolean a;
        private int b = 0;
        private boolean c;
        private long d = 0;
        private boolean e;
        private String f = "";
        private boolean g;
        private boolean h = false;
        private boolean i;
        private int j = 1;
        private boolean k;
        private String l = "";
        private boolean m;
        private CountryCodeSource n = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        private boolean o;
        private String p = "";

        public enum CountryCodeSource {
            FROM_NUMBER_WITH_PLUS_SIGN,
            FROM_NUMBER_WITH_IDD,
            FROM_NUMBER_WITHOUT_PLUS_SIGN,
            FROM_DEFAULT_COUNTRY
        }

        public int a() {
            return this.b;
        }

        public PhoneNumber a(int value) {
            this.a = true;
            this.b = value;
            return this;
        }

        public long b() {
            return this.d;
        }

        public PhoneNumber a(long value) {
            this.c = true;
            this.d = value;
            return this;
        }

        public boolean c() {
            return this.e;
        }

        public String d() {
            return this.f;
        }

        public PhoneNumber a(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.e = true;
            this.f = value;
            return this;
        }

        public boolean e() {
            return this.g;
        }

        public boolean f() {
            return this.h;
        }

        public PhoneNumber a(boolean value) {
            this.g = true;
            this.h = value;
            return this;
        }

        public boolean g() {
            return this.i;
        }

        public int h() {
            return this.j;
        }

        public PhoneNumber b(int value) {
            this.i = true;
            this.j = value;
            return this;
        }

        public boolean i() {
            return this.k;
        }

        public String j() {
            return this.l;
        }

        public PhoneNumber b(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.k = true;
            this.l = value;
            return this;
        }

        public boolean k() {
            return this.m;
        }

        public CountryCodeSource l() {
            return this.n;
        }

        public PhoneNumber a(CountryCodeSource value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.m = true;
            this.n = value;
            return this;
        }

        public PhoneNumber m() {
            this.m = false;
            this.n = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            return this;
        }

        public boolean n() {
            return this.o;
        }

        public String o() {
            return this.p;
        }

        public PhoneNumber c(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.o = true;
            this.p = value;
            return this;
        }

        public boolean a(PhoneNumber other) {
            if (other == null) {
                return false;
            }
            if (this == other) {
                return true;
            }
            if (this.b == other.b && this.d == other.d && this.f.equals(other.f) && this.h == other.h && this.j == other.j && this.l.equals(other.l) && this.n == other.n && this.p.equals(other.p) && n() == other.n()) {
                return true;
            }
            return false;
        }

        public boolean equals(Object that) {
            return (that instanceof PhoneNumber) && a((PhoneNumber) that);
        }

        public int hashCode() {
            int i = 1231;
            int a = (((((((((((((((a() + 2173) * 53) + Long.valueOf(b()).hashCode()) * 53) + d().hashCode()) * 53) + (f() ? 1231 : 1237)) * 53) + h()) * 53) + j().hashCode()) * 53) + l().hashCode()) * 53) + o().hashCode()) * 53;
            if (!n()) {
                i = 1237;
            }
            return a + i;
        }

        public String toString() {
            StringBuilder outputString = new StringBuilder();
            outputString.append("Country Code: ").append(this.b);
            outputString.append(" National Number: ").append(this.d);
            if (e() && f()) {
                outputString.append(" Leading Zero(s): true");
            }
            if (g()) {
                outputString.append(" Number of leading zeros: ").append(this.j);
            }
            if (c()) {
                outputString.append(" Extension: ").append(this.f);
            }
            if (k()) {
                outputString.append(" Country Code Source: ").append(this.n);
            }
            if (n()) {
                outputString.append(" Preferred Domestic Carrier Code: ").append(this.p);
            }
            return outputString.toString();
        }
    }
}
