package defpackage;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: TypeAdapters */
public final class ajk {
    public static final aij<String> A = new ajk$8();
    public static final aij<BigDecimal> B = new ajk$9();
    public static final aij<BigInteger> C = new ajk$10();
    public static final aik D = ajk.a(String.class, A);
    public static final aij<StringBuilder> E = new ajk$11();
    public static final aik F = ajk.a(StringBuilder.class, E);
    public static final aij<StringBuffer> G = new ajk$13();
    public static final aik H = ajk.a(StringBuffer.class, G);
    public static final aij<URL> I = new ajk$14();
    public static final aik J = ajk.a(URL.class, I);
    public static final aij<URI> K = new ajk$15();
    public static final aik L = ajk.a(URI.class, K);
    public static final aij<InetAddress> M = new ajk$16();
    public static final aik N = ajk.b(InetAddress.class, M);
    public static final aij<UUID> O = new ajk$17();
    public static final aik P = ajk.a(UUID.class, O);
    public static final aij<Currency> Q = new ajk$18().a();
    public static final aik R = ajk.a(Currency.class, Q);
    public static final aik S = new ajk$19();
    public static final aij<Calendar> T = new ajk$20();
    public static final aik U = ajk.b(Calendar.class, GregorianCalendar.class, T);
    public static final aij<Locale> V = new ajk$21();
    public static final aik W = ajk.a(Locale.class, V);
    public static final aij<aid> X = new ajk$22();
    public static final aik Y = ajk.b(aid.class, X);
    public static final aik Z = new ajk$24();
    public static final aij<Class> a = new ajk$1();
    public static final aik b = ajk.a(Class.class, a);
    public static final aij<BitSet> c = new ajk$12();
    public static final aik d = ajk.a(BitSet.class, c);
    public static final aij<Boolean> e = new ajk$23();
    public static final aij<Boolean> f = new ajk$30();
    public static final aik g = ajk.a(Boolean.TYPE, Boolean.class, e);
    public static final aij<Number> h = new ajk$31();
    public static final aik i = ajk.a(Byte.TYPE, Byte.class, h);
    public static final aij<Number> j = new ajk$32();
    public static final aik k = ajk.a(Short.TYPE, Short.class, j);
    public static final aij<Number> l = new ajk$33();
    public static final aik m = ajk.a(Integer.TYPE, Integer.class, l);
    public static final aij<AtomicInteger> n = new ajk$34().a();
    public static final aik o = ajk.a(AtomicInteger.class, n);
    public static final aij<AtomicBoolean> p = new ajk$35().a();
    public static final aik q = ajk.a(AtomicBoolean.class, p);
    public static final aij<AtomicIntegerArray> r = new ajk$2().a();
    public static final aik s = ajk.a(AtomicIntegerArray.class, r);
    public static final aij<Number> t = new ajk$3();
    public static final aij<Number> u = new ajk$4();
    public static final aij<Number> v = new ajk$5();
    public static final aij<Number> w = new ajk$6();
    public static final aik x = ajk.a(Number.class, w);
    public static final aij<Character> y = new ajk$7();
    public static final aik z = ajk.a(Character.TYPE, Character.class, y);

    public static <TT> aik a(Class<TT> type, aij<TT> typeAdapter) {
        return new ajk$25(type, typeAdapter);
    }

    public static <TT> aik a(Class<TT> unboxed, Class<TT> boxed, aij<? super TT> typeAdapter) {
        return new ajk$26(unboxed, boxed, typeAdapter);
    }

    public static <TT> aik b(Class<TT> base, Class<? extends TT> sub, aij<? super TT> typeAdapter) {
        return new ajk$27(base, sub, typeAdapter);
    }

    public static <T1> aik b(Class<T1> clazz, aij<T1> typeAdapter) {
        return new ajk$28(clazz, typeAdapter);
    }
}
