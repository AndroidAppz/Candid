/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonIOException
 *  com.google.gson.internal.LinkedTreeMap
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.LinkedHashMap
 *  java.util.LinkedHashSet
 *  java.util.LinkedList
 *  java.util.Map
 *  java.util.Queue
 *  java.util.Set
 *  java.util.SortedMap
 *  java.util.SortedSet
 *  java.util.TreeMap
 *  java.util.TreeSet
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.ConcurrentNavigableMap
 *  java.util.concurrent.ConcurrentSkipListMap
 */
import com.google.gson.JsonIOException;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class air {
    private final Map<Type, aia<?>> a;

    public air(Map<Type, aia<?>> map) {
        this.a = map;
    }

    private <T> aiu<T> a(Class<? super T> class_) {
        try {
            final Constructor constructor = class_.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            aiu aiu2 = new aiu<T>(){

                @Override
                public T a() {
                    Object object;
                    try {
                        object = constructor.newInstance(null);
                    }
                    catch (InstantiationException var3_2) {
                        throw new RuntimeException("Failed to invoke " + (Object)constructor + " with no args", (Throwable)var3_2);
                    }
                    catch (InvocationTargetException var2_3) {
                        throw new RuntimeException("Failed to invoke " + (Object)constructor + " with no args", var2_3.getTargetException());
                    }
                    catch (IllegalAccessException var1_4) {
                        throw new AssertionError((Object)var1_4);
                    }
                    return (T)object;
                }
            };
            return aiu2;
        }
        catch (NoSuchMethodException var2_4) {
            return null;
        }
    }

    private <T> aiu<T> a(final Type type, Class<? super T> class_) {
        if (Collection.class.isAssignableFrom(class_)) {
            if (SortedSet.class.isAssignableFrom(class_)) {
                return new aiu<T>(){

                    @Override
                    public T a() {
                        return (T)new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(class_)) {
                return new aiu<T>(){

                    @Override
                    public T a() {
                        if (type instanceof ParameterizedType) {
                            Type type2 = ((ParameterizedType)type).getActualTypeArguments()[0];
                            if (type2 instanceof Class) {
                                return (T)EnumSet.noneOf((Class)((Class)type2));
                            }
                            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(class_)) {
                return new aiu<T>(){

                    @Override
                    public T a() {
                        return (T)new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(class_)) {
                return new aiu<T>(){

                    @Override
                    public T a() {
                        return (T)new LinkedList();
                    }
                };
            }
            return new aiu<T>(){

                @Override
                public T a() {
                    return (T)new ArrayList();
                }
            };
        }
        if (Map.class.isAssignableFrom(class_)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(class_)) {
                return new aiu<T>(){

                    @Override
                    public T a() {
                        return (T)new ConcurrentSkipListMap();
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(class_)) {
                return new aiu<T>(){

                    @Override
                    public T a() {
                        return (T)new ConcurrentHashMap();
                    }
                };
            }
            if (SortedMap.class.isAssignableFrom(class_)) {
                return new aiu<T>(){

                    @Override
                    public T a() {
                        return (T)new TreeMap();
                    }
                };
            }
            if (type instanceof ParameterizedType && !String.class.isAssignableFrom(ajm.get(((ParameterizedType)type).getActualTypeArguments()[0]).getRawType())) {
                return new aiu<T>(){

                    @Override
                    public T a() {
                        return (T)new LinkedHashMap();
                    }
                };
            }
            return new aiu<T>(){

                @Override
                public T a() {
                    return (T)new LinkedTreeMap();
                }
            };
        }
        return null;
    }

    private <T> aiu<T> b(final Type type, final Class<? super T> class_) {
        return new aiu<T>(){
            private final aix d;

            @Override
            public T a() {
                Object t2;
                try {
                    t2 = this.d.a(class_);
                }
                catch (Exception var1_2) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + (Object)type + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", (Throwable)var1_2);
                }
                return t2;
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     */
    public <T> aiu<T> a(ajm<T> ajm2) {
        void var5_6;
        final Type type = ajm2.getType();
        Class<T> class_ = ajm2.getRawType();
        final aia aia2 = (aia)this.a.get((Object)type);
        if (aia2 != null) {
            aiu aiu2 = new aiu<T>(){

                @Override
                public T a() {
                    return aia2.a(type);
                }
            };
            return var5_6;
        }
        final aia aia3 = (aia)this.a.get(class_);
        if (aia3 != null) {
            return new aiu<T>(){

                @Override
                public T a() {
                    return aia3.a(type);
                }
            };
        }
        aiu<T> aiu3 = super.a(class_);
        if (aiu3 != null) return var5_6;
        {
            aiu<T> aiu4 = super.a(type, class_);
            if (aiu4 == null) return super.b(type, class_);
            return aiu4;
        }
    }

    public String toString() {
        return this.a.toString();
    }

}

