package defpackage;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GenericLoaderFactory */
public class ma {
    private static final mj c = new ma$1();
    private final Map<Class, Map<Class, mk>> a = new HashMap();
    private final Map<Class, Map<Class, mj>> b = new HashMap();
    private final Context d;

    public ma(Context context) {
        this.d = context.getApplicationContext();
    }

    public synchronized <T, Y> mk<T, Y> a(Class<T> modelClass, Class<Y> resourceClass, mk<T, Y> factory) {
        mk previous;
        this.b.clear();
        Map<Class, mk> resourceToFactories = (Map) this.a.get(modelClass);
        if (resourceToFactories == null) {
            resourceToFactories = new HashMap();
            this.a.put(modelClass, resourceToFactories);
        }
        previous = (mk) resourceToFactories.put(resourceClass, factory);
        if (previous != null) {
            for (Map<Class, mk> factories : this.a.values()) {
                if (factories.containsValue(previous)) {
                    previous = null;
                    break;
                }
            }
        }
        return previous;
    }

    public synchronized <T, Y> mj<T, Y> a(Class<T> modelClass, Class<Y> resourceClass) {
        mj<T, Y> mjVar;
        mj<T, Y> result = c(modelClass, resourceClass);
        if (result == null) {
            mk<T, Y> factory = d(modelClass, resourceClass);
            if (factory != null) {
                result = factory.a(this.d, this);
                a((Class) modelClass, (Class) resourceClass, (mj) result);
            } else {
                b(modelClass, resourceClass);
            }
            mjVar = result;
        } else if (c.equals(result)) {
            mjVar = null;
        } else {
            mjVar = result;
        }
        return mjVar;
    }

    private <T, Y> void b(Class<T> modelClass, Class<Y> resourceClass) {
        a((Class) modelClass, (Class) resourceClass, c);
    }

    private <T, Y> void a(Class<T> modelClass, Class<Y> resourceClass, mj<T, Y> modelLoader) {
        Map<Class, mj> resourceToLoaders = (Map) this.b.get(modelClass);
        if (resourceToLoaders == null) {
            resourceToLoaders = new HashMap();
            this.b.put(modelClass, resourceToLoaders);
        }
        resourceToLoaders.put(resourceClass, modelLoader);
    }

    private <T, Y> mj<T, Y> c(Class<T> modelClass, Class<Y> resourceClass) {
        Map<Class, mj> resourceToLoaders = (Map) this.b.get(modelClass);
        if (resourceToLoaders != null) {
            return (mj) resourceToLoaders.get(resourceClass);
        }
        return null;
    }

    private <T, Y> mk<T, Y> d(Class<T> modelClass, Class<Y> resourceClass) {
        Map<Class, mk> resourceToFactories = (Map) this.a.get(modelClass);
        mk mkVar = null;
        if (resourceToFactories != null) {
            mkVar = (mk) resourceToFactories.get(resourceClass);
        }
        if (mkVar == null) {
            for (Class<? super T> registeredModelClass : this.a.keySet()) {
                if (registeredModelClass.isAssignableFrom(modelClass)) {
                    Map<Class, mk> currentResourceToFactories = (Map) this.a.get(registeredModelClass);
                    if (currentResourceToFactories != null) {
                        mkVar = (mk) currentResourceToFactories.get(resourceClass);
                        if (mkVar != null) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return mkVar;
    }
}
